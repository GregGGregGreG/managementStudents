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
        <div class="col-sm-8  " style="padding: 0px 45px">
            <%--<div >--%>
                <%--<a href="<c:url value="/student/addStudent.html"/>">Add Students</a>--%>
            <%--</div>--%>
            <c:if test="${!empty students}">
                <h4 class="text-muted" style="padding: 0px 0px 10px 0px">Список студентов</h4>
                <table class="table table-bordered table-striped table-hover table-condensed">
                    <thead>
                    <tr >
                        <th class="text-info" >Фамилия</th>
                        <th class="text-info">Имя</th>
                        <th class="text-info">Группа</th>
                        <th class="text-info">Дата поступления</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${students}" var="student">
                        <tr>
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
    </div>
</div>
</body>
</html>
