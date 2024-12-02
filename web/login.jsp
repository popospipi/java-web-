<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>
<form action="login_check.jsp" method="post">
    <%
        String uid = "";
        String upassword = "";
        String remenber = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(int i=0; i<cookies.length; i++){
                if (cookies[i].getName().equals("Cookie2020")) {
                    //如果cookie对象的名称为Cookie2019
                    uid = cookies[i].getValue().split("#")[0];
                    upassword = cookies[i].getValue().split("#")[1];
                    remenber = cookies[i].getValue().split("#")[2];
                }
            }
        }
    %>
<div class="box">
    <h2>登录</h2>
    <div class="input-box">
        <label>账号</label>
        <input type="text" name="uid" value="<%=uid %>">
    </div>
    <div class="input-box">
        <label>密码</label>
        <input type="password" name="upassword" value="<%=upassword %>">
    </div>
    <div class="btn-box">
        <a href="mlogin.jsp">管理员登录</a>
        <div>
            <button type="submit">登录</button>
            <button type="button" onclick="location.href='register.jsp'">注册</button>
        </div>
    </div>
</div>
</form>
</body>
</html>
