<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<div class="container">
    <div class="text-right">
        <sec:authorize access="!isAuthenticated()">
            <p><a href="<c:url value="/login" />" role="button">Войти</a></p>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <p>Ваш логин: <sec:authentication property="principal.username"/></p>

            <p><a href="<c:url value="/logout" />" role="button">Выйти</a></p>
        </sec:authorize>
    </div>

    <div class="row">
        <div>
            <div class=" text-center ">
                <h2 class="text-muted">Система управления студентами и их успеваемостью</h2>
            </div>

        </div>
    </div>
    <hr>
</div>
