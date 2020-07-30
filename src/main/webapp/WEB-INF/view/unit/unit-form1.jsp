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
    <title>Add Quantity Unit</title>
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
        <h2>Add Quantity Unit</h2>
    </div>
</div>

<div id="container">
    <h3>Save Quantity Unit</h3>

    <%--@elvariable id="quantityUnit" type=""--%>
    <form:form action="saveQuantityUnit" modelAttribute="quantityUnit" method="post">
<%--        <c:url var="addUnit" value="/QuantityUnits/saveQuantityUnit">--%>
<%--            <c:param name="sku" value="${quantityUnit.sku}"/>--%>
<%--        </c:url>--%>
<%--        <a href="${addUnit}"> Add Unit </a>--%>

        ${param.skuId}
<%--        <form:hidden path= "skuId"/>--%>

        <table>
            <tbody>
            <tr>
<%--                ${skuId}--%>
                <td><label>Name:</label></td>
                <td><form:input path="name"/></td>
            </tr>

<%--            <tr>--%>
<%--                <td><label></label></td>--%>
<%--                <td><form:hidden path="sku"/></td>--%>
<%--                    ${quantityUnit}--%>
<%--            </tr>--%>


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
