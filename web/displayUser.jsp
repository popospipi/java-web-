<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="ss.service.UserService"%>
<%@page import="ss.serviceimpl.UserServiceImpl"%>
<%@page import="ss.entity.User"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查询用户详情</title>
	<link rel="stylesheet" href="displayUser.css">
</head>
<body>
<%
    String uid = request.getParameter("uid");

	UserService us = new UserServiceImpl();

	User user = us.queryOneUser(uid);

	if(user != null){
%>
		<table align="center">
			<tr>
				<td>用户</td>
				<td><input type="text" name="uid" value="<%=user.getUid() %>"></td>
			</tr>
			<tr>
				<td>昵称</td>
				<td><input type="text" name="uname" value="<%=user.getUname() %>"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><textarea rows="5" cols="70" name="content"><%=user.getUpassword() %></textarea> </td>
			</tr>
	</table>
<%
	}
%>
<br>
<center>
	<a href="queryAllUser.jsp">返回</a>
</center>

</body>
</html>