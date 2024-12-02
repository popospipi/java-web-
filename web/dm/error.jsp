<%--
  Created by IntelliJ IDEA.
  User: 86172
  Date: 2024/6/29
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
</head>
<body>
<h1>Error Occurred</h1>
<p>An error has occurred while processing your request:</p>
<p><strong><%= request.getAttribute("error") %></strong></p>

<p>Please try again later or contact the administrator.</p>
<a href="index.jsp">Return to Home Page</a>
</body>
</html>