<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Students</title>
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/bootstrap.min.css" />" rel="stylesheet">
   </head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row text-center">
        <div class="col-sm-4">
            <a href="<c:url value="/students/"/>">Студенты</a>
        </div>
        <div class="col-sm-4">
            <a href="<c:url value="/disciplines/"/>">Дисциплины</a>
        </div>
        <div class="col-sm-4">
            <a href="<c:url value="/curriculums/"/>">Семестры</a>
        </div>
    </div>
</div>
</body>
</html>
