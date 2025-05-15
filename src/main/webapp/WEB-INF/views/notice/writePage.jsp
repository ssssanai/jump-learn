<%--
  Created by IntelliJ IDEA.
  User: lsm01
  Date: 25. 5. 4.
  Time: 오후 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/community/edu/eduWritePage.css" rel="stylesheet" type="text/css">
    <title>JL - 게시글 작성</title>
    <script src="https://kit.fontawesome.com/2d74121aef.js" crossorigin="anonymous"></script>
    <script src="/resources/static/js/checkModule.js"></script>
</head>
<body>
<div class="header">
    <img src="/resources/static/images/registLogo2.svg" alt="로고">
    <p>공지사항 게시물 작성</p>
</div>
<div class="wrap">
    <form id="frmWrite" name="frmWrite" action="/notice/writePage" method="post">
        <div class="boardTitle">
            <p>제목</p>
            <input type="text" name="title" id="title" placeholder="글 제목을 입력해주세요.">
            <div id="titleError" class="error"></div>
        </div>
        <div class="boardCont">
            <p>내용</p>
            <textarea name="content" id="content" placeholder="content값"></textarea>
            <div id="contentError" class="error"></div>
        </div>
        <div class="formBtn">
            <input class="endBtn" type="submit" value="등록">
            <input class="endBtn" type="reset" value="취소">
            <input class="endBtn" onclick="location.href = '/notice/searchListPage';" type="button" value="목록">
            <input type="hidden" name="admin_id" value="${adto.id}"/>
        </div>
    </form>
</div>
<script>
    const writeForm = document.getElementById('frmWrite');
    const titleForm = document.getElementById('title');
    const contentForm = document.getElementById('content');

    const titleError = document.getElementById('titleError');
    const contentError = document.getElementById('contentError');

    writeForm.addEventListener('submit', function (event) {
        event.preventDefault();

        resetErrors();

        let isValid = true;

        if (!validateTitleForm(titleForm.value)) {
            isValid = false;
        }
        if (!validateContentForm(contentForm.value)) {
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

        if (trimmedId.length < 1 || trimmedId.length >= 255) {
            titleError.textContent = '255자 미만이어야 합니다.';
            return false;
        }

        if (!checkSQLInjection(trimmedId)) {
            titleError.textContent = '--, $$, /*, \', ", # 은 포함할 수 없습니다.';
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

        if (trimmedCont.length < 1 || trimmedCont.length >= 500) {
            contentError.textContent = '500자 미만이어야 합니다.';
            return false;
        }

        if (!checkSQLInjection(trimmedCont)) {
            contentError.textContent = '--, $$, /*, \', ", # 은 포함할 수 없습니다.';
            return false;
        }
        return true;
    }
</script>
</body>
</html>