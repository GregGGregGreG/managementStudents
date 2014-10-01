<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="modifyingStudent" type="greg.studentProgress.persistence.domain.Student"--%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>StudentCreating</title>
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <jsp:include page="navBar.jsp"/>
        <div class="col-sm-8 " style="padding: 0px 45px">
            <form:form method="post" action="/student/admin/studentSave" commandName="student" role="form">
                <c:choose>
                    <c:when test="${empty student.id}">
                    <h4 class="text-muted">Для создания студента заполните все поля и нажмите кнопку "Cоздать"</h4>

                        <div class="row">
                            <div class="form-groups col-sm-5">
                                <form:label path="lastName">Фамилия:</form:label>
                                <form:input path="lastName" class="form-control" placeholder="Введите фамилию:"/>
                            </div>
                            <div class="col-sm-6" style="margin-top: 30px">
                                <form:errors path="lastName" cssClass="text-danger"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-groups col-sm-5">
                                <form:label path="firstName">Имя:</form:label>
                                <form:input path="firstName" class="form-control" placeholder="Введите имя:"/>
                            </div>
                            <div class="col-sm-6" style="margin-top: 30px">
                                <form:errors path="firstName" cssClass="text-danger"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-groups col-sm-5">
                                <form:label path="groups">Группа:</form:label>
                                <form:select path="groups" id="groups" name="groups" class="form-control">
                                    <form:option value="" label="Выберите группу"/>
                                    <form:options items="${groups}" />
                                </form:select>
                            </div>
                            <div class="col-sm-5" style="margin-top: 30px">
                                <form:errors path="groups" cssClass="text-danger"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-groups col-sm-5">
                                <form:label path="weekOfEntry">Дата поступления:</form:label>
                                <form:input path="weekOfEntry" class="form-control" placeholder="Введите год поступления"/>
                                <button type="submit" class="btn btn-success" style="margin-top: 20px">Создать</button>
                            </div>
                            <div class="col-sm-5" style="margin-top: 30px">
                                <form:errors path="weekOfEntry" cssClass="text-danger"/>
                            </div>
                        </div>

                    </c:when>
                    <c:otherwise>
                        <h4 class="text-muted">Для модификации студента заполните все поля и нажмите кнопку
                            "Применить"</h4>
                        <div class="row">
                            <div class="form-groups col-sm-5">
                                <form:label path="lastName">Фамилия:</form:label>
                                <form:input path="lastName" class="form-control" placeholder="Введите фамилию:"
                                            value="${student.lastName}"/>
                            </div>
                            <div class="col-sm-6" style="margin-top: 30px">
                                <form:errors path="lastName" cssClass="text-danger"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-groups col-sm-5">
                                <form:label path="firstName">Имя:</form:label>
                                <form:input path="firstName" class="form-control" placeholder="Введите имя:"
                                            value="${student.firstName}"/>
                            </div>
                            <div class="col-sm-6" style="margin-top: 30px">
                                <form:errors path="firstName" cssClass="text-danger"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-groups col-sm-5">
                                <form:label path="groups">Группа:</form:label>
                                <form:select path="groups" id="groups" name="groups" class="form-control">
                                    <form:options items="${groups}"/>
                                </form:select>
                            </div>
                            <div class="col-sm-5" style="margin-top: 30px">
                                <form:errors path="groups" cssClass="text-danger"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-groups col-sm-5">
                                <form:label path="weekOfEntry">Дата поступления:</form:label>
                                <form:input path="weekOfEntry" class="form-control" placeholder="Введите год поступления"
                                            value="${student.weekOfEntry}"/>
                                <button type="submit" class="btn btn-success" name="id" value="${student.id}"
                                        style="margin-top: 20px">Применить
                                </button>
                            </div>
                            <div class="col-sm-5" style="margin-top: 30px">
                                <form:errors path="weekOfEntry" cssClass="text-danger"/>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>

