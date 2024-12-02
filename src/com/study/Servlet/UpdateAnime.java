package com.study.Servlet;

import com.study.dao.AnimeDao;
import com.study.pojo.Anime;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@WebServlet("/UpdateAnime")
@MultipartConfig
public class UpdateAnime extends HttpServlet {
    private AnimeDao animeDao = new AnimeDao();
    private static final String UPLOAD_DIRECTORY = "D:/work";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String animeName = request.getParameter("animeName");
        String originalName = request.getParameter("originalName");
        String type = request.getParameter("type");
        String episodeCount= request.getParameter("episodeCount");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String originalWork = request.getParameter("originalWork");
        String productionCompany = request.getParameter("productionCompany");
        String director = request.getParameter("director");
        String scriptwriter = request.getParameter("scriptwriter");
        String musicDirector = request.getParameter("musicDirector");
        String status = request.getParameter("status");
        String rate = request.getParameter("rate");
        String music = request.getParameter("music");
        String summary = request.getParameter("summary");
        Part filePart = request.getPart("fileToUpload");
        String coverImageUrl = null;
        if (!(filePart.getSize() ==0)){
            // 获取文件名
            coverImageUrl = getFileName(filePart);
            // 构建上传文件的路径
            Path uploadPath = Paths.get(UPLOAD_DIRECTORY, coverImageUrl);
            // 确保上传目录存在
            Files.createDirectories(uploadPath.getParent());
            // 保存文件到服务器
            try (InputStream inputStream = filePart.getInputStream()) {
                Files.copy(inputStream, uploadPath, StandardCopyOption.REPLACE_EXISTING);
            }
        }
        // 创建Anime对象
        Anime anime = new Anime();
        anime.setId(Integer.parseInt(id));
        anime.setAnimeName(animeName);
        anime.setOriginalName(originalName);
        anime.setType(type);
        anime.setEpisodeCount(Integer.parseInt(episodeCount));
        anime.setStartDate(startDate);
        anime.setEndDate(endDate);
        anime.setOriginalWork(originalWork);
        anime.setProductionCompany(productionCompany);
        anime.setDirector(director);
        anime.setScriptwriter(scriptwriter);
        anime.setMusicDirector(musicDirector);
        anime.setStatus(status);
        anime.setMusic(music);
        anime.setCoverImageUrl(coverImageUrl);
        anime.setRate(Double.valueOf(rate));
        anime.setSummary(summary);


            Anime animeById = animeDao.getAnimeById(Integer.parseInt(id));
            anime.setId(Integer.parseInt(id));
            if (filePart.getSize() ==0) {
                anime.setCoverImageUrl(animeById.getCoverImageUrl());
            }
            animeDao.updateAnime(anime);
            request.setAttribute("msg", "动漫更新成功");

        // 转发到查询所有Anime的Servlet
        request.getRequestDispatcher("/SelectAllAnime").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
