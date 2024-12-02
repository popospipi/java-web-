<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="MysqlData.JDBC" %>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>管理员登录程序之验证页面</title>
</head>
<body>
<%
    try {
        request.setCharacterEncoding("UTF-8");
        String mid  = request.getParameter("mid");
        String mpassword= request.getParameter("mpassword");
        String remenber = request.getParameter("remenber");

        Connection conn= new JDBC().getConnection();
        PreparedStatement stmt=conn.prepareStatement("select * from t_manager where mid=? and mpassword=?");
        stmt.setString(1,mid);
        stmt.setString(2,mpassword);
        ResultSet rs=stmt.executeQuery();
        String mname = "";
        Cookie[] cookies;
        if(rs.next()){
            mname = rs.getString("mname");
            cookies = request.getCookies();
            int i;
            boolean cookies_flag = false;
            if(cookies != null){
                for(i=0; i<cookies.length; i++){
                    if("Cookie2020".equals(cookies[i].getName())){
                        break;
                    }
                }
                if(i<cookies.length){
                    cookies_flag = false;
                }else{
                    cookies_flag = true;
                }
            }else{
                cookies_flag = true;
            }

            Cookie cookie;

            if(remenber != null){
                if(cookies_flag){
                    cookie = new Cookie("Cookie2020", mid+"#"+mpassword);
                    cookie.setMaxAge(10);
                    response.addCookie(cookie);
                }
            }else{
                if(!cookies_flag){
                    cookie = new Cookie("Cookie2020", mid+"#"+mpassword);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
            rs.close();
            stmt.close();
            conn.close();
            session.setAttribute("username", mname);
            session.setMaxInactiveInterval(60);
            response.sendRedirect("menu.jsp");
        }else{
            rs.close();
            stmt.close();
            conn.close();
            response.sendRedirect("mlogin_failure.jsp");
        }
    }catch (Exception e) {
        out.print("错误！");
    }
%>
</body>
