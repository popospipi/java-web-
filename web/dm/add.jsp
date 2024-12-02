<%--
  Created by IntelliJ IDEA.
  User: 86172
  Date: 2024/6/27
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" language="java" %>
<% request.setCharacterEncoding("utf-8"); %>
<link rel="stylesheet" href="add.css">


<%
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/animation";
    String USER = "root";
    String PASS = "823181698";

    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    try {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "SELECT * FROM animation";
        psmt = conn.prepareStatement(sql);
        rs = psmt.executeQuery();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (psmt != null) psmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
<html>
<head>
    <title>添加信息</title>
</head>
<body>
<center>
    <h1>添加新番</h1>
    <hr>
    <form action="insert.jsp" method="post">
        <label for="name">动漫：</label>
        <input type="text" id="name" name="name" />
        <br/>
        <label for="director">导演：</label>
        <input type="text" id="director" name="director" />
        <br/>
        <label for="scriptwriter">编剧：</label>
        <input type="text" id="scriptwriter" name="scriptwriter" />
        <br/>
        <label for="dub">主要配音：</label>
        <input type="text" id="dub" name="dub" /><br/>
        <label for="music">音乐：</label>
        <input type="text" id="music" name="music" />
        <br/>
        <label for="time">时间：</label>
        <input type="text" id="time" name="time" />
        <br/>
        <label for="episode">集数：</label>
        <input type="text" id="episode" name="episode" />
        <br/>
        <input type="submit" value="添加信息" />
        <img src="t/4.jpg" alt="旁边的图片" class="button-side-image">
    </form>
</center>
</body>
</html>