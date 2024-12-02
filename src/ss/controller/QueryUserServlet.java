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

@WebServlet("/queryUser")
public class QueryUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、解决编码问题
        req.setCharacterEncoding("utf-8");
        //resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //2、接受前台数据
        String id = req.getParameter("uid");
        int flag = Integer.parseInt(req.getParameter("flag"));

        // 3、调用service层，查询指定id的新闻信息
        UserService us = new UserServiceImpl();

        User user = us.queryOneUser(id);

        // 4、处理结果
        if(user != null) {
            req.setAttribute("user",user);
            if(flag == 1) {
                req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
            }else {
                req.getRequestDispatcher("displayUser.jsp").forward(req, resp);
            }
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }

}
