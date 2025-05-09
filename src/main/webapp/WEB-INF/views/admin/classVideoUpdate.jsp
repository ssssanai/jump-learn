<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-09
  Time: 오전 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/classUpdateStyle.css" rel="stylesheet" type="text/css">
    <title>강의 영상 수정</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<h1 style="text-align:center;">강의 영상 수정</h1>
<div class="wrap" id="wrap">
    <div class="aside">
        <div id="sideMenu" class="sideMenu">
            <p onclick="menuDisplay(2)">강의 내부 영상 수정 입력</p>
            <p onclick="menuDisplay(3)">강의 외부 영상 수정 입력</p>
        </div>
    </div>
    <div class="form-container">
        <span class="center-text">강의 영상 수정 전</span>
        <form>
            <label for="u_id">영상 ID</label>
            <input type="text" id="u_id" name="id" value="${dto.id}" readonly>
            <label for="u_order">영상 순서</label>
            <input type="number" id="u_order" name="order" value="${dto.video_order}" readonly>
            <label for="u_title">영상 제목</label>
            <input type="text" id="u_title" name="title" value="${dto.title}" readonly>
            <label for="u_content">영상 설명</label>
            <textarea type="text" id="u_content" name="content" rows="5" cols="55" readonly>${dto.content}</textarea>
            <label>외부 영상</label>
            <c:choose>
                <c:when test="${not empty dto.video_url}">
                    <a href="${dto.video_url}" target="_blank">외부 영상</a>
                </c:when>
                <c:otherwise>
                    X
                </c:otherwise>
            </c:choose>
            <label>내부 영상</label>
            <c:choose>
                <c:when test="${not empty dto.video_name}">
                    <a href="/upload/${dto.video_name}" target="_blank">${dto.video_name}</a>
                </c:when>
                <c:otherwise>
                    X
                </c:otherwise>
            </c:choose>
        </form>
    </div>
    <div class="main">
        <div id="cont2">
            <div class="form-container">
                <span class="center-text">강의 내부 영상 수정&lt;입력&gt;</span>
                <form action="/admin/class_video_update" method="post" enctype="multipart/form-data">
                    <label for="u_id">영상 ID</label>
                    <input type="text" name="id" value="${dto.id}" readonly>

                    <label for="video_order">영상 순서</label>
                    <input type="number" id="video_order" name="video_order" required>

                    <label for="title">영상 제목</label>
                    <input type="text" id="title" name="title" required>

                    <label for="content">영상 설명</label>
                    <textarea id="content" name="content" rows="5" cols="55" required></textarea>

                    <label for="video">영상 파일</label>
                    <input type="file" id="video" name="video" accept="video/*" required>
                    <input type="hidden" name="class_id" value="${dto.class_id}"/>
                    <button type="submit">영상 등록</button>
                </form>
            </div>
        </div>
        <div id="cont3">
            <div class="form-container">
                <span class="center-text">강의 외부 수정&lt;입력&gt;</span>
                <form action="/admin/class_video_update1" method="post" enctype="multipart/form-data">
                    <label for="u_id">영상 ID</label>
                    <input type="text" name="id" value="${dto.id}" readonly>

                    <label for="video_order">영상 순서</label>
                    <input type="number" id="video_order1" name="video_order" required>

                    <label for="title">영상 제목</label>
                    <input type="text" id="title1" name="title" required>

                    <label for="content">영상 설명</label>
                    <textarea id="content1" name="content" rows="5" cols="55" required></textarea>

                    <label for="video_url">영상 url</label>
                    <input type="text" id="video_url" name="video_url" required>
                    <input type="hidden" name="class_id" value="${dto.class_id}"/>
                    <button type="submit">영상 등록</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    function menuDisplay(num) {
        const contents = document.querySelectorAll('.main > div');

        contents.forEach(function(content) {
            content.style.display = 'none';
        });

        const selectedContentId = 'cont' + num;
        const selectedContent = document.getElementById(selectedContentId);

        if (selectedContent) {

            selectedContent.style.display = 'block';
        }
    }

    //기본 값
    document.addEventListener('DOMContentLoaded', function() {
        menuDisplay(1);
    });
</script>
</body>
</html>
