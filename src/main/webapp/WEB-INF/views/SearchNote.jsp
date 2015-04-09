<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <%@ include file="Include.jsp"%>
    <title>Search Note</title>
    <script type="application/javascript">


        function fnSubmit(selId){
            $('#noteId').val(selId);
            $('#detailsFrm').submit();
        }

    </script>
</head>
<body>
<%@include file="Navigation.jsp"%>
<div class="container">
        <c:if test="${fn:length(notes)>0}">
        <form id="detailsFrm" action="getdetails" method="post">
        <input id="noteId" name="id" type="hidden" value="${note.id}"/>
            <!-- Example row of columns -->
            <div class="row">
                <c:forEach items="${notes}" var="note">
                    <div class="col-md-4">
                        <h2>${note.title}</h2>
                        <%--<h4 class="project-name">${note.projectName}</h4>--%>
                        <div class="presented-dt"><fmt:formatDate value="${note.date}" pattern="dd-MMM-yyyy hh:mm:ss a"></fmt:formatDate></div>
                        <p style="white-space: pre-wrap">${note.content}</p>
                        <p><div class="list-group-item-text presented-by">Presented By : ${note.presenter}</div></p>
                        <p><button type="button" class="btn btn-default" role="button" onclick="fnSubmit('${note.id}')">View details »</button></p>
                    </div>
                </c:forEach>
            </div>
        </form>
        </c:if>
        <c:if test="${fn:length(notes)==0}">
            No search results found.
        </c:if>
</div>

</body>
</html>