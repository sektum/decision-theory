<%@ include file="/WEB-INF/utils/pageMeta.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/utils/head.jsp" %>
    <title>Оценки</title>
</head>
<body>
<%@include file="/WEB-INF/components/navbar.jsp" %>
<div class="container">
    <c:forEach items="${criteria}" var="criterion">
        <div class="row justify-content-center">
            <div class="col-8">
                <h3>${criterion.name}</h3>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-8">
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th>Оценка</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${criterion.marks}" var="mark">
                        <tr>
                            <td>${mark.name}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:forEach>
</div>
<%@include file="/WEB-INF/utils/footer.jsp" %>
</body>
</html>