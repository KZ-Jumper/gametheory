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

                <h3>Criteria</h3>
                <%--@elvariable id="criteria" type="java.util.List"--%>
                <c:if test="${not empty criteria}">
                    <c:forEach items="${criteria}" var="criterion">
                        <div>
                            <label>${criterion}</label>
                            <input type="text" name="values" class="form-control" placeholder="Enter value">
                        </div>
                    </c:forEach>
                </c:if>

                <%--@elvariable id="builds" type="java.util.List"--%>
                <%--@elvariable id="build" type="ua.kharkov.nure.sharaban.model.Build"--%>
                <c:if test="${not empty builds}">
                    <c:forEach items="${builds}" var="build">
                        <div>
                            <input type="hidden" name="buildIds" value="${build.id}">
                            <label>${build.criterion.name}</label>
                            <input type="text" name="values" class="form-control" value="${build.value}" placeholder="Enter value">
                        </div>
                    </c:forEach>
                </c:if>

                <input type="submit" class="btn btn-success" value="Save">
            </form>
        </div>
    </div>
</div>
</body>
</html>
