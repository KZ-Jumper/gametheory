<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Alternatives</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <a href="<c:url value="/"/>" class="btn btn-default">Back</a>
            <h3>Alternatives</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <c:choose>
                <%--@elvariable id="alternatives" type="java.util.List"--%>
                <c:when test="${not empty alternatives}">
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <td>Number</td>
                                <td>Name</td>
                                <td></td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <%--@elvariable id="alternative" type="ua.kharkov.nure.sharaban.model.Alternative"--%>
                            <c:forEach items="${alternatives}" var="alternative" varStatus="i">
                                <tr>
                                    <td>${i.count}</td>
                                    <td>${alternative.name}</td>
                                    <td><a href="<c:url value="/alternatives/${alternative.id}/edit"/>" class="btn btn-info">Edit</a></td>
                                    <td><a href="<c:url value="/alternatives/${alternative.id}/delete"/>" class="btn btn-danger">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <h3>No records</h3>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <a href="<c:url value="/alternatives/add"/>" class="btn btn-primary">Add</a>
        </div>
    </div>
</div>
</body>
</html>
