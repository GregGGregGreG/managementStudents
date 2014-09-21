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
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <jsp:include page="navBar.jsp"/>
        <div class="col-sm-8  " style="padding: 0px 45px">
            <h4 class="text-muted">${mesage}</h4>
            <form:form method="post" action="saveDiscipline" commandName="discipline" role="form">
                <div style="display: none">
                    <form:input path="id" value="${modifyingDiscipline.id}"/>
                </div>
                <div class="form-groups">
                        <form:label path="name">Название:</form:label>
                    <form:input path="name" class="form-control" placeholder="Название"
                                value="${modifyingDiscipline.name}"/>
                </div>
                    <div class="form-groups" style="padding:15px 0px">
                        <button type="submit" class="btn btn-success">${nameButton}</button>
                    </div>
                </form:form>
        </div>
    </div>
</div>
</body>
</html>
