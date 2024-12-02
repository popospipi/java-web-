<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>动漫详情</title>
</head>
<body>
<div style="width: 80%;margin: 10px auto;">
    <div class="header"  style="padding:10px;">
        <div style="font-size: 28px;font-weight: bold">${anime.animeName}</div>
        <div style="color: #444446;font-size: 14px">原名：${anime.originalName}</div>
    </div>

    <div class="contain"  style="display: flex;height: 450px;">
        <div class="left" style="width: 400px; height: 400px; margin-right: 40px; box-shadow:2px 2px 5px #000;;">
            <img src="${pageContext.request.contextPath}/getImage?filename=${anime.coverImageUrl}" width="400" height="400" alt="动漫凳面" >
        </div>

        <div class="right" style="width: 500px;">
            <div >
                <div style="font-weight: bold;color: #27b2b2">评分：<span style="font-size: 40px">${anime.rate}</span></div>
                <div style="margin-top: 5px"><strong>类型</strong>：${anime.type}</div>
                <div style="margin-top: 5px"><strong>集数</strong>：${anime.episodeCount}</div>
                <div style="margin-top: 5px"><strong>开播日期</strong>：${anime.startDate}</div>
                <div style="margin-top: 5px"><strong>完结日期</strong>：${anime.endDate}</div>
                <div style="margin-top: 5px"><strong>原作</strong>：${anime.originalWork}</div>
                <div style="margin-top: 5px"><strong>制片公司</strong>：${anime.productionCompany}</div>
                <div style="margin-top: 5px"><strong>导演</strong>：${anime.director}</div>
                <div style="margin-top: 5px"><strong>编剧</strong>：${anime.scriptwriter}</div>
                <div style="margin-top: 5px"><strong>音乐</strong>：${anime.music}</div>
                <div style="margin-top: 5px"><strong>音乐总监</strong>：${anime.musicDirector}</div>
                <div style="margin-top: 5px"><strong>状态</strong>：${anime.status }</div>
                <div style="margin-top: 5px"><strong>简介</strong>：${anime.summary}</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
