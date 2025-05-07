<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 5. 4.
  Time: 오후 4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../resources/static/css/study/studyDetailPage.css" rel="stylesheet" type="text/css">
    <link href="../resources/static/css/headerGnb2.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
    <title>JL - 선생님 정보</title>
</head>
<body>

<%--고정 헤더 파일--%>
<%@include file="../resources/static/html/headerGnb.jsp"%>

<div class="wrap">
    <div class="studyTit">
        <h1>강의명 입니다.</h1>
    </div>
    <div class="studyBox1">
        <div class="study1">
            <div class="sbH1">
                <a href="#">강사 : 홍길동</a>
                <p>학습수준 : 고2</p>
                <p>과목 : 국어</p>
                <p>학습시간 : 12시간</p>
            </div>
            <div class="sbB1">
                <img src="../resources/static/images/memberPage/slide01.jpg" alt="강의 사진">
            </div>
        </div>
        <div class="study2">
            <div class="sbH2">
                <h2>강의명 입니다.</h2>
            </div>
            <div class="sbB2">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                    Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est
                    lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa.
                    Commodo odio aenean sed adipiscing
                    diam donec adipiscing tristique. Mi eget mauris pharetra et.</p>
            </div>
            <div class="price">
                <p class="priCnt1" style="font-size: 13px; line-height: 28px;">총 강의 가격</p>
                <p class="priCnt2" style="font-size: 17px; line-height: 28px;">32,000</p>
                <p class="priCnt3" style="font-size: 13px; line-height: 28px;">원</p>
            </div>
            <div class="buyBtn">
                <a href="#">구매하기</a>
                <a href="#">찜 하기</a>
            </div>
        </div>
    </div>
    <div class="studyBox2">
        <div class="studyDetail">
            <div class="sbH3">
                <h2>선생님을 소개합니다!</h2>
                <p>여러분들의 학습을 도와주실 선생님입니다.</p>
            </div>
            <div class="sbB3">
                <div class="teacherPro">
                    <img src="../resources/static/images/memberPage/profileEx.jpg">
                </div>
                <div class="teacherIn">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                        sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                        Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est
                        lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa.
                        Commodo odio aenean sed adipiscing </p>
                </div>
                <div class="tBtn">
                    <a htef="#">수강후기</a>
                    <a htef="#">강사 정보 </a>
                    <a htef="#">질문하기</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
