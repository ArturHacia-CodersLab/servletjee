<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 26.01.2020
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty start && not empty end}">
    <c:forEach begin="${start}" end="${end}" var="element">
        ${element}<br>
    </c:forEach>
</c:if>
</body>
</html>
