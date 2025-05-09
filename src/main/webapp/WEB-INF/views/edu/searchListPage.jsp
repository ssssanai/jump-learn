<%--
  Created by IntelliJ IDEA.
  User: lsm01
  Date: 25. 5. 4.
  Time: 오후 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/community/eduListPage.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb1.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>검색 결과 리스트 페이지</title>
</head>
<body>
<%--고정 헤더 파일--%>
<%@include file="../../../resources/static/html/headerGnb.jsp"%>
<div class="wrap">
    <div class="aside">
        <div class="profile">
            <div class="myInfo">
                <p>회원등급  ??</p>
                <h2>환영합니다 OOO님!</h2>
            </div>
            <div class="logoutBtn">
                <a href="#">로그아웃</a>
                <a href="#">회원탈퇴</a>
            </div>
        </div>
        <div class="sideMenu">
            <h2 class="sideMenuTitle">커뮤니티</h2>
            <a href="#">자유게시판</a>
            <a href="#" class="select">교육 정보 게시판</a>
            <a href="#">대입 정보 게시판</a>
            <a href="#">대외활동 게시판</a>
            <a href="#">자료실 게시판</a>
            <a href="#">뉴스 게시판</a>
        </div>
    </div>
    <div class="main">
        <div class="writeTit">
            <h2>edu 게시판</h2>
            <p>교육 정보 게시판 입니다.</p>
            <div class="wtBtn">
                <a href="#">글쓰기</a>
            </div>
        </div>
        <form class="searchInput" method="GET" action="/edu/searchListPage">
            <input type="hidden" name="page_no"   value="${pageDTO.page_no}" />
            <input type="hidden" name="page_size" value="${pageDTO.page_size}" />
            <div class="siReset">
                <input type="reset" value="검색조건 초기화">
            </div>
            <div class="searchBoxs">
                <select id="search_category" name="search_category" class="selectOption">
                    <option value="-"           ${pageDTO.search_category==''             ? 'selected':''}>선택</option>
                    <option value="title"       ${pageDTO.search_category=='title'        ? 'selected':''}>제목</option>
                    <option value="content"     ${pageDTO.search_category=='content'      ? 'selected':''}>내용</option>
                    <option value="admin_id"    ${pageDTO.search_category=='admin_id'     ? 'selected':''}>작성자</option>
                    <option value="created_at"  ${pageDTO.search_category=='created_at'   ? 'selected':''}>작성일</option>
                </select>
                <input type="text" id="search_word" name="search_word" class="search_in" placeholder="검색어를 입력해주세요." value="${pageDTO.search_word}">
                <div class="searchDate">
                    <input type="date" name="search_date_from" id="search_date_from" value="${pageDTO.search_date_from}"/>
                    <p>~</p>
                    <input type="date" name="search_date_to" id="search_date_to" value="${pageDTO.search_date_to}"/>
                </div>
                <input type="submit" class="search_btn" name="serch_btn" value="검색">
            </div>
        </form>
        <div class="writeList">
            <div class="wlHeader">
                <p class="listCk">선택</p>
                <p class="listNo">번호</p>
                <p class="listTit">제목</p>
                <p class="listName">작성자</p>
                <p class="listDate">작성일</p>
                <p class="listCnt">조회수</p>
                <div class="listDelBtnBox">
                    <input class="listDelBtn" type="button" value="선택삭제">
                </div>
            </div>
            <c:forEach var="post" items="${dto.dtoList}">
                <div class="wlBody">
                    <div class="listCk">
                        <input class="listCkbox" type="checkbox" id="deleteCheckBox${post.id}" name="deleteCheckBox${post.id}">
                    </div>
                    <p class="listNo">${post.id}</p>
                    <p class="listTit"><a href="/edu/viewPage?id=${post.id}">${post.title}</a></p>
                    <p class="listName"><a href="#">${post.admin_id}</a></p>
                    <p class="listDate">${fn:replace(post.created_at,'T',' ')}</p>
                    <p class="listCnt">${post.view_count}</p>
                    <div class="listDelBtnBox">
                        <input class="listDelBtn" type="button" id="deleteBtn${post.id}" name="deleteBtn${post.id}" onClick="if(confirm('${post.title} 글을 삭제하시겠습니까?')) {location.href='/edu/delete?id=${post.id}';}" value="삭제">
                    </div>
                </div>
            </c:forEach>
            <div class="pagingBox">
                ${paging}
            </div>
        </div>
    </div>
</div>
</body>
</html>
