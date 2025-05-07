<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-07
  Time: 오전 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/memberStyle.css" rel="stylesheet" type="text/css">
    <title>회원 상세 조회</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<h1>회원 상세 조회</h1>
<c:choose>
    <c:when test="${not empty dto.file_path and not empty dto.file_name}">
        <img src="/upload/${dto.file_name}" alt="회원 사진" />
    </c:when>
    <c:otherwise>
        <img src="../../../resources/static/images/basic.jpg" alt="기본 프로필 이미지" />
    </c:otherwise>
</c:choose>
<table>
    <tr>
        <td>아이디</td>
        <td colspan="2">${dto.id}</td>
        <td>상태</td>
        <td colspan="2">${dto.status}</td>
    </tr>
    <tr>
        <td colspan="2">작성 게시물</td>
        <td><a href="/admin/memberCreate?id=${dto.id}">${dto.totalCountBbs}</a></td>
        <td colspan="2">구매 강의</td>
        <td><a href="/admin/memberEnrollments?id=${dto.id}">${dto.totalCountEnrollments}</a></td>
    </tr>
    <tr>
        <td>이름</td>
        <td>${dto.name}</td>
        <td>성별</td>
        <td>${dto.gender}</td>
        <td>생년월일</td>
        <td>${dto.birth}</td>
    </tr>
    <tr>
        <td>학년</td>
        <td>${dto.grade}</td>
        <td colspan="2">회원가입 날짜</td>
        <td colspan="2">${dto.signup_date}</td>
    </tr>
    <tr>
        <td colspan="5">비밀번호 변경 날짜</td>
        <td>${dto.last_pwd_date}</td>
    </tr>
</table>
</body>
</html>
