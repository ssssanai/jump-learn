<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-08
  Time: 오후 4:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="../../../resources/static/css/admin/teacherCreateStyle.css" rel="stylesheet" type="text/css">
  <title>강의 데이터 생성</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<h2 style="text-align:center;">${id}번 강의 등록</h2>

<form action="/admin/class_data_create" method="post" enctype="multipart/form-data">
  <input type="text" name="class_id" value="${id}" readonly>

  <label for="data_order">자료 순서</label>
  <input type="number" id="data_order" name="data_order" value="${order_id}" readonly>

  <label for="title">데이터 제목</label>
  <input type="text" id="title" name="title" required>

  <label for="pdf">PDF 파일</label>
  <input type="file" id="pdf" name="pdf" accept="application/pdf" required>

  <button type="submit">자료 등록</button>
</form>
</body>
</html>
