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
    <title>StudentsList</title>
    <link href="http://getbootstrap.com/dist/css/bootstrap.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <jsp:include page="navBar.jsp"/>
        <div class="col-sm-8  " style="padding: 0px 45px 0px">
            <form:form action="/student/studentsList/studentProgress" method="POST" role="form">
                <div>
                    <div class="row">
                        <div class="col-sm-7">
                            <a href="<c:url value="/"/>">
                                <button class="btn btn-mini btn-block btn-primary" type="submit" name="action"
                                        style="margin: 10px"
                                        value="studentListProgress">
                                    Просмотреть успеваемость выбранных студентов
                                </button>
                            </a>
                            <a href="<c:url value="/"/>">
                                <button class="btn btn-mini btn-block btn-primary" type="submit" name="action"
                                        value="modifying" style="margin: 10px">
                                Модифцировать
                                    выбраннго студента
                                </button>
                            </a>
                        </div>
                        <div class="col-sm-5">
                            <a href="<c:url value="/student/studentCreating.html"/>">
                                <button class="btn btn-mini btn-block btn-primary" type="button" style="margin: 10px">
                                    Создать студента
                                </button>
                            </a><a href="<c:url value="/"/>">
                            <button class="btn btn-mini btn-block btn-primary" type="submit" name="action"
                                    value="remove"
                                    style="margin: 10px">
                                Удалить выбарнных студентов
                            </button>
                        </a>
                        </div>

                    </div>


                </div>
                <div>
                        <%--@elvariable id="students" type="java.util.List"--%>
                    <c:if test="${!empty students}">
                        <h4 class="text-muted" style="padding: 0px 0px 10px 0px">Список студентов</h4>
                        <table class="table table-bordered table-striped table-hover table-condensed">
                            <thead>
                            <tr>
                                <th></th>
                                <th class="text-info">Фамилия</th>
                                <th class="text-info">Имя</th>
                                <th class="text-info">Группа</th>
                                <th class="text-info">Дата поступления</th>
                            </tr>
                            </thead>
                    <tbody>
                        <%--@elvariable id="students" type="java.util.List"--%>
                    <c:forEach items="${students}" var="student">
                        <tr>
                            <td><input type="checkbox" name="id" value="${student.id}"/></td>
                            <td>${student.lastName}</td>
                            <td>${student.firstName}</td>
                            <td>${student.groups.name}</td>
                            <td>${student.weekOfEntry}</td>
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
