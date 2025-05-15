<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-09
  Time: 오후 3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/reportStyle.css" rel="stylesheet" type="text/css">
    <title>신고 상세 페이지</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>

<!-- 신고 카드 반복 예시 -->
<h2>신고 상세 보기</h2>

<div class="report-card">
    <div class="report-row">
        <div class="report-label">신고 ID:</div>
        <div class="report-value">${dto.report_id}</div>
    </div>
    <div class="report-row">
        <div class="report-label">Target ID:</div>
        <div class="report-value"><a href="/post/view?id=${dto.target_id}">${dto.target_id}</a></div>
    </div>
    <div class="report-row">
        <div class="report-label">Target Type:</div>
        <div class="report-value">${dto.target_type}</div>
    </div>
    <div class="report-row">
        <div class="report-label">신고자:</div>
        <div class="report-value">${dto.member_id}</div>
    </div>
    <div class="report-row">
        <div class="report-label">신고 사유:</div>
        <div class="report-value">${dto.reason}</div>
    </div>
    <div class="report-row">
        <div class="report-label">신고일:</div>
        <div class="report-value">${dto.report_create_date}</div>
    </div>
    <div class="report-row">
        <div class="report-label">처리 상태:</div>
        <div class="report-value status-pending">
            ${dto.report_status.equals("completed") ? "처리 완료" : "처리중"}
        </div>
    </div>
</div>
<c:choose>
    <c:when test="${empty dto.resolution}">
        <div class="report-card">
            <form action="/admin/resolution" method="post">
                <div class="report-row">
                    <div class="report-label">답변하기:</div>
                    <div class="report-value">
                        <textarea name="resolution" placeholder="답변 내용을 입력하세요"></textarea>
                    </div>
                </div>
                <input type="hidden" name="report_id" value="${dto.report_id}">
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
                <div class="report-label">답변 ID:</div>
                <div class="report-value">${dto.resolution_id}</div>
            </div>
            <div class="report-row">
                <div class="report-label">관리자 ID:</div>
                <div class="report-value">${dto.admin_id}</div>
            </div>
            <div class="report-row">
                <div class="report-label">응답내용:</div>
                <div class="report-value">${dto.resolution}</div>
            </div>
            <div class="report-row">
                <div class="report-label">답변일:</div>
                <div class="report-value">${dto.resolution_create_date}</div>
            </div>
        </div>
    </c:otherwise>
</c:choose>
<a href="/admin/reportList"><button>뒤로가기</button></a>
</body>
</html>
