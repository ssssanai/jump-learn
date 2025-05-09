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
        <img src="/resources/static/images/registLogo2.svg" alt="로고"/>
    </div>
    <%-- 로그인 상태 --%>
    <c:if test="${loginInfo ne null}" var="isLogin">
        <ul class="mainmenu">
            <li>
                <a href="/course/list">강의</a>
                <ul class="submenu">
                    <li><a href="/course/list?search_condition3=KOREAN">국어</a></li>
                    <li><a href="/course/list?search_condition3=MATH">수학</a></li>
                    <li><a href="/course/list?search_condition3=ENGLISH" class="lsMenu">영어</a></li>
                </ul>
            </li>
            <li><a href="#">나의 학습방</a></li>
            <li><a href="#">마이페이지</a></li>
            <li>
                <a href="/inquiry/list">문의하기</a>
                <ul class="submenu">
                    <li><a href="/inquiry/list">1:1 문의</a></li>
                    <li><a href="#" class="lsMenu">자주묻는질문</a></li>
                </ul>
            </li>
            <li>
                <a href="#">커뮤니티</a>
                <ul class="submenu">
                    <li><a href="#">자료실 게시판</a></li>
                    <li><a href="#">교육정보 게시판</a></li>
                    <li><a href="#">대입 정보 게시판</a></li>
                    <li><a href="#">대외활동 게시판</a></li>
                    <li><a href="#">뉴스 게시판</a></li>
                    <li><a href="#" class="lsMenu">공지사항 게시판</a></li>
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
                <ul class="submenu">
                    <li><a href="/member/login">국어</a></li>
                    <li><a href="/member/login">수학</a></li>
                    <li><a href="/member/login" class="lsMenu">영어</a></li>
                </ul>
            </li>
            <li><a href="/member/login">나의 학습방</a></li>
            <li><a href="/member/login">마이페이지</a></li>
            <li>
                <a href="/member/login">문의하기</a>
                <ul class="submenu">
                    <li><a href="/member/login">1:1 문의</a></li>
                    <li><a href="/member/login" class="lsMenu">자주묻는질문</a></li>
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
                    <li><a href="/member/login" class="lsMenu">공지사항 게시판</a></li>
                </ul>
            </li>
        </ul>
    </c:if>
</div>