<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pairing</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <a href="<c:url value="/"/>" class="btn btn-default">Back</a>
            <h3>Leadership</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="col-md-4">
                <h4>${first.name}</h4>
                <c:forEach items="${firstVectors}" var="vector">
                    <div>
                        <h5>${vector.mark.criterion.name}: ${vector.mark.name}</h5>
                    </div>
                </c:forEach>
            </div>
            <div class="col-md-2"><h2>VS</h2></div>
            <div class="col-md-4">
                <h4>${second.name}</h4>
                <c:forEach items="${secondVectors}" var="vector">
                    <div>
                        <h5>${vector.mark.criterion.name}: ${vector.mark.name}</h5>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <form action="<c:url value="/decide/compare"/>" method="post">
                <input type="hidden" name="firstId" value="${first.id}">
                <input type="hidden" name="secondId" value="${second.id}">
                <input type="hidden" name="altCount" value="${altCount}">

                <input type="radio" name="winnerId" value="${first.id}">Left &emsp;
                <input type="radio" name="winnerId" value="${second.id}">Right &emsp;

                <input type="submit" class="btn btn-success" value="Choose">
            </form>
        </div>
    </div>
</div>
</body>
</html>
