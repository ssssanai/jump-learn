<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <title>JL - 결제내역</title>
</head>
<body>

<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/memberGnb.jsp" %>

<div class="wrap">
    <div class="buyHead">
        <h2>My Jump Learn</h2>
        <p>지금까지 구매한 강의 목록을 확인할 수 있어요.</p>
    </div>
    <h2 class="tit">구매목록</h2>
    <div class="searchBox">
        <%--        <form class="searchForm" action="" method="">--%>
        <%--            <input type=text name="" class="scInput" placeholder="구매한 강의를 검색할 수 있어요!">--%>
        <%--            <input type="submit" name="" class="scBtn" value="검색"/>--%>
        <%--        </form>--%>
        <div class="buyBtn">
            <a href="/course/list">장바구니 가기</a>
            <a href="#">찜 목록</a>
        </div>
    </div>
    <c:choose>
        <c:when test="${payList.size() > 0}">
            <c:forEach items="${payList}" var="p">
                <div class="buyList">
                    <div class="buyDate">
                        <c:if test="${p.pay_canceled_at != null}" var="isCanceled"><p>${p.pay_canceled_at.toString().split("T")[0]}&nbsp;${p.pay_canceled_at.toString().split("T")[1]} 취소</p></c:if>
                        <c:if test="${not isCanceled}"><p>${p.pay_created_at.toString().split("T")[0]}&nbsp;${p.pay_created_at.toString().split("T")[1]} 주문</p></c:if>
                        <a href="/course/detail/${p.class_id}">강의 상세보기 ></a>
                    </div>
                    <div class="buyMain">
                        <div class="buyCont">
                            <img src="../../../resources/static/images/notProfile.jpg" alt="강의 썸네일">
                                ${p.class_file_name}
                            <div class="bP">
                                <h2>${p.class_title}</h2>
                                <h3>${p.class_introduce}</h3>
                                <p>${p.pay_cost}원</p>
                            </div>
                        </div>
                        <div class="blBtn">
                            <c:if test="${p.pay_complete == 1}" var="isCompleted">
                                <div>
                                    구매 확정된 강좌
                                </div>
                            </c:if>
                            <c:if test="${not isCompleted}">
                                <a id="/pay/purchase_ok/${p.pay_id}" class="confirm">구매 확정</a>
                                <a href="/pay/refund/${p.class_id}">환불 요청</a>
                            </c:if>
                            <a href="#">후기 작성</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <div class="noBuyList">
                구매한 강의가 없습니다!
            </div>
        </c:otherwise>
    </c:choose>
</div>
<script>
    $('.confirm').on('click', function(e){
        if(confirm('구매를 확정하시겠습니까?')) {
            location.href = $(this).attr("id");
        }
    })
</script>
</body>
</html>
