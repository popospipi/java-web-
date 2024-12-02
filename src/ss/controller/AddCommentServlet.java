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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/addComment")
public class AddCommentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String aname = req.getParameter("aname");
        String username = req.getParameter("username");
        String acomment = req.getParameter("ucomment");

        Comment comment = null;
        comment = new Comment(aname,username,acomment);

        CommentService cs = new CommentServiceImpl();

        int n = cs.addComment(comment);

        if(n >0) {

            resp.sendRedirect("queryAllUser");
        }else {
            req.getRequestDispatcher("addComment.jsp").forward(req, resp);

        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }

}
