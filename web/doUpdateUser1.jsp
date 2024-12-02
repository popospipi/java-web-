<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.text.DateFormat,java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<%@page import="ss.service.UserService"%>
<%@page import="ss.serviceimpl.UserServiceImpl"%>
<%@page import="ss.entity.User"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>保存修改结果</title>
</head>
<body>
<%
   	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("uid");
	String uname = request.getParameter("uname");
	String upassword = request.getParameter("upassword");
	
	User user = new User(uid,uname,upassword);

	UserService us = new UserServiceImpl();

	int n = us.updateUser(user);

	if(n > 0) {
		//修改成功
		response.sendRedirect("queryAllUser.jsp");
	}else {
		//修改失败
		response.sendRedirect("queryAllUser.jsp");
	}
%>

</body>
</html>