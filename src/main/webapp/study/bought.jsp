<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 5. 8.
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/member/buyListPage.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb2.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
    <title>JL - 결제내역</title>
</head>
<body>

<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/headerGnb.jsp"%>

<div class="wrap">
    <div class="buyHead">
        <h2>My Jump Learn</h2>
        <p>지금까지 구매한 강의 목록을 확인할 수 있어요.</p>
    </div>
    <h2 class="tit">구매목록</h2>
    <div class="searchBox">
        <form class="searchForm" action="" method="">
            <input type=text name="" class="scInput" placeholder="구매한 강의를 검색할 수 있어요!">
            <input type="submit" name="" class="scBtn" value="검색"/>
        </form>
        <div class="buyBtn">
            <a href="#">장바구니 가기</a>
            <a href="#">찜 목록</a>
        </div>
    </div>
    <div class="buyList">
        <div class="buyDate">
            <p>2025.04.29 주문</p>
            <a href="#">강의 상세보기 ></a>
        </div>
        <div class="buyMain">
            <div class="buyCont">
                <img src="../../../resources/static/images/notProfile.jpg" alt="강의 썸네일">
                <div class="bP">
                    <h2>강의 제목입니다.</h2>
                    <h3>강의 내용이 들어갑니다.</h3>
                    <p>28,000원</p>
                </div>
            </div>
            <div class="blBtn">
                <a href="#">구매 확정</a>
                <a href="#">환불 요청</a>
                <a href="#">후기 작성</a>
            </div>
        </div>
    </div>
    <div class="noBuyList">
        구매한 강의가 없습니다!
    </div>
    <div class="footer">
        <a href="#">이전</a>
        <a href="#">다음</a>
    </div>
</div>
</body>
</html>
