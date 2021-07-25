<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
<html>
<body>
<div class="table-responsive">
    <h2>
        Payment List
    </h2>
    <table class="table table-hover table-condensed">
        <thead>
        <tr>
            <th>id</th>
            <th>Amount</th>
            <th>Payment Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${rental.paymentList}" var="payment">
            <tr>
                <td>${payment.paymentId}</td>
                <td>${payment.amount}</td>
                <td>${payment.paymentDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
