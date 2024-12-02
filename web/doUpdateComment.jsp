<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="ss.service.CommentService"%>
<%@page import="ss.serviceimpl.CommentServiceImpl"%>
<%@page import="ss.entity.Comment"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改评论</title>
    <link rel="stylesheet" href="addComment.css">
</head>
<body>
<%
    String aname = request.getParameter("aname");
    String username = request.getParameter("username");

    CommentService Us = new CommentServiceImpl();

    Comment comment = Us.queryOneComment(aname,username);

%>
<form action="doUpdateComment1.jsp" method="post">
    <input type="hidden" name="name" value="<%=comment.getAname() %>">
    <table align="center">
        <tr>
            <td>动漫</td>
            <td><input type="text" name="aname" value="<%=comment.getAname() %>"></td>
        </tr>
        <tr>
            <td>名称</td>
            <td><input type="text" name="username" value="<%=comment.getUsername()%>"></td>
        </tr>
        <tr>
            <td>评论</td>
            <td><textarea rows="5" cols="70" name="acomment"><%=comment.getAcomment()%></textarea> </td>
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
    <a href="queryAllComment.jsp">返回</a>
</center>

</body>
</html>