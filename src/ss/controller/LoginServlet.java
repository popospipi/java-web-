package ss.controller;

import ss.entity.User;
import ss.service.UserService;
import ss.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前台数据
        request.setCharacterEncoding("UTF-8");
        String uid = request.getParameter("uid");
        String upassword = request.getParameter("upassword");
        String remenber = request.getParameter("remenber");
        String uname;
        if((!(uname=check(uid,upassword)).equals(""))){  //登录成功，跳转到成功页
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

            request.getSession().setAttribute("username", uname);
            request.getSession().setMaxInactiveInterval(30);// 30秒
            response.sendRedirect("queryAllUsers.jsp");

        }else{              //登录失败，跳转到失败页
            response.sendRedirect("login_failure.jsp");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private String check(String userid, String userpwd){

        String uname = "";

        UserService us = new UserServiceImpl();
        User user = us.login(userid, userpwd);

        if(user != null){  //登录成功
            uname = user.getUname();
        }

        return uname;
    }

}
