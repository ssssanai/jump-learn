<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-08
  Time: 오전 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link href="../../../resources/static/css/admin/teacherClassStyle.css" rel="stylesheet" type="text/css">
  <title>강좌 조회</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<h1>${id}님의 강좌 조회</h1>
<table id="list">
  <thead>
  <tr>
    <th>순서</th>
    <th>강좌 사진</th>
    <th>강좌 아이디</th>
    <th>강좌 제목</th>
    <th>타겟 층</th>
    <th>가격</th>
    <th>구매한 회원 수</th>
  </tr>
  </thead>
  <tbody>
  <c:choose>
    <c:when test="${not empty dtoList}">
      <c:forEach var="list" items="${dtoList}" varStatus="loop">
        <tr>
          <td>${loop.index + 1}</td>
          <td>
            <c:choose>
              <c:when test="${not empty list.file_name}">
                <img src="/upload/${list.file_name}" alt="회원 사진" />
              </c:when>
              <c:otherwise>
                <img src="../../../resources/static/images/img.png" alt="기본 강좌 이미지" />
              </c:otherwise>
            </c:choose>
          </td>
          <td>${list.class_id}</td>
          <td>${list.title}</td>
          <td>${list.target}</td>
          <td>${list.price}</td>
          <td>${list.pay_count}</td>
        </tr>
      </c:forEach>
    </c:when>
    <c:otherwise>
      <tr>
        <td colspan="8">강좌 정보가 없습니다.</td>
      </tr>
    </c:otherwise>
  </c:choose>
  </tbody>
</table>
