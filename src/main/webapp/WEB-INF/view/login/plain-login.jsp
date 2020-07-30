<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Custom Login Page</title>
    <style>
        .failed{
            color:red;
        }
    </style>
</head>
<body>
    <h3>Login</h3>

    <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">

        <c:if test="${param.error != null}">
            <i class="failed"> Invalid Credentials</i>
        </c:if>

        <p>
            User Name: <input type="text" name="username">
        </p>

        <p>
            Password: <input type="password" name="password">
        </p>

        <input type="submit" value="Login"/>

    </form:form>
</body>
</html>
