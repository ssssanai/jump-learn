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
    <link href="../../../resources/static/css/member/myStudyRoom.css" rel="stylesheet" type="text/css">
    <link href="../../../resources/static/css/headerGnb2.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
    <title>JL - 나의 학습방</title>
</head>
<body>

<%--고정 헤더 파일--%>
<%@include file="../../../resources/static/html/headerGnb.jsp"%>

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
            <p onclick="menuDisplay(1)">나의 강의실</p>
            <p onclick="menuDisplay(2)">내가 작성한 글</p>
            <p onclick="menuDisplay(3)">내가 남긴 댓글</p>
            <p onclick="menuDisplay(4)">성적표 보기</p>
            <p onclick="menuDisplay(5)">학습계획표</p>
        </div>
    </div>
    <div class="main">
        <div id="cont1">
            <h2 class="ht">나의 강의실</h2>
            <div class="searchBox">
                <div class="btns">
                    <button name="search" class="searchBtn">최신순</button>
                    <button name="search" class="searchBtn">글자순</button>
                </div>
                <div class="searchBox2">
                    <input type="text" class="serchIn" placeholder="검색어를 입력해주세요.">
                    <input type="submit" class="serchBtn" name="serchBtn" value="검색">
                </div>
            </div>
            <div class="myStudyList1">
                <p class="studyNo">번호</p>
                <p class="studyCate">과목명</p>
                <p class="studyTit1">제목</p>
                <p class="studyTeach">강사명</p>
                <p class="studyRegDate">구매날짜</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">1</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">2</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">3</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">4</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">5</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">6</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">7</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">8</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">9</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">10</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">홍길동</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="pageBox">
                <p>< 1 2 3 4 5 ></p>
            </div>
        </div>
        <div id="cont2">
            <h2 class="ht">내가 작성한 글</h2>
            <div class="searchBox">
                <div class="btns">
                    <button name="search" class="searchBtn">최신순</button>
                    <button name="search" class="searchBtn">인기순</button>
                </div>
                <div class="searchBox2">
                    <input type="text" class="serchIn" placeholder="검색어를 입력해주세요.">
                    <input type="submit" class="serchBtn" name="serchBtn" value="검색">
                </div>
            </div>
            <div class="myStudyList1">
                <p class="studyNo">번호</p>
                <p class="studyCate">게시판</p>
                <p class="studyTit1">제목</p>
                <p class="studyTeach">조회수</p>
                <p class="studyRegDate">작성날짜</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">1</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">1232</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">2</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">12</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">3</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">32</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">4</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">21</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">5</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">234</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">6</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">323</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">7</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">35</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">8</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">12</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">9</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">23</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="studyNo">10</p>
                <p class="studyCate">국어</p>
                <a href="#" class="studyTit">강의 제목입니다.</a>
                <p class="studyTeach">22</p>
                <p class="studyRegDate">2025.01.03</p>
            </div>
            <div class="pageBox">
                <p>< 1 2 3 4 5 ></p>
            </div>
        </div>
        <div id="cont3">
            <h2 class="ht">내가 남긴 댓글</h2>
            <div class="searchBox">
                <div class="btns">
                    <button name="search" class="searchBtn">최신순</button>
                    <button name="search" class="searchBtn">글자순</button>
                </div>
                <div class="searchBox2">
                    <input type="text" class="serchIn" placeholder="검색어를 입력해주세요.">
                    <input type="submit" class="serchBtn" name="serchBtn" value="검색">
                </div>
            </div>
            <div class="myStudyList1">
                <p class="comuNo">번호</p>
                <p class="comuTit">게시글 제목</p>
                <p class="comuCont">내용</p>
                <p class="comuRegDate">작성날짜</p>
            </div>
            <div class="myStudyList2">
                <p class="comuNo">1</p>
                <p class="comuTit1">안녕하세요요</p>
                <p class="comuCont">반가워용용</p>
                <p class="comuRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="comuNo">1</p>
                <p class="comuTit1">안녕하세요요</p>
                <p class="comuCont">반가워용용</p>
                <p class="comuRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="comuNo">1</p>
                <p class="comuTit1">안녕하세요요</p>
                <p class="comuCont">반가워용용</p>
                <p class="comuRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="comuNo">1</p>
                <p class="comuTit1">안녕하세요요</p>
                <p class="comuCont">반가워용용</p>
                <p class="comuRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="comuNo">1</p>
                <p class="comuTit1">안녕하세요요</p>
                <p class="comuCont">반가워용용</p>
                <p class="comuRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="comuNo">1</p>
                <p class="comuTit1">안녕하세요요</p>
                <p class="comuCont">반가워용용</p>
                <p class="comuRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="comuNo">1</p>
                <p class="comuTit1">안녕하세요요</p>
                <p class="comuCont">반가워용용</p>
                <p class="comuRegDate">2025.01.03</p>
            </div>
            <div class="myStudyList2">
                <p class="comuNo">1</p>
                <p class="comuTit1">안녕하세요요</p>
                <p class="comuCont">반가워용용</p>
                <p class="comuRegDate">2025.01.03</p>
            </div>
            <div class="pageBox">
                <p>< 1 2 3 4 5 ></p>
            </div>
        </div>
        <div id="cont4">
            <h2 class="ht">성적표</h2>
            <div class="myStudyList1">
                <p class="sc1">번호</p>
                <p class="sc">과목</p>
                <p class="sc3">수강 점수</p>
                <p class="sc4">미수강 강의</p>
                <p class="sc5">시험 결과</p>
                <p class="sc6">총점</p>
            </div>
            <div class="myStudyList2">
                <p class="sc1">1</p>
                <p class="sc2">수학</p>
                <p class="sc3">54/60</p>
                <p class="sc4">16강,19강</p>
                <p class="sc5">32/40</p>
                <p class="sc6">86점</p>
            </div>
            <div class="myStudyList2">
                <p class="sc1">1</p>
                <p class="sc2">수학</p>
                <p class="sc3">54/60</p>
                <p class="sc4">16강,19강</p>
                <p class="sc5">32/40</p>
                <p class="sc6">86점</p>
            </div>
            <div class="myStudyList2">
                <p class="sc1">1</p>
                <p class="sc2">수학</p>
                <p class="sc3">54/60</p>
                <p class="sc4">16강,19강</p>
                <p class="sc5">32/40</p>
                <p class="sc6">86점</p>
            </div>
            <div class="myStudyList2">
                <p class="sc1">1</p>
                <p class="sc2">수학</p>
                <p class="sc3">54/60</p>
                <p class="sc4">16강,19강</p>
                <p class="sc5">32/40</p>
                <p class="sc6">86점</p>
            </div>
            <div class="myStudyList2">
                <p class="sc1">1</p>
                <p class="sc2">수학</p>
                <p class="sc3">54/60</p>
                <p class="sc4">16강,19강</p>
                <p class="sc5">32/40</p>
                <p class="sc6">86점</p>
            </div>
            <div class="pageBox">
                <p>< 1 2 3 4 5 ></p>
            </div>
        </div>
        <div id="cont5">
            <h2 class="ht">학습 계획표</h2>
            <div class="calHeader">

            </div>
            <div id="calendar">

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

    function generateCalendar() {
        var calendarContainer = document.getElementById("calendar");
        var currentDate = new Date();
        var year = currentDate.getFullYear();
        var month = currentDate.getMonth();
        var calendarHTML = `<h2>${year}년 ${month + 1}월</h2>`;

        calendarHTML += '<table>';
        calendarHTML += '<tr>';
        const daysOfWeek = ['일', '월', '화', '수', '목', '금', '토'];
        for (let day of daysOfWeek) {
            calendarHTML += `<th>${day}</th>`;
        }
        calendarHTML += '</tr>';

        // 각 주와 날짜 표시
        const totalDaysInMonth = new Date(year, month + 1, 0).getDate();
        const firstDayOfMonth = new Date(year, month, 1).getDay();

        let dayCounter = 1;

        for (let i = 0; i < 6; i++) {
            calendarHTML += '<tr>';

            for (let j = 0; j < 7; j++) {
                if (i === 0 && j < firstDayOfMonth) {
                    calendarHTML += '<td></td>';
                } else if (dayCounter > totalDaysInMonth) {
                    calendarHTML += '<td></td>';
                } else {
                    calendarHTML += `<td>${dayCounter}</td>`;
                    dayCounter++;
                }
            }

            calendarHTML += '</tr>';

            if (dayCounter > totalDaysInMonth) {
                break;
            }
        }

        calendarHTML += '</table>';
        calendarContainer.innerHTML = calendarHTML;
    }
    window.onload = function () {
        generateCalendar();
    };
</script>
</body>
</html>
