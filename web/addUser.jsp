<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>添加页面</title>
    <link rel="stylesheet" href="addUser.css">
</head>
<body>
<form action="doAddUser.jsp" method="post">
    <div class="box">
        <h2>用户添加</h2>
        <div class="input-box">
            <label>账号</label>
            <input type="text" name="uid">
        </div>
        <div class="input-box">
            <label>昵称</label>
            <input type="text" name="uname">
        </div>
        <div class="input-box">
            <label>密码</label>
            <input type="password" name="upassword">
        </div>
        <div class="input-box">
            <label>确认密码</label>
            <input type="password" name="upassword2">
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