<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-02
  Time: 오전 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<html>
<head>
    <link href="../../../resources/static/css/admin/adminLoginStyle.css" rel="stylesheet" type="text/css">
    <title>JL - 관리자 로그인</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<div id="loginContainer">
    <form action="/admin/login" method="post">
        <h1>Jump Learn 관리자 로그인</h1>
        <span>아이디 : </span><input type="text" name="id"/><br>
        <span>비밀번호 : </span><input type="password" name="password"/><br><br>
        <input type="submit" value="로그인">
    </form>
</div>
</body>
</html>
