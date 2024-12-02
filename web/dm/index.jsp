
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" %>
<%@ page import="java.net.URLEncoder" %>
<% request.setCharacterEncoding("utf-8"); %>
<html>
<head>
  <link rel="stylesheet" href="show2.css">
  <title>四月</title>
</head>
<body>
<center>
  <h1>新番信息</h1>
  <hr width="100%">
    <table border="1" width="80%" align="center">
      <tr>
        <th style="width: 15%"><b>动漫</b></th>
        <th style="width: 15%"><b>导演</b></th>
        <th style="width: 15%"><b>编剧</b></th>
        <th style="width: 15%"><b>主要配音</b></th>
        <th style="width: 15%"><b>音乐</b></th>
        <th style="width: 15%"><b>时间</b></th>
        <th style="width: 15%"><b>集数</b></th>
        <th style="width: 15%"><b>修改</b></th>
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
      <form action="${pageContext.request.contextPath}/updateData" method="post">
        <tr align="center">
          <td><input name="name" value="<%=a%>" readonly /></td>
          <td><input name="director" value="<%=b%>"  /></td>
          <td><input name="scriptwriter" value="<%=c%>"  /></td>
          <td><input name="dub" value="<%=d%>" /></td>
          <td><input name="music" value="<%=e%>"  /></td>
          <td><input name="time" value="<%=f%>" /></td>
          <td><input name="episode" value="<%=g%>" /></td>
          <td style="width: 20%"><input type="button" value="删除" data-name="<%=a%>" onclick="del(this)" /></td>
          <td style="width: 20%"><input type="submit" value="更新" ></td>
        </tr>
      </form>
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

        <script>
          function del(button) {
            var name = button.getAttribute('data-name');
            window.location.href = "delete.jsp?name=" + name;
          }
        </script>
    </table>
    <a href="add.jsp" style="font-size: 20px">添加</a>
</center>
</body>
</html>