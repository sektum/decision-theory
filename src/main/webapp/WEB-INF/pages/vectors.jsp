<%@ include file="/WEB-INF/utils/pageMeta.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/utils/head.jsp" %>
    <title>Векторы</title>
</head>
<body>
<%@include file="/WEB-INF/components/navbar.jsp" %>
<div class="container">
    <c:forEach items="${vectors}" var="alternative">
    </c:forEach>
</div>
<%@include file="/WEB-INF/utils/footer.jsp" %>
</body>
</html>