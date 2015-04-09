<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <%@ include file="Include.jsp"%>
    <title>Note Details</title>
    <script type="application/javascript">

        $(document).ready(function(){
            fnGenerateTags('${note.tags}','tags');
            $('#noteDataTA').expandable();
        });

        function fnDelete(){
            $('#noteFrm').attr('action','delete');
            $('#noteFrm').submit();
        }

        function fnSave(){
            $('#noteFrm').attr('action','savechanges');
            $('#noteFrm').submit();
        }


    </script>

    <%@include file="Navigation.jsp"%>
</head>
<body>
<div class="container">
<c:if test="${note != null}">
    <form id="noteFrm" action="#" method="post">
        <input name="id" type="hidden" value="${note.id}"/>
        <input type="hidden" name="title" value="${note.title}"/>
        <input type="hidden" name="presenter" value="${note.presenter}"/>
        <input type="hidden" name="date" value="<fmt:formatDate value="${note.date}" pattern="dd-MMM-yyyy hh:mm:ss a"></fmt:formatDate>"/>
        <div class="jumbotron">
            <h2>${note.title}</h2>
            <%--<h4>${note.projectName}</h4>--%>
            <p class="presented-by">${note.presenter}</p>
            <textarea id="noteDataTA" name="content" class="required note-content form-control" placeholder="Enter some content" rows="10">${note.content}</textarea>
            <div style="margin-top: 10px;" align="left">
                <input id="tags" placeholder="Add a tag" name="tags" value=""/>
            </div>
            <div align="right" class="presented-dt">
                <fmt:formatDate value="${note.date}" pattern="dd-MMM-yyyy hh:mm:ss a"></fmt:formatDate>
            </div>
            <div align="right">
                <button type="button" onclick="fnDelete()" class="btn btn-lg btn-info" role="button">Delete</button>
                <button type="button" onclick="fnSave()" class="btn btn-lg btn-success" role="button">Save Changes</button>
            </div>
        </div>
    </form>
</c:if>
<c:if test="${note == null}">
    No search results found.
</c:if>
</div>
</body>
</html>