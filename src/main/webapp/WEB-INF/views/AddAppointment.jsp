<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <%@ include file="Include.jsp"%>
  <title>Add Appointment</title>
</head>
<body>
<%@include file="Navigation.jsp"%>
<div align="center">
  <div>
    <form role="form" class="patient-form" action="add"
          enctype="multipart/form-data" method="post">
      <div class="details-container">
        <div class="table">
          <div class="table-row">
            <div class="table-cell">
              <input name="title" class="required form-control" placeholder="Project" type="text" />
            </div>
          </div>
          <div class="table-row">
            <div class="table-cell">
              <input name="title" class="required form-control" placeholder="Enter a title" type="text" />
            </div>
          </div>
          <div class="table-row">
            <div class="table-cell">
              <input name="presenter" class="required form-control" placeholder="Who is the presenter?" type="text" />
            </div>
          </div>
          <div class="table-row">
            <div class="table-cell">
              <textarea name="content" class="required form-control" placeholder="Enter notes content" rows="10" cols="40"></textarea>
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