<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>动漫新增/修改</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
<%-- 管理员才显示--%>
<%--<c:if test="${sessionScope.user.role == 'admin'}">--%>
<%--    <div class="container">--%>
<%--        <button id="openModalButton"><a href="/addDongman.jsp">添加动漫</a></button>--%>
<%--    </div>--%>
<%--</c:if>--%>
<div class="heads" style="display: flex;align-items: center;width: 60%;margin: 10px auto;">
    <button id="openModalButton"><a style="color: #FFFFFF" href="<c:url value="/addDongman.jsp"/>">添加动漫</a></button>
    <form action="${pageContext.request.contextPath}/SelectAnimeByName" method="post" style="display: flex;align-items: center;height: 50px;width: 80%;">
        <input type="text" name="name" value="${name}" style="flex: 4;outline: none;height: 30px;margin-left: 10px" placeholder="动漫名">
        <button  type="submit" style="flex: 1;background-color: #d9dee7;border: none" >搜索</button>
    </form>
</div>
<div class="container">
<c:forEach items="${animes}" var="anime" >
    <div class="anime-card">
        <img src="${pageContext.request.contextPath}/getImage?filename=${anime.coverImageUrl}" width="50"  height="50" alt="Anime Image" class="anime-image">
        <div class="info">
            <p class="id">${anime.id}</p>
            <p class="name">${anime.animeName}</p>
            <p class="original-name">${anime.originalName}</p>
            <p class="state-episodes">状态: ${anime.status} | 集数: ${anime.episodeCount}</p>
            <p class="state-episodes">开播日期：${anime.startDate}</p>
            <div class="tags">
                <span class="tag">${anime.type}</span>
            </div>
            <p class="rating">Rating: ${anime.rate}</p>
            <div style="display: flex">
                <button ><a style="color: #FFFFFF" href="${pageContext.request.contextPath}/GetAnimeDetail?id=${anime.id}">详情</a></button>
                <button ><a style="color: #FFFFFF"  href="${pageContext.request.contextPath}/SelectAnimeById?id=${anime.id}">修改</a></button>
                <button onclick="confirmDelete(${anime.id})">删除</button>
            </div>

        </div>
    </div>
</c:forEach>

</div>

</body>
<script>
    function confirmDelete(id) {
        var result = confirm("确定要删除吗？");
        if (result) {
            // 如果用户点击确定，执行删除操作
            window.location.href = "${pageContext.request.contextPath}/DeleteAnime?id=" + id;
        } else {
            // 如果用户点击取消，取消操作
            return;
        }
    }

</script>
</html>
