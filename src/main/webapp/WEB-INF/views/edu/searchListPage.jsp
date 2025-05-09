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
    <link href="../../../resources/static/css/community/writeListPageStyle.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>검색 결과 리스트 페이지</title>
</head>
<body>
<div class="header">
    <div class="logo">
        <img src="img/registLogo.svg" alt="로고"/>
    </div>
    <ul class="mainmenu">
        <li>
            <a href="#">강의</a>
            <ul class="submenu">
                <li>
                    <a href="#">국어</a>
                </li>
                <li>
                    <a href="#">수학</a>
                </li>
                <li>
                    <a href="#" class="lsMenu">영어</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="#">나의 학습방</a>
        </li>
        <li>
            <a href="#">마이페이지</a>
        </li>
        <li>
            <a href="#">문의하기</a>
            <ul class="submenu">
                <li>
                    <a href="#">1:1 문의</a>
                </li>
                <li>
                    <a href="#" class="lsMenu">자주묻는질문</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="#">커뮤니티</a>
            <ul class="submenu">
                <li>
                    <a href="#">자료실 게시판</a>
                </li>
                <li>
                    <a href="#">교육정보 게시판</a>
                </li>
                <li>
                    <a href="#">대입 정보 게시판</a>
                </li>
                <li>
                    <a href="#">대외활동 게시판</a>
                </li>
                <li>
                    <a href="#">뉴스 게시판</a>
                </li>
                <li>
                    <a href="#" class="lsMenu">교육정보 게시판</a>
                </li>
            </ul>
        </li>
    </ul>
</div>
<div class="wrap">
    <div class="aside">
        <div class="profile">

        </div>
        <h2>커뮤니티</h2>
        <div class="comuMenu">
            <a href="#">자유게시판</a>
            <a href="#">교육 정보 게시판</a>
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
                <c:choose>
                    <c:when test="${not empty sessionScope.loginInfo.status}">
                        <a href="/edu/viewPage?id=${post.id}">글쓰기</a>
                    </c:when>
                </c:choose>


            </div>
        </div>
        <form class="searchInput" method="GET" action="/edu/searchListPage">
            <input type="hidden" name="page_no"   value="${pageDTO.page_no}" />
            <input type="hidden" name="page_size" value="${pageDTO.page_size}" />
            <div class="siReset">
                <input type="reset" value="검색조건 초기화">
            </div>
            <div>
                <select id="search_category" name="search_category" class="selectOption">
<%--                    옵션 value qu0,1,2 에서 변경했음 --%>
                    <option value="-"           ${pageDTO.search_category==''             ? 'selected':''}>-</option>
                    <option value="title"       ${pageDTO.search_category=='title'        ? 'selected':''}>제목</option>
                    <option value="content"     ${pageDTO.search_category=='content'      ? 'selected':''}>내용</option>
                    <option value="admin_id"    ${pageDTO.search_category=='admin_id'     ? 'selected':''}>작성자</option>
                    <option value="created_at"  ${pageDTO.search_category=='created_at'   ? 'selected':''}>작성일</option>
                </select>
<%--       검색조건이 작성일일때는 from날짜 to날짜 2개로 검색할 수 있게 UI 전환    --%>
                <div>
                    <input type="text" id="search_word" name="search_word" class="serch_in"
                       placeholder="검색어를 입력해주세요." value="${pageDTO.search_word}">
                    <input type="date" name="search_date_from" id="search_date_from" value="${pageDTO.search_date_from}" />~
                    <input type="date" name="search_date_to" id="search_date_to" value="${pageDTO.search_date_to}"/>
                    <input type="submit" class="serch_btn" name="serch_btn" value="검색">
                </div>
            </div>
        </form>

        <div class="writeList">
            <div class="wlHeader">
                <c:choose>
                    <c:when test="${not empty sessionScope.loginInfo.status}">
                        <p>선택</p>
                        <p class="listNo">번호</p>>
                    </c:when>
                </c:choose>

                <p class="listTit">제목</p>
                <p class="listCont">내용</p>
                <p class="listName">작성자</p>
                <p class="listDate">작성일</p>
                <p class="listCnt">조회수</p>

            <c:choose>
                <c:when test="${not empty sessionScope.loginInfo.status}">
                    <p><input type="button" value="선택 삭제"></p>
                </c:when>
            </c:choose>
            </div>
            <div>
            <c:forEach var="post" items="${dto.dtoList}">
                <div class="wlBody">
                    <c:choose>
                        <c:when test="${not empty sessionScope.loginInfo.status}">
                            <p class="listNo">
                                <input type="checkbox" id="deleteCheckBox${post.id}" name="deleteCheckBox${post.id}">
                                ${post.id}
                            </p>
                        </c:when>
                    </c:choose>
                    <p class="listTit"><a href="/edu/viewPage?id=${post.id}">${post.title}</a></p>
                    <p class="listName"><a href="#">${post.admin_id}</a></p>
<%--                    아이디 눌러서 해당 계정명으로 검색하기 기능 나중에 시간나면 추가.--%>
                    <p class="listDate">${fn:replace(post.created_at,'T',' ')}</p>
                    <p class="listCnt">${post.view_count}</p>

                    <c:choose>
                        <c:when test="${not empty sessionScope.loginInfo.status}">
                            <input type="button" id="deleteBtn${post.id}" name="deleteBtn${post.id}" onClick="if(confirm('${post.title} 글을 삭제하시겠습니까?')) {location.href='/edu/delete?id=${post.id}';}" value="삭제">
                        </c:when>
                    </c:choose>
                </div>
            </c:forEach>
            </div>
            <div>
                ${paging}
            </div>
        </div>
    </div>
</div>

</body>
</html>
