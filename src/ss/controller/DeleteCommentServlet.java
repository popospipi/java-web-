package ss.controller;

import ss.service.CommentService;
import ss.serviceimpl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class DeleteCommentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、解决编码问题
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String aname = req.getParameter("aname");
        String usename = req.getParameter("usename");
        // 3、调用Service层
        CommentService cs = new CommentServiceImpl();
        int n = cs.removeComment(aname,usename);
        // 4、处理结果
        if(n>0) {
            //删除成功，则直接刷新页面
            resp.sendRedirect("queryAllComment.jsp");
        }else {
            resp.getWriter().println("删除失败！");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }

}
