<%@ include file="/WEB-INF/utils/pageMeta.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/utils/head.jsp" %>
    <title>Smart выбор</title>
</head>
<body>
<%@include file="/WEB-INF/components/navbar.jsp" %>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-8">
            <c:forEach items="${smartpairs}" var="smartpairs">
                <caption>${smartpairs.altName}</caption>
                <table class="table">
                    <tbody>
                    <!--XZ-->
                    </tbody>
                </table>
                <input type="submit" name="Equals" value="Equals">
                <input type="submit" name="Choose1" value="Choose">
                <input type="submit" name="Choose2" value="Choose">
            </c:forEach>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/utils/footer.jsp" %>
</body>
</html>