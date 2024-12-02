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

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uid = req.getParameter("uid");
        String uname = req.getParameter("uname");
        String upassword = req.getParameter("upassword");

        User user = null;
        user = new User(uid,uname,upassword);

        UserService ns = new UserServiceImpl();

        int n = ns.addUser(user);

        // 4、处理结果
        if(n >0) {
            //插入成功
            resp.sendRedirect("queryAllUser");
        }else {
            // 插入失败
            req.getRequestDispatcher("addUser.jsp").forward(req, resp);

        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }

}