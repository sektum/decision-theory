<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="vector" required="true" type="dto.VectorDto" %>

<table class="table">
    <tbody>
    <c:forEach items="${vector.marks}" var="mark">
        <tr>
            <td>${mark.key}</td>
            <td>${mark.value}</td>
        </tr>
    </c:forEach>
    </tbody>
    <caption>${vector.altName}</caption>
</table>