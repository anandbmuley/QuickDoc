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
            $('#searchBox').autocomplete({
                source: "./search?searchBy=2",
                minLength: 2,
                select: function( event, ui ) {
                    $('#searchTitleBox').val(ui.item.value);
                    $('#searchFrm').attr('action','searchpassword');
                    $('#searchFrm').submit();
                }
            });

            $('#searchTitleBox').autocomplete({
                source: "./search?searchBy=1",
                minLength: 2,
                select: function( event, ui ) {
                    $('#searchTitleBox').val(ui.item.value);
                    $('#searchFrm').attr('action','searchpassword');
                    $('#searchFrm').submit();
                }
            });

            $('#addTag').tagsInput({
                width: 'auto',
                autocomplete_url:'resources/sample.txt'
            });

             $('.allowCopy').click(function() {
                 var $temp = $("<input>");
                 $("body").append($temp);
                 $temp.val($(this).attr('value')).select();
                 document.execCommand("copy");
                 $temp.remove();
                 $('#copyToClipboardMessage').show();
                  $('#copyToClipboardMessage').fadeOut(1500);
             });

        });

    </script>
    <%@include file="Navigation.jsp"%>
</head>
<body>
<div class="container">
<c:if test="${fn:length(passwords)==0}">
<form role="form" action="create" method="post">
            <div class="col-md-4"></div>
			<div align="center" class="jumbotron col-md-4">
						<div class="table">
						    <div class="table-row">
                                <div class="table-cell">
                                    <div style="font-size:20px;">Save New Password</div>
                                </div>
                            </div>
                            <div class="table-row">
                                <div class="table-cell">
                                    <input name="title" class="required form-control" placeholder="Enter a title" type="text" />
                                </div>
                            </div>
                            <div class="table-row">
                                <div class="table-cell">
                                    <input name="username" class="required form-control" placeholder="Username" type="text" />
                                </div>
                            </div>
                            <div class="table-row">
                                <div class="table-cell">
                                    <input name="password" class="required form-control" placeholder="Password" type="password" />
                                </div>
                            </div>
                            <div class="table-row">
                                <div class="table-cell">
                                    <textarea id="noteDataTA" name="additionalDetails" class="required form-control" placeholder="Additional Details" rows="5" cols="10"></textarea>
                                </div>
                            </div>
                            <div class="table-row" style="display:none">
                                <div class="table-cell">
                                    <input id="addTag" placeholder="Add a tag" name="tags" value=""/>
                                </div>
                            </div>
                            <div class="table-row">
                                <div class="table-cell">
                                    <button type="submit" class="btn btn-primary" role="button">Save</button>
                                </div>
                            </div>

						</div>

			</div>
		</form>
</c:if>
<div class="container">
        <c:if test="${fn:length(passwords)>0}">
        <form id="detailsFrm" action="getdetails" method="post">
        <input id="noteId" name="id" type="hidden" value="${note.id}"/>
            <!-- Example row of columns -->
            <div class="row">
                <div class="col-md-4"></div>
                <c:forEach items="${passwords}" var="password">
                    <div class="col-md-4">
                        <div id="copyToClipboardMessage" style="display:none">Copied to clipboard</div>
                        <h2>${password.title}</h2>
                        <div><a style="cursor:pointer;text-decoration:none" class="allowCopy" value="${password.username}">Username</a> </div>
                        <div><a style="cursor:pointer;text-decoration:none" class="allowCopy" value="${password.password}">Password</a> </div>
                        <div class="presented-dt"><fmt:formatDate value="${note.date}" pattern="dd-MMM-yyyy hh:mm:ss a"></fmt:formatDate></div>
                        <p style="white-space: pre-wrap">${password.additionalDetails}</p>
                        <p><div class="list-group-item-text presented-by">Additional Details : ${password.additionalDetails}</div></p>
                    </div>

                </c:forEach>
            </div>
        </form>
        </c:if>

</div>
</div>
</body>
</html>