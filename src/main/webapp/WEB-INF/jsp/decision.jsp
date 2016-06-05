<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Make decision</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <a href="<c:url value="/"/>" class="btn btn-default">Back</a>
            <h3>Make decision</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="<c:url value="/decide/save"/>" method="post">
                <%--@elvariable id="criteria" type="java.util.List"--%>
                <%--@elvariable id="criterion" type="ua.kharkov.nure.sharaban.model.Criterion"--%>
                <c:forEach items="${criteria}" var="criterion" varStatus="i">
                    <div class="row">
                        <div>${i.count}. ${criterion.name}</div>
                        <div class="row">
                            <div class="col-sm-6">
                                <input type="text" name="marks" class="form-control" placeholder="Enter mark">
                            </div>
                            <div class="col-sm-6">
                                Priority:
                                <c:forEach var="priority" begin="1" end="5">
                                    <input type="radio" name="${criterion.id}-priority" value="${priority}">${priority}&emsp;
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <input type="submit" class="btn btn-success" value="Save">
            </form>
        </div>
    </div>
</div>
</body>
</html>
