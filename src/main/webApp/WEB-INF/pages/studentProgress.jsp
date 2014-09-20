
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentsProgress</title>
    <link href="http://getbootstrap.com/dist/css/bootstrap.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <jsp:include page="navBar.jsp"/>
        <div class="col-sm-10" style="padding: 0px 45px">
            <c:if test="${!empty modifyingStudent}">
                <h4 class="text-muted" style="padding: 0px 0px 10px 0px">Отображена успеваемость для следующего
                    студента:</h4>
                <table class="table table-bordered table-striped table-hover table-condensed">
                    <thead>
                    <tr>
                        <th class="text-info">Фамилия</th>
                        <th class="text-info">Имя</th>
                        <th class="text-info">Группа</th>
                        <th class="text-info">Дата поступления</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${modifyingStudent.lastName}</td>
                        <td>${modifyingStudent.firstName}</td>
                        <td>${modifyingStudent.groups.name}</td>
                        <td>${modifyingStudent.weekOfEntry}</td>
                    </tr>
                    </tbody>
                </table>
            </c:if>
            <div class="row" style="padding: 20px 20px 0px 0px">
                <div class="col-sm-5 ">
                    <c:if test="${!empty studentProgressList}">
                        <table class="table table-bordered table-striped table-hover table-condensed">
                            <thead>
                            <tr>
                                <th class="text-info">Дисциплина</th>
                                <th class="text-info">Оценка</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${studentProgressList}" var="studentProgress">
                                <tr>
                                    <td>${studentProgress.pk.curriculum.pk.discipline.name}</td>
                                    <td>${studentProgress.rating}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
                <div class="col-sm-6 ">
                    <div>
                        <form:form method="get" action="/student/studentProgress" role="form"
                                   modelAttribute="SPDto">
                            <div class=" form-horizontal">
                                <label for="term" class="col-sm-5 control-label ">Выбрать семестр:</label>

                                <div class="col-sm-3">
                                    <div style="display: none">
                                        <form:input path="studentId" value="${modifyingStudent.id}"/>
                                    </div>
                                    <form:select id="term" name="term" class="form-control" path="termId">
                                        <c:forEach items="${termList}" var="term">
                                            <option>${term.numberTerm}</option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <button type="submit" class="btn btn-success">Выбрать</button>
                            </div>
                        </form:form>
                    </div>
                    <div style="padding: 0px 30px">
                        <c:if test="${!empty studentProgressList }">
                            <h4 class="text-muted">Средняя оценка за симестр ${averageRating}</h4>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>

