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
    <link href="/resources/static/css/community/qna/listPage.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb2.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>Q&A 페이지</title>
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
                <a href="/edu/searchListPage">교육 정보 게시판</a>
                <a href="/info/searchListPage">대입 정보 게시판</a>
                <a href="/activity/searchListPage">대외활동 게시판</a>
                <a href="/lib/searchListPage">자료실 게시판</a>
                <a href="/news/searchListPage">뉴스 게시판</a>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="writeTit">
            <h2>QnA 게시판입니다.</h2>
            <p>질문 사항을 편하게 작성해주세요</p>
            <div class="wtBtn">
                <a href="/inquiry/write">글쓰기</a>
            </div>
        </div>
        <form class="searchInput" method="GET" action="" name="frmSearch">
            <div class="searchBoxs">
                <select id="search_category" name="search_category" class="selectOption">
                    <option value="member_id">작성자</option>
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                </select>
                <input type="text" id="search_word" name="search_word" class="search_in" placeholder="검색어를 입력해주세요." value=""/>
                <input type="submit" id="btnSubmit" class="search_btn" name="serch_btn" value="검색">
            </div>
        </form>
        <div class="writeList">
            <table class="wlHeader">
                <tr>
                    <th class="listNo"><p>번호</p></th>
                    <th class="listTit"><p>제목</p></th>
                    <th class="listContent"><p>내용</p></th>
                    <th class="listName"><p>작성자</p></th>
                    <th class="listDate"><p>작성일</p></th>
                    <th class="listEditDate"><p>수정일</p></th>
                    <th class="listCnt"><p>처리상태</p></th>
                </tr>
            </table>
                <c:forEach items="${dtoList}" var="i">
                    <c:choose>
                        <c:when test="${i.visibility == 1}">
                            <table class="wlBody">
                                <tr>
                                    <td class="listNo"><a href="/inquiry/detail/${i.inquiry_id}"> ${i.inquiry_id}</a></td>
                                    <td class="listTit"><p>${i.inquiry_title}</p></td>
                                    <td class="listContent"><p>${i.inquiry_content}</p></td>
                                    <td class="listName"><p>${i.member_id}</p></td>
                                    <td class="listDate"><p>${i.inquiry_created_at}</p></td>
                                    <td class="listEditDate"><p>${i.inquiry_updated_at}</p></td>
                                    <td class="listCnt"><p>${i.inquiry_status}</p></td>
                                </tr>
                            </table>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${i.member_id == loginInfo.id}">
                                <table class="wlBody">
                                    <tr>
                                        <td class="listNo"><a href="/inquiry/detail/${i.inquiry_id}">${i.inquiry_id}</a></td>
                                        <td class="listTit"><p>${i.inquiry_title}</p></td>
                                        <td class="listContent"><p>${i.inquiry_content}</p></td>
                                        <td class="listName"><p>${i.member_id}</p></td>
                                        <td class="listDate"><p>${i.inquiry_created_at}</p></td>
                                        <td class="listEditDate"><p>${i.inquiry_updated_at}</p></td>
                                        <td class="listCnt"><p>${i.inquiry_status}</p></td>
                                    </tr>
                                </table>
                                </c:when>
                                <c:otherwise>
                                    <table class="wlBody">
                                        <tr>
                                            <td class="listNo"><p>${i.inquiry_id}</p></td>
                                            <td class="listsecrete" colspan="6"><p>비밀글입니다.</p></td>
                                        </tr>
                                    </table>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </table>
<%--            <div class="pagingBox">--%>
<%--                <p>123456</p>--%>
<%--            </div>--%>
        </div>
    </div>
</div>
</body>
</html>
