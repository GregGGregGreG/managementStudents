<%--
  Created by IntelliJ IDEA.
  User: GreG
  Date: 10.09.2014
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Discipline</title>
    <link href="http://getbootstrap.com/dist/css/bootstrap.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="masthead">
        <h2 class="muted">Система управления студентами и их успеваемостью</h2>
        <hr>
    </div>
</div>
<div class="container">
    <a href="<c:url value="/discipline/addDiscipline.html"/>">Add Discipline</a>
</div>
<div style="padding: 0px 200px; width: 184px; top: 0px;">
    <aside>
        <form:form action="/" method="get"><input type="submit"
                                                  class="btn btn-success btn-mini"
                                                  value="На главную"/>
        </form:form>
    </aside>
</div>
</div>
<div class="container">
    <c:if test="${!empty disciplines}">
        <h3>Cписок дисциплин</h3>
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>№</th>
                <th>Наименование дисциплины</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${disciplines}" var="disciplin">
                <tr>
                    <td>${disciplin.id}</td>
                    <td>${disciplin.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
