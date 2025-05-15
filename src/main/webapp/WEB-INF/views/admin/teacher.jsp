<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-07
  Time: 오후 5:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/memberStyle.css" rel="stylesheet" type="text/css">
    <title>선생님 상세 조회</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<h1>선생님 상세 조회</h1>
<c:choose>
    <c:when test="${not empty dto.file_path and not empty dto.file_name}">
        <img src="/upload/${dto.file_name}" alt="회원 사진" />
    </c:when>
    <c:otherwise>
        <img src="../../../resources/static/images/basic.jpg" alt="기본 프로필 이미지" />
    </c:otherwise>
</c:choose>
<div>
    <span id="class"><a href="/admin/teacherClass?id=${dto.id}">맡은 강좌 : ${dto.totalCountClass}</a></span>
</div>
<table>
    <tr>
        <td>아이디</td>
        <td>${dto.id}</td>
        <td>상태</td>
        <td>${dto.status}</td>
        <td>이름</td>
        <td>${dto.name}</td>
    </tr>
    <tr>
        <td>성별</td>
        <td>${dto.gender}</td>
        <td>생년월일</td>
        <td>${dto.birth}</td>
        <td>회원가입 날짜</td>
        <td>${dto.signup_date}</td>
    </tr>
    <tr>
        <td>자기소개1</td>
        <td colspan="5">${dto.introduce1}</td>
    </tr>
    <tr>
        <td>자기소개2</td>
        <td colspan="5">${dto.introduce2}</td>
    </tr>
    <tr>
        <td>자기소개3</td>
        <td colspan="5">${dto.introduce3}</td>
    </tr>
</table>
<button>
    <a href="/admin/teacherList" class="button-link">뒤로가기</a>
</button>
</body>
</html>
