<%--
  Created by IntelliJ IDEA.
  User: 86172
  Date: 2024/6/28
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" language="java" %>
<%
    // 获得name
    String name = request.getParameter("name");

    System.out.println("^^^^^");
    System.out.println(name);
    System.out.println("^^^^^");

    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/animation";
    String USER = "root";
    String PASS = "823181698";

    try {
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "DELETE FROM dm WHERE name=?";

        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, name);
        psmt.executeUpdate();
        conn.close();
        response.sendRedirect("index.jsp");

    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }

%>