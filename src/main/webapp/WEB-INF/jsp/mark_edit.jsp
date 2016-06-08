<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add/Edit mark</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <a href="<c:url value="/marks"/>" class="btn btn-default">Back</a>
            <h3>Add/Edit mark</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="<c:url value="/marks/save"/>" method="post">
                <%--@elvariable id="mark" type="ua.kharkov.nure.sharaban.model.Mark"--%>
                <input type="hidden" name="id" value="${mark.id}">

                <label for="select">Criterion name</label>
                <select name="criterion.name" class="form-control" id="select">
                    <%--@elvariable id="criteriaNames" type="java.util.List"--%>
                    <c:forEach items="${criteriaNames}" var="name">
                        <option value="${name}" <c:if test="${name eq mark.criterion.name}">selected</c:if>>${name}</option>
                    </c:forEach>
                </select>

                <label>Value</label>
                <input type="text" name="name" class="form-control" value="${mark.name}" placeholder="Enter value">

                <input type="submit" class="btn btn-success" value="Save">
            </form>
        </div>
    </div>
</div>
</body>
</html>
