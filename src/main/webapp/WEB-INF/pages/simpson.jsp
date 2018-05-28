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
        <div class="col-md-6">
            <c:if test="${results.isEmpty()}">
                <div class="alert alert-danger" role="alert">
                    Перейдите на <a href="/smart">страницу </a>, чтобы сделать выбор.
                </div>
            </c:if>
            <c:if test="${! results.isEmpty()}">
                <ul class="list-group">
                    <c:forEach items="${results}" var="result">
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            ${result.key}
                            <span class="badge badge-primary badge-pill">${result.value}</span>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/utils/footer.jsp" %>
</body>
</html>
