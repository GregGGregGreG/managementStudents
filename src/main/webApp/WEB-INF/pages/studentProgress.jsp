
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentsProgress</title>
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <jsp:include page="navBar.jsp"/>
        <div class="col-sm-10" style="padding: 0px 45px">
            <%--@elvariable id="StudentProgressListDto" type="greg.studentProgress.dto.StudentProgressListDto"--%>
                <form:form method="get"
                           action="${requestScope['javax.servlet.forward.request_uri']}"
                           role="form"
                           modelAttribute="studentProgressListDto">
                    <c:forEach items="${StudentProgressListDto.progressDtoList}" var="StudentProgress">

                        <h4 class="text-muted" style="margin-top: 10px">Отображена успеваемость для следующего
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
                                <td>${StudentProgress.student.lastName}</td>
                                <td>${StudentProgress.student.firstName}</td>
                                <td>${StudentProgress.student.groups.name}</td>
                                <td>${StudentProgress.student.weekOfEntry}</td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="row">
                            <div class="col-sm-5 ">
                                <c:if test="${!empty StudentProgress.studentProgressList}">
                                    <h4 class="text-info">Список дисциплин за ${StudentProgress.termId} семестр</h4>
                                    <table class="table table-bordered table-striped table-hover table-condensed">
                                        <thead>
                                        <tr>
                                            <th class="text-info">Дисциплина</th>
                                            <th class="text-info">Оценка</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${StudentProgress.studentProgressList}" var="progress">
                                            <tr>
                                                <td>${progress.pk.curriculum.pk.discipline.name}</td>
                                                <td>${progress.rating}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </c:if>
                                <c:if test="${empty StudentProgress.studentProgressList}">
                                    <h4 class="text-danger" style="margin-top: 30px">Успеваемость за
                                            ${StudentProgress.termId}
                                        семестр отсутствует</h4>
                                </c:if>
                            </div>
                            <div class="col-sm-6" style="margin-top: 25px">
                                <div>
                                    <div style="display: none">
                                        <input name="termsId"
                                               value="${StudentProgress.termId}"/>
                                    </div>
                                    <div class=" form-horizontal">
                                        <label for="term" class="col-sm-5 control-label ">Выбрать семестр:</label>

                                        <div class="col-sm-3">
                                            <select id="term" name="term" class="form-control">
                                                <c:forEach items="${termList}" var="term">
                                                    <option>${term.numberTerm}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <button type="submit" name="studentId" value="${StudentProgress.student.id}"
                                                class="btn btn-success">Выбрать
                                        </button>
                                    </div>
                                </div>
                                <div style="margin-top: 30px">
                                    <c:if test="${!empty StudentProgress.studentProgressList}">
                                        <h4 class="text-muted">Средняя оценка за
                                            симестр ${StudentProgress.averageRating}</h4>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </form:form>
        </div>
    </div>
</div>
</body>
</html>

