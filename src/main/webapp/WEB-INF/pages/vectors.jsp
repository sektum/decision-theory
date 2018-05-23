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
                <my:vector vector="${vector}"/>
            </c:forEach>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/utils/footer.jsp" %>
</body>
</html>