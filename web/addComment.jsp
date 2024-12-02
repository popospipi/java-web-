<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
  <title>添加页面</title>
  <link rel="stylesheet" href="addComment.css">
</head>、
<%
  String animeName = request.getParameter("animeName");

%>
<body>
<form action="doAddComment.jsp" method="post">
  <div class="box">
    <h2>评论添加</h2>
    <div class="input-box">
      <label>动漫</label>
      <input type="text" name="aname"  value="<%= animeName %>">
    </div>
    <div class="input-box">
      <label>用户</label>
      <input type="text" name="username" value="<%=session.getAttribute("username")%>">
    </div>
    <div class="input-box">
      <label>评论</label>
      <input type="text" name="acomment">
    </div>
    <div class="btn-box">
      <div>
        <button type="submit">添加</button>
      </div>
    </div>
  </div>
</form>
</body>
</html>
