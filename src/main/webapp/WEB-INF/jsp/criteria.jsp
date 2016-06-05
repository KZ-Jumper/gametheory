<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Criteria</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <a href="<c:url value="/"/>" class="btn btn-default">Back</a>
            <h3>Criteria</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <c:choose>
                <%--@elvariable id="criteria" type="java.util.List"--%>
                <c:when test="${not empty criteria}">
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <td>Number</td>
                                <td>Name</td>
                                <td>Range</td>
                                <td>Weight</td>
                                <td>Type</td>
                                <td>Optimal type</td>
                                <td>Unit</td>
                                <td>Scale type</td>
                                <td></td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <%--@elvariable id="criterion" type="ua.kharkov.nure.sharaban.model.Criterion"--%>
                            <c:forEach items="${criteria}" var="criterion" varStatus="i">
                                <tr>
                                    <td>${i.count}</td>
                                    <td>${criterion.name}</td>
                                    <td>${criterion.range}</td>
                                    <td>${criterion.weight}</td>
                                    <td>${criterion.type}</td>
                                    <td>${criterion.optimalType}</td>
                                    <td>${criterion.unit}</td>
                                    <td>${criterion.scaleType}</td>
                                    <td><a href="<c:url value="/criteria/${criterion.id}/edit"/>" class="btn btn-info">Edit</a></td>
                                    <td><a href="<c:url value="/criteria/${criterion.id}/delete"/>" class="btn btn-danger">Delete</a></td>
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
        <div class="col-md-10 col-md-offset-1">
            <a href="<c:url value="/criteria/add"/>" class="btn btn-primary">Add</a>
        </div>
    </div>
</div>
</body>
</html>
