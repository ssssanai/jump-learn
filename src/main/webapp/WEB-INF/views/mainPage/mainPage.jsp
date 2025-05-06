<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 4. 30.
  Time: 오후 5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../../resources/static/css/mainStyle.css" rel="stylesheet" type="text/css">
    <link href="../../../resources/static/css/headerStyle.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>JL - 메인화면</title>
</head>
<body>
<%@include file="../../../resources/static/html/memberGnb.jsp" %>
<div id="slider-wrapper">
    <div class="inner-wrapper">
        <input checked type="radio" name="slide" class="control" id="Slide1"/>
        <label for="Slide1" id="s1"></label>
        <input type="radio" name="slide" class="control" id="Slide2"/>
        <label for="Slide2" id="s2"></label>
        <input type="radio" name="slide" class="control" id="Slide3"/>
        <label for="Slide3" id="s3"></label>
        <div class="overflow-wrapper">
            <a class="slide" href="#"><img src="../../../resources/static/images/mainPage/slide01.jpg"
                                           alt="슬라이드 01"/></a>
            <a class="slide" href="#"><img src="../../../resources/static/images/mainPage/slide02.jpg"
                                           alt="슬라이드 02"/></a>
            <a class="slide" href="#"><img src="../../../resources/static/images/mainPage/slide03.jpg"
                                           alt="슬라이드 03"/></a>
        </div>
    </div>
</div>
<div class="main">
    <%-- TODO: 슬라이드 처리 --%>
    <c:forEach var="recClass" items="${recommendList}">
        <div class="buyStudy1">

            <div class="bsTitle">
                <h1>${recClass.title}</h1>
            </div>
            <div class="bsCont">
                <p>${recClass.introduce}</p>
            </div>
            <div class="bsBtn">
                <a href="#" class="buyLink">구매하기</a>
                <a href="#" class="review">강의후기</a>
            </div>

        </div>
        <div class="buyStudy2">
            <img src="../../../resources/static/images/mainPage/slide03.jpg" alt="홍보 이미지"/>
                ${recClass.file_name} ${recClass.file_ext}
        </div>
    </c:forEach>

    <c:choose>
        <c:when test="${loginInfo eq null}">
            <!-- 비로그인 시 -->
            <div class="loginBox1">
                <div class="loginHead">
                    <a href="member/login">로그인 하기</a>
                </div>
                    <%--                <div class="myPageBtn">--%>
                    <%--                    <a href="#">마이페이지</a>--%>
                    <%--                </div>--%>
                <div class="loginFoot">
                    <div class="registBtn">
                        <a href="member/register">회원가입</a>
                    </div>
                    <div class="foundPwd">
                        <a href="#">비밀번호 찾기</a>
                    </div>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <!-- 로그인 시 -->
            <div class="loginBox2">
                <div class="profile">
                    <div class="profileImg">
                            ${member.file_path} ${member.file_name} ${member.file_ext}
                    </div>
                    <div class="profileInfo">
                        <div class="infoHead">
                            <p>${member.name}님 어서오세요.</p>
                        </div>
                        <div class="infobody">
                            <p>오늘도 공부하는 당신에게 화이팅!</p>
                        </div>
                    </div>
                        <%-- TODO: 로그아웃 버튼 --%>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<%-- TODO: 슬라이드 처리 --%>
<article>
    <div class="gradCard">
        <c:forEach var="hs1Class" items="${hs1List}">
            <div class="gradeImg">

            </div>
            <div class="gradeCont">
                    ${hs1Class.title}
                <div class="gradeP">
                    <p>고등학교 1학년 강의</p>
                </div>
                <div class="gradeA">
                    <a href="#">바로가기</a>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="gradCard">
        <c:forEach var="hs2Class" items="${hs2List}">
            <div class="gradeImg">

            </div>
            <div class="gradeCont">
                    ${hs2Class.title}
                <div class="gradeP">
                    <p>고등학교 2학년 강의</p>
                </div>
                <div class="gradeA">
                    <a href="#">바로가기</a>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="gradCard">
        <c:forEach var="hs3Class" items="${hs3List}">
            <div class="gradeImg">

            </div>
            <div class="gradeCont">
                    ${hs3Class.title}
                <div class="gradeP">
                    <p>고등학교 3학년 강의</p>
                </div>
                <div class="gradeA">
                    <a href="#">바로가기</a>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="gradCard">
        <c:forEach var="rptClass" items="${repeaterList}">
            <div class="gradeImg">

            </div>
            <div class="gradeCont">
                    ${rptClass.title}
                <div class="gradeP">
                    <p>N수생 강의</p>
                </div>
                <div class="gradeA">
                    <a href="#">바로가기</a>
                </div>
            </div>
        </c:forEach>
    </div>
</article>

</body>
</html>
