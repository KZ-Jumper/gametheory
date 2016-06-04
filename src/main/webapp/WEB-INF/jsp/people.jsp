<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>People</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <%--@elvariable id="user" type="ua.kharkov.nure.sharaban.model.LPR"--%>
                    <c:choose>
                        <c:when test="${not empty user.name}">
                            <h3>Hello, ${user.name}! Your range is ${user.range}.</h3>
                        </c:when>
                        <c:otherwise>
                            <h3>Enter your name, please!</h3>
                            <form method="post" action="<c:url value="/login"/>">
                                <input type="text" class="form-control" name="name" placeholder="Name">
                                <input type="submit" class="btn btn-primary">
                            </form>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h3>People</h3>
                    <c:choose>
                        <c:when test="${not empty people}">
                            <table class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <td>Number</td>
                                        <td>Name</td>
                                        <td>Range</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%--@elvariable id="people" type="java.util.List"--%>
                                    <%--@elvariable id="person" type="ua.kharkov.nure.sharaban.model.LPR"--%>
                                    <c:forEach items="${people}" var="person" varStatus="i">
                                        <tr>
                                            <td>${i.count}</td>
                                            <td>${person.name}</td>
                                            <td>${person.range}</td>
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
        </div>
    </body>
</html>
