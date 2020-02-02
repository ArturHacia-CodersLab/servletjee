<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 02.02.2020
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty books}">
    <c:forEach var="book" items="${books}">
        Tytuł: ${book.title} Autor: ${book.author} ISBN: ${book.isbn}<br>
    </c:forEach>
</c:if>
</body>
</html>
