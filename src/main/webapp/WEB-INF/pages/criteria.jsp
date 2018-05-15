<%@ include file="/WEB-INF/utils/pageMeta.jsp" %>
<html>
<%@include file="/WEB-INF/utils/head.jsp" %>
<title>Criteria</title>
<body>
<%@include file="/WEB-INF/components/navbar.jsp" %>
<%@include file="/WEB-INF/utils/footer.jsp" %>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-8">
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>Название</th>
                    <th>Тип</th>
                    <th>Оптимальность</th>
                    <th>Единицы</th>
                    <th>Шкала</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${criteria}" var="criterion">
                    <tr>
                        <td>${criterion.name}</td>
                        <td>${criterion.type}</td>
                        <td>${criterion.optimalType}</td>
                        <td>${criterion.unit}</td>
                        <td>${criterion.scale}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>