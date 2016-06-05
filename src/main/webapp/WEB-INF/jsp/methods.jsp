<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Methods</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <a href="<c:url value="/decide"/>" class="btn btn-default">Back</a>
            <h3>Methods</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <a href="<c:url value="/decide/methods/1/result"/>" class="btn btn-primary">Use method 1</a>
            <a href="<c:url value="/decide/methods/2/result"/>" class="btn btn-info">Use method 2</a>
            <a href="<c:url value="/decide/methods/3/result"/>" class="btn btn-danger">Use method 3</a>
        </div>
    </div>
</div>
</body>
</html>
