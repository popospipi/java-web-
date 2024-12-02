<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.text.DateFormat,java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<%@page import="ss.service.CommentService" %>
<%@page import="ss.serviceimpl.CommentServiceImpl" %>
<%@page import="ss.entity.Comment" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加结果</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String aname = request.getParameter("aname");
    String username = request.getParameter("username");
    String acomment = request.getParameter("acomment");


    Comment comment = new Comment(aname,username,acomment);

    CommentService ns = new CommentServiceImpl();

    int n = ns.addComment(comment);

    if(n >0) {
        //添加成功
        response.sendRedirect("queryOneComment.jsp");
    }else {
        //添加失败
        response.sendRedirect("queryOneComment.jsp");
    }
%>
</body>
</html>