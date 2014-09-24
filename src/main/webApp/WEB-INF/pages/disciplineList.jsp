<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Discipline</title>
    <link href="http://getbootstrap.com/dist/css/bootstrap.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <jsp:include page="navBar.jsp"/>
        <form:form action="admin/handlerDisciplineList" method="post" role="form">
            <div class="col-sm-6" style="padding: 0px 45px">
            <c:if test="${!empty disciplines}">
                <h4 class="text-muted" style="padding: 0px 0px 10px 0px">Cписок дисциплин</h4>
                <table class="table table-bordered table-striped table-hover table-condensed">
                    <thead>
                    <tr>
                        <sec:authorize access="isAuthenticated()">
                            <th class="text-info"></th>
                        </sec:authorize>
                        <th class="text-info">Наименование дисциплины</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${disciplines}" var="discipline">
                        <tr>
                            <sec:authorize access="isAuthenticated()">
                            <td><input type="checkbox" name="id" value="${discipline.id}"/></td>
                            </sec:authorize>
                            <td>${discipline.name}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
        <div class="col-sm-4" style="margin: 45px 0px;" >
            <sec:authorize access="isAuthenticated()">
            <button class="btn btn-mini btn-block btn-primary" type="submit" name="action" value="creating">
                Создать дисциплину
            </button>
            <button class="btn btn-mini btn-block btn-primary" type="submit" name="action" value="modifying">
                Модифицировать выбранную дисциплину
            </button>
            <button class="btn btn-mini btn-block btn-primary" type="submit" name="action" value="remove">Удалить
                выбранную дисциплину
            </button>
            </sec:authorize>
        </div>
        </form:form>
    </div>
</div>
</body>
</html>
