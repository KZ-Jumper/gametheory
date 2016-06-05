<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Marks</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <a href="<c:url value="/"/>" class="btn btn-default">Back</a>
            <h3>Marks</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <c:choose>
                <%--@elvariable id="marks" type="java.util.List"--%>
                <c:when test="${not empty marks}">
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <td>Number</td>
                                <td>Criterion name</td>
                                <td>Name</td>
                                <td>Range</td>
                                <td>Mark number equivalent</td>
                                <td>Normalized mark</td>
                                <td></td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <%--@elvariable id="mark" type="ua.kharkov.nure.sharaban.model.Mark"--%>
                            <c:forEach items="${marks}" var="mark" varStatus="i">
                                <tr>
                                    <td>${i.count}</td>
                                    <td>${mark.criterion.name}</td>
                                    <td>${mark.name}</td>
                                    <td>${mark.range}</td>
                                    <td>${mark.markNumberEquivalent}</td>
                                    <td>${mark.normalizedMark}</td>
                                    <td><a href="<c:url value="/marks/${mark.id}/edit"/>" class="btn btn-info">Edit</a></td>
                                    <td><a href="<c:url value="/marks/${mark.id}/delete"/>" class="btn btn-danger">Delete</a></td>
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
            <a href="<c:url value="/marks/add"/>" class="btn btn-primary">Add</a>
        </div>
    </div>
</div>
</body>
</html>
