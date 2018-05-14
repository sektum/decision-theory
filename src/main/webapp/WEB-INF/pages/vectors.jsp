<%@ include file="/WEB-INF/utils/pageMeta.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/utils/head.jsp" %>
    <title>Векторы</title>
</head>
<body>
<%@include file="/WEB-INF/components/navbar.jsp" %>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-8">
            <c:forEach items="${vectors}" var="vector">
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
            </c:forEach>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/utils/footer.jsp" %>
</body>
</html>