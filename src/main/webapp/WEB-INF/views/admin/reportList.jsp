<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-07
  Time: 오전 1:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/memberListStyle.css" rel="stylesheet" type="text/css">
    <title>신고 조회</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<div id="AdminInfo">
    <span>${loginInfo.status == 1 ? '슈퍼관리자' : (loginInfo.status == 2 ? '중간 관리자' : (loginInfo.status == 3 ? '말단 관리자' : ''))}</span>
    <span>${loginInfo.name}</span>
</div>
<h1>신고 조회</h1>
<div id="total">
    총 신고 : ${pageInfo.total_count} 개
    <form id="search" action="/admin/report_search_list" method="get">
        <select name="search_category">
            <option value="" disabled selected>선택</option>
            <option value="target_type">신고 타입</option>
            <option value="member_id">신고자</option>
            <option value="report_status">응답 상태</option>
        </select>
        <input type="text" name="search_word" placeholder="검색어를 입력하세요"/>
        <button type="submit">검색</button>
        <a href="/admin/reportList"><button type="button">전체</button></a>
    </form>
</div>
<table id="list">
    <thead>
    <tr>
        <th>순서</th>
        <th>신고 아이디</th>
        <th>신고 타입</th>
        <th>신고자</th>
        <th>응답 상태</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${not empty dtoList}">
            <c:forEach var="list" items="${dtoList}" varStatus="loop">
                <tr>
                    <td>${pageInfo.total_count - (pageInfo.page_no - 1) * pageInfo.page_size - loop.index}</td>
                    <td><a href="/admin/report?id=${list.report_id}">${list.report_id}</a></td>
                    <td>${list.target_type}</td>
                    <td>${list.member_id}</td>
                    <td>${list.report_status.equals("completed") ? "처리 완료" : "처리중"}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="7">신고 정보가 없습니다.</td>
            </tr>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
<div id="pages">
    <ul class="pagination justify-content-center">
        <li class="page-item <c:if test="${pageInfo.prev_page_flag eq false}">disabled</c:if>">
            <a class="page-link"
               data-num="
         <c:choose>
           <c:when test='${pageInfo.prev_page_flag}'>
             ${pageInfo.page_block_start - 1}
           </c:when>
           <c:otherwise>1</c:otherwise>
         </c:choose>"
               href="/admin/report_search_list?"
            <c:choose>
                    <c:when test='${pageInfo.prev_page_flag}'>
                        ${pageInfo.linkParams}&page_no=${pageInfo.page_block_start - 1}
                    </c:when>
                    <c:otherwise>#</c:otherwise>
            </c:choose>">
            Previous
            </a>
        </li>

        <c:forEach begin="${pageInfo.page_block_start}" end="${pageInfo.page_block_end}" var="page_num">
            <li class="page-item <c:if test='${pageInfo.page_no == page_num}'>active</c:if>'">
                <a class="page-link" data-num="${page_num}"
                   href="<c:choose>
                 <c:when test='${pageInfo.page_no == page_num}'>#</c:when>
                 <c:otherwise>/admin/report_search_list?${pageInfo.linkParams}&page_no=${page_num}</c:otherwise>
              </c:choose>">${page_num}</a>
            </li>
        </c:forEach>

        <li class="page-item <c:if test="${pageInfo.next_page_flag eq false}">disabled</c:if>">
            <a class="page-link"
               data-num="
         <c:choose>
           <c:when test='${pageInfo.next_page_flag}'>
             ${pageInfo.page_block_end + 1}
           </c:when>
           <c:otherwise>${pageInfo.page_block_end}</c:otherwise>
         </c:choose>"
               href="/admin/report_search_list?"
            <c:choose>
                    <c:when test='${pageInfo.next_page_flag}'>
                        ${pageInfo.linkParams}&page_no=${pageInfo.page_block_end + 1}
                    </c:when>
                    <c:otherwise>#</c:otherwise>
            </c:choose>">
            Next
            </a>
        </li>
    </ul>
</div>
</body>
</html>
