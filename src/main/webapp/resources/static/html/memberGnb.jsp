<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 7.
  Time: 01:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
    <div class="logo">
        <img src="/resources/static/images/registLogo2.svg" alt="로고" onclick="location.href='/main'"/>
    </div>
    <%-- 로그인 상태 --%>
    <c:if test="${loginInfo ne null}" var="isLogin">
        <ul class="mainmenu">
            <li><a href="/course/list">강의</a></li>
            <li><a href="/studyroom/enroll">나의 학습방</a></li>
            <li><a href="/member/mypage">마이페이지</a></li>
            <li>
                <a href="/inquiry/list">문의하기</a>
                <ul class="submenu">
                    <li><a href="/inquiry/list" class="lsMenu">1:1 문의</a></li>
                </ul>
            </li>
            <li>
                <a href="/post/searchListPage">커뮤니티</a>
                <ul class="submenu">
                    <li><a href="/post/searchListPage">자유게시판</a></li>
                    <li><a href="/notice/searchListPage">공지사항 게시판</a></li>
                    <li><a href="/edu/searchListPage">교육정보 게시판</a></li>
                    <li><a href="/info/searchListPage">대입 정보 게시판</a></li>
                    <li><a href="/activity/searchListPage">대외활동 게시판</a></li>
                    <li><a href="/news/searchListPage">뉴스 게시판</a></li>
                    <li><a href="/lib/searchListPage" class="lsMenu">자료실 게시판</a></li>
                </ul>
            </li>
            <li>
                <a href="/member/logout">로그아웃</a>
            </li>
        </ul>
    </c:if>

    <%-- 비로그인 상태--%>
    <c:if test="${not isLogin}">
        <ul class="mainmenu">
            <li>
                <a href="/member/login">강의</a>
            </li>
            <li><a href="/member/login">나의 학습방</a></li>
            <li><a href="/member/login">마이페이지</a></li>
            <li>
                <a href="/member/login">문의하기</a>
                <ul class="submenu">
                    <li><a href="/member/login" class="lsMenu">1:1 문의</a></li>
                </ul>
            </li>
            <li>
                <a href="/member/login">커뮤니티</a>
                <ul class="submenu">
                    <li><a href="/member/login">자료실 게시판</a></li>
                    <li><a href="/member/login">교육정보 게시판</a></li>
                    <li><a href="/member/login">대입 정보 게시판</a></li>
                    <li><a href="/member/login">대외활동 게시판</a></li>
                    <li><a href="/member/login">뉴스 게시판</a></li>
                    <li>
                        <a href="/member/login">자유게시판</a>
                    </li>
                    <li><a href="/member/login" class="lsMenu">공지사항 게시판</a></li>
                </ul>
            </li>
        </ul>
    </c:if>
</div>