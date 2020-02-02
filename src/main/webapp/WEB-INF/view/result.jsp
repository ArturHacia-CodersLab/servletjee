<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 02.02.2020
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${not empty message ? message : null}
<c:if test="${not empty book}">
    Tytuł: ${book.title}<br>
    Autor: ${book.author}<br>
    ISBN: ${book.isbn}
</c:if>
</body>
</html>
