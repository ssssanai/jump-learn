<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 5. 4.
  Time: 오후 3:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../resources/static/css/teacher/teacherDetailPage.css" rel="stylesheet" type="text/css">
    <link href="../resources/static/css/headerGnb2.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
    <title>JL - 선생님 정보</title>
</head>
<body>
<!--모달 팝업-->
<div id="modal">
    <div class="modalPopup">
        <h3>홍길동 선생님 프로필</h3>
        <div class="mpCont">
            <div class="mc">
                <p class="leftp">이름</p>
                <p class="rightp">홍길동</p>
            </div>
            <div class="mc">
                <p class="leftp">이메일</p>
                <p class="rightp">test1234@gmail.com</p>
            </div>
            <div class="mc">
                <p class="leftp">전화번호</p>
                <p class="rightp">010-1234-1234</p>
            </div>
            <div class="mc">
                <p class="leftp">담당 과목</p>
                <p class="rightp">국어</p>
            </div>
        </div>
        <a href="#">닫기</a>
    </div>
</div>

<%--고정 헤더 파일--%>
<%@include file="../resources/static/html/headerGnb.jsp"%>

<div class="wrap">
    <div class="tcBar">
        <div class="dp">
            <p>강사 한 줄 소개</p>
            <h1>홍길동 선생님</h1>
        </div>
        <div class="tcMo">
            <a href="#modal">프로필</a>
        </div>
    </div>
    <div class="review">
        <h2>강의 후기</h2>
        <a class="cumu" href="#">
            <i class="fa-solid fa-plus"></i>
        </a>
        <table>
            <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>등록일</th>
                <th>조회수</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td><a href="#">김철수</a></td>
                <td>2025.01.03</td>
                <td>123</td>
            </tr>
            <tr>
                <td>2</td>
                <td><a href="#">김백수</a></td>
                <td>2025.01.03</td>
                <td>123</td>
            </tr>
            <tr>
                <td>3</td>
                <td><a href="#">홍길동</a></td>
                <td>2025.01.03</td>
                <td>123</td>
            </tr>
            <tr>
                <td>4</td>
                <td><a href="#">아무개</a></td>
                <td>2025.01.03</td>
                <td>123</td>
            </tr>
            <tr>
                <td>5</td>
                <td><a href="#">덩구다</a></td>
                <td>2025.01.03</td>
                <td>123</td>
            </tr>
            <tr>
                <td>6</td>
                <td><a href="#">덩구다</a></td>
                <td>2025.01.03</td>
                <td>123</td>
            </tr>
            <tr>
                <td>7</td>
                <td><a href="#">덩구다</a></td>
                <td>2025.01.03</td>
                <td>123</td>
            </tr>
            <tr>
                <td>8</td>
                <td><a href="#">덩구다</a></td>
                <td>2025.01.03</td>
                <td>123</td>
            </tr>
            <tr>
                <td>9</td>
                <td><a href="#">덩구다</a></td>
                <td>2025.01.03</td>
                <td>123</td>
            </tr>
            <tr>
                <td>10</td>
                <td><a href="#">덩구다</a></td>
                <td>2025.01.03</td>
                <td>123</td>
            </tr>
            </tbody>
        </table>
        <a class="cumu2" href="#">후기작성</a>
    </div>
    <div class="tcStudyList">
        <h2>운영중인 강의</h2>
        <form class="searchBox" action="" method="">
            <label class="chkStyle">
                <input type="checkbox" name="search">
                <span>최신순</span>
            </label>
            <label class="chkStyle">
                <input type="checkbox" name="search">
                <span>가격순</span>
            </label>
            <div class="searchBox2">
                <input type="text" class="serchIn" placeholder="검색어를 입력해주세요.">
                <input type="submit" class="serchBtn" name="serchBtn" value="검색">
            </div>
        </form>
        <div class="tcb">
            <div class="tcBox">
                <div class="lb1">
                    <p>홍길동</p>
                </div>
                <div class="lb2">
                    <a href="#">강의 제목입니다.</a>
                    <p class="cal1">강의 간단한 설명입니다.</p>
                    <p  class="cal2">2024.01.03</p>
                </div>
                <div class="lb3">
                    <p>32,000원</p>
                    <div class="buyBtn">
                        <a href="#">
                            <i class="fa-solid fa-heart"></i>
                        </a>
                        <a href="#">
                            <i class="fa-solid fa-cart-shopping"></i>
                        </a>
                    </div>
                </div>
            </div>
            <div class="tcBox">
                <div class="lb1">
                    <p>홍길동</p>
                </div>
                <div class="lb2">
                    <a href="#">강의 제목입니다.</a>
                    <p class="cal1">강의 간단한 설명입니다.</p>
                    <p  class="cal2">2024.01.03</p>
                </div>
                <div class="lb3">
                    <p>32,000원</p>
                    <div class="buyBtn">
                        <a href="#">
                            <i class="fa-solid fa-heart"></i>
                        </a>
                        <a href="#">
                            <i class="fa-solid fa-cart-shopping"></i>
                        </a>
                    </div>
                </div>
            </div>
            <div class="tcBox">
                <div class="lb1">
                    <p>홍길동</p>
                </div>
                <div class="lb2">
                    <a href="#">강의 제목입니다.</a>
                    <p class="cal1">강의 간단한 설명입니다.</p>
                    <p  class="cal2">2024.01.03</p>
                </div>
                <div class="lb3">
                    <p>32,000원</p>
                    <div class="buyBtn">
                        <a href="#">
                            <i class="fa-solid fa-heart"></i>
                        </a>
                        <a href="#">
                            <i class="fa-solid fa-cart-shopping"></i>
                        </a>
                    </div>
                </div>
            </div>
            <div class="tcBox">
                <div class="lb1">
                    <p>홍길동</p>
                </div>
                <div class="lb2">
                    <a href="#">강의 제목입니다.</a>
                    <p class="cal1">강의 간단한 설명입니다.</p>
                    <p  class="cal2">2024.01.03</p>
                </div>
                <div class="lb3">
                    <p>32,000원</p>
                    <div class="buyBtn">
                        <a href="#">
                            <i class="fa-solid fa-heart"></i>
                        </a>
                        <a href="#">
                            <i class="fa-solid fa-cart-shopping"></i>
                        </a>
                    </div>
                </div>
            </div>
            <div class="tcBox">
                <div class="lb1">
                    <p>홍길동</p>
                </div>
                <div class="lb2">
                    <a href="#">강의 제목입니다.</a>
                    <p class="cal1">강의 간단한 설명입니다.</p>
                    <p  class="cal2">2024.01.03</p>
                </div>
                <div class="lb3">
                    <p>32,000원</p>
                    <div class="buyBtn">
                        <a href="#">
                            <i class="fa-solid fa-heart"></i>
                        </a>
                        <a href="#">
                            <i class="fa-solid fa-cart-shopping"></i>
                        </a>
                    </div>
                </div>
            </div>
            <div class="tcBox">
                <div class="lb1">
                    <p>홍길동</p>
                </div>
                <div class="lb2">
                    <a href="#">강의 제목입니다.</a>
                    <p class="cal1">강의 간단한 설명입니다.</p>
                    <p  class="cal2">2024.01.03</p>
                </div>
                <div class="lb3">
                    <p>32,000원</p>
                    <div class="buyBtn">
                        <a href="#">
                            <i class="fa-solid fa-heart"></i>
                        </a>
                        <a href="#">
                            <i class="fa-solid fa-cart-shopping"></i>
                        </a>
                    </div>
                </div>
            </div>
            <div class="tcBox">
                <div class="lb1">
                    <p>홍길동</p>
                </div>
                <div class="lb2">
                    <a href="#">강의 제목입니다.</a>
                    <p class="cal1">강의 간단한 설명입니다.</p>
                    <p  class="cal2">2024.01.03</p>
                </div>
                <div class="lb3">
                    <p>32,000원</p>
                    <div class="buyBtn">
                        <a href="#">
                            <i class="fa-solid fa-heart"></i>
                        </a>
                        <a href="#">
                            <i class="fa-solid fa-cart-shopping"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
