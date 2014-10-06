<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentsList</title>
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <jsp:include page="navBar.jsp"/>
        <div class="col-sm-8" style="padding: 0px 45px 0px">
            <form:form action="/student/studentsList" method="post" role="form">
                <div>
                    <div class="row">
                        <div class="col-sm-7">
                            <button class="btn btn-mini btn-block btn-primary" type="submit"
                                    name="studentListProgress">
                            Просмотреть успеваемость выбранных студентов
                            </button>
                            <sec:authorize access="isAuthenticated()">
                            <button class="btn btn-mini btn-block btn-primary" type="submit" name="modifying">
                            Модифцировать выбраннго студента
                            </button>
                        </div>
                        <div class="col-sm-5">
                            <button formaction="/student/admin/studentCreating" formmethod="get" type="submit"
                                    class="btn btn-mini btn-block btn-primary" >
                            Создать студента
                            </button>
                            <button  class="btn btn-mini btn-block btn-primary" type="submit" name="remove">
                            Удалить выбарнных студентов
                            </button>
                        </div>
                        </sec:authorize>
                    </div>
                </div>
                <div>
                    <c:if test="${!empty studentsList}">
                        <h4 class="text-muted" style="margin-top: 10px">Список студентов</h4>
                        <table class="table table-bordered table-striped table-hover table-condensed">
                            <thead>
                            <tr>
                                <th></th>
                                <th class="text-info">Фамилия</th>
                                <th class="text-info">Имя</th>
                                <th class="text-info">Группа</th>
                                <th  class="text-info" >Дата поступления</th>
                            </tr>
                            </thead>
                    <tbody>
                    <c:forEach items="${studentsList}" var="student">
                    <tr>
                            <td><input type="checkbox" name="studentsId" value="${student.id}"/></td>
                            <td>${student.lastName}</td>
                            <td>${student.firstName}</td>
                            <td>${student.groups.name}</td>
                            <td >${student.weekOfEntry}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
