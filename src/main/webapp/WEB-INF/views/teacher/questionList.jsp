<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-13
  Time: 오전 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/memberListStyle.css" rel="stylesheet" type="text/css">
    <title>질문 조회</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>

<h1>${title}&nbsp;질문 조회</h1>

<table id="list">
    <thead>
    <tr>
        <th>순서</th>
        <th>문의 아이디</th>
        <th>회원 아이디</th>
        <th>질문 제목</th>
        <th>문의 날짜</th>
        <th>응답 상태</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${not empty dtoList}">
            <c:forEach var="list" items="${dtoList}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td><a href="/admin/inquiry?id=${list.id}">${list.id}</a></td>
                    <td>${list.member_id}</td>
                    <td>${list.title}</td>
                    <td>${list.created_at}</td>
                    <td>${Integer.parseInt(list.is_answered)== 0 ? '답변 필요' : '답변 완료'}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="7">문의 정보가 없습니다.</td>
            </tr>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
</body>
</html>