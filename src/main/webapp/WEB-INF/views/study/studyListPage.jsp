<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 5. 8.
  Time: 오후 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/study/studyListPage.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb2.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
    <title>JL - 강의 목록</title>
</head>
<body>

<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/memberGnb.jsp"%>

<div class="wrap" id="wrap">
    <div class="aside">
        <div class="myInfo1">
            <div class="myInfoHead1">
                <div class="myInfop">
                    <p>회원등급  ??</p>
                    <h2>환영합니다 OOO님!</h2>
                </div>
            </div>
            <div class="logoutBtn">
                <a href="#">로그아웃</a>
                <a href="#">회원탈퇴</a>
            </div>
            <div class="myInfoMenu">
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox"><i class="fa-solid fa-cart-shopping"></i></div>
                    </div>
                    <div class="infoMenuBody">
                        <a href="#" class="cnt1">장바구니</a>
                        <a href="#" class="cnt2">3</a>
                    </div>
                </div>
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox"><i class="fa-solid fa-bookmark"></i></div>
                    </div>
                    <div class="infoMenuBody">
                        <a href="#" class="cnt1">찜 목록</a>
                        <a href="#" class="cnt2">10</a>
                    </div>

                </div>
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox"><i class="fa-solid fa-credit-card"></i></div>
                    </div>
                    <div class="infoMenuBody">
                        <a href="#" class="noCnt">결제내역</a>
                    </div>

                </div>
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox"><i class="fa-solid fa-headset"></i></div>
                    </div>
                    <div class="infoMenuBody">
                        <a href="#" class="noCnt">1:1 문의</a>
                    </div>

                </div>
            </div>
        </div>
        <div id="sideMenu" class="sideMenu">
            <p onclick="menuDisplay(1)">국어</p>
            <p onclick="menuDisplay(2)">수학</p>
            <p onclick="menuDisplay(3)">영어</p>
        </div>
    </div>
    <div class="main">
        <div id="cont1">
            <h2 class="ht">국어</h2>
            <div class="searchBox">
                <div class="btns">
                    <button name="search" class="searchBtn">최신순</button>
                    <button name="search" class="searchBtn">가격순</button>
                </div>
                <div class="searchBox2">
                    <input type="text" class="serchIn" placeholder="검색어를 입력해주세요.">
                    <input type="submit" class="serchBtn" name="serchBtn" value="검색">
                </div>
            </div>
            <div class="myStudyList1">
                <p class="studyNo">번호</p>
                <p class="studyTit1">제목</p>
                <p class="studyTeach">강사명</p>
                <p class="studyPrice">가격</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">1</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyPrice">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">1</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyPrice">2025.01.03</p>
            </div>
            <div class="pageBox">
                <p>< 1 2 3 4 5 ></p>
            </div>
        </div>
        <div id="cont2">
            <h2 class="ht">수학</h2>
            <div class="searchBox">
                <div class="btns">
                    <button name="search" class="searchBtn">최신순</button>
                    <button name="search" class="searchBtn">가격순</button>
                </div>
                <div class="searchBox2">
                    <input type="text" class="serchIn" placeholder="검색어를 입력해주세요.">
                    <input type="submit" class="serchBtn" name="serchBtn" value="검색">
                </div>
            </div>
            <div class="myStudyList1">
                <p class="studyNo">번호</p>
                <p class="studyTit1">제목</p>
                <p class="studyTeach">강사명</p>
                <p class="studyPrice">가격</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">1</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyPrice">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">1</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyPrice">2025.01.03</p>
            </div>
            <div class="pageBox">
                <p>< 1 2 3 4 5 ></p>
            </div>
        </div>
        <div id="cont3">
            <h2 class="ht">영어</h2>
            <div class="searchBox">
                <div class="btns">
                    <button name="search" class="searchBtn">최신순</button>
                    <button name="search" class="searchBtn">가격순</button>
                </div>
                <div class="searchBox2">
                    <input type="text" class="serchIn" placeholder="검색어를 입력해주세요.">
                    <input type="submit" class="serchBtn" name="serchBtn" value="검색">
                </div>
            </div>
            <div class="myStudyList1">
                <p class="studyNo">번호</p>
                <p class="studyTit1">제목</p>
                <p class="studyTeach">강사명</p>
                <p class="studyPrice">가격</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">1</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyPrice">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">1</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyPrice">2025.01.03</p>
            </div>
            <div class="pageBox">
                <p>< 1 2 3 4 5 ></p>
            </div>
        </div>
    </div>
</div>
<script>
    function menuDisplay(num) {
        const contents = document.querySelectorAll('.main > div');

        contents.forEach(function(content) {
            content.style.display = 'none';
        });

        const selectedContentId = 'cont' + num;
        const selectedContent = document.getElementById(selectedContentId);

        if (selectedContent) {

            selectedContent.style.display = 'block';
        }
    }

    //기본 값은 나의 강의실
    document.addEventListener('DOMContentLoaded', function() {
        menuDisplay(1);
    });
</script>
</body>
</html>
