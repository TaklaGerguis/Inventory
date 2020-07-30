<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <title>List Inventories</title>

    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Inventories</h2>

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

        <!--  add our html table here -->

        <input type="button" value="Add Inventory" onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"/>

        <form:form action="search" method="GET">
            Search Inventory: <input type="text" name="searchName"/>

            <input type="submit" value="Search" class="add-button"/>
        </form:form>

        <table>
            <tr>
                <th>id</th>
                <th>sku_id</th>
                <th>unit_id</th>
                <th>current_quantity</th>
                <th>best_by</th>
            </tr>

            <c:forEach items="${inventories}" var="tempInventory">


                <c:url var="updateLink" value="/inventories/inventoryForm">
                    <c:param name="inventoryId" value="${tempInventory.id}"/>
                </c:url>

<%--                <c:url var="deleteLink" value="/skues/delete">--%>
<%--                    <c:param name="inventoryId" value="${tempInventory.id}"/>--%>
<%--                </c:url>--%>


                <tr>
                    <td> ${tempInventory.id} </td>
                    <td> ${tempInventory.skuName} </td>
                    <td> ${tempInventory.unitName} </td>
                    <td> ${tempInventory.currentQuantity} </td>
                    <td> ${tempInventory.bestBy} </td>


                    <td>

                        <a href="${updateLink}"> Update </a>
                        |
                        <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this ' +
                         'Inventory?')))
                            return false"> Delete </a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>

    <form:form action="${pageContext.request.contextPath}/logout" method="post">

        <input type="submit" value="Logout"/>

    </form:form>

</div>


</body>

</html>
