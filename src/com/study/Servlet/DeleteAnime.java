package com.study.Servlet;

import com.study.dao.AnimeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteAnime")
public class DeleteAnime extends HttpServlet {
    private AnimeDao animeDao = new AnimeDao();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");


        animeDao.deleteAnime(Integer.parseInt(id));

        request.setAttribute("success","操作成功");

        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/SelectAllAnime").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
