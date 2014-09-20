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
        <div class="col-sm-8 col-dm-2 ">
            <div class=" form-horizontal col-sm-8">
                <form:form method="post" action="showDisciplineInTerm" role="form" modelAttribute="term">
                    <div>
                        <label for="curriculum1" class="col-sm-5 control-label ">Выберите семестр:</label>

                        <div class="col-sm-3">
                            <form:select id="curriculum1" name="curriculum" class="form-control" path="nameTerm">
                                <c:forEach items="${curriculum}" var="term">
                                    <option>${term.numberTerm}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <button type="submit" class="btn btn-success">Выбрать</button>
                    </div>
                </form:form>
                <div style="padding: 10px 45px">
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
            </div>
        </div>
    </div>
</div>
</body>
</html>