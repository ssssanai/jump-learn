<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lsm01
  Date: 25. 5. 4.
  Time: 오후 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/calendar/calendarWrite.css" rel="stylesheet" type="text/css">
    <title>JL - 학습계획 작성</title>
    <script src="https://kit.fontawesome.com/2d74121aef.js" crossorigin="anonymous"></script>
    <script src="/resources/static/js/checkModule.js"></script>
</head>
<body>
<%@ include file="/resources/static/html/adminMsg.jsp" %>
<div class="header">
    <img src="/resources/static/images/registLogo2.svg" alt="로고">
    <p>${date.split("-")[0]}/${date.split("-")[1]}/${date.split("-")[2]} 학습계획 작성</p>
</div>
<div class="wrap">
    <form id="frmWrite" name="frmWrite" action="/plan/create" method="post">
        <input type="hidden" name="date" value="${date}"/>
        <div class="boardTitle">
            <p>제목</p>
            <input type="text" name="title" id="title" placeholder="글 제목을 입력해주세요.">
            <div id="titleError" class="error"></div>
        </div>
        <div class="boardCont">
            <p>내용</p>
            <textarea name="content" id="content" placeholder="학습계획 내용"></textarea>
            <div id="contentError" class="error"></div>
        </div>
        <div class="formBtn">
            <input class="endBtn" type="submit" value="작성완료">
            <input class="endBtn" type="reset" value="취소">
            <input class="endBtn" id="btnList" type="button" value="이전">
        </div>
    </form>
</div>
<script>
    document.getElementById('btnList').addEventListener('click', () => location.href = '/studyroom/plan')

    const writeForm = document.getElementById('frmWrite');
    const title = document.getElementById('title');
    const content = document.getElementById('content');

    const titleError = document.getElementById('titleError');
    const contentError = document.getElementById('contentError');

    writeForm.addEventListener('submit', function (e) {
        e.preventDefault();
        e.stopPropagation();

        resetErrors();
        let isValid = true;
        if (!validateTitleForm(title.value)) {
            isValid = false;
        }
        if (!validateContentForm(content.value)) {
            isValid = false;
        }

        // 모든 유효성 검사를 통과했을 때
        if (isValid) {
            writeForm.submit();
        }
    });

    // 모든 에러 메시지를 비우는 함수
    function resetErrors() {
        titleError.textContent = '';
        contentError.textContent = '';
    }

    // 제목
    function validateTitleForm(title) {
        const trimmedId = title.trim();
        if (trimmedId === '') {
            titleError.textContent = '제목을 입력해주세요.';
            return false;
        }

        if (trimmedId.length < 4 || trimmedId.length > 101) {
            titleError.textContent = '제목은 5자 이상 100자 이하여야 합니다.';
            return false;
        }

        if(!checkSQLInjection(title)){
            titleError.textContent = "--, $$, #, /*, ', \" 은 포함될 수 없습니다.";
            return false;
        }
        return true;
    }

    // 내용
    function validateContentForm(content) {
        const trimmedCont = content.trim();
        if (trimmedCont === '') {
            contentError.textContent = '내용을 입력해주세요.';
            return false;
        }

        if (trimmedCont.length < 10 || trimmedCont.length > 201) {
            contentError.textContent = '내용은 10자 이상 200자 이하여야 합니다.';
            return false;
        }

        if(!checkSQLInjection(content)){
            titleError.textContent = "--, $$, #, /*, ', \" 은 포함될 수 없습니다.";
            return false;
        }
        return true;
    }
</script>
</body>
</html>