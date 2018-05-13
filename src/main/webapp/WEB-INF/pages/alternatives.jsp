<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<ul>
<c:forEach items="${alternatives}" var="alternative">
    <li>${alternative}</li>
</c:forEach>
</ul>
</body>
</html>