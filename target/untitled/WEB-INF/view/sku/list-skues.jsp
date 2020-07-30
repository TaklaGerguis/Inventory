<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <title>List Skues</title>

    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Skues</h2>

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

        <input type="button" value="Add Sku" onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"/>

        <form:form action="search" method="GET">
            Search Sku: <input type="text" name="searchName"/>

            <input type="submit" value="Search" class="add-button"/>
        </form:form>

        <table>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Action</th>
            </tr>

            <c:forEach items="${skues}" var="tempSku">

                <c:url var="detailsLink" value="/QuantityUnits/details">
                    <c:param name="skuId" value="${tempSku.id}"/>
                </c:url>

                <c:url var="updateLink" value="/skues/showFormForUpdate">
                    <c:param name="skuId" value="${tempSku.id}"/>
                </c:url>

                <c:url var="addUnit" value="/QuantityUnits/unitForm">
                    <c:param name="skuId" value="${tempSku.id}"/>
                </c:url>

                <%--                <c:url var="addUnit">--%>
                <%--                    <c:redirect url="/QuantityUnits/unitForm">--%>
                <%--                        <c:param name="skuId"--%>
                <%--                                 value="${tempSku.id}"/>--%>
                <%--                    </c:redirect></c:url>--%>


                <c:url var="deleteLink" value="/skues/delete">
                    <c:param name="skuId" value="${tempSku.id}"/>
                </c:url>


                <tr>
                    <td> ${tempSku.id} </td>
                    <td> ${tempSku.name} </td>

                    <td>
                        <a href="${detailsLink}"> Details </a>
                        |
                        <a href="${addUnit}"> Add Unit </a>
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

    <form:form action="${pageContext.request.contextPath}/logout" method="post">

        <input type="submit" value="Logout"/>

    </form:form>

</div>


</body>

</html>
