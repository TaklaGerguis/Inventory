<%--
  Created by IntelliJ IDEA.
  User: tgerguis
  Date: 6/21/2020
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
<head>
    <title>Update Inventory</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-sku-style.css"/>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Update Inventory</h2>
    </div>
    <hr>
    <p>
        User: <security:authentication property="principal.username"/>
        <br><br>
        Role: <security:authentication property="principal.authorities"/>
    </p>
    <hr>
</div>

<div id="container">
    <h3>Save Inventory</h3>
    <form:form action="saveInventory" modelAttribute="inventory" method="post">

        <form:hidden path="id"/>

    <table>
        <tbody>
        <tr>
            <td><label>Current Quantity:</label></td>
            <td><form:input path="currentQuantity"/></td>
        </tr>

        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save"/></td>
        </tr>

        </tbody>
    </table>
    </form:form>

    <div style="clear:both;"></div>
    <p>
        <a href="${pageContext.request.contextPath}/inventories/list">Back To List</a>
    </p>

</div>

</body>
</html>
