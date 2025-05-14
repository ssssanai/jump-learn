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
    <link href="/resources/static/css/community/edu/eduListPage.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb2.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>검색 결과 리스트 페이지</title>
</head>
<body>
<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/memberGnb.jsp"%>
<div class="wrap">
    <div class="aside">
        <div class="profile">
            <div class="myInfo">
                <p>회원등급  ${loginInfo.status}</p>
                <h2>환영합니다 ${loginInfo.name}님!</h2>
            </div>
            <div class="sideMenu">
                <h2 class="sideMenuTitle">커뮤니티</h2>
                <a href="/post/searchListPage">자유게시판</a>
                <a href="/notice/searchListPage">공지사항 게시판</a>
                <a href="/edu/searchListPage" >교육 정보 게시판</a>
                <a href="/info/searchListPage">대입 정보 게시판</a>
                <a href="/activity/searchListPage">대외활동 게시판</a>
                <a href="/lib/searchListPage">자료실 게시판</a>
                <a href="/news/searchListPage" class="select">뉴스 게시판</a>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="writeTit">
            <h2>뉴스 게시판</h2>
            <p>시사 정보를 얻을 수 있는 게시판입니다.</p>
            <div class="wtBtn">
                <c:if test="${isAdmin}">
                    <a href="/news/writePage">글쓰기</a>
                </c:if>
            </div>
        </div>
        <form class="searchInput" name="frmSearch" id="frmSearch" method="GET" action="/news/searchListPage">
            <input type="hidden" name="page_size" value="${pageDTO.page_size}" />
            <div class="siReset">
                <input type="button" onclick="location.href='<c:url value="/news/searchListPage"/>'"  value="검색조건 초기화">
            </div>
            <div class="searchBoxs">
                <select id="search_category" name="search_category" class="selectOption">
                    <option value="-"           ${pageDTO.search_category==''             ? 'selected':''}>선택</option>
                    <option value="title"       ${pageDTO.search_category=='title'        ? 'selected':''}>제목</option>
                    <option value="content"     ${pageDTO.search_category=='content'      ? 'selected':''}>내용</option>
                    <option value="admin_id"    ${pageDTO.search_category=='admin_id'     ? 'selected':''}>작성자</option>
                    <option value="created_at"  ${pageDTO.search_category=='created_at'   ? 'selected':''}>작성일</option>
                </select>
                <input type="text" id="search_word" name="search_word" class="search_in" placeholder="검색어를 입력해주세요." value="${pageDTO.search_word}" style="" >
                <div class="searchDate" style="display:none">
                    <input type="date" name="search_date_from" id="search_date_from" value="${pageDTO.search_date_from}"/>
                    <p>~</p>
                    <input type="date" name="search_date_to" id="search_date_to" value="${pageDTO.search_date_to}"/>
                </div>
                <input type="submit" class="search_btn" name="serch_btn" value="검색">
            </div>
        </form>
        <div class="writeList">
            <div class="wlHeader">
                <p class="listNo">번호</p>
                <p class="listTit">제목</p>
                <p class="listName">작성자</p>
                <p class="listDate">작성일</p>
                <p class="listCnt">조회수</p>
            </div>
            <c:forEach var="post" items="${dto.dtoList}">
                <div class="wlBody">
                    <p class="listNo">${post.id}</p>
                    <p class="listTit"><a href="/news/viewPage?id=${post.id}&${pageDTO.getLinkParams()}">${post.title}</a></p>
                    <p class="listName">${post.admin_id}</p>
                    <p class="listDate">${fn:replace(post.created_at,'T',' ')}</p>
                    <p class="listCnt">${post.view_count}</p>
                    <c:if test="${isAdmin}">
                        <div class="listDelBtnBox">
                            <input class="listDelBtn" type="button" id="deleteBtn${post.id}" name="deleteBtn${post.id}" onClick="if(confirm('${post.title} 글을 삭제하시겠습니까?')) {location.href='/news/delete/${post.id}'}" value="삭제">
                        </div>
                    </c:if>
                </div>
            </c:forEach>
            <div class="pagingBox">
                ${paging}
            </div>
        </div>
    </div>
</div>

<script>

    const frmSearch = document.getElementById('frmSearch');
    const search_category = document.getElementById('search_category');
    const search_word = document.getElementById('search_word');
    const searchDate = document.querySelector('.searchDate');
    const search_date_from = document.getElementById('search_date_from');
    const search_date_to = document.getElementById('search_date_to');

    search_category.addEventListener('change', function (e) {
        if( search_category.value == 'created_at'  ) {
            search_word.value = '';
            search_word.style.display = 'none';
            searchDate.style.display = 'block';
        } else {
            search_word.style.display = 'block';
            search_date_from.value = '';
            search_date_to.value = '';
            searchDate.style.display = 'none';
        }

    }, false );


    frmSearch.addEventListener('submit', function (e) {
        e.preventDefault();
        e.stopPropagation();

        if( search_category.value == 'created_at' ) {
            if (search_date_from.value.length > 0  && search_date_to.value.length > 0) {
                let date1 = new Date(search_date_from.value);
                let date2 = new Date(search_date_to.value);

                if (  (date2.getTime() - date1.getTime() )<0 ) {
                    alert("날짜 값이 올바르지 않습니다1.")
                    return false;
                }
            } else {
                alert("날짜 값이 올바르지 않습니다2.")
                return false;
            }
        } else {
            if( search_word.value == '') {
                alert("검색어를 입력하세요")
                search_word.focus();
                return false;
            }
        }

        // frmSearch.method="GET";
        // frmSearch.action="/edu/searchListPage";
        frmSearch.submit();


    })


</script>
</body>
</html>
