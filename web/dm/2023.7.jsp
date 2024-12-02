<%--
  Created by IntelliJ IDEA.
  User: 86172
  Date: 2024/6/30
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" %>
<html>
<head>
    <title>2023.7</title>
    <link rel="stylesheet" href="show2.css">

</head>
<body>
<center>
    <h1><a href="https://www.bilibili.com/video/BV1j14y1U77P/?spm_id_from=333.788&vd_source=2966c37b095e634bd3cb613b94d54827">七月新番信息</a></h1>
    <hr width="100%">
    <form>
        <table >
            <tr>
                <th style="width: 15%"><b>动漫</b></th>
                <th style="width: 15%"><b>导演</b></th>
                <th style="width: 15%"><b>编剧</b></th>
                <th style="width: 15%"><b>主要配音</b></th>
                <th style="width: 15%"><b>音乐</b></th>
                <th style="width: 15%"><b>时间</b></th>
                <th style="width: 15%"><b>集数</b></th>
            </tr>
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
                    String sql = "SELECT * FROM dm";
                    psmt = conn.prepareStatement(sql);
                    rs = psmt.executeQuery();
                    while (rs.next()) {
                        String a = rs.getString("name");
                        String b = rs.getString("director");
                        String c = rs.getString("scriptwriter");
                        String d = rs.getString("dub");
                        String e = rs.getString("music");
                        String f = rs.getString("time");
                        String g = rs.getString("episode");
            %>
            <tr align="center">
                <td><input name="name" value="<%=a%>" readonly /></td>
                <td><input name="director" value="<%=b%>"  /></td>
                <td><input name="scriptwriter" value="<%=c%>"  /></td>
                <td><input name="dub" value="<%=d%>" /></td>
                <td><input name="music" value="<%=e%>"  /></td>
                <td><input name="time" value="<%=f%>" /></td>
                <td><input name="episode" value="<%=g%>" /></td>
            </tr>
            <%
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    out.println("JDBC 驱动未找到：" + e.getMessage());
                } catch (SQLException e) {
                    e.printStackTrace();
                    out.println("SQL 异常：" + e.getMessage());
                }
            %>
        </table>
    </form>
</center>
</body>
</html>