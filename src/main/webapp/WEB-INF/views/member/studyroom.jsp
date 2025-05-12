<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="/resources/static/css/member/myStudyRoom.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb2.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
    <script src="/resources/static/js/checkModule.js"></script>

    <title>JL - 나의 학습방</title>
</head>
<body>

<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/memberGnb.jsp" %>

<div class="wrap" id="wrap">
    <div class="aside">
        <div class="myInfo1">
            <div class="myInfoHead1">
                <div class="myInfop">
                    <p>회원등급 ${member.grade}</p>
                    <h2>환영합니다 ${member.name}님!</h2>
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
            <form id="frm_search_enroll" name="frmSearch" class="searchBox" method="get"
                  action="/mypage/studyroom/enroll">
                <input type="hidden" name="search_category" value="title"/>
                <input type="hidden" id="sort_order_enroll" name="sort_order" value=""/>
                <div class="btns">
                    <button name="search_order_recent" id="search_order_recent_enroll" class="searchBtn">최신순</button>
                    <button name="search_order_chars" id="search_order_chars_enroll" class="searchBtn">글자순</button>
                </div>
                <div class="searchBox2">
                    <input type="text" class="serchIn" id="search_word_enroll" name="search_word"
                           placeholder="검색어를 입력해주세요."
                           value="">
                    <input type="submit" class="serchBtn" id="btnSubmitEnroll" value="검색">
                </div>
            </form>
            <div class="myStudyList1">
                <p class="studyNo">번호</p>
                <p class="studyCate">과목명</p>
                <p class="studyTit1">제목</p>
                <p class="studyTeach">강사명</p>
                <p class="studyRegDate">구매날짜</p>
            </div>
            <c:choose>
                <c:when test="${EnrollDTOList.dtoList.size() > 0 }">
                    <c:forEach items="${EnrollDTOList.dtoList}" var="dto">
                        <div class="myStudyList2">
                            <p class="studyNo">${dto.id}</p>
                            <p class="studyCate">${dto.class_category}</p>
                            <a href="#" class="studyTit">${dto.class_title}</a>
                            <p class="studyTeach">${dto.teacher_name}</p>
                            <p class="studyRegDate">${dto.pay_created_at.toString().split("T")[0]}&nbsp;${dto.pay_created_at.toString().split("T")[1]}</p>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="myStudyList2">
                        수강중인 강좌가 없습니다.
                    </div>
                </c:otherwise>
            </c:choose>
            <div class="pageBox">
                <p>${EnrollPaging}</p>
            </div>
        </div>
        <div id="cont2">
            <h2 class="ht">내가 작성한 글</h2>
            <form id="frm_search_post" name="frmSearch" class="searchBox" method="get" action="/mypage/studyroom/post">
                <input type="hidden" name="search_category" value="title"/>
                <input type="hidden" id="sort_order_post" name="sort_order" value=""/>
                <div class="btns">
                    <button name="search_order_recent" id="search_order_recent_post" class="searchBtn">최신순</button>
                    <button name="search_order_popular" id="search_order_chars_post" class="searchBtn">인기순</button>
                </div>
                <div class="searchBox2">
                    <input type="text" class="serchIn" id="search_word_post" name="search_word"
                           placeholder="검색어를 입력해주세요."
                           value="">
                    <input type="submit" class="serchBtn" id="btnSubmitPost" value="검색">
                </div>
            </form>
            <div class="myStudyList1">
                <p class="studyNo">번호</p>
                <p class="studyCate">제목</p>
                <p class="studyTit1">내용</p>
                <p class="studyTeach">좋아요</p>
                <p class="studyTeach">조회수</p>
                <p class="studyRegDate">작성날짜</p>
            </div>
            <c:choose>
                <c:when test="${PostDTOList.dtoList.size() > 0 }">
                    <c:forEach items="${PostDTOList.dtoList}" var="dto">
                        <div class="myStudyList2">
                            <p class="studyNo">${dto.id}</p>
                            <p class="studyCate">${dto.title}</p>
                            <a href="#" class="studyTit">${dto.content}</a>
                            <p class="studyTeach">${dto.like_count}</p>
                            <p class="studyTeach">${dto.view_count}</p>
                            <p class="studyRegDate">${dto.created_at.toString().split("T")[0]}&nbsp;${dto.created_at.toString().split("T")[1]}</p>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="myStudyList2">
                        수강중인 강좌가 없습니다.
                    </div>
                </c:otherwise>
            </c:choose>
            <div class="pageBox">
                <p>${PostPaging}</p>
            </div>
        </div>
        <div id="cont3">
            <h2 class="ht">내가 남긴 댓글</h2>
            <form id="frm_search_enroll" name="frmSearch" class="searchBox" method="get"
                  action="/mypage/studyroom/comment">
                <input type="hidden" name="search_category" value="title"/>
                <input type="hidden" id="sort_order_comment" name="sort_order" value=""/>
                <div class="btns">
                    <button name="search_order_recent" id="search_order_recent_comment" class="searchBtn">최신순</button>
                    <button name="search_order_chars" id="search_order_chars_comment" class="searchBtn">글자순</button>
                </div>
                <div class="searchBox2">
                    <input type="text" class="serchIn" id="search_word_comment" name="search_word"
                           placeholder="검색어를 입력해주세요."
                           value="">
                    <input type="submit" class="serchBtn" id="btnSubmitComment" value="검색">
                </div>
            </form>
            <div class="myStudyList1">
                <p class="comuNo">번호</p>
                <p class="comuTit">게시글 제목</p>
                <p class="comuCont">내용</p>
                <p class="comuRegDate">작성날짜</p>
            </div>
            <c:choose>
                <c:when test="${PostCommentVOList.dtoList.size() > 0 }">
                    <c:forEach items="${PostCommentVOList.dtoList}" var="dto">
                        <div class="myStudyList2">
                            <p class="comuNo">${dto.id}</p>
                            <p class="comuTit1">${dto.post_id}</p>
                            <a href="#"
                               class="comuCont">${dto.content.length() >= 26 ? dto.content.substring(0, 30) + "..." : dto.content}</a>
                            <p class="comuRegDate">${dto.created_at.toString().split("T")[0]}&nbsp;${dto.created_at.toString().split("T")[1]}</p>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="myStudyList2">
                        수강중인 강좌가 없습니다.
                    </div>
                </c:otherwise>
            </c:choose>
            <div class="pageBox">
                <p>${PostCommentPaging}</p>
            </div>
        </div>
        <div id="cont4">
            <h2 class="ht">성적표</h2>
            <div class="myStudyList1">
                <p class="sc">번호</p>
                <p class="sc2">과목</p>
                <p class="sc5">강좌명</p>
                <p class="sc3">학습 진행률</p>
                <p class="sc2">중간고사 점수</p>
                <p class="sc2">기말고사 점수</p>
                <p class="sc2">최종 점수</p>
            </div>
            <c:choose>
                <c:when test="${GradeList.size() > 0}">
                    <c:forEach items="${GradeList}" var="g">
                        <div class="myStudyList2">
                            <p class="sc">${g.class_id}</p>
                            <p class="sc2">${g.class_category}</p>
                            <p class="sc5">${g.class_title}</p>
                            <p class="sc3">${g.progress}</p>
                            <p class="sc2">${g.midterm_score}</p>
                            <p class="sc2">${g.final_score}</p>
                            <p class="sc2">${g.final_grade_score}</p>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="myStudyList2">
                        수강한 강좌가 없습니다.
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
        <div id="cont5">
            <h2 class="ht">학습 계획표</h2>
            <div class="calendarBox">
                <div id="month"></div>
                <div id="calendar"></div>
            </div>
            <c:choose>
                <c:when test="${PlanList.size() > 0}">
                    <c:forEach items="${PlanList}" var="p">
                        <p>${p.id}</p>
                        <p>${p.member_id}</p>
                        <p>${p.title}</p>
                        <p>${p.description}</p>
                        <p>${p.study_date}</p>
                        <p>${p.created_at}</p>
                        <p>${p.updated_at}</p>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    등록된 계획이 없습니다.
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<script>
    function menuDisplay(num) {
        const contents = document.querySelectorAll('.main > div');

        contents.forEach(function (content) {
            content.style.display = 'none';
        });

        const selectedContentId = 'cont' + num;
        const selectedContent = document.getElementById(selectedContentId);

        if (selectedContent) {
            selectedContent.style.display = 'block';
        }
    }

    //기본 값은 나의 강의실
    document.addEventListener('DOMContentLoaded', function () {
        menuDisplay(1);
    });

    // Enroll 리스트
    document.getElementById('frm_search_enroll').addEventListener('submit', function (e) {
        e.preventDefault();
        e.stopPropagation();

        let search_word = document.getElementById('search_word_enroll');
        if (!checkSQLInjection(search_word.value)) {
            alert('포함할 수 없는 문자가 있습니다.');
            search_word.value = '';
        } else {
            document.getElementById('frm_search_enroll').submit();
        }
    });

    document.getElementById('frm_search_enroll').addEventListener('keydown', function (e) {
        if (e.code === "Enter") {
            e.preventDefault();
        }
    });

    document.getElementById('search_order_recent_enroll').addEventListener('click', function () {
        document.getElementById('sort_order_enroll').value = 'recent';
        document.getElementById('frm_search_enroll').submit();
    });


    document.getElementById('search_order_chars_enroll').addEventListener('click', function () {
        document.getElementById('sort_order_enroll').value = 'chars';
        document.getElementById('frm_search_enroll').submit();
    });

    // Post 리스트
    document.getElementById('frm_search_post').addEventListener('submit', function (e) {
        e.preventDefault();
        e.stopPropagation();

        let search_word = document.getElementById('search_word_post');
        if (!checkSQLInjection(search_word.value)) {
            alert('포함할 수 없는 문자가 있습니다.');
            search_word.value = '';
        } else {
            document.getElementById('frm_search_post').submit();
        }
    });

    document.getElementById('frm_search_post').addEventListener('keydown', function (e) {
        if (e.code === "Enter") {
            e.preventDefault();
        }
    });

    document.getElementById('search_order_recent_post').addEventListener('click', function () {
        document.getElementById('sort_order_post').value = 'recent';
        document.getElementById('frm_search_post').submit();
    });


    document.getElementById('search_order_popular_post').addEventListener('click', function () {
        document.getElementById('sort_order_post').value = 'popular';
        document.getElementById('frm_search_post').submit();
    });

    // Comment 리스트
    document.getElementById('frm_search_comment').addEventListener('submit', function (e) {
        e.preventDefault();
        e.stopPropagation();

        let search_word = document.getElementById('search_word_comment');
        if (!checkSQLInjection(search_word.value)) {
            alert('포함할 수 없는 문자가 있습니다.');
            search_word.value = '';
        } else {
            document.getElementById('frm_search_comment').submit();
        }
    });

    document.getElementById('frm_search_comment').addEventListener('keydown', function (e) {
        if (e.code === "Enter") {
            e.preventDefault();
        }
    });

    document.getElementById('search_order_recent_comment').addEventListener('click', function () {
        document.getElementById('sort_order_comment').value = 'recent';
        document.getElementById('frm_search_comment').submit();
    });


    document.getElementById('search_order_chars_comment').addEventListener('click', function () {
        document.getElementById('sort_order_comment').value = 'chars';
        document.getElementById('frm_search_comment').submit();
    });
</script>
<script src="/resources/static/js/calendar.js"></script>
<script>printMonth();</script>
</body>
</html>