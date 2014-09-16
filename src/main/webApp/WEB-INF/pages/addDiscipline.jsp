<%--
  Created by IntelliJ IDEA.
  User: GreG
  Date: 15.09.2014
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddDiscipline</title>
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
<div style="padding: 0px 200px; width: 184px; top: 0px;">
    <aside>
        <form:form action="/" method="get"><input type="submit"
                                                  class="btn btn-success btn-mini"
                                                  value="На главную"/>
        </form:form>
    </aside>
</div>
<div class="container">
    <h3>Для того чтобы создать новую дисциплину заполните все поля и нажмите кнопку "Cоздать": </h3>
    <form:form method="post" action="saveDiscipline" commandName="discipline" role="form">
        <div class="form-groups">
            <form:label path="name">Название:</form:label>
            <form:input path="name" class="form-control" placeholder="Название"/>
        </div>
        <div class="form-groups" style="padding:15px 0px">
            <button type="submit" class="btn btn-default">Создать</button>
        </div>
    </form:form>
</div>

</body>
</html>