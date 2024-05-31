<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2>Home Page</h2>
    <p>Welcome, <c:out value="${pageContext.request.userPrincipal.name}"/>!</p>
    <a href="/logout">Logout</a>
</body>
</html>
