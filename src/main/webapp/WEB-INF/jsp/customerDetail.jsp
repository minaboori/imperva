<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
<c:url var="detailUrl" value="/detailRental"/>

<html>
<jsp:include page="layout/header.jsp"/>

<head>
    <h1>
        Customer
    </h1>
</head>
<body>
<div class="">
    <table class="table">

        <tr>
            <td>id :</td>
            <td>${customer.id}</td>
        </tr>

        <tr>
            <td>First Name :</td>
            <td>${customer.firstName}</td>
            <td>Last Name :</td>
            <td >${customer.lastName}</td>
        </tr>

        <tr>
            <td>Country :</td>
            <td>${customer.country}</td>
            <td>City :</td>
            <td>${customer.city}</td>
        </tr>

        <tr>
            <td>Address :</td>
            <td>${customer.address}</td>
            <td>Phone :</td>
            <td>${customer.phone}</td>
        </tr>
    </table>

</div>

<div class="table-responsive">
    <h2>
        Rental List
    </h2>
    <table class="table table-hover table-condensed">
        <thead>
        <tr>
            <th>id</th>
            <th>Film Title</th>
            <th>Rental Date</th>
            <th>return Date</th>
            <th>duration</th>
            <th style="text-align:center">Payment Detail</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customer.rentalFilms}" var="rental">
            <tr>
                <td>${rental.rentalId}</td>
                <td style="font-weight: bold; font-size:15px"><a
                        href="detailFilm?id=${rental.filmId}">${rental.filmTitle}</a></td>
                <td style="font-weight: bold; font-size:15px">${rental.rentalDate}</td>
                <td style="font-weight: bold; font-size:15px">${rental.returnDate}</td>
                <td style="font-weight: bold; font-size:15px">${rental.duration}</td>
                <td style="font-weight: bold; text-align:right">
                    <a href="javascript:showPaymentDetail('${detailUrl}','${rental.rentalId}','${customer.id}');">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
<script type="text/javascript">
    function showPaymentDetail(detailUrl, id, customerId) {
        var path = detailUrl + "?id=" + id + "&customerId=" + customerId;
        // alert("show" + path);
        popup_window = window.open(path, "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,top=500,left=500,width=400,height=250");
        popup_window.focus();
    }

</script>