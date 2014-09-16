<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Students</title>
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
    <a href="<c:url value="/student/studentsList.html"/>">Студенты</a>
    <a href="<c:url value="/discipline/disciplineList.html"/>">Дисциплины</a>
</div>

</body>
</html>
