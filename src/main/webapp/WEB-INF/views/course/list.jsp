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
    <link href="../../../resources/static/css/study/studyBuyPage.css" rel="stylesheet" type="text/css">
    <link href="../../../resources/static/css/headerGnb1.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
    <title>JL - 강좌 목록</title>
</head>
<%--고정 헤더 파일--%>
<%@include file="../../../resources/static/html/headerGnb.jsp" %>
<div class="wrap">
    <div class="aside">
        <div class="myInfo">
            <div class="radiusProfile">
                <span>
                    ${member.file_path} ${member.file_name} ${member.file_ext}
                    <img src="../../../resources/static/images/notProfile.jpg" alt="프로필 이미지 없을시">
                </span>

            </div>
            <div class="myInfop">
                <p>회원등급 ${member.grade}</p>
                <h2>환영합니다 ${member.name}님!</h2>
            </div>
            <div class="logoutBtn">
                <a href="#">로그아웃</a>
                <a href="#">회원탈퇴</a>
            </div>
        </div>
        <div class="cartList">
            <div class="clTit">
                <h2>장바구니 목록</h2>
            </div>
            <c:set var="total_price" value="0"/>
            <div class="notBuy">
                <p>아직 강좌가 없습니다!</p>
            </div>
            <div class="buyy">
                <c:forEach items="${basketList}" var="b">
                    <div class="cart">
                        <div class="cartTit1">
                            <p id="cart_course_title">${b.title}</p>
                        </div>
                        <div class="cartTit2">
                            <p id="cart_course_teacher">${b.teacher}강사의</p>
                            <p id="cart_course_introduce">${b.introduce}</p>
                        </div>
                        <div class="cartInfo">
                            <p id="cart_course_price">${b.price}</p>
                            <button><a href="/basket/remove/${b.class_id}">X</a></button>
                            <c:set var="total_price" value="${total_price + b.price}"/>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="cartHap">
            <p class="hapP">총 합계금액</p>
            <p id="total_price">${total_price} 원</p>
        </div>
        <div class="cartBtn">
            <button id="purchase_btn">구매하기</button>
            <button id="wishlist_btn">찜 목록</button>
        </div>
    </div>
    <div class="main">
        <form name="frm_search" id="frm_search" class="frm_search" method="get" action="/course/list">
            <select name="search_condition1" class="search_condition1">
                <option value="제목" <c:if test="${searchDTO.search_condition1 == '제목'}">selected</c:if>>제목</option>
                <option value="강사" <c:if test="${searchDTO.search_condition1 == '강사'}">selected</c:if>>강사</option>
            </select>
            <select name="search_condition2" class="search_condition2">
                <option value="none" <c:if test="${searchDTO.search_condition2 == 'none'}">selected</c:if>>선택</option>
                <option value="고1" <c:if test="${searchDTO.search_condition2 == '고1'}">selected</c:if>>고1</option>
                <option value="고2" <c:if test="${searchDTO.search_condition2 == '고2'}">selected</c:if>>고2</option>
                <option value="고3" <c:if test="${searchDTO.search_condition2 == '고3'}">selected</c:if>>고3</option>
                <option value="N수생" <c:if test="${searchDTO.search_condition2 == 'N수생'}">selected</c:if>>N수생</option>
            </select>
            <select name="search_condition3" class="search_condition3">
                <option value="none" <c:if test="${searchDTO.search_condition3 == 'none'}">selected</c:if>>선택</option>
                <option value="KOREAN" <c:if test="${searchDTO.search_condition3 == 'KOREAN'}">selected</c:if>>국어
                </option>
                <option value="MATH" <c:if test="${searchDTO.search_condition3 == 'MATH'}">selected</c:if>>수학</option>
                <option value="ENGLISH" <c:if test="${searchDTO.search_condition3 == 'ENGLISH'}">selected</c:if>>영어
                </option>
            </select>
            <input type="hidden" id="sort_condition" name="sort_condition" value=""/>
            <input type="text" name="search_word" id="search_word" class="search_word" placeholder="강좌명을 검색하세요."
                   <c:if test="${searchDTO.search_word != null and searchDTO.search_word != ''}">value="${searchDTO.search_word}"</c:if> />
            <input type="submit" name="search_btn" id="search_btn" class="search_btn" value="검색"/>
        </form>
        <div id="course_list_container">
            <div class="chBtn">
                <button class="sort_condition" id="recently">최신순</button>
                <button class="sort_condition" id="lower_price">낮은 가격순</button>
                <button class="sort_condition" id="higher_price">높은 가격순</button>
            </div>
            <div id="course_list">
                <c:choose>
                    <c:when test="${not empty courseList }">
                        <c:forEach items="${courseList}" var="course">
                            <div class="course">
                                    <%-- TODO: 디테일 페이지 링크 걸기 --%>
                                <div class="course_img">
                                        ${course.file_path} ${course.file_name} ${course.file_ext}
                                </div>
                                <div class="course_body">
                                    <div class="course_cont">
                                        <a href="/course/detail/${course.id}" class="course_title">${course.title}</a>
                                        <p class="course_introduce">${course.introduce}</p>
                                    </div>
                                    <div class="course_info">
                                        <p class="course_teacher">강사명 : ${course.name}</p>
                                        <p class="course_category">과목 : ${course.category}</p>
                                        <p class="course_target">학습 수준 : ${course.target}</p>
                                    </div>
                                </div>
                                <div class="course_ls">
                                    <p class="course_price">가격 - ${course.price}원</p>
                                    <div class="course_btn">
                                        <button>찜</button>
                                        <c:if test="${exceptList.contains(course.id)}" var="contained">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32"
                                                 fill="#06C755" class="bi bi-bag-check" viewBox="0 0 24 8">
                                                <path fill-rule="evenodd"
                                                      d="M10.854 8.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L7.5 10.793l2.646-2.647a.5.5 0 0 1 .708 0"/>
                                                <path d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1m3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1z"/>
                                            </svg>
                                        </c:if>
                                        <c:if test="${not contained}">
                                            <button><a href="/basket/add/${course.id}">장바구니 담기</a></button>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <div class="noDataPage">
                            <h2>강좌가 없습니다. 으하하!</h2>
                            <img src="../../../resources/static/images/notDataImg.png" alt="강좌없을 시 이미지"/>
                        </div>
                    </c:otherwise>
                </c:choose>
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
