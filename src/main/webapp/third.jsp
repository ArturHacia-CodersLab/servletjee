<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 02.02.2020
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${not empty param.a ? param.a : "brak a"}
<br>
${not empty param.b ? param.b : "brak b"}
</body>
</html>
