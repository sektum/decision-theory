<%@ include file="/WEB-INF/utils/pageMeta.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/utils/head.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/components/navbar.jsp" %>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-8">
            <table class="table">
                <c:forEach begin="0" end="13" varStatus="loop">
                    <tbody>
                    <c:forEach items="${smartpairs.get(loop.index).marks}" var="mark">
                        <tr>
                            <td>${mark.key}</td>
                            <td>${mark.value}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <c:if test="${loop.index % 2 == 0}">
                        <form method="post">
                            <label>
                                <input type="checkbox" class="radio" value="${smartpairs.get(loop.index).altName}" name="choice" />${smartpairs.get(loop.index).altName}</label>
                            <label>
                                <input type="checkbox" class="radio" value="${smartpairs.get(loop.index + 1).altName}" name="choice" />${smartpairs.get(loop.index + 1).altName}</label>
                            <label>
                                <input type="checkbox" class="radio" value="=" name="choice" />EQUALS</label>
                            <input type="submit" class="button" value="Choose"/>
                        </form>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/utils/footer.jsp" %>
</body>
</html>