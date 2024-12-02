<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="ss.service.UserService"%>
<%@page import="ss.serviceimpl.UserServiceImpl"%>
<%@page import="ss.entity.User"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改用户</title>s
	<link rel="stylesheet" href="doUpdateUser.css">
</head>
<body>
<%
    String uid = request.getParameter("uid");

	UserService Us = new UserServiceImpl();

	User user = Us.queryOneUser(uid);
%>
	<form action="doUpdateUser1.jsp" method="post">
		<input type="hidden" name="uid" value="<%=user.getUid() %>">
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
				<td><textarea rows="5" cols="70" name="upassword"><%=user.getUpassword() %></textarea> </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="保存修改">
				</td>
			</tr>
		</table>
	</form>

<br>
<center>
	<a href="queryAllUser.jsp">返回</a>
</center>

</body>
</html>