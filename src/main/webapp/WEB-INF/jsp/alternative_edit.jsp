<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add/Edit alternative</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <a href="<c:url value="/alternatives"/>" class="btn btn-default">Back</a>
            <h3>Add/Edit alternative</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="<c:url value="/alternatives/save"/>" method="post">
                <%--@elvariable id="alternative" type="ua.kharkov.nure.sharaban.model.Alternative"--%>
                <input type="hidden" name="id" value="${alternative.id}">

                <label>Name</label>
                <input type="text" name="name" class="form-control" value="${alternative.name}" placeholder="Enter name">

                <input type="submit" class="btn btn-success" value="Save">
            </form>
        </div>
    </div>
</div>
</body>
</html>
