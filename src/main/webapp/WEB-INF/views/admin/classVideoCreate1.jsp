<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-08
  Time: 오후 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/teacherCreateStyle.css" rel="stylesheet" type="text/css">
    <title>강의 생성</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<h2 style="text-align:center;">${id}번 강의 등록</h2>

<form action="/admin/class_video_create1" method="post" enctype="multipart/form-data">
    <input type="text" name="class_id" value="${id}" readonly>

    <label for="video_order">영상 순서</label>
    <input type="number" id="video_order" name="video_order" required>

    <label for="title">영상 제목</label>
    <input type="text" id="title" name="title" required>

    <label for="content">영상 설명</label>
    <textarea id="content" name="content" rows="5" cols="55" required></textarea>

    <label for="video_url">영상 url</label>
    <input type="text" id="video_url" name="video_url" required>
    <button type="submit">영상 등록</button>
</form>
</body>
</html>

