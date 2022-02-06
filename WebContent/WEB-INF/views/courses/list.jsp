<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Курсы</title>
</head>
<body>
    <h1>Курсы</h1>
    <div id="userinfo">
        <s:authorize access="isAuthenticated()">Привет,
            <s:authentication property="principal.username" />!
            <br/>
            <a href="../j_spring_security_logout">Выход</a>
        </s:authorize>
    </div>
    <br/>
    <s:authorize access="isAnonymous()">
        <form id="login" name="loginForm" action="../j_spring_security_check"
              method="POST">
            <label>Логин: </label>&nbsp;
            <input type="text" name="j_username">
            <label>Пароль: </label>&nbsp;
            <input type="password" name="j_password">
            <input type="submit" name="submit" value="Войти">
        </form>
        <br/>
    </s:authorize>
    <c:if test="${not empty courses}">
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Title</td>
                <td>Duration</td>
                <td>Description</td>
                <s:authorize access="hasRole('ROLE_USER')">
                <td colspan="2">Action</td>
                </s:authorize>
            </tr>
            <c:forEach items="${courses}" var="course">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.title}</td>
                    <td>${course.length}</td>
                    <td>${course.description}</td>
                    <s:authorize access="hasRole('ROLE_USER')">
                        <td><a href="update/${course.id}">edit</a></td>
                        <td><a href="delete/${course.id}">delete</a></td>
                    </s:authorize>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <s:authorize access="hasRole('ROLE_USER')">
        <p><a href="update/0">add new entry</a></p>
    </s:authorize>
</body>
</html>