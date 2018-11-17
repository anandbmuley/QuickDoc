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

        $('#searchTitleBox').autocomplete({
            source: "home/search?searchBy=1",
            minLength: 2,
            select: function( event, ui ) {
                $('#searchTitleBox').val(ui.item.value);
                $('#homePageSearchFrm').submit();
            }
        });

    });

</script>

</head>
<body>

    <!-- HEADER -->
    <%@ include file="HomeNavigation.jsp"%>

    <div align="center" class="container">
        <div>
            <img src="resources/images/QuickDocLogo.svg" alt="QuickDocLogo" width="50%"/>
        </div>
        <form id="homePageSearchFrm" role="form" class="patient-form" action="home/search-all" enctype="multipart/form-data" method="post">
            <div class="row search-box">
                <input id="searchTitleBox" name="title" class="required form-control input-lg" placeholder="Search by title" type="text" />
            </div>
        </form>
    </div>

    <c:if test="${fn:length(searchResults)>0}">
        <c:forEach items="${searchResults}" var="searchResult">
           <c:choose>
            <c:when test="${searchResult.module == 'PASSWORDS'}">
                <div class="row">
                    <div class="col-md-4"></div>
                    <div class="col-md-4" align="center">
                        <div id="copyToClipboardMessage" style="display:none">Copied to clipboard</div>
                        <div class="row" align="center">
                            <h2>${searchResult.title}</h2>
                        </div>
                        <div class="row" align="center">
                            <div class="col-md-6" align="center"><a style="cursor:pointer;text-decoration:none" class="allowCopy" value="${searchResult.username}">Username</a> </div>
                            <div class="col-md-6" align="center"><a style="cursor:pointer;text-decoration:none" class="allowCopy" value="${searchResult.password}">Password</a> </div>
                        </div>
                        <!-- <p style="white-space: pre-wrap">${searchResult.additionalDetails}</p> -->
                        <p><div class="list-group-item-text presented-by">${searchResult.additionalDetails}</div></p>
                    </div>
               </div>
            </c:when>
            <c:when test="${searchResult.module == 'NOTES'}">
                <form id="detailsFrm" action="getdetails" method="post">
                    <input id="noteId" name="id" type="hidden" value="${searchResult.id}"/>
                    <!-- Example row of columns -->
                    <div class="row">
                            <div class="col-md-4"></div>
                            <div class="col-md-4">
                                <h2>${note.title}</h2>
                                <%--<h4 class="project-name">${searchResult.projectName}</h4>--%>
                                <div class="presented-dt"><fmt:formatDate value="${searchResult.date}" pattern="dd-MMM-yyyy hh:mm:ss a"></fmt:formatDate></div>
                                <p style="white-space: pre-wrap">${searchResult.content}</p>
                                <!-- <p><div class="list-group-item-text presented-by">Presented By : ${searchResult.presenter}</div></p> -->
                                <!--<p><button type="button" class="btn btn-default" role="button" onclick="fnSubmit('${searchResult.id}')">View details »</button></p>-->
                            </div>
                    </div>
                </form>
            </c:when>
           </c:choose>
           <br/><br/><br/><br/>
        </c:forEach>
    </c:if>

</body>
</html>