package com.study.Servlet;


import com.study.dao.AnimeDao;
import com.study.pojo.Anime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectAnimeByName")
public class SelectAnimeByName extends HttpServlet {
    private AnimeDao animeDao = new AnimeDao();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        //1. 接收name
        String name = request.getParameter("name");

        List<Anime> animes = animeDao.searchAnimeByName(name);

        // 将结果存储到 request 对象中
        request.setAttribute("animes", animes);
        request.setAttribute("name", name);

        // 转发到结果显示的 JSP 页面
        request.getRequestDispatcher("dongmanAdmin.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
