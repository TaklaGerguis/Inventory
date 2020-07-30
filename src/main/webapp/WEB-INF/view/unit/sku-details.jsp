<%--
  Created by IntelliJ IDEA.
  User: tgerguis
  Date: 6/22/2020
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sku Details</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Units</h2>
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

    <div id="content">

        <input type="button" value="Add Quantity Unit" onclick="window.location.href='unitForm'; return false;"
               class="add-button"/>

        <form:form action="search" method="GET">
            Search Unit: <input type="text" name="searchName" />

            <input type="submit" value="Search" class="add-button" />
        </form:form>

        <table>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Action</th>
            </tr>

            <!-- loop over and print our customers -->
            <c:forEach items="${quantityUnits}" var="tempSku">
                <c:url var="detailsLink" value="/skues/details">
                    <c:param name="skuId" value="${tempSku.id}"/>
                </c:url>

                <c:url var="updateLink" value="/skues/showFormForUpdate">
                    <c:param name="skuId" value="${tempSku.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/skues/delete">
                    <c:param name="skuId" value="${tempSku.id}"/>
                </c:url>


                <tr>
                    <td> ${tempSku.id} </td>
                    <td> ${tempSku.name} </td>

                    <td>
                        <a href="${detailsLink}"> Details </a>
                        |
                        <a href="${updateLink}"> Update </a>
                        |
                        <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this Sku?')))
                            return false"> Delete </a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>
</div>

</body>
</html>
