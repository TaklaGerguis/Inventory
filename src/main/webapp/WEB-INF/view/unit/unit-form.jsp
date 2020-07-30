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

<!DOCTYPE html>

<html>
<head>
    <title>Add Unit</title>
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
        <h2>Add Unit</h2>
    </div>
</div>

<div id="container">
    <h3>Save Sku</h3>
    <form:form action="saveQuantityUnit" modelAttribute="quantityUnit" method="post">

        <form:hidden path="id"/>
        ${param.skuId}
    <table>
        <tbody>
        <tr>
            <td><label>Name:</label></td>
            <td><form:input path="name"/></td>
        </tr>

        <form:input path="sku" value = "${param.skuId}" />

<%--        <c:url var="addUnit" value="/QuantityUnits/saveQuantityUnit">--%>
<%--            <c:param name="skuId" value="${param.skuId}"/>--%>
<%--        </c:url>--%>
<%--        <c:set value="${param.skuId}" var="sku" scope="request"/>--%>

<%--        <tr>--%>
<%--            <td><label>Units:</label></td>--%>
<%--            <td><form:input path="units"/></td>--%>
<%--        </tr>--%>

        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save"/></td>
        </tr>

        </tbody>
    </table>
    </form:form>

    <div style="clear:both;"></div>
    <p>
        <a href="${pageContext.request.contextPath}/skues/list">Back To List</a>
    </p>

</div>

</body>
</html>
