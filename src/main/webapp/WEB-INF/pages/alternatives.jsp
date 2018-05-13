<%@include file="/WEB-INF/utils/pageMeta.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <%@ include file="/WEB-INF/utils/head.jsp" %>
    <title>Hello, world!</title>
</head>
<body>
<%@include file="/WEB-INF/components/navbar.jsp"%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-6">
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>Название альтернативы</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${alternatives}" var="alternative">
                    <tr>
                        <td>${alternative.name}</td>
                    </tr>
                </c:forEach></tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/utils/footer.jsp" %>
</body>
</html>