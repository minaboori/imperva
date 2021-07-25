<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="nav-justified" align="center">
    <table tborder="1" cellpadding="5" cellspacing="5" class="table-cell" >
        <tr class="table-row-cell">
            <c:if test="${currentPage != 1}">
                <td ><a href="${pageUrl}?page=${currentPage - 1}">Previous</a></td>
            </c:if>
            <td class="table-cell">
                <table border="1" cellpadding="5" cellspacing="5">
                    <tr>
                        <c:forEach begin="1" end="${pageNumber}" var="i">
                            <c:choose>
                                <c:when test="${currentPage eq i}">
                                    <td>${i}</td>
                                </c:when>
                                <c:otherwise>
                                    <td><a href="${pageUrl}?page=${i}">${i}</a></td>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </tr>
                </table>
            </td>

            <%--For displaying Next link --%>
            <c:if test="${currentPage lt pageNumber}">
                <td><a href="${pageUrl}?page=${currentPage + 1}">Next</a></td>
            </c:if>
        </tr>
    </table>
</div>