<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TermList</title>
    <link href="http://getbootstrap.com/dist/css/bootstrap.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="masthead">
        <h2 class="muted">Система управления студентами и их успеваемостью</h2>
        <hr>
    </div>
</div>
<div class="container">
    <a href="<c:url value=""/>">Create term..</a>
</div>
<div style="padding: 0px 200px; width: 184px; top: 0px;">
    <aside>
        <form:form action="/" method="get"><input type="submit"
                                                  class="btn btn-success btn-mini"
                                                  value="На главную"/>
        </form:form>
    </aside>
</div>
</div>
<div class="container">
    <c:if test="${!empty students}">
        <h3>Students</h3>
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Группа</th>
                <th>Дата поступления</th>
                <th>&nbsp;</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.lastName}</td>
                    <td>${student.firstName}</td>
                    <td>${student.groups.name}</td>
                    <td>${student.weekOfEntry}</td>
                    <td>
                        <form:form action="delete/${student.id}" method="post"><input type="submit"
                                                                                      class="btn btn-danger btn-mini"
                                                                                      value="Delete"/>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>