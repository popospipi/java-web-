<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="ss.entity.User, ss.service.UserService,ss.serviceimpl.UserServiceImpl" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>登录程序之验证页面</title>
</head>
<body>
<%!
    String check(String userid, String userpwd){

        String uname = "";

        UserService us = new UserServiceImpl();
        User user = us.login(userid, userpwd);

        if(user != null){  //登录成功
            uname = user.getUname();
        }

        return uname;
    }
%>
<%
    request.setCharacterEncoding("UTF-8");
    String  uid =request.getParameter("uid");
    String upassword = request.getParameter("upassword");
    String remenber = request.getParameter("remenber");
    String name;
    if((!(name=check(uid,upassword)).equals(""))){  //登录成功，跳转到成功页
        Cookie cookie;
        System.out.println("remenber=" + remenber);// on, null
        if(remenber != null) {
            cookie = new Cookie("Cookie2020", uid+"#"+upassword+"#"+remenber);
            cookie.setMaxAge(45);
            response.addCookie(cookie);
        } else {
            cookie = new Cookie("Cookie2020", uid+"#"+upassword+"#"+remenber);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        session.setAttribute("username", name);
        session.setMaxInactiveInterval(30);// 30秒
        response.sendRedirect("menu2.jsp");

    }else{              //登录失败，跳转到失败页
        response.sendRedirect("login_failure.jsp");
    }
%>
</body>