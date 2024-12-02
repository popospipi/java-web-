<%--
  Created by IntelliJ IDEA.
  User: 86172
  Date: 2024/6/28
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("utf-8"); %>

<%

    // 尝试获取表单参数
    String name = request.getParameter("name");
    String director = request.getParameter("director");
    String scriptwriter = request.getParameter("scriptwriter");
    String music = request.getParameter("music");
    String dub = request.getParameter("dub");
    String time = request.getParameter("time");
    String episode = request.getParameter("episode");

    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/animation?useSSL=false&serverTimezone=UTC";
    String USER = "root";
    String PASS = "823181698";
    // 初始化数据库连接
    Connection conn = null;
    PreparedStatement psmt = null;
    try {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        String sql = "INSERT into dm(name,director,scriptwriter,music,dub,time,episode) VALUES (?,?,?,?,?,?,?)";
        psmt = conn.prepareStatement(sql);

        // 设置参数值
        psmt.setString(1,name);
        psmt.setString(2,director);
        psmt.setString(3,scriptwriter);
        psmt.setString(5,music);
        psmt.setString(4,dub);
        psmt.setString(6,time);
        psmt.setString(7,episode);

        // 执行 SQL 语句
        int rowsAffected = psmt.executeUpdate();

        // 检查是否插入成功
        if (rowsAffected > 0) {
            // 插入成功，重定向到另一个页面
            response.sendRedirect("index.jsp");
        } else {
            // 插入失败，显示错误信息
            out.println("插入失败，请检查输入数据或联系管理员。");
        }
    } catch (ClassNotFoundException e) {
        // 处理 JDBC 驱动未找到异常
        e.printStackTrace();
        out.println("JDBC 驱动未找到：" + e.getMessage());
    } catch (SQLException e) {
        // 处理 SQL 异常
        e.printStackTrace();
        out.println("SQL 异常：" + e.getMessage());
    } finally {
        // 关闭资源
        try {
            if (psmt != null) psmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>