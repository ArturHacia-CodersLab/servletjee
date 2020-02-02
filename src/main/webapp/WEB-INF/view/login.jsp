<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 02.02.2020
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${not empty message ? message : null}
<form  method="post">
    <input type="text"  name="username"/>
    <input name="password" type="password"/>
    <button type="submit">Zaloguj</button>
</form>
</body>
</html>
