<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <title>Main Menu</title>

    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>eCommerce</h2>

    </div>
    <hr>
    <p>
        User: <security:authentication property="principal.username"/>
        <br><br>
        Role: <security:authentication property="principal.authorities"/>
    </p>
    <hr>
</div>

<h2>
    Home
</h2>

<p>
    <a href="${pageContext.request.contextPath}/skues/list">Skues</a>
</p>

<p>
    <a href="${pageContext.request.contextPath}/inventories/list">Inventory</a>
</p>

<p>
    <a href="${pageContext.request.contextPath}/skues/list">Advices</a>
</p>

<p>
    <a href="${pageContext.request.contextPath}/skues/list">Orders</a>
</p>


<form:form action="${pageContext.request.contextPath}/logout" method="post">

    <input type="submit" value="Logout"/>

</form:form>

</body>
</html>