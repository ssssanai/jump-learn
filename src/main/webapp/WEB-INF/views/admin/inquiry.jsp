<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-10
  Time: 오전 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/reportStyle.css" rel="stylesheet" type="text/css">
    <title>신고 상세 페이지</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>

<!-- 신고 카드 반복 예시 -->
<h2>문의 상세 보기</h2>

<div class="inquiry-card">
    <div class="inquiry-row">
        <div class="inquiry-label">문의 ID:</div>
        <div class="inquiry-value">${dto.inquiry_id}</div>
    </div>
    <div class="inquiry-row">
        <div class="inquiry-label">작성자 ID:</div>
        <div class="inquiry-value">${dto.member_id}</div>
    </div>
    <div class="inquiry-row">
        <div class="inquiry-label">문의 제목:</div>
        <div class="inquiry-value">${dto.inquiry_title}</div>
    </div>
    <div class="inquiry-row">
        <div class="inquiry-label">문의 내용:</div>
        <div class="inquiry-value">${dto.inquiry_content}</div>
    </div>
    <div class="inquiry-row">
        <div class="inquiry-label">작성일:</div>
        <div class="inquiry-value">${dto.inquiry_created_at}</div>
    </div>
    <div class="inquiry-row">
        <div class="inquiry-label">수정일:</div>
        <div class="inquiry-value">${dto.inquiry_updated_at}</div>
    </div>
    <div class="inquiry-row">
        <div class="inquiry-label">처리 상태:</div>
        <div class="inquiry-value status-pending">
            ${dto.inquiry_status.equals("completed") ? "답변 완료" : "답변 대기중"}
        </div>
    </div>
</div>

<!-- 답변 처리 -->
<c:choose>
    <c:when test="${empty dto.resolution_content}">
        <div class="inquiry-card">
            <form action="/admin/inquiry_resolution" method="post">
                <div class="inquiry-row">
                    <div class="inquiry-label">답변 작성:</div>
                    <div class="inquiry-value">
                        <textarea name="resolution_content" placeholder="답변을 입력하세요"></textarea>
                    </div>
                </div>
                <input type="hidden" name="inquiry_id" value="${dto.inquiry_id}">
                <div class="inquiry-row">
                    <div class="inquiry-label"></div>
                    <div class="inquiry-value">
                        <button type="submit" class="submit-button">전송</button>
                    </div>
                </div>
            </form>
        </div>
    </c:when>
    <c:otherwise>
        <div class="inquiry-card">
            <div class="inquiry-row">
                <div class="inquiry-label">답변 ID:</div>
                <div class="inquiry-value">${dto.resolution_id}</div>
            </div>
            <div class="inquiry-row">
                <div class="inquiry-label">관리자 ID:</div>
                <div class="inquiry-value">${dto.admin_id}</div>
            </div>
            <div class="inquiry-row">
                <div class="inquiry-label">답변 내용:</div>
                <div class="inquiry-value">${dto.resolution_content}</div>
            </div>
            <div class="inquiry-row">
                <div class="inquiry-label">답변일:</div>
                <div class="inquiry-value">${dto.resolution_created_at}</div>
            </div>
            <div class="inquiry-row">
                <div class="inquiry-label">답변 수정 시간:</div>
                <div class="inquiry-value">${dto.resolution_updated_at}</div>
            </div>
        </div>
    </c:otherwise>
</c:choose>

<c:if test="${not empty dtoList}">
    <div class="inquiry-card">
        <h3>댓글</h3>
        <c:forEach var="comment" items="${dtoList}">
            <div class="inquiry-row">
                <div class="inquiry-label">${comment.inquiry_comment_created_at}:</div>
                <div class="inquiry-label">${comment.inquiry_comment_updated_at}:</div>
                <div class="inquiry-label">${comment.inquiry_commenter}:</div>
                <div class="inquiry-value">${comment.inquiry_comment_content}</div>
            </div>
        </c:forEach>
    </div>
</c:if>


<div class="report-card">
    <form action="/admin/inquiry_comment_resolution" method="post">
        <div class="report-row">
            <div class="report-label">댓글 달기:</div>
            <div class="report-value">
                <textarea name="resolution_content" placeholder="댓글 내용을 입력하세요"></textarea>
            </div>
        </div>
        <input type="hidden" name="inquiry_id" value="${dto.inquiry_id}">
        <div class="report-row">
            <div class="report-label"></div>
            <div class="report-value">
                <button type="submit" class="submit-button">전송</button>
            </div>
        </div>
    </form>
</div>

<a href="/admin/inquiryList"><button>뒤로가기</button></a>
</body>
</html>