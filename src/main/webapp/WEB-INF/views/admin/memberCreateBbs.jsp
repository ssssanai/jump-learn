<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-07
  Time: 오후 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/memberListStyle.css" rel="stylesheet" type="text/css">
    <title>강좌 조회</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<h1>${id}님의 게시물 조회</h1>
<table id="list">
    <thead>
    <tr>
        <th>순서</th>
        <th>게시물 아이디</th>
        <th>게시물 제목</th>
        <th>조회 수</th>
        <th>좋아요 수</th>
        <th>생성 날짜</th>
        <th>수정 날짜</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${not empty dtoList}">
            <c:forEach var="list" items="${dtoList}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${list.post_id}</td>
                    <td>${list.post_title}</td>
                    <td>${list.view_count}</td>
                    <td>${list.like_count}</td>
                    <td>${list.created_at}</td>
                    <td>${list.updated_at}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="8">게시물 정보가 없습니다.</td>
            </tr>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>