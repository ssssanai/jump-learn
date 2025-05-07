<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-07
  Time: 오전 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/memberListStyle.css" rel="stylesheet" type="text/css">
    <title>문의 조회</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<div id="AdminInfo">
    <span>${loginInfo.status == 1 ? '슈퍼관리자' : (loginInfo.status == 2 ? '중간 관리자' : (loginInfo.status == 3 ? '말단 관리자' : ''))}</span>
    <span>${loginInfo.name}</span>
</div>
<h1>문의 조회</h1>
<div id="total">
    총 문의 : ${pageInfo.total_count} 개
    <form id="search" action="/admin/inquiry_search_list" method="get">
        <select name="search_category">
            <option value="" disabled selected>선택</option>
            <option value="member_id">문의한 회원</option>
            <option value="inquiry_status">응답 상태</option>
        </select>
        <input type="text" name="search_word" placeholder="검색어를 입력하세요"/>
        <button type="submit">검색</button>
        <a href="/admin/inquiryList"><button type="button">전체</button></a>
    </form>
</div>
<table id="list">
    <thead>
    <tr>
        <th>순서</th>
        <th>문의 아이디</th>
        <th>회원 아이디</th>
        <th>제목</th>
        <th>문의 날짜</th>
        <th>응답 상태</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${not empty dtoList}">
            <c:forEach var="list" items="${dtoList}" varStatus="loop">
                <tr>
                    <td>${pageInfo.total_count - (pageInfo.page_no - 1) * pageInfo.page_size - loop.index}</td>
                    <td><a href="/admin/inquiry?id=${list.inquiry_id}">${list.inquiry_id}</a></td>
                    <td>${list.member_id}</td>
                    <td>${list.inquiry_title}</td>
                    <td>${list.inquiry_created_at}</td>
                    <td>${list.inquiry_status}</td>
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
               href="/admin/inquiry_search_list?"
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
                 <c:otherwise>/admin/inquiry_search_list?${pageInfo.linkParams}&page_no=${page_num}</c:otherwise>
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
               href="/admin/inquiry_search_list?"
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
