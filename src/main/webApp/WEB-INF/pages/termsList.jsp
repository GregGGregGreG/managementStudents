<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TermList</title>
    <link href="http://getbootstrap.com/dist/css/bootstrap.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-theme.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <jsp:include page="navBar.jsp"/>
        <form:form method="post" action="/term/handlerTermsList" role="form" modelAttribute="term">
        <div class="col-sm-10">
            <div class="form-horizontal col-sm-10">
                <label for="curriculum1" class="col-sm-3 control-label ">Выберите семестр:</label>

                <div class="col-sm-2">
                    <form:select id="curriculum1" name="curriculum" class="form-control" path="nameTerm">
                        <c:forEach items="${curriculum}" var="term">
                            <option>${term.numberTerm}</option>
                        </c:forEach>
                    </form:select>
                        </div>
                <button class="btn btn-success" type="submit" name="action" value="selectTerm">Выбрать</button>
                <button class="btn btn-mini  btn-primary" type="submit" name="action"
                        value="creating">
                    Создать семестр
                </button>
            </div>
            <div style="padding: 60px 0px">
                <div class="col-sm-6" style="padding: 0px 45px">
                    <c:if test="${!empty listDiscipline}">
                        <h4 class="text-muted " style="padding: 5px 0px">Длительность семестра ${weekTerm.week}
                            недель</h4>
                        <h4 class="text-muted" style="padding: 5px 0px">Список дисциплин семестра </h4>
                        <table class="table table-bordered table-striped table-hover table-condensed">
                            <thead>
                            <tr>
                                <th class="text-info">Наименование дисциплины</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listDiscipline}" var="discipline">
                                <tr>
                                    <td>${discipline.pk.discipline.name}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
                <div class="col-sm-4" style="margin:85px  0px;">
                    <c:if test="${!empty listDiscipline}">
                        <button class="btn btn-mini btn-block btn-primary" type="submit" name="action"
                                value="modifying">
                            Модифцировать текущий семестр
                        </button>
                        <button class="btn btn-mini btn-block btn-primary" type="submit" name="action"
                                value="remove">
                            Удалить
                            текущий семестр
                        </button>
                    </c:if>
                </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>