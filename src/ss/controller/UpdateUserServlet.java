package ss.controller;

import ss.entity.User;
import ss.service.UserService;
import ss.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/doUpdateUser")
public class UpdateUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、解决编码问题
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //2、接受前台数据，并将前台数据封装成一个User对象

        String uid =req.getParameter("uid");
        String uname = req.getParameter("uname");
        String upassword = req.getParameter("upassword");

           User user = null;
            user = new User(uid,uname,upassword);

        // 3、调用service层，然后传入user
        UserService ns = new UserServiceImpl();

        int n = ns.updateUser(user);

        // 4、处理结果
        if(n>0) {
            //修改成功
            resp.sendRedirect("queryAllUser");
        }else {
            // 修改失败
            resp.sendRedirect("queryAllUser");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }

}
