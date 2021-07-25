<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
<c:url value="/css/main.css" var="jstlCss"/>
<link href="${jstlCss}" rel="stylesheet"/>


<nav class="navbar navbar-inverse">
    <div class="container">
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="customerList">Customer List</a></li>
                <li><a href="filmList">Film List</a></li>
            </ul>
        </div>
    </div>
</nav>