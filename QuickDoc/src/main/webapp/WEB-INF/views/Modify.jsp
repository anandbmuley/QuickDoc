<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <%@ include file="Include.jsp"%>
    <title>Create Document</title>
    <script type="application/javascript">

        $(document).ready(function(){
            $('#custom-templates .typeahead').typeahead(null, {
                name: 'best-pictures',
                displayKey: 'value',
                source: function(query,process){
                    return $.getJSON('searchdoc',{txt:query},function(data){
                        return process(data);
                    });
                },
                templates: {
                    empty: [
                        '<div class="empty-message">',
                        'Unable to find any document',
                        '</div>'
                    ].join('\n'),
                    suggestion: Handlebars.compile('<p><strong>{{name}}</strong> – {{text}}</p>')
                }
            });
        });

    </script>
</head>
<body>
<%@include file="Navigation.jsp"%>
<div align="center">
    <div>
        <form action="searchdoc" method="post">
            <div class="table">
                <div class="table-row">
                    <div class="table-cell">Search</div>
                    <div  id="custom-templates" class="table-cell">
                        <input name="txt" class="required form-control typeahead" placeholder="Enter a name" type="text" />
                    </div>
                    <div class="table-cell">
                        <button type="submit" class="btn btn-primary" role="button">Search</button>
                    </div>
                </div>
            </div>
        </form>
        <c:if test="${message != null}">
            <div role="alert" class="alert alert-success"
                 style="text-align: center;">
                <strong id="message">${message}</strong>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>