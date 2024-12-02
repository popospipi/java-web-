package ss.controller;

import ss.entity.User;
import ss.service.UserService;
import ss.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取前台数据
        String uid =req.getParameter("uid");
        String uname = req.getParameter("uname");
        String upassword = req.getParameter("upassword");

        User user = new User(uid,uname,upassword);

        //调用service层，进行注册操作
        UserService us = new UserServiceImpl();

        User User = null;
        int n = us.register(User);

        if(n > 0){
            //注册成功
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("reg_success.jsp");
        }else{
            String error = "注册失败！";
            if(n==-1){
                error = "您填写的登录UID已经存在！";
            }
            req.getSession().setAttribute("error", error);
            resp.sendRedirect("reg_failure.jsp");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }
}