<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 4.
  Time: 01:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>강좌 목록</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <style>
        div {
            border: 1px solid black;
        }

        .container {
            width: 100%;
            height: 70%;
            display: flex;
            text-align: center;
        }

        .course_container {
            width: 70%;
            height: 100%;
            display: flex;
            flex-direction: column;
            text-align: center;
        }

        #course_list {
            height: 100%;
        }

        .course {
            padding: 50px;
        }

        .sort_condition {
            border: 1px solid red;
            padding: 15px;
        }

    </style>
</head>
<body>
<div class="header">
    <span>로고</span>
    <ul>
        <li>Lecture</li>
        <li>My Learning</li>
        <li>My Page</li>
        <li>QnA</li>
        <li>Community</li>
    </ul>
</div>
<h1>강좌 목록</h1>
<div class="container">
    <aside>
        <div id="member_info">
            <span id="member_img">${member.file_path} ${member.file_name} ${member.file_ext}</span>
            <span id="member_grade">${member.grade}</span>
            <span id="greeting">환영합니다 ${member.name} 님!</span>
        </div>
        <div id="cart">
            <div>장바구니</div>
            <div id="cart_list">
                <c:set var="total_price" value="0"/>
                <c:forEach items="${basketList}" var="b">
                    <div>
                        <span id="cart_course_title">${b.title}</span>
                        <span id="cart_course_introduce">${b.introduce}</span>
                        <span id="cart_course_teacher">${b.teacher}</span>
                        <span id="cart_course_price">${b.price}</span>
                        <button>X</button>
                        <c:set var="total_price" value="${total_price + b.price}"/>
                    </div>
                </c:forEach>
            </div>
            <div id="cart_price">
                <span>총 합계금액</span>
                <span id="total_price">${total_price} 원</span>
            </div>
            <div>
                <button id="purchase_btn">구매하기</button>
                <button id="wishlist_btn">찜 목록</button>
            </div>
        </div>
    </aside>
    <div class="course_container">
        <form name="frm_search" id="frm_search" method="get" action="/course/list">
            <select name="search_condition1">
                <option value="제목" <c:if test="${searchDTO.search_condition1 == '제목'}">selected</c:if>>제목</option>
                <option value="강사" <c:if test="${searchDTO.search_condition1 == '강사'}">selected</c:if>>강사</option>
            </select>
            <input type="text" name="search_word" id="search_word" <c:if test="${searchDTO.search_word != null and searchDTO.search_word != ''}">value="${searchDTO.search_word}"</c:if> />
            <input type="submit" name="search_btn" id="search_btn" value="검색"/>
            <select name="search_condition2">
                <option value="none" <c:if test="${searchDTO.search_condition2 == 'none'}">selected</c:if>>선택</option>
                <option value="고1" <c:if test="${searchDTO.search_condition2 == '고1'}">selected</c:if>>고1</option>
                <option value="고2" <c:if test="${searchDTO.search_condition2 == '고2'}">selected</c:if>>고2</option>
                <option value="고3" <c:if test="${searchDTO.search_condition2 == '고3'}">selected</c:if>>고3</option>
                <option value="N수생" <c:if test="${searchDTO.search_condition2 == 'N수생'}">selected</c:if>>N수생</option>
            </select>
            <select name="search_condition3">
                <option value="none" <c:if test="${searchDTO.search_condition3 == 'none'}">selected</c:if>>선택</option>
                <option value="KOREAN" <c:if test="${searchDTO.search_condition3 == 'KOREAN'}">selected</c:if>>국어</option>
                <option value="MATH" <c:if test="${searchDTO.search_condition3 == 'MATH'}">selected</c:if>>수학</option>
                <option value="ENGLISH" <c:if test="${searchDTO.search_condition3 == 'ENGLISH'}">selected</c:if>>영어</option>
            </select>
            <input type="hidden" id="sort_condition" name="sort_condition" value=""/>
        </form>
        <div id="course_list_container">
            <div>
                <span class="sort_condition" id="recently">최신순</span>
                <span class="sort_condition" id="lower_price">낮은 가격순</span>
                <span class="sort_condition" id="higher_price">높은 가격순</span>
            </div>
            <div id="course_list">
                <c:choose>
                    <c:when test="${not empty courseList }">
                        <c:forEach items="${courseList}" var="course">
                            <div class="course">
                                <%-- TODO: 디테일 페이지 링크 걸기 --%>
                                <a href="/course/detail/${course.id}">상세보기</a>
                                <span class="course_img">${course.file_path} ${course.file_name} ${course.file_ext}</span>
                                <span class="course_title">${course.title}</span>
                                <span class="course_introduce">${course.introduce}</span>
                                <span class="course_teacher">${course.name}</span>
                                <span class="course_category">${course.category}</span>
                                <span class="course_target">${course.target}</span>
                                <span class="course_price">${course.price}</span>
                                <button>찜</button>
                                <button>장바구니 담기</button>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        강좌 없음
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
                    첫 페이지
                </a>
                <!-- 페이지 번호 -->
                <c:forEach begin="${startPage}" end="${endPage}" var="p">
                    <c:choose>
                        <c:when test="${p == searchDTO.page_no}">
                            <strong>${p}</strong>
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
                    마지막 페이지
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
