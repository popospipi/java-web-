package com.study.dao;

import com.study.pojo.Anime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimeDao {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///animation?useSSL=false";
        String username = "root";
        String password = "823181698";
        return DriverManager.getConnection(url, username, password);
    }

    public List<Anime> getAllAnimes() {
        List<Anime> animes = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            String sql = "SELECT * FROM Anime";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Anime anime = new Anime();
                anime.setId(rs.getInt("id"));
                anime.setAnimeName(rs.getString("anime_name"));
                anime.setOriginalName(rs.getString("original_name"));
                anime.setType(rs.getString("type"));
                anime.setEpisodeCount(rs.getInt("episode_count"));
                anime.setStartDate(rs.getString("start_date"));
                anime.setEndDate(rs.getString("end_date"));
                anime.setOriginalWork(rs.getString("original_work"));
                anime.setProductionCompany(rs.getString("production_company"));
                anime.setDirector(rs.getString("director"));
                anime.setScriptwriter(rs.getString("scriptwriter"));
                anime.setMusicDirector(rs.getString("music_director"));
                anime.setStatus(rs.getString("status"));
                anime.setCoverImageUrl(rs.getString("cover_image_url"));
                anime.setSummary(rs.getString("summary"));
                anime.setRate(rs.getDouble("rate"));
                anime.setMusic(rs.getString("music"));
                animes.add(anime);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return animes;
    }
    public void deleteAnime(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            String sql = "DELETE FROM Anime WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAnime(Anime anime) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            String sql = "INSERT INTO anime (id,anime_name, original_name, type, episode_count, start_date, end_date, original_work, production_company, director, scriptwriter, music_director, status, cover_image_url, summary,rate,music) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, anime.getId());
            pstmt.setString(2, anime.getAnimeName());
            pstmt.setString(3, anime.getOriginalName());
            pstmt.setString(4, anime.getType());
            pstmt.setInt(5, anime.getEpisodeCount());
            pstmt.setString(6, anime.getStartDate());
            pstmt.setString(7, anime.getEndDate());
            pstmt.setString(8, anime.getOriginalWork());
            pstmt.setString(9, anime.getProductionCompany());
            pstmt.setString(10, anime.getDirector());
            pstmt.setString(11, anime.getScriptwriter());
            pstmt.setString(12, anime.getMusicDirector());
            pstmt.setString(13, anime.getStatus());
            pstmt.setString(14, anime.getCoverImageUrl());
            pstmt.setString(15, anime.getSummary());
            pstmt.setDouble(16, anime.getRate());
            pstmt.setString(17, anime.getMusic());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAnime(Anime anime) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            String sql = "UPDATE Anime SET anime_name=?, original_name=?, type=?, episode_count=?, start_date=?, end_date=?, original_work=?, production_company=?, director=?, scriptwriter=?, music_director=?, status=?, cover_image_url=?, summary=?, rate=?, music=? WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, anime.getAnimeName());
            pstmt.setString(2, anime.getOriginalName());
            pstmt.setString(3, anime.getType());
            pstmt.setInt(4, anime.getEpisodeCount());
            pstmt.setString(5, anime.getStartDate());
            pstmt.setString(6, anime.getEndDate());
            pstmt.setString(7, anime.getOriginalWork());
            pstmt.setString(8, anime.getProductionCompany());
            pstmt.setString(9, anime.getDirector());
            pstmt.setString(10, anime.getScriptwriter());
            pstmt.setString(11, anime.getMusicDirector());
            pstmt.setString(12, anime.getStatus());
            pstmt.setString(13, anime.getCoverImageUrl());
            pstmt.setString(14, anime.getSummary());
            pstmt.setDouble(15, anime.getRate());
            pstmt.setString(16, anime.getMusic());
            pstmt.setInt(17, anime.getId());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Anime getAnimeById(int id) {
        Anime anime = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            String sql = "SELECT * FROM Anime WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                anime = new Anime();
                anime.setId(rs.getInt("id"));
                anime.setAnimeName(rs.getString("anime_name"));
                anime.setOriginalName(rs.getString("original_name"));
                anime.setType(rs.getString("type"));
                anime.setEpisodeCount(rs.getInt("episode_count"));
                anime.setStartDate(rs.getString("start_date"));
                anime.setEndDate(rs.getString("end_date"));
                anime.setOriginalWork(rs.getString("original_work"));
                anime.setProductionCompany(rs.getString("production_company"));
                anime.setDirector(rs.getString("director"));
                anime.setScriptwriter(rs.getString("scriptwriter"));
                anime.setMusicDirector(rs.getString("music_director"));
                anime.setStatus(rs.getString("status"));
                anime.setCoverImageUrl(rs.getString("cover_image_url"));
                anime.setSummary(rs.getString("summary"));
                anime.setMusic(rs.getString("music"));
                anime.setRate(rs.getDouble("rate"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return anime;
    }
    public List<Anime> searchAnimeByName(String keyword) {
        List<Anime> results = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            String sql = "SELECT * FROM Anime WHERE anime_name LIKE ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + keyword + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Anime anime = new Anime();
                anime.setId(rs.getInt("id"));
                anime.setAnimeName(rs.getString("anime_name"));
                anime.setOriginalName(rs.getString("original_name"));
                anime.setType(rs.getString("type"));
                anime.setEpisodeCount(rs.getInt("episode_count"));
                anime.setStartDate(rs.getString("start_date"));
                anime.setEndDate(rs.getString("end_date"));
                anime.setOriginalWork(rs.getString("original_work"));
                anime.setProductionCompany(rs.getString("production_company"));
                anime.setDirector(rs.getString("director"));
                anime.setScriptwriter(rs.getString("scriptwriter"));
                anime.setMusicDirector(rs.getString("music_director"));
                anime.setStatus(rs.getString("status"));
                anime.setCoverImageUrl(rs.getString("cover_image_url"));
                anime.setSummary(rs.getString("summary"));
                anime.setRate(rs.getDouble("rate"));
                anime.setMusic(rs.getString("music"));
                results.add(anime);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return results;
    }


}

