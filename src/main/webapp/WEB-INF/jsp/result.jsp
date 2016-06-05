<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Results</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <a href="<c:url value="/decide/methods"/>" class="btn btn-default">Back</a>
            <h3>Results</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <c:forEach items="${results}" var="result">
                <div>
                    <h4>${result.alternative.name}</h4>
                    <h6>${result.range}</h6>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
