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
            <c:if test="${matrix.isEmpty()}">
                <div class="alert alert-danger" role="alert">
                    Перейдите на <a href="/smart">страницу </a>, чтобы сделать выбор.
                </div>
            </c:if>
            <c:if test="${! matrix.isEmpty()}">
            <table class="table">
                <thead>
                <tr>
                    <td></td>
                    <c:forEach items="${matrix.alternatives}" var="alternative">
                        <th class="text-center">${alternative}</th>
                    </c:forEach>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${matrix.alternatives}" var="outer">
                    <tr>
                        <td class="font-weight-bold">${outer}</td>
                        <c:forEach items="${matrix.alternatives}" var="inner">
                            <td class="text-center">${matrix.get(outer, inner).sign}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </c:if>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/utils/footer.jsp" %>
</body>
</html>