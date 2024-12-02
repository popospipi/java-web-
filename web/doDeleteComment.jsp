<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="ss.service.CommentService"%>
<%@page import="ss.serviceimpl.CommentServiceImpl"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>删除评论</title>
</head>
<body>
<%
    String aname = request.getParameter("aname");
    String username = request.getParameter("username");

    CommentService us = new CommentServiceImpl();

    int n = us.removeComment(aname,username);

    if(n>0) {
        response.sendRedirect("queryAllComment.jsp");
    }else {
        response.getWriter().println("删除失败！");
    }

%>

</body>
</html>