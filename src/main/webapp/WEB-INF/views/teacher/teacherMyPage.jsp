<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 5. 4.
  Time: 오후 3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/teacher/teacherMyPage.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb3.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>JL - 강사 마이 페이지</title>
</head>
<body>

<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/tcheaderGnb.jsp"%>

<div class="wrap">
    <div class="main">
        <div class="userInfo">
            <div class="userInfoTit">
                <h2>기본정보</h2>
            </div>
            <div class="userInfoCont">
                <div class="userProfile">
                    <div class="radiusProfile2">
                        <img src="/upload/${dto.file_name}" alt="기본 이미지" onerror="this.onerror=null; this.src='/resources/static/images/basic.jpg';">
                    </div>
                </div>
                <div class="userInfoP">
                    <table class="userTable">
                        <tr>
                            <td class="lfTd">아이디</td>
                            <td class="rtTd">${dto.id}</td>
                        </tr>
                        <tr>
                            <td class="lfTd">이름</td>
                            <td class="rtTd">${dto.name}</td>
                        </tr>
                        <tr>
                            <td class="lfTd">생일</td>
                            <td class="rtTd">${dto.birth}</td>
                        </tr>
                        <tr>
                            <td class="lfTd">이메일</td>
                            <td class="rtTd">${dto.email}</td>
                        </tr>
                        <tr>
                            <td class="lfTd">성별</td>
                            <td class="rtTd">${dto.gender}</td>
                        </tr>
                        <tr>
                            <td class="lfTd">회원가입 날짜</td>
                            <td class="rtTd">${dto.signup_date.toString().replace("T", " ")}</td>
                        </tr>
                    </table>
                    <div class="introduceBox">
                        <p class="lfTd2">자기소개</p>
                        <div class="rtTdBox">
                            <p class="rtTd2">
                                1. ${empty dto.introduce1 ? '정보 수정을 통해 자기소개서를 작성하세요' : dto.introduce1}
                            </p>
                            <p class="rtTd2">
                                2. ${empty dto.introduce2 ? '정보 수정을 통해 자기소개서를 작성하세요' : dto.introduce2}
                            </p>
                            <p class="rtTd2">
                                3. ${empty dto.introduce3 ? '정보 수정을 통해 자기소개서를 작성하세요' : dto.introduce3}
                            </p>
                        </div>
                    </div>
                    <div class="tbA">
                        <a href="/teacher/ChangeInfo?id=${dto.id}">강사정보수정</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="todayBest">
            <div class="boardBox">
                <div class="boardTit">
                    <h2>강좌 목록</h2>
                </div>
                <div class="writeList">
                    <table class="wlHeader">
                        <tr>
                            <th class="tbImg1"><p>사진</p></th>
                            <th class="tbTit"><p>제목</p></th>
                            <th class="tbDate"><p>개설날짜</p></th>
                            <th class="tbUserCnt"><p>학생 수</p></th>
                            <th class="tbScore"><p>평점</p></th>
                            <th class="tbScore"><p>QnA 답변</p></th>
                        </tr>
                    </table>
                    <table class="wlBody">
                        <c:choose>
                            <c:when test="${not empty dtoClass}">
                                <c:forEach var="list" items="${dtoClass}" varStatus="loop">
                                    <tr>
                                        <td class="tbImg">
                                            <img src="/upload/${list.file_name}" alt="기본 이미지" onerror="this.onerror=null;  this.src='/resources/static/images/img.png';">
                                        </td>
                                        <td class="tbTit"><a href="/teacher/class_detail?class_id=${list.class_id}">${list.title}</a></td>
                                        <td class="tbDate">${list.created_at}</td>
                                        <td class="tbUserCnt"><a href="/teacher/studentList?class_id=${list.class_id}">${list.pay_count}</a></td>
                                        <td class="tbScore">${list.feedback_avg}</td>
                                        <td class="tbScore"><a href="/teacher/questionList?class_id=${list.class_id}">확인하기</a></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <div>
                                    강좌 정보가 없습니다.
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
