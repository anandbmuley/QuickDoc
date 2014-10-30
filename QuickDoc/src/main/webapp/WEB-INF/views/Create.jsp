<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<%@ include file="Include.jsp"%>
<title>Create Document</title>
</head>
<body>
	<%@include file="Navigation.jsp"%>
	<div align="center">
	<div>
		<form role="form" class="patient-form" action="save"
			enctype="multipart/form-data" method="post">
			<div class="details-container">
						<div class="table">
                            <div class="table-row">
                                <div class="table-cell">
                                    <input name="name" class="required form-control" placeholder="Enter a name" type="text" />
                                </div>
                            </div>
                            <div class="table-row">
                                <div class="table-cell">
                                    <textarea name="text" class="required form-control" placeholder="Enter document content" rows="20" cols="70"></textarea>
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