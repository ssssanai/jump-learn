<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 4.
  Time: 01:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/study/studyPick.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb1.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
    <title>JL - 강좌 목록</title>
</head>
<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/memberGnb.jsp" %>
<div class="wrap">
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
    </div>
    <div class="main">
        <h2>찜 목록</h2>
        <form name="frm_search" id="frm_search" class="frm_search" method="get" action="/course/list">
            <select name="search_condition1" class="search_condition1">
                <option value="제목" >제목</option>
                <option value="강사" >강사</option>
            </select>
            <select name="search_condition2" class="search_condition2">
                <option value="none" >선택</option>
                <option value="고1" >고1</option>
                <option value="고2" >고2</option>
                <option value="고3" >고3</option>
                <option value="N수생" >N수생</option>
            </select>
            <select name="search_condition3" class="search_condition3">
                <option value="none" >선택</option>
                <option value="KOREAN" >국어</option>
                <option value="MATH" >수학</option>
                <option value="ENGLISH" >영어</option>
            </select>
            <input type="hidden" id="sort_condition" name="sort_condition" value=""/>
            <input type="text" name="search_word" id="search_word" class="search_word" placeholder="강좌명을 검색하세요." value=""/>
            <input type="submit" name="search_btn" id="search_btn" class="search_btn" value="검색"/>
        </form>
        <div id="course_list_container">
            <div class="chBtn">
                <button class="sort_condition" id="recently">최신순</button>
                <button class="sort_condition" id="lower_price">낮은 가격순</button>
                <button class="sort_condition" id="higher_price">높은 가격순</button>
            </div>
            <div id="course_list">
                <div class="course">
                    <div class="course_img">
                        <img src="#" style="width: 100%; height: 100%">
                    </div>
                    <div class="lb2">
                        <a href="" class="course_title">강의제목입니다</a>
                        <p class="course_introduce">강의 소개입니다</p>
                        <div class="course_info">
                            <p class="course_teacher">강사명 : </p>
                            <p class="course_category">과목 : </p>
                            <p class="course_target">학습 수준 : </p>
                        </div>
                    </div>
                    <div class="lb3">
                        <p class="course_price">23,000원</p>
                        <div class="buyBtn">
                            <%-- EL 작업할때 주석 풀어주세요! -->
                            <%-- <p href="#"><i class="fa-solid fa-check"></i></p>--%>
                            <a href="#">
                                <i class="fa-solid fa-cart-shopping"></i>
                            </a>
                        </div>
                    </div>
                </div>
                <%-- EL 작업할때 주석 풀어주세요! -->
                <%-- <div class="noDataPage">--%>
                    <%--<h2>강좌가 없습니다.</h2>--%>
                    <%--<img src="../../../resources/static/images/notDataImg.png" alt="강좌없을 시 이미지"/>--%>
                <%--</div>--%>
            </div>
            <div id="paging_block">
                <a href="/course/list?page_no=1
                    &search_condition1=${searchDTO.search_condition1}
                    &search_word=${searchDTO.search_word}
                    &search_condition2=${searchDTO.search_condition2}
                    &search_condition3=${searchDTO.search_condition3}
                    &sort_condition=${searchDTO.sort_condition}">
                    <<
                </a>
                <!-- 페이지 번호 -->
                <c:forEach begin="${startPage}" end="${endPage}" var="p">
                    <c:choose>
                        <c:when test="${p == searchDTO.page_no}">
                            <p class="pNum">${p}</p>
                        </c:when>
                        <c:otherwise>
                            <a href="/course/list?page_no=${p}
                                &search_condition1=${searchDTO.search_condition1}
                                &search_word=${searchDTO.search_word}
                                &search_condition2=${searchDTO.search_condition2}
                                &search_condition3=${searchDTO.search_condition3}
                                &sort_condition=${searchDTO.sort_condition}">
                                    ${p}
                            </a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <a href="/course/list?page_no=${total_page}
                    &search_condition1=${searchDTO.search_condition1}
                    &search_word=${searchDTO.search_word}
                    &search_condition2=${searchDTO.search_condition2}
                    &search_condition3=${searchDTO.search_condition3}
                    &sort_condition=${searchDTO.sort_condition}">
                    >>
                </a>
            </div>
        </div>
    </div>
</div>
<script>
    $('.sort_condition').on('click', function () {
        $('#sort_condition').val(this.id); // 정렬 조건 값을 클릭한 요소의 id로 설정
        $('#frm_search').submit();
    });
</script>
</body>
</html>
