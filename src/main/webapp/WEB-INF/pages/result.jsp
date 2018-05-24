<%@include file="/WEB-INF/utils/pageMeta.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <%@ include file="/WEB-INF/utils/head.jsp" %>
    <title>Результаты</title>
</head>
<body>
<%@include file="/WEB-INF/components/navbar.jsp" %>
<div class="container">
    <div class="row justify-content-center">
        <div class="col">
            <table>
                <thead>
                <tr>
                    <td>/</td>
                    <c:forEach items="${alternatives}" var="alternative">
                        <th>${alternative}</th>
                    </c:forEach>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${alternatives}" var="alt1">
                    <c:forEach items="${alternatives}" var="alt2">
                            <tr>
                                <td class="font-weight-bold">${alt2}</td>
                                <td>${comparisons.get(f:of(alt1, alt2))}</td>
                            </tr>
                    </c:forEach>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/utils/footer.jsp" %>
</body>
</html>