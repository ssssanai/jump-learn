<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-13
  Time: 오전 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String id = request.getParameter("id");
  String classId = request.getParameter("class_id");
%>
<html>
<head>
  <link href="/resources/static/css/teacher/popup.css" rel="stylesheet" type="text/css">
  <title>공지사항 입력</title>
</head>
<body>
<h2>공지사항 입력</h2>
<form class="registBox" action="/teacher/notice_add_popup" method="post">
  <input class="regi_input" type="text" name="notice" placeholder="공지사항를 입력하세요"><br>
  <input type="hidden" name="id" value="${id}">
  <div class="btn">
    <input type="submit" value="입력하기">
    <button type="button" onclick="window.close()">취소</button>
  </div>
</form>
<c:if test="${not empty msg}">
<script>
  let msg = '${msg}';
  if (msg.trim() !== '') {
    alert(msg);
    window.close();
    window.opener.location.reload();
  }
</script>
</c:if>
</html>
