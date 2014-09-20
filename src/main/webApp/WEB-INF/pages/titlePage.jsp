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
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row text-center">
    <div class="col-sm-4">
            <a href="<c:url value="/student/studentsList.html"/>">Студенты</a>

        </div>
        <div class="col-sm-4">
            <a href="<c:url value="/discipline/disciplineList.html"/>">Дисциплины</a>

        </div>
        <div class="col-sm-4">
            <a href="<c:url value="/curriculum/curriculumList.html"/>">Семестры</a>

        </div>
    </div>
</div>
</body>
</html>
