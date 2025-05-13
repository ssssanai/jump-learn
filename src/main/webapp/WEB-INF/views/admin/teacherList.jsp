<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-05
  Time: 오후 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/memberListStyle.css" rel="stylesheet" type="text/css">
    <title>선생님 조회</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<div id="AdminInfo">
    <span>${loginInfo.status == 1 ? '슈퍼관리자' : (loginInfo.status == 2 ? '중간 관리자' : (loginInfo.status == 3 ? '말단 관리자' : ''))}</span>
    <span>${loginInfo.name}</span>
</div>
<h1>선생님 조회</h1>
<div id="total">
    총 선생님 : ${pageInfo.total_count}명
    <form id="search" action="/admin/teacher_search_list" method="get">
        <select name="search_category">
            <option value="" disabled selected>선택</option>
            <option value="id">아이디</option>
            <option value="name">이름</option>
            <option value="status">상태</option>
        </select>
        <input type="text" name="search_word" placeholder="검색어를 입력하세요"/>
        <button type="submit">검색</button>
        <a href="/admin/teacherList"><button type="button">전체</button></a>
        <a href="/admin/teacher_create"><button type="button">추가</button></a>
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
        <th>성별</th>
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
                    <td><a href="/admin/teacher?id=${list.id}">${list.id}</a></td>
                    <td>${list.name}</td>
                    <td>${list.status}</td>
                    <td>${list.email}</td>
                    <td>${list.gender}</td>
                    <td><button onclick="changeTeacherStatus('${list.id}')">변경</button></td>
                    <td><a href="/admin/teacherDelete?id=${list.id}"><button>삭제</button></a></td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="8">선생님 정보가 없습니다.</td>
            </tr>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
<div id="pages">
${paging}
</div>
<script>
    function changeTeacherStatus(id) {
        const status = prompt("변경하고자 하는 상태 값을 입력하세요(1: 활성 2:제지 3:장기 미변경 4:유예)");

        if (status !== null && status.trim() !== "") {
            const pattern = /^[1-4]+$/; // 숫자만 허용

            if (pattern.test(status)) {
                window.location.href = "/admin/teacherChange?id=" + encodeURIComponent(id) + "&s=" + encodeURIComponent(status);
            } else {
                alert("1~4까지의 숫자만 입력할 수 있습니다.");
            }
        }
    }
</script>
</body>
</html>
