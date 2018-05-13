<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <%@ include file="/WEB-INF/utils/meta.jsp"%>
    <%@ include file="/WEB-INF/utils/styles.jsp"%>
    <title>Hello, world!</title>
</head>
<body>
<c:forEach items="${alternatives}" var="alternative">
    ${alternative}
</c:forEach>
<%@ include file="/WEB-INF/utils/scripts.jsp"%>
</body>
</html>