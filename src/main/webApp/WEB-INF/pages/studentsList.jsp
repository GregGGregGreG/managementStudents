<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Students</title>
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/bootstrap.min.css" />" rel="stylesheet">

    <%--<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>--%>
    <%--<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css"/>--%>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"/>

    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <script>
        var countChecked = function () {
            var n = $('input:checked').length;
            if (n == 0) {
                $(alert("!"));
            }
        };
    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <jsp:include page="navBar.jsp"/>
        <div class="col-sm-8" style="padding: 0px 45px 0px">
            <form:form action="/students/" method="post" role="form">
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
                            <button formaction="/students/admin/creating" formmethod="get" type="submit"
                                    class="btn btn-mini btn-block btn-primary" >
                            Создать студента
                            </button>
                            <button class="btn btn-mini btn-block btn-primary" data-toggle="modal"
                                    data-target=".bs-example-modal-sm" onclick="countChecked()">Удалить выбарнных
                                студентов
                            </button>
                            <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
                                 aria-labelledby="mySmallModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog modal-sm modal-content">
                                    <div class="modal-body">
                                        <p>Вы действительно хотите удалить Студента</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button class="btn" data-dismiss="modal" aria-hidden="true">Отмена</button>
                                        <button class="btn btn-danger " type="submit" name="remove">Удалить</button>
                                    </div>
                                </div>
                            </div>
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
                                <th class="text-info">Дата поступления</th>
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
