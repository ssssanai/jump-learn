<%--
  Created by IntelliJ IDEA.
  User: lsm01
  Date: 25. 5. 4.
  Time: 오후 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/community/edu/eduListPage.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>Document</title>
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
                <li><a href="#">국어</a></li>
                <li><a href="#">수학</a></li>
                <li><a href="#" class="lsMenu">영어</a></li>
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
            <h2>자유게시판</h2>
            <p>회원간 자유로운 주제로 대화를 나누는 공간입니다.</p>
            <div class="wtBtn">
                <a href="/freeboard/write">글쓰기</a>
            </div>
        </div>
        <form class="searchInput" method="" action="">
            <div class="siReset">
                <input type="reset" value="검색조건 초기화">
            </div>

            <select id="selectOption" class="selectOption">
                <option value="qu0">전체</option>
                <option value="qu1">제목</option>
                <option value="qu2">내용</option>
            </select>
            <input type="text" class="serch_in" placeholder="검색어를 입력해주세요.">
            <input type="submit" class="serch_btn" name="serch_btn" value="검색">
        </form>

        
        <div class="writeList">
            <div class="wlHeader">
                <p class="listNo">번호</p>
                <p class="listTit">제목</p>
                <p class="listCont">내용</p>
                <p class="listName">작성자</p>
                <p class="listDate">작성일</p>
                <p class="listCnt">조회수</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
