<%--
  Created by IntelliJ IDEA.
  User: GreG
  Date: 10.09.2014
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddStudents</title>
    <link href="http://getbootstrap.com/dist/css/bootstrap.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navBar.jsp"/>
<div class="container">
    <h3>Для создпния студента заполните все поля и нажмите кнопку "Cоздать": </h3>
    <form:form method="post" action="saveStudent" commandName="student" role="form">
        <div class="form-groups">
            <form:label path="firstName">Фамилия:</form:label>
            <form:input path="firstName" class="form-control" placeholder="Фамилия"/>
        </div>
        <div class="form-groups">
            <form:label path="lastName">Имя:</form:label>
            <form:input path="lastName" class="form-control" placeholder="Имя"/>
        </div>
        <div class="form-groups">
            <form:label path="groups">Группа:</form:label>
            <form:input path="groups" class="form-control" placeholder="Группа"/>
        </div>
        <div class="form-groups">
            <form:label path="weekOfEntry">Дата поступления:</form:label>
            <form:input path="weekOfEntry" class="form-control" placeholder="Дата поступления"/>
        </div>
        <div class="form-groups" style="padding:15px 0px">
        <button type="submit" class="btn btn-default">Создать</button>
        </div>
    </form:form>
</div>
</body>
</html>
