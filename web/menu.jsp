<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>mikufans</title>
    <link rel="stylesheet" href="menu.css">

</head>
<body>
<script>
    $(function() {
        $(".header .openmenu").click(function() {
            $(".header .center").addClass("menuopen")
        })
        $(".header .closemenu").click(function() {
            $(".header .center").removeClass("menuopen")
        })
    })
</script>
<div class="header">
    <div class="center">
        <div class="links">
            <button class="closemenu"><span class="l"></span><span class="r"></span></button>
            <a href="#st" class="link">首页</a>
            <a href="queryAllUser.jsp" class="link">用户信息管理</a>
            <a href="dongmanAdmin.jsp" class="link">动漫信息管理</a>
            <a href="dm/Administrators_Show.jsp" class="link">新番信息管理</a>
            <a href="queryAllComment.jsp" class="link">讨论区管理</a>
            <a href="login.jsp" class="link">退出</a>
        </div>
        <button class="openmenu"><span></span><span></span><span></span></button>
        <div class="menubg"></div>
    </div>
</div>
<div class="page">
    <section id="nd"></section>
    <section id="rd"></section>
</div>
</body>
</html>