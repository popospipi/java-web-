<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="ss.service.UserService"%>
<%@page import="ss.serviceimpl.UserServiceImpl"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>删除用户</title>
</head>
<body>
<%
	String uid = request.getParameter("uid");

	UserService us = new UserServiceImpl();

	int n = us.removeUser(uid);

	if(n>0) {
		response.sendRedirect("queryAllUser.jsp");
	}else {
		response.getWriter().println("删除失败！");
	}

%>

</body>
</html>