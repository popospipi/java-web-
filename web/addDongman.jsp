<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>动漫新增</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body style="    overflow-y: scroll;">
<div id="addModal" class="modal">
    <div class="modal-content">
        <h2>动漫新增</h2>
        <form id="addAnimeForm"  action="${pageContext.request.contextPath}/SaveAnime" method="post" enctype="multipart/form-data">

            <div class="form-row">
                <label for="name">动漫编号</label>
                <input type="number" id="aid" name="id" value="${anime.id}" required>
            </div>

            <div class="form-row">
                <label for="name">动漫名</label>
                <input type="text" id="name" name="animeName" value="${anime.animeName}" required>
                <label for="originalName">原名</label>
                <input type="text" id="originalName" name="originalName" value="${anime.originalName}" required>
            </div>

            <div class="form-row">
                <label for="genre">类型</label>
                <input type="text" id="genre" name="type" value="${anime.type}" required>
                <label for="episodes">集数</label>
                <input type="number" id="episodes" name="episodeCount" value="${anime.episodeCount}" required>
            </div>

            <div class="form-row">
                <label for="startDate">开播日期</label>
                <input type="date" id="startDate" name="startDate" value="${anime.startDate}">
                <label for="endDate">完结日期</label>
                <input type="date" id="endDate" name="endDate" value="${anime.endDate}">
            </div>
            <div class="form-row">
                <label for="originalWork">原作</label>
                <input type="text" id="originalWork" name="originalWork" value="${anime.originalWork}">
                <label for="productionCompany">制片公司</label>
                <input type="text" id="productionCompany" name="productionCompany" value="${anime.productionCompany}" required>
            </div>
            <div class="form-row">
                <label for="director">导演</label>
                <input type="text" id="director" name="director" value="${anime.director}" required>
                <label for="screenwriter">编剧</label>
                <input type="text" id="screenwriter" name="scriptwriter" value="${anime.scriptwriter}" required>
            </div>
            <div class="form-row">
                <label for="music">音乐</label>
                <input type="text" id="music" name="music" value="${anime.music}">
                <label for="voiceActors">配音演员</label>
                <input type="text" id="voiceActors" name="musicDirector" value="${anime.musicDirector}">
            </div>
            <div class="form-row">
                <label for="rate">评分</label>
                <input type="text" id="rate" name="rate" value="${anime.rate}">
            </div>
            <div class="form-row full-width">
                <label>状态</label>
                <div class="radio-group">
                    <input type="radio" id="unreleased" name="status" value="未上架" ${anime.status == '未上架' ? 'checked' : ''} required>
                    <label for="unreleased">未上架</label>
                    <input type="radio" id="ongoing" name="status" value="连载中" ${anime.status == '连载中' ? 'checked' : ''} required>
                    <label for="ongoing">连载中</label>
                    <input type="radio" id="completed" name="status" value="已完结" ${anime.status == '已完结' ? 'checked' : ''} required>
                    <label for="completed">已完结</label>
                </div>
            </div>
            <div class="form-row full-width">
                <label for="coverImage">封面图片</label>
                <c:if test="${anime.coverImageUrl != null}">
                    <img src="${pageContext.request.contextPath}/getImage?filename=${anime.coverImageUrl}" width="30"  height="30" alt="Anime Image" class="anime-image">

                </c:if>
                <input type="file" id="coverImage" name="fileToUpload" accept="image/*">
            </div>
            <div class="form-row full-width">
                <label for="summary">简介</label>
                <textarea id="summary" name="summary" rows="4"  required>${anime.summary}</textarea>
            </div>
            <div class="form-row buttons">
                <button type="submit">确认添加</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
<script>

</script>