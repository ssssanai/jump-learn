<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-06
  Time: 오후 3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/memberListStyle.css" rel="stylesheet" type="text/css">
    <title>관리자 조회</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<div id="AdminInfo">
    <span>${loginInfo.status == 1 ? '슈퍼관리자' : (loginInfo.status == 2 ? '중간 관리자' : (loginInfo.status == 3 ? '말단 관리자' : ''))}</span>
    <span>${loginInfo.name}</span>
</div>
<h1>관리자 조회</h1>
<div id="total">
    총 관리자 : ${pageInfo.total_count}명
    <form id="search" action="/admin/admin_search_list" method="get">
        <select name="search_category">
            <option value="" disabled selected>선택</option>
            <option value="id">아이디</option>
            <option value="name">이름</option>
            <option value="status">상태</option>
        </select>
        <input type="text" name="search_word" placeholder="검색어를 입력하세요"/>
        <button type="submit">검색</button>
        <a href="/admin/adminList"><button type="button">전체</button></a>
        <a href="/admin/admin_create"><button type="button">추가</button></a>
    </form>
</div>
<table id="list">
    <thead>
    <tr>
        <th>순서</th>
        <th>아이디</th>
        <th>이름</th>
        <th>상태</th>
        <th>이메일</th>
        <th>상태변경</th>
        <th>삭제</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${not empty dtoList}">
            <c:forEach var="list" items="${dtoList}" varStatus="loop">
                <tr>
                    <td>${pageInfo.total_count - (pageInfo.page_no - 1) * pageInfo.page_size - loop.index}</td>
                    <td>${list.id}</td>
                    <td>${list.name}</td>
                    <td>${list.status}</td>
                    <td>${list.email}</td>
                    <td><button onclick="changeTeacherStatus('${list.id}')">변경</button></td>
                    <td><a href="/admin/adminDelete?id=${list.id}"><button>삭제</button></a></td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="7">관리자 정보가 없습니다.</td>
            </tr>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
<%--<div id="pages">--%>
<%--    <ul class="pagination justify-content-center">--%>
<%--        <li class="page-item <c:if test='${!pageInfo.prev_page_flag}'>disabled</c:if>'">--%>
<%--            <a class="page-link"--%>
<%--               data-num="<c:choose>--%>
<%--                   <c:when test='${pageInfo.prev_page_flag}'>--%>
<%--                       ${pageInfo.page_block_start - 1}--%>
<%--                   </c:when>--%>
<%--                   <c:otherwise>--%>
<%--                       1--%>
<%--                   </c:otherwise>--%>
<%--                 </c:choose>"--%>
<%--               href="<c:choose>--%>
<%--                <c:when test='${pageInfo.prev_page_flag}'>--%>
<%--                    /admin/admin_search_list?${pageInfo.linkParams}&page_no=${pageInfo.page_block_start - 1}--%>
<%--                </c:when>--%>
<%--                <c:otherwise>#</c:otherwise>--%>
<%--             </c:choose>">--%>
<%--                Previous--%>
<%--            </a>--%>
<%--        </li>--%>

<%--        <c:forEach begin="${pageInfo.page_block_start}" end="${pageInfo.page_block_end}" var="page_num">--%>
<%--            <li class="page-item <c:if test='${pageInfo.page_no == page_num}'>active</c:if>'">--%>
<%--                <a class="page-link" data-num="${page_num}"--%>
<%--                   href="<c:choose>--%>
<%--                 <c:when test='${pageInfo.page_no == page_num}'>#</c:when>--%>
<%--                 <c:otherwise>/admin/admin_search_list?${pageInfo.linkParams}&page_no=${page_num}</c:otherwise>--%>
<%--              </c:choose>">${page_num}</a>--%>
<%--            </li>--%>
<%--        </c:forEach>--%>

<%--        <li class="page-item <c:if test='${!pageInfo.next_page_flag}'>disabled</c:if>">--%>
<%--            <a class="page-link"--%>
<%--               data-num="<c:choose>--%>
<%--                    <c:when test='${pageInfo.next_page_flag}'>--%>
<%--                        ${pageInfo.page_block_end + 1}--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        ${pageInfo.page_block_end}--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>"--%>
<%--               href="<c:choose>--%>
<%--                 <c:when test='${pageInfo.next_page_flag}'>--%>
<%--                     /admin/admin_search_list?${pageInfo.getLinkParams()}&page_no=${pageInfo.page_block_end + 1}--%>
<%--                 </c:when>--%>
<%--                 <c:otherwise>#</c:otherwise>--%>
<%--             </c:choose>">--%>
<%--                Next--%>
<%--            </a>--%>
<%--        </li>--%>
<%--    </ul>--%>

<%--</div>--%>
<div id="pages">
    ${paging}
</div>
<script>
    function changeTeacherStatus(id) {
        const status = prompt("변경하고자 하는 상태 값을 입력하세요(1: 슈퍼 관리자 2:중간 관리자 )");

        if (status !== null && status.trim() !== "") {
            const pattern = /^[1-2]+$/; // 숫자만 허용

            if (pattern.test(status)) {
                window.location.href = "/admin/adminChange?id=" + encodeURIComponent(id) + "&s=" + encodeURIComponent(status);
            } else {
                alert("1~2까지의 숫자만 입력할 수 있습니다.");
            }
        }
    }
</script>
</body>
</html>
