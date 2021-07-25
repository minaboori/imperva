<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>


<html>
<jsp:include page="layout/header.jsp"/>

<head>
    <h1>
        Film
    </h1>
</head>
<body>
<div class="table-responsive">
    <table class="table table-hover table-condensed">

        <tr>
            <td>id :</td>
            <td>${film.id}</td>
        </tr>

        <tr>
            <td>Film Title:</td>
            <td>${film.title}</td>
        </tr>

        <tr>
            <td>Film description</td>
            <td>${film.description}</td>
        </tr>
        <tr>
            <td>Film category </td>
            <td>${film.category}</td>
        </tr>
        <tr>
            <td>rating</td>
            <td>${film.rating}</td>
        </tr>
        <tr>
            <td>length</td>
            <td>${film.length}</td>
        </tr>

    </table>

</div>

<div class="table-responsive">
    <h2>
        Actor List
    </h2>
    <table class="table table-hover table-condensed">
        <thead>
        <tr>
            <th>Actor id</th>
            <th>Actor First Name</th>
            <th>Actor Last Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${film.actorList}" var="actor">
            <tr>
                <td>${actor.id}</td>
                <td>${actor.firstName}</td>
                <td>${actor.lastName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
