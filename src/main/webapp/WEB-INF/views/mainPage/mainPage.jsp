<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 4. 30.
  Time: 오후 5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../../resources/static/css/mainStyle.css" rel="stylesheet" type="text/css">
    <link href="../../../resources/static/css/headerStyle.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>JL - 메인화면</title>
</head>
<body>
<div class="header">
    <div class="logo">
        <img src="../../../resources/static/images/registLogo2.svg" alt="로고"/>
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
<div id="slider-wrapper">
    <div class="inner-wrapper">
        <input checked type="radio" name="slide" class="control" id="Slide1" />
        <label for="Slide1" id="s1"></label>
        <input type="radio" name="slide" class="control" id="Slide2" />
        <label for="Slide2" id="s2"></label>
        <input type="radio" name="slide" class="control" id="Slide3" />
        <label for="Slide3" id="s3"></label>
        <div class="overflow-wrapper">
            <a class="slide" href="#"><img src="../../../resources/static/images/mainPage/slide01.jpg" alt="슬라이드 01" /></a>
            <a class="slide" href="#"><img src="../../../resources/static/images/mainPage/slide02.jpg" alt="슬라이드 02" /></a>
            <a class="slide" href="#"><img src="../../../resources/static/images/mainPage/slide03.jpg" alt="슬라이드 03" /></a>
        </div>
    </div>
</div>
<div class="main">
    <div class="buyStudy1">
        <div class="bsTitle">
            <h1>orem ipsum</h1>
        </div>
        <div class="bsCont">
            <p>대표적인 강의 이미지를 넣은 후 강의에 대한 소개글입니다.
                대표적인 강의 이미지를 넣은 후 강의에 대한 소개글입니다.
                대표적인 강의 이미지를 넣은 후 강의에 대한 소개글입니다.
                대표적인 강의 이미지를 넣은 후 강의에 대한 소개글입니다.
            </p>
        </div>
        <div class="bsBtn">
            <a href="#" class="buyLink">구매하기</a>
            <a href="#" class="review">강의후기</a>
        </div>
    </div>
    <div class="buyStudy2">
        <img src="../../../resources/static/images/mainPage/slide03.jpg" alt="홍보 이미지"/>
    </div>

    <!-- 비로그인 시 -->
    <div class="loginBox1">
        <div class="loginHead">
            <a href="#">로그인 하기</a>
        </div>
        <div class="myPageBtn">
            <a href="#">마이페이지</a>
        </div>
        <div class="loginFoot">
            <div class="registBtn">
                <a href="#">회원가입</a>
            </div>
            <div class="foundPwd">
                <a href="#">비밀번호 찾기</a>
            </div>
        </div>
    </div>

    <!-- 로그인 시 -->
    <div class="loginBox2">
        <div class="profile">
            <div class="profileImg">

            </div>
            <div class="profileInfo">
                <div class="infoHead">
                    <p>OOO님 어서오세요.</p>
                </div>
                <div class="infobody">
                    <p>오늘도 공부하는 당신에게 화이팅!</p>
                </div>
            </div>
        </div>
    </div>
</div>
<article>
    <div class="gradCard">
        <div class="gradeImg">

        </div>
        <div class="gradeCont">
            <div class="gradeP">
                <p>고등학교 1학년 강의</p>
            </div>
            <div class="gradeA">
                <a href="#">바로가기</a>
            </div>
        </div>
    </div>
    <div class="gradCard">
        <div class="gradeImg">

        </div>
        <div class="gradeCont">
            <div class="gradeP">
                <p>고등학교 2학년 강의</p>
            </div>
            <div class="gradeA">
                <a href="#">바로가기</a>
            </div>
        </div>
    </div>
    <div class="gradCard">
        <div class="gradeImg">

        </div>
        <div class="gradeCont">
            <div class="gradeP">
                <p>고등학교 3학년 강의</p>
            </div>
            <div class="gradeA">
                <a href="#">바로가기</a>
            </div>
        </div>
    </div>
    <div class="gradCard">
        <div class="gradeImg">

        </div>
        <div class="gradeCont">
            <div class="gradeP">
                <p>N수생 강의</p>
            </div>
            <div class="gradeA">
                <a href="#">바로가기</a>
            </div>
        </div>
    </div>
</article>

</body>
</html>
