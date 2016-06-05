<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add/Edit criterion</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.12.4.min.js"/>"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <a href="<c:url value="/criteria"/>" class="btn btn-default">Back</a>
            <h3>Add/Edit criterion</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="<c:url value="/criteria/save"/>" method="post">
                <%--@elvariable id="criterion" type="ua.kharkov.nure.sharaban.model.Criterion"--%>
                <c:if test="${not empty criterion}">
                    <input type="hidden" name="id" value="${criterion.id}">
                </c:if>
                <c:if test="${empty criterion}">
                    <input type="hidden" name="id" value="0">
                </c:if>

                <label>Name</label>
                <input type="text" name="name" class="form-control" value="${criterion.name}" placeholder="Enter name">

                <label>Range</label>
                <input type="text" name="range" class="form-control" value="${criterion.range}" placeholder="Enter range">

                <label>Weight</label>
                <input type="text" name="weight" class="form-control" value="${criterion.weight}" placeholder="Enter weight">

                <label for="type">Type</label>
                <select name="type" class="form-control" id="type">
                    <%--@elvariable id="types" type="java.util.List"--%>
                    <c:forEach items="${types}" var="type">
                        <option value="${type}" <c:if test="${type eq criterion.type}">selected</c:if>>${type}</option>
                    </c:forEach>
                </select>

                <label>Optimal type</label>
                <input type="text" name="optimalType" class="form-control" value="${criterion.optimalType}" placeholder="Enter optimal type">

                <label>Unit</label>
                <input type="text" name="unit" class="form-control" value="${criterion.unit}" placeholder="Enter unit">

                <label for="scaleType">Scale type</label>
                <select name="scaleType" class="form-control" id="scaleType">
                    <%--@elvariable id="scaleTypes" type="java.util.List"--%>
                    <c:forEach items="${scaleTypes}" var="scaleType">
                        <option value="${scaleType}" <c:if test="${scaleType eq criterion.scaleType}">selected</c:if>>${scaleType}</option>
                    </c:forEach>
                </select>

                <label>Min value</label>
                <input type="text" id="min" name="minValue" class="form-control" value="${criterion.minValue}" placeholder="Enter min value">

                <label>Max value</label>
                <input type="text" id="max" name="maxValue" class="form-control" value="${criterion.maxValue}" placeholder="Enter max value">

                <input type="submit" class="btn btn-success" value="Save">
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function() {
        select();

        $("#scaleType").on("change", function() {
            select();
        });
    });

    function select() {
        if ($("#scaleType").val() == "interval") {
            $("#min").prop("disabled", false);
            $("#max").prop("disabled", false);
        } else {
            $("#min").prop("disabled", true);
            $("#max").prop("disabled", true);
        }
    }
</script>
</body>
</html>
