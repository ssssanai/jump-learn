<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 5. 4.
  Time: 오후 3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/teacher/teacherMyPage.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb3.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>JL - 강사 마이 페이지</title>
</head>
<body>

<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/tcheaderGnb.jsp"%>

<div class="wrap">
    <div class="main">
        <div class="userInfo">
            <div class="userInfoTit">
                <h2>기본정보</h2>
            </div>
            <div class="userInfoCont">
                <div class="userProfile">
                    <div class="radiusProfile2">
                        <img src="/resources/static/images/teacherPage/profileEx.jpg" alt="프로필 이미지">
                    </div>
                </div>
                <div class="userInfoP">
                    <table class="userTable">
                        <tr>
                            <td class="lfTd">아이디</td>
                            <td class="rtTd">test1234</td>
                        </tr>
                        <tr>
                            <td class="lfTd">이름</td>
                            <td class="rtTd">홍길동</td>
                        </tr>
                        <tr>
                            <td class="lfTd">생일</td>
                            <td class="rtTd">2005.01.03</td>
                        </tr>
                        <tr>
                            <td class="lfTd">이메일</td>
                            <td class="rtTd">test1234@naver.com</td>
                        </tr>
                        <tr>
                            <td class="lfTd">성별</td>
                            <td class="rtTd">남자</td>
                        </tr>
                        <tr>
                            <td class="lfTd">회원가입 날짜</td>
                            <td class="rtTd">2025.01.03</td>
                        </tr>
                    </table>
                    <div class="introduceBox">
                        <p class="lfTd2">자기소개</p>
                        <div class="rtTdBox">
                            <p class="rtTd2">1. 자기소개</p>
                            <p class="rtTd2">2. 자기소개</p>
                            <p class="rtTd2">3. 자기소개</p>
                        </div>
                    </div>
                    <div class="tbA">
                        <a href="#">강사정보수정</a>
                        <a href="#">비밀번호변경</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="todayBest">
            <div class="boardBox">
                <div class="boardTit">
                    <h2>강좌 목록</h2>
                </div>
                <div class="boardLine1">
                    <div class="tbH1">
                        <div class="tbImg"><p>사진</p></div>
                        <div class="tbTit">제목</div>
                        <div class="tbDate">개설날짜</div>
                        <div class="tbUserCnt">학생 수</div>
                        <div class="tbScore">평점</div>
                    </div>
                    <div class="tbB1">
                        <div class="tbImg">
                            <img src="/resources/static/images/teacherPage/profileEx.jpg" alt="썸네일">
                        </div>
                        <div class="tbTit"><a href="#">가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창</a></div>
                        <div class="tbDate">2025.01.03</div>
                        <div class="tbUserCnt"><a href="#">24명</a></div>
                        <div class="tbScore">4.5</div>
                    </div>
                    <div class="tbB1">
                        <div class="tbImg">
                            <img src="/resources/static/images/teacherPage/profileEx.jpg" alt="썸네일">
                        </div>
                        <div class="tbTit"><a href="#">가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창</a></div>
                        <div class="tbDate">2025.01.03</div>
                        <div class="tbUserCnt"><a href="#">24명</a></div>
                        <div class="tbScore">4.5</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
