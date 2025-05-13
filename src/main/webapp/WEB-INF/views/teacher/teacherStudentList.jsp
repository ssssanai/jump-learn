<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 5. 4.
  Time: 오후 3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/teacher/teacherStudentList.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb3.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>JL - 강사 마이 페이지</title>
</head>
<body>

<%--고정 헤더 파일--%>
<%@include file="../../../resources/static/html/tcheaderGnb.jsp" %>

<div id="modal1">
    <div class="modalwrap">
        <div class="modalBox">
            <h2>중간고사 점수 입력</h2>
            <form method="post" action="/teacher/midterm_score">
                <input type="hidden" name="class_id" id="modal_class_id">
                <input type="hidden" name="enrollments_id" id="modal_enrollments_id">
                <input class="scoreInput" type="text" name="midterm_score" placeholder="점수를 입력해주세요.">
                <input class="submitBtn" type="submit" value="입력하기">
            </form>
            <a href="#">닫기</a>
        </div>
    </div>
</div>
<div id="modal2">
    <div class="modalwrap">
        <div class="modalBox">
            <h2>기말고사 점수 입력</h2>
            <form method="post" action="">
                <input class="scoreInput" type="text" placeholder="점수를 입력해주세요.">
                <input class="submitBtn" type="submit" value="입력하기">
            </form>
            <a href="#">닫기</a>
        </div>
    </div>
</div>
<div id="modal3">
    <div class="modalwrap">
        <div class="modalBox">
            <h2>마무리시험 점수 입력</h2>
            <form method="post" action="">
                <input class="scoreInput" type="text" placeholder="점수를 입력해주세요.">
                <input class="submitBtn" type="submit" value="입력하기">
            </form>
            <a href="#">닫기</a>
        </div>
    </div>
</div>
<div id="modal4">
    <div class="modalwrap">
        <div class="modalBox2">
            <h2>학생 평가 상세보기</h2>
            <p>별점 : 3/5점</p>
            <textarea placeholder="입력된 후기가 없습니다." readonly></textarea>
            <a href="#">닫기</a>
        </div>
    </div>
</div>
<div id="scoreEdit1">
    <div class="modalwrap">
        <div class="modalBox">
            <h2>중간고사 점수수정</h2>
            <form method="post" action="">
                <input class="scoreInput" type="text" placeholder="점수를 입력해주세요.">
                <input class="submitBtn" type="submit" value="입력하기">
            </form>
            <a href="#">닫기</a>
        </div>
    </div>
</div>
<div id="scoreEdit2">
    <div class="modalwrap">
        <div class="modalBox">
            <h2>기말고사 점수수정</h2>
            <form method="post" action="">
                <input class="scoreInput" type="text" placeholder="점수를 입력해주세요.">
                <input class="submitBtn" type="submit" value="입력하기">
            </form>
            <a href="#">닫기</a>
        </div>
    </div>
</div>
<div id="scoreEdit3">
    <div class="modalwrap">
        <div class="modalBox">
            <h2>종합 점수 수정</h2>
            <form method="post" action="">
                <input class="scoreInput" type="text" placeholder="점수를 입력해주세요.">
                <input class="submitBtn" type="submit" value="입력하기">
            </form>
            <a href="#">닫기</a>
        </div>
    </div>
</div>
<div class="wrap">
    <div class="main">
        <div class="todayBest">
                <div class="boardTit">
                    <h2>수강중인 학생</h2>
                </div>
                <div class="writeList">
                    <c:choose>
                        <c:when test="${not empty dtoList}">
                            <table class="wlHeader">
                                <tr>
                                    <th class="tbTit"><p>학생ID</p></th>
                                    <th class="tbTit"><p>중간고사</p></th>
                                    <th class="tbTit"><p>기말고사</p></th>
                                    <th class="tbTit"><p>총합 점수</p></th>
                                    <th class="tbScore"><p>수강시작일</p></th>
                                    <th class="tbScore"><p>학생평가</p></th>
                                </tr>
                            </table>
                            <c:forEach var="list" items="${dtoList}" varStatus="loop">
                                <table class="wlHeader">
                                    <tr>
                                        <td class="tbTit"><p>${list.member_id}</p></td>
                                        <td class="tbTit">
                                            <c:choose>
                                                <c:when test="${not empty list.midterm_score and list.midterm_score ne 0}">
                                                    <p>${list.midterm_score}</p>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="#" onclick="midterm_score_window('${list.id}','${class_id}')">점수 추가</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="tbTit">
                                            <c:choose>
                                                <c:when test="${not empty list.final_score and list.midterm_score ne 0}">
                                                    <p>${list.final_score}</p>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="#" onclick="final_score_window('${list.id}','${class_id}')">점수 추가</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="tbTit">
                                            <c:choose>
                                                <c:when test="${not empty list.final_grade_score and list.final_grade_score ne 0}">
                                                    <p>${list.final_grade_score}</p>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="#" onclick="final_grade_score_window('${list.id}','${class_id}')">점수 추가</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="tbScore">${list.pay_created_at.toString().substring(0,10)}</td>
                                        <td class="tbScore">
                                            <c:choose>
                                                <c:when test="${not empty list.feedback_score}">
                                                    <a href="#" onclick="review_window('${list.review}','${list.feedback_score}')">상세보기</a>
                                                </c:when>
                                                <c:otherwise>
                                                    후기 X
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                </table>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div>
                                수강하는 학생이 없습니다.
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</body>
<script>
    function midterm_score_window(enrollments_id, class_id) {
        const url = '/teacher/midterm_score_popup?id=' + enrollments_id + '&class_id=' + class_id;
        window.open(url, '_blank', 'width=400,height=300');
    }

    function final_score_window(enrollments_id, class_id) {
        const url = '/teacher/final_score_popup?id=' + enrollments_id + '&class_id=' + class_id;
        window.open(url, '_blank', 'width=400,height=300');
    }
    function final_grade_score_window(enrollments_id, class_id) {
        const url = '/teacher/final_grade_score_popup?id=' + enrollments_id + '&class_id=' + class_id;
        window.open(url, '_blank', 'width=400,height=300');
    }
    function review_window(review, feedback_score) {
        const popup = window.open('', '_blank', 'width=400,height=300');
        popup.document.write('<h2>리뷰 상세</h2>' +
            '<span>리뷰 점수 : </span>'+'<sapn>'+feedback_score+'</sapn>'+'<br/>'+
            '<span>리뷰  : </span>'+'<sapn>'+review+'</sapn>');
    }
</script>
</html>
