package com.study.Servlet;

import com.study.dao.AnimeDao;
import com.study.pojo.Anime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectAnimeById")
public class SelectAnimeById extends HttpServlet {
    private AnimeDao animeDao = new AnimeDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接收id
        String id = request.getParameter("id");

        Anime anime = animeDao.getAnimeById(Integer.parseInt(id));

        // 将结果存储到 request 对象中
        request.setAttribute("anime", anime);

        // 转发到结果显示的 JSP 页面
        request.getRequestDispatcher("updateDongman.jsp").forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
