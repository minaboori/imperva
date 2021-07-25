<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
<c:url value="/css/main.css" var="jstlCss"/>
<link href="${jstlCss}" rel="stylesheet"/>
<c:url var="editUrl" value="/editCustomer"/>
<c:url var="deleteUrl" value="/deleteCustomer"/>
<c:url var="detailUrl" value="/detailCustomer"/>

<html>
<jsp:include page="layout/header.jsp"/>

<head>
    <h1>
        Customer List
    </h1>
</head>
<body>

<jsp:include page="layout/paging.jsp"/>
<div class="nav-justified" align="center">
    <table class="table-bordered table" width="100%" tborder="1" cellpadding="5" cellspacing="5" >
        <tr>
            <td>
                <table >
                    <tr>
                        <td>Id</td>
                        <td><input type="text" name="id" id="id"></td>

                        <td>First Name</td>
                        <td><input type="text" name="firstName" id="firstName"></td>

                        <td>Last Name</td>
                        <td><input type="text" name="lastName" id="lastName"></td>
                    </tr>
                    <tr>
                        <td colspan="6" align="center" ><input type="button" value="search" onclick="javascript:searchCustomer()"></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>


<script type="text/javascript">

    function searchCustomer() {
        var path = "searchCustomer" + "?id=" + document.getElementById("id").value
            + "&firstName=" + document.getElementById("firstName").value
            + "&lastName=" + document.getElementById("lastName").value;
        window.location.href = path;

    }

</script>

<div class="table-responsive">
    <table class="table table-hover table-condensed">
        <thead>
        <tr>
            <th>id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th style="text-align:center">Edit</th>
            <th style="text-align:center">Delete</th>
            <th style="text-align:center">Detail</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td style="font-weight: bold; font-size:15px">${customer.firstName}</td>
                <td style="font-weight: bold; font-size:15px">${customer.lastName}</td>
                <td style="font-weight: bold; text-align:right">
                    <a href="${editUrl}?id=${customer.id}">Edit</a>
                </td>
                <td style="font-weight: bold; text-align:right">
                    <a href="${deleteUrl}?id=${customer.id}">Delete</a>
                </td>
                <td style="font-weight: bold; text-align:right">
                    <a href="${detailUrl}?id=${customer.id}">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<jsp:include page="layout/footer.jsp"/>
</html>
