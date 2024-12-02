package ss.controller;

import ss.entity.Comment;
import ss.service.CommentService;
import ss.serviceimpl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/queryComment")
public class QueryCommentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、解决编码问题
        req.setCharacterEncoding("utf-8");

        resp.setContentType("text/html;charset=utf-8");

        //2、接受前台数据
        String aname = req.getParameter("aname");
        String username = req.getParameter("username");
        int flag = Integer.parseInt(req.getParameter("flag"));

        CommentService cs = new CommentServiceImpl();

        Comment comment = cs.queryOneComment(aname,username);

        // 4、处理结果
        if(comment != null) {
            req.setAttribute("comment", comment);
            if(flag == 1) {
                req.getRequestDispatcher("updateComment.jsp").forward(req, resp);
            }else {
                req.getRequestDispatcher("displayComment.jsp").forward(req, resp);
            }
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }

}
