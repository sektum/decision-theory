<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="vector" required="true" type="dto.VectorDto" %>
<%@ attribute name="strike" required="false" %>

<table class="table">
    <tbody>
    <c:forEach items="${vector.marks}" var="mark">
        <tr>
            <td>
                <c:if test="${strike}">
                    <input type="checkbox" class="_criterionCheck" checked/>
                </c:if>
            </td>
            <td class="_criterion">${mark.key}</td>
            <td class="_mark">${mark.value}</td>
        </tr>
    </c:forEach>
    </tbody>
    <caption>${vector.altName}</caption>
</table>