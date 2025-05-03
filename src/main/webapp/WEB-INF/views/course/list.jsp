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
            width: 100%;
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
            <span id="member_img">img</span>
            <span id="member_grade">grade</span>
            <span id="greeting">환영합니다 name 님!</span>
        </div>
        <div id="cart">
            <div>장바구니</div>
            <div id="cart_list">
                <div>
                    <span id="cart_course_title">title</span>
                    <span id="cart_course_introduce">introduce</span>
                    <span id="cart_course_teacher">teacher</span>
                    <span id="cart_course_price">price</span>
                    <button>X</button>
                </div>
            </div>
            <div id="cart_price">
                <span>총 합계금액</span>
                <span id="total_price">total_price 원</span>
            </div>
            <div>
                <button id="purchase_btn">구매하기</button>
                <button id="wishlist_btn">찜 목록</button>
            </div>
        </div>
    </aside>
    <div class="course_container">
        <form name="frm_search" method="post" action="/course/list">
            <select name="search_condition1">
                <option>제목</option>
                <option>강사</option>
            </select>
            <input type="text" name="search_word" id="search_word"/>
            <input type="submit" name="search_btn" id="search_btn" value="검색"/>
            <select name="search_condition2">
                <option value="none">선택</option>
                <option value="고1">고1</option>
                <option value="고2">고2</option>
                <option value="고3">고3</option>
                <option value="N수생">N수생</option>
            </select>
            <select name="search_condition3">
                <option value="none">선택</option>
                <option value="KOREAN">국어</option>
                <option value="MATH">수학</option>
                <option value="ENGLISH">영어</option>
            </select>
            <input type="hidden" name="sort_condition" value=""/>
        </form>
        <div id="course_list_container">
            <div class="sort_condition">
                <span class="sort_condition" id="recently">최신순</span>
                <span class="sort_condition" id="lower_price">낮은 가격순</span>
                <span class="sort_condition" id="higher_price">높은 가격순</span>
            </div>
            <div id="course_list">
                <c:forEach items="${courseList}" var="course">
                    <div class="course">
                        <span class="course_img">${course.file_path} ${course.file_name} ${course.file_ext}</span>
                        <span class="course_title">${course.title}</span>
                        <span class="course_introduce">${course.introduce}</span>
                        <span class="course_category">${course.category}</span>
                        <span class="course_price">${course.price}</span>
                        <button>찜</button>
                        <button>장바구니 담기</button>
                    </div>
                </c:forEach>
            </div>
            <div id="paging_block"> < << paging block > >></div>
        </div>
    </div>
</div>

<script>

</script>
</body>
</html>
