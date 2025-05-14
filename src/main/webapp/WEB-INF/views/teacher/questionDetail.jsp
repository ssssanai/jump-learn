<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-13
  Time: 오전 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/reportStyle.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb3.css" rel="stylesheet" type="text/css">
    <title>질문 상세 상세 페이지</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>

<!-- 신고 카드 반복 예시 -->
<h2>질문 상세 보기</h2>

<div class="report-card">
    <div class="report-row">
        <div class="report-label">질문 ID:</div>
        <div class="report-value">${dto.id}</div>
    </div>
    <div class="report-row">
        <div class="report-label">질문 회원:</div>
        <div class="report-value">${dto.member_id}</div>
    </div>
    <div class="report-row">
        <div class="report-label">질문 제목:</div>
        <div class="report-value">${dto.title}</div>
    </div>
    <div class="report-row">
        <div class="report-label">질문 내용:</div>
        <div class="report-value">${dto.content}</div>
    </div>
    <div class="report-row">
        <div class="report-label">질문 날짜:</div>
        <div class="report-value">${dto.created_at}</div>
    </div>
    <div class="report-row">
        <div class="report-label">처리 상태:</div>
        <div class="report-value status-pending">
            ${Integer.parseInt(dto.is_answered)== 0 ? '답변 필요' : '답변 완료'}
        </div>
    </div>
</div>
<c:choose>
    <c:when test="${empty dto.comment_content}">
        <div class="report-card">
            <form action="/teacher/questionDetail" method="post">
                <div class="report-row">
                    <div class="report-label">답변하기:</div>
                    <div class="report-value">
                        <textarea name="comment_content" placeholder="답변 내용을 입력하세요"></textarea>
                    </div>
                </div>
                <input type="hidden" name="id" value="${dto.id}">
                <div class="report-row">
                    <div class="report-label"></div>
                    <div class="report-value">
                        <button type="submit" class="submit-button">전송</button>
                    </div>
                </div>
            </form>
        </div>
    </c:when>
    <c:otherwise>
        <div class="report-card">
            <div class="report-row">
                <div class="report-label">선생님 ID:</div>
                <div class="report-value">${dto.teacher_id}</div>
            </div>
            <div class="report-row">
                <div class="report-label">답변내용:</div>
                <div class="report-value">${dto.comment_content}</div>
            </div>
            <div class="report-row">
                <div class="report-label">답변일:</div>
                <div class="report-value">${dto.comment_created_at}</div>
            </div>
        </div>
    </c:otherwise>
</c:choose>
<a href="/teacher/questionList?class_id=${dto.class_id}"><button>뒤로가기</button></a>
</body>
</html>

