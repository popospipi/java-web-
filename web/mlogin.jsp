<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>管理员登录页面</title>
    <link rel="stylesheet" href="register.css">
</head>
<body>
<form action="mlogin_check.jsp" method="post">

        <%
        String mid = "";
        String mpassword = "";
        String remenber = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(int i=0; i<cookies.length; i++){
                if (cookies[i].getName().equals("Cookie2020")) {
                    //如果cookie对象的名称为Cookie2019
                    mid = cookies[i].getValue().split("#")[0];
                    mpassword = cookies[i].getValue().split("#")[1];
                    remenber = cookies[i].getValue().split("#")[2];
                }
            }
        }
    %>

<div class="box">
    <h2>管理员登录</h2>
    <div class="input-box">
        <label>账号</label>
        <td><input type="text" name="mid"></td>
    </div>
    <div class="input-box">
        <label>密码</label>
        <input type="password" name="mpassword" >
    </div>
    <div class="btn-box">
        <div>
            <button type="submit">登录</button>
        </div>
    </div>
</div>
</body>
</form>
</html>