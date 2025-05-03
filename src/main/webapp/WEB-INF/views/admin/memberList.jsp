<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-02
  Time: 오전 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link href="../../../resources/static/css/memberListStyle.css" rel="stylesheet" type="text/css">
    <title>회원 조회</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<div id="AdminInfo">
  <span>${loginInfo.status == 1 ? '슈퍼관리자' : (loginInfo.status == 2 ? '중간 관리자' : (loginInfo.status == 3 ? '말단 관리자' : ''))}</span>
  <span>${loginInfo.name}</span>
</div>
<h1>회원 조회</h1>
<div id="total">
  <span>총 회원 : ${totalCount}명</span>
</div>
<table id="list">
  <thead>
  <tr>
    <th>순서</th>
    <th>아이디</th>
    <th>이름</th>
    <th>상태</th>
    <th>이메일</th>
    <th>성별</th>
    <th>상태변경</th>
    <th>삭제</th>
  </tr>
  </thead>
  <tbody>
  <c:choose>
    <c:when test="${not empty dtoList}">
      <c:forEach var="list" items="${dtoList}" varStatus="loop">
        <tr>
          <td>${loop.index + 1}</td>
          <td>${list.id}</td>
          <td>${list.name}</td>
          <td>${list.status}</td>
          <td>${list.email}</td>
          <td>${list.gender}</td>
          <td><button>변경</button></td>
          <td><button>삭제</button></td>
        </tr>
      </c:forEach>
    </c:when>
    <c:otherwise>
      <tr>
        <td colspan="8">회원 정보가 없습니다.</td>
      </tr>
    </c:otherwise>
  </c:choose>
  </tbody>
</table>
</body>
</html>
