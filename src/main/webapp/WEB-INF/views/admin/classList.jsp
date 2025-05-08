<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-06
  Time: 오후 5:25
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
<div id="AdminInfo">
    <span>${loginInfo.status == 1 ? '슈퍼관리자' : (loginInfo.status == 2 ? '중간 관리자' : (loginInfo.status == 3 ? '말단 관리자' : ''))}</span>
    <span>${loginInfo.name}</span>
</div>
<h1>강좌 조회</h1>
<div id="total">
    총 강좌 : ${pageInfo.total_count} 개
    <form id="search" action="/admin/class_search_list" method="get">
        <select name="search_category">
            <option value="" disabled selected>선택</option>
            <option value="category">과목</option>
            <option value="class_title">강좌 이름</option>
            <option value="teacher_id">담당 선생님</option>
            <option value="class_target">학년</option>
        </select>
        <input type="text" name="search_word" placeholder="검색어를 입력하세요"/>
        <button type="submit">검색</button>
        <a href="/admin/classList"><button type="button">전체</button></a>
        <a href="/admin/class_create"><button type="button">추가</button></a>
    </form>
</div>
<table id="list">
    <thead>
    <tr>
        <th>순서</th>
        <th>강좌 사진</th>
        <th>강좌 아이디</th>
        <th>강좌  제목</th>
        <th>선생님 아이디</th>
        <th>과목</th>
        <th>담당 학년</th>
        <th>가격</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${not empty dtoList}">
            <c:forEach var="list" items="${dtoList}" varStatus="loop">
                <tr>
                    <td>
                        ${pageInfo.total_count - (pageInfo.page_no - 1) * pageInfo.page_size - loop.index}
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty list.class_file_name}">
                                <img src="/upload/${list.class_file_name}" alt="강좌 사진" />
                            </c:when>
                            <c:otherwise>
                                <img src="../../../resources/static/images/img.png" alt="기본 강좌 이미지" />
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td><a href="/admin/class?id=${list.class_id}">${list.class_id}</a></td>
                    <td>${list.class_title}</td>
                    <td>${list.class_teacher_id}</td>
                    <td>${list.class_category}</td>
                    <td>${list.class_target}</td>
                    <td>${list.class_price}</td>
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
               href="/admin/class_search_list?"
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
                 <c:otherwise>/admin/class_search_list?${pageInfo.linkParams}&page_no=${page_num}</c:otherwise>
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
               href="/admin/class_search_list?"
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
