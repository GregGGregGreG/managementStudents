<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentCreating</title>
    <link href="http://getbootstrap.com/dist/css/bootstrap.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <jsp:include page="navBar.jsp"/>
        <div class="col-sm-8 " style="padding: 0px 45px">
            <h4 class="text-muted">${massage}</h4>
            <form:form method="post" action="studentSave" commandName="student" role="form">
                <div style="display: none">
                <form:input path="id" value="${modifyingStudent.id}"/>
                </div>
                <div class="form-groups">
                    <form:label path="lastName">Фамилия:</form:label>
                    <form:input path="lastName" class="form-control" placeholder="Фамилия:"
                                value="${modifyingStudent.lastName}"/>
                </div>
                <div class="form-groups">
                    <form:label path="firstName">Имя:</form:label>
                    <form:input path="firstName" class="form-control" placeholder="Имя"
                                value="${modifyingStudent.firstName}"/>
                </div>
                <div class="form-groups">
                    <form:label path="groups">Группа:</form:label>
                    <form:input path="groups" class="form-control" placeholder="Группа"
                                value="${modifyingStudent.groups.name}"/>
                </div>
                <div class="form-groups">
                    <form:label path="weekOfEntry">Дата поступления:</form:label>
                    <form:input path="weekOfEntry" class="form-control" placeholder="Дата поступления"
                                value="${modifyingStudent.weekOfEntry}"/>
                </div>
                <div class="form-groups" style="padding:15px 0px">
                    <button type="submit" class="btn btn-success">${nameButton}</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>

