package ss.controller;

import ss.service.UserService;
import ss.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、解决编码问题
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uid = req.getParameter("uid");
        // 3、调用Service层
        UserService ns = new UserServiceImpl();
        int n = ns.removeUser(uid);
        // 4、处理结果
        if(n==0) {
            //删除成功，则直接刷新页面
            resp.sendRedirect("queryAllUser");
        }else {
            resp.getWriter().println("删除失败！");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }

}
