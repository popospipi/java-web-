
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List and Update Animes</title>
    <link rel="stylesheet" href="show2.css">
</head>
<body>
<h1>未上架动漫</h1>
<table border="1">
    <tr>
        <th>动漫名</th>
        <th>导演</th>
        <th>编剧</th>
        <th>配音</th>
        <th>音乐</th>
        <th>时间</th>
        <th>集数</th>
        <th>类型</th>
    </tr>
    <%
        String url = "jdbc:mysql://localhost:3306/animation";
        String username = "root";
        String password = "823181698";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT  id, anime_name,original_name,type,episode_count,start_date,end_date,original_work ,production_company,director,scriptwriter,music_director,status,cover_image_url,summary,rate,music FROM anime WHERE type = ?")) {

            stmt.setString(1, "未上架");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
    %>
    <tr>
        <td><%= rs.getString("id") %></td>
        <td><%= rs.getString("anime_name") %></td>
        <td><%= rs.getString("original_name") %></td>
        <td><%= rs.getString("type") %></td>
        <td><%= rs.getString("episode_count") %></td>
        <td><%= rs.getString("start_date") %></td>
        <td><%= rs.getString("end_date") %></td>
        <td><%= rs.getString("original_work") %></td>
        <td><%= rs.getString("production_company") %></td>
        <td><%= rs.getString("director") %></td>
        <td><%= rs.getString("scriptwriter") %></td>
        <td><%= rs.getString("music_director") %></td>
        <td><%= rs.getString("status") %></td>
        <td><%= rs.getString("cover_image_url") %></td>
        <td><%= rs.getString("summary") %></td>
        <td><%= rs.getString("rate") %></td>
        <td><%= rs.getString("music") %></td>
        </td>
    </tr>
    <%
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>
</table>
</body>
</html>