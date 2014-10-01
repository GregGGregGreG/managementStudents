<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddDiscipline</title>
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <jsp:include page="navBar.jsp"/>
        <div class="col-sm-11" style="padding: 0px 45px">
            <form:form method="post" action="/discipline/admin/disciplineSave" commandName="discipline" role="form">
                <c:choose>
                    <c:when test="${empty discipline.id}">
                        <h4 class="text-muted">Для того чтобы создать новую дисциплину заполните все поля и нажмите
                            кнопку "Cоздать"</h4>

                        <div class="row">
                            <div class="form-groups col-sm-5">
                                <form:label path="name">Дисциплина:</form:label>
                                <form:input path="name" class="form-control"
                                            placeholder="Введите название дисциплины:"/>
                                <button type="submit" class="btn btn-success" style="margin-top: 20px">Создать</button>
                            </div>
                            <div class="col-sm-6" style="margin-top: 30px">
                                <form:errors path="name" cssClass="text-danger"/>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <h4 class="text-muted">Для того чтобы модифицировать дисциплину введите новое значение поля и
                            нажмите кнопку "Применить"</h4>

                        <div class="row">
                            <div class="form-groups col-sm-5">
                                <form:label path="name">Дисциплина:</form:label>
                                <form:input path="name" class="form-control" placeholder="Введите название дисциплины::"
                                            value="${discipline.name}"/>
                                <button type="submit" class="btn btn-success" name="id" value="${discipline.id}"
                                        style="margin-top: 20px">Применить
                                </button>
                            </div>
                            <div class="col-sm-6" style="margin-top: 30px">
                                <form:errors path="name" cssClass="text-danger"/>
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
