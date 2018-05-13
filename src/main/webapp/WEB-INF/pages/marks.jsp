<%@ include file="/WEB-INF/utils/pageMeta.jsp"%>
<html>
<head>
    <%@include file="/WEB-INF/utils/head.jsp"%>
    <title>Оценки</title>
</head>
<body>
<%@include file="/WEB-INF/components/navbar.jsp"%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-8">
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>Имя</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${persons}" var="person">
                    <tr>
                        <td>${person.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/utils/footer.jsp"%>
</body>
</html>