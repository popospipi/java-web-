
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.text.DateFormat,java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<%@page import="ss.service.CommentService"%>
<%@page import="ss.serviceimpl.CommentServiceImpl"%>
<%@page import="ss.entity.Comment"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>保存修改结果</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String aname = request.getParameter("aname");
    String username = request.getParameter("username");
    String acomment = request.getParameter("acomment");

    Comment comment = new Comment(aname,username,acomment);

    CommentService cs = new CommentServiceImpl();

    int n = cs.updateComment(comment);

    if(n > 0) {
        //修改成功
        response.sendRedirect("queryAllComment.jsp");
    }else {
        //修改失败
        response.sendRedirect("queryAllComment.jsp");
    }
%>


</body>
</html>