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
        <div class="col-sm-9" style="padding: 0px 45px">
            <c:choose>
                <c:when test="${empty termId}">
                    <form:form method="post" action="/curriculums/admin/creating" commandName="curriculum" role="form">
                        <h4 class="text-muted">Для создания семестра заполните следующие данные и нажмите кнопку
                            "Cоздать"</h4>

                        <div class="row">
                            <div class="form-groups col-sm-5">
                                <form:label path="week">Длительность (в неделях):</form:label>
                                <form:input path="week" class="form-control"
                                            placeholder="Введите количество недель:"/>
                            </div>
                            <div class="col-sm-6" style="margin-top: 30px">
                                <form:errors path="week" cssClass="text-danger"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-groups col-sm-5">
                                <form:label path="disciplineList">Дисциплины в семестре</form:label>
                                <form:select path="disciplineList" class="form-control" items="${disciplineList}"
                                             multiple="true"/>
                                <button type="submit" class="btn btn-success" style="margin-top: 20px">Создать</button>
                            </div>
                            <div class="col-sm-6" style="margin-top: 30px">
                                <form:errors path="disciplineList" cssClass="text-danger"/>
                            </div>
                        </div>
                    </form:form>
                </c:when>
                <c:otherwise>
                    <form:form method="post" action="${requestScope['javax.servlet.forward.request_uri']}" commandName="curriculum" role="form">
                        <h4 class="text-muted">Для модификации семестра отредактируйте данные и нажмите кнопку
                            "Применить"</h4>
                                                  <div class="row">
                            <div class="form-groups col-sm-5">
                                <form:label path="week">Длительность (в неделях):</form:label>
                                <form:input path="week" class="form-control"
                                            placeholder="Введите количество недель:"
                                            value="${modifyingCurriculum.week}"/>
                            </div>
                            <div class="col-sm-6" style="margin-top: 30px">
                                <form:errors path="week" cssClass="text-danger"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-groups col-sm-5">
                                <form:label path="disciplineList">Дисциплины в семестре</form:label>
                                <form:select path="disciplineList" class="form-control" items="${disciplineList}"
                                             multiple="true"/>
                                <button type="submit" class="btn btn-success" style="margin-top: 20px">Применить
                                </button>
                            </div>
                            <div class="col-sm-6" style="margin-top: 30px">
                                <form:errors path="disciplineList" cssClass="text-danger"/>
                            </div>
                        </div>
                    </form:form>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>
