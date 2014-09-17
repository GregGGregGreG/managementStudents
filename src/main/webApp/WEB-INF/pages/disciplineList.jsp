<%--
  Created by IntelliJ IDEA.
  User: GreG
  Date: 10.09.2014
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Discipline</title>
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
        <div class="col-sm-6  " style="padding: 0px 45px">
            <c:if test="${!empty disciplines}">
                <h4 class="text-muted" style="padding: 0px 0px 10px 0px">Cписок дисциплин</h4>
                <table class="table table-bordered table-striped table-hover table-condensed">
                    <thead>
                    <tr>
                        <th class="text-info"></th>
                        <th class="text-info">Наименование дисциплины</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${disciplines}" var="disciplin">
                        <tr>
                            <td><input type="checkbox" id="cb3" name="cb3"/></td>
                            <td>${disciplin.name}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
        <div class="col-sm-4" style="margin: 35px;" >
            <a href="<c:url value="/discipline/addDiscipline.html"/>">
                <button class="btn btn-mini btn-block btn-primary" type="button" style="margin: 10px">Создать дисциплину</button>
            </a>
            <a href="<c:url value="/discipline/addDiscipline.html"/>">
                <button class="btn btn-mini btn-block btn-primary" type="button" style="margin: 10px">Модифцировать выбранную дисциплину</button>
            </a>
            <a href="<c:url value="/discipline/addDiscipline.html"/>">
                <button class="btn btn-mini btn-block btn-primary" type="button" style="margin: 10px">Удалить выбранную дисциплину</button>
            </a>
        </div>
    </div>
</div>
</body>
</html>
