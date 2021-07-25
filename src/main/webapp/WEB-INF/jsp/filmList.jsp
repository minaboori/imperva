<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
<c:url var="editUrl" value="/editFilm"/>
<c:url var="deleteUrl" value="/deleteFilm"/>
<c:url var="detailUrl" value="/detailFilm"/>

<html>
<jsp:include page="layout/header.jsp"/>

<head>
    <h1>
        Film List
    </h1>
</head>
<body>
<jsp:include page="layout/paging.jsp" />
<div class="table-responsive">
    <table class="table table-hover table-condensed">
        <thead>
        <tr>
            <th>id</th>
            <th>title</th>
<%--            <th>description</th>--%>
            <th>category</th>
            <th>length</th>
            <th>rating</th>
<%--            <th style="text-align:center">Edit</th>--%>
            <th style="text-align:center">Delete</th>
            <th style="text-align:center">Detail</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${filmList}" var="film">
            <tr>
                <td>${film.id}</td>
                <td style="font-weight: bold; font-size:15px">${film.title}</td>
<%--                <td style="font-weight: bold; font-size:15px">${film.description}</td>--%>
                <td style="font-weight: bold; font-size:15px">${film.category}</td>
                <td style="font-weight: bold; font-size:15px">${film.length}</td>
                <td style="font-weight: bold; font-size:15px">${film.rating}</td>
<%--                <td style="font-weight: bold; text-align:right">--%>
<%--                    <a href="${editUrl}?id=${film.id}">Edit</a>--%>
<%--                </td>--%>
                <td style="font-weight: bold; text-align:right">
                    <a href="${deleteUrl}?id=${film.id}">Delete</a>
                </td>
                <td style="font-weight: bold; text-align:right">
                    <a href="${detailUrl}?id=${film.id}">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="layout/footer.jsp"/>
</body>
</html>
