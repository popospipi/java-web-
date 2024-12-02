<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="ss.service.CommentService"%>
<%@page import="ss.serviceimpl.CommentServiceImpl"%>
<%@page import="ss.entity.Comment"%>
<%@ page import="java.util.List" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询讨论详情</title>
    <link rel="stylesheet" href="displayUser.css">
</head>
<body>
<%
    String aname = request.getParameter("aname");
    String username = request.getParameter("username");

    CommentService us = new CommentServiceImpl();

    Comment comment = us.queryOneComment(aname,username);

    if(comment != null){
%>
<table align="center">
    <tr>
        <td>动漫</td>
        <td><input type="text" name="uid" value="<%=comment.getAcomment() %>"></td>
    </tr>
    <tr>
        <td>用户</td>
        <td><input type="text" name="uname" value="<%=comment.getUsername() %>"></td>
    </tr>
    <tr>
        <td>讨论</td>
        <td><textarea rows="5" cols="70" name="comment"><%=comment.getAcomment() %></textarea> </td>
    </tr>
</table>
<%
    }
%>
<br>
<center>
    <a href="queryAllComment.jsp">返回</a>
</center>

</body>
</html>