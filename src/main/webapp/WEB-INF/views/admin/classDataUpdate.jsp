<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-08
  Time: 오후 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link href="../../../resources/static/css/admin/classUpdateStyle.css" rel="stylesheet" type="text/css">
  <title>강의 자료 수정</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<h1 style="text-align:center;">강의 자료 수정</h1>
<div class="center-wrapper">
  <a href="/admin/class_data_delete?data_id=${dto.id}&class_id=${dto.class_id}">
    <button class="center-button">삭제하기</button>
  </a>
</div>
<div class="form-container">
  <span class="center-text">강의 자료 수정 전</span>
  <form>
    <label for="u_id">자료 ID</label>
    <input type="text" id="u_id" name="id" value="${dto.id}" readonly>
    <label for="u_order">자료 순서</label>
    <input type="number" id="u_order" name="order" value="${dto.data_order}" readonly>
    <label for="u_title">자료 제목</label>
    <input type="text" id="u_title" name="title" value="${dto.title}" readonly>
    <label>PDF 파일</label>
    <a href="/upload/${dto.data_name}" target="_blank">${dto.data_name}</a>
  </form>
</div>

<div class="form-container">
  <span class="center-text">강의 자료 수정&lt;입력&gt;</span>
  <form action="/admin/class_data_update" method="post" enctype="multipart/form-data">
    <label for="id">자료 ID</label>
    <input type="text" id="id"name="id" value="${dto.id}" readonly>

    <label for="data_order">자료 순서</label>
    <input type="number" id="data_order" name="data_order" required>

    <label for="title">데이터 제목</label>
    <input type="text" id="title" name="title" required>

    <label for="pdf">PDF 파일</label>
    <input type="file" id="pdf" name="pdf" accept="application/pdf" required>

    <input type="hidden" name="class_id" value="${dto.class_id}"/>
    <input type="submit">자료 등록</input>
  </form>
</div>
</body>
</html>