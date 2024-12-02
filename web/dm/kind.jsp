<%--
  Created by IntelliJ IDEA.
  User: 86172
  Date: 2024/6/30
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<h1>Student List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <!-- 其他字段 -->
    </tr>
    <%
        String url = "jdbc:mysql://localhost:3306/animation";
        String username = "root";
        String password = "823181698";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM your_table WHERE type = ?")) {

            stmt.setString(1, "student");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                // 输出其他字段
                out.println("</tr>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>
</table>
</body>
</html>