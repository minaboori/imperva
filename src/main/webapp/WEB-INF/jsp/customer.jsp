<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
<c:url var="editUrl" value="/editCustomer"/>
<c:url var="deleteUrl" value="/deleteCustomer"/>
<c:url var="detailUrl" value="/detailCustomer"/>

<html>
<jsp:include page="layout/header.jsp"/>

<head>
    <h1>
        Customer
    </h1>
</head>
<body>
<form action="updateCustomer"  method="post" >
    <div class="table-responsive">
        <table class="table table-hover table-condensed">

            <tr>
                <td>id :</td>
                <td>${customer.id}<input type="hidden" name="id" value="${customer.id}"> </td>
            </tr>

            <tr>
                <td>First Name :</td>
                <td><input class="input-sm" type="text" name="firstName" value="${customer.firstName}"></td>
            </tr>

            <tr>
                <td>Last Name :</td>
                <td><input class="input-sm" type="text" name="lastName" value="${customer.lastName}"></td>
            </tr>

            <tr>
                <td>Country :</td>
                <td><input class="input-sm" type="text" name="country" value="${customer.country}"></td>
            </tr>

            <tr>
                <td>City :</td>
                <td><input class="input-sm" type="text" name="city" value="${customer.city}"></td>
            </tr>

            <tr>
                <td>Address :</td>
                <td><input class="input-sm" type="text" name="address" value="${customer.address}"></td>
            </tr>

            <tr>
                <td>Phone :</td>
                <td><input class="input-sm" type="text" name="phone" value="${customer.phone}"></td>
            </tr>


        </table>
    </div>
    <button  class="btn-link" type="submit" value="save">Save</button>
    <a class="btn-link" href="customerList" >Cancel</a>
</form>
</body>
</html>
