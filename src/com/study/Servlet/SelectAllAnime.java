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

@WebServlet("/SelectAllAnime")
public class SelectAllAnime extends HttpServlet {
    private AnimeDao animeDao = new AnimeDao();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Anime> animes = animeDao.getAllAnimes();

        // 将结果存储到 request 对象中
        request.setAttribute("animes", animes);

        // 转发到结果显示的 JSP 页面
        request.getRequestDispatcher("dongmanAdmin.jsp").forward(request, response);
    }


}
