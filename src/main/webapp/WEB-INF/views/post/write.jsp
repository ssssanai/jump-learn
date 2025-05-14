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

    <link href="/resources/static/css/community/freeBoard/writePage.css" rel="stylesheet" type="text/css">
    <title>JL - 게시글 작성</title>
    <script src="https://kit.fontawesome.com/2d74121aef.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<div class="header">
    <img src="/resources/static/images/registLogo2.svg" alt="로고">
    <p>자유게시판 게시물 작성</p>
</div>
<div class="wrap">
    <form id="frmWrite" name="frmWrite" action="/post/write" method="post" enctype="multipart/form-data">
        <div class="boardTitle">
            <p>제목</p>
            <input type="text" name="title" id="title" placeholder="글 제목을 입력해주세요.">
            <div id="titleError" class="error"></div>
        </div>
        <div class="boardCont">
            <p>내용</p>
            <textarea name="content" id="content"  placeholder="글 내용"></textarea>
            <div id="contentError" class="error"></div>
        </div>
        <div class="boardImg">
            <p>이미지 첨부</p>
            <input type="file" id="file" name="file" multiple accept=".png, .jpg, .jpeg">>
            <div id="contentError1" class="error"></div>
        </div>
        <div class="formBtn">
            <input class="endBtn" type="submit" value="작성완료">
            <input class="endBtn" type="reset"  value="취소">
            <input class="endBtn" type="button" value="목록">
        </div>
    </form>
</div>
<script>
    const fileInput = document.getElementById('file');
    const errorDiv = document.getElementById('contentError1');

    fileInput.addEventListener('change', function () {
        const files = fileInput.files;

        if (files.length > 5) {
            errorDiv.textContent = "파일은 최대 5개까지 업로드할 수 있습니다.";
            fileInput.value = ""; // 선택된 파일 초기화
        } else {
            errorDiv.textContent = ""; // 에러 메시지 초기화
        }
    });
</script>
</body>
</html>