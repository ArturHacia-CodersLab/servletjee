<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 26.01.2020
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${not empty userRole ? userRole : "guest"}
<br><br>
<c:choose>
    <c:when test="${not empty userRole}">
        ${userRole}
    </c:when>
    <c:otherwise>
        guest
    </c:otherwise>
</c:choose>
</body>
</html>
