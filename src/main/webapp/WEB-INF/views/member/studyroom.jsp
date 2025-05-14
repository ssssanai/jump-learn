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
<%@ include file="/resources/static/html/adminMsg.jsp" %>
<div class="wrap" id="wrap">
    <div class="aside">
        <div class="myInfo1">
            <div class="myInfoHead1">
                <div class="myInfop">
                    <p>회원등급 ${member.grade}</p>
                    <h2>환영합니다 ${member.name}님!</h2>
                </div>
            </div>
            <div class="myInfoMenu">
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox">
                            <a href="/course/list" class="cnt1">
                                <i class="fa-solid fa-cart-shopping"></i>
                            </a>
                        </div>
                    </div>
                    <div class="infoMenuBody">
                        <p>장바구니</p>
                    </div>
                </div>
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox">
                            <a href="#" class="cnt1">
                                <i class="fa-solid fa-bookmark"></i>
                            </a>
                        </div>
                    </div>
                    <div class="infoMenuBody">
                        찜 목록
                    </div>

                </div>
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox">
                            <a href="/pay/list" class="cnt1">
                                <i class="fa-solid fa-credit-card"></i>
                            </a>
                        </div>
                    </div>
                    <div class="infoMenuBody">
                        결제내역
                    </div>
                </div>
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox">
                            <a href="/inquiry/list" class="cnt1">
                                <i class="fa-solid fa-headset"></i>
                            </a>
                        </div>
                    </div>
                    <div class="infoMenuBody">
                        1:1 문의
                    </div>

                </div>
            </div>
        </div>
        <div id="sideMenu" class="sideMenu">
            <a href="/studyroom/enroll">나의 강의실</a>
            <a href="/studyroom/post">내가 작성한 글</a>
            <a href="/studyroom/comment">내가 남긴 댓글</a>
            <a href="/studyroom/score">성적표 보기</a>
            <a href="/studyroom/plan">학습계획표</a>
        </div>
    </div>
    <div class="main">
        <c:if test="${EnrollDTOList != null}">
            <%@include file="./cont1.jsp" %>
        </c:if>
        <c:if test="${PostDTOList != null}">
            <%@include file="./cont2.jsp" %>
        </c:if>
        <c:if test="${PostCommentVOList != null}">
            <%@include file="./cont3.jsp" %>
        </c:if>
        <c:if test="${GradeList != null}">
            <%@include file="./cont4.jsp" %>
        </c:if>
        <c:if test="${PlanList != null}">
            <%@include file="./cont5.jsp" %>
        </c:if>
    </div>
</div>
</body>
</html>