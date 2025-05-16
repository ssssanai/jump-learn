<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-14
  Time: 오후 5:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
  <p>커뮤니티 게시물 수정</p>
</div>
<div class="wrap">
  <form id="frmWrite" name="frmWrite" action="/post/updatePost" method="post">
    <input type="hidden" name="id" id="id" value="${dto.post_id}"/>

    <!-- 제목 입력 -->
    <div class="boardTitle">
      <p>제목</p>
      <input type="text" name="title" id="title" value="${dto.post_title}" placeholder="글 제목을 입력해주세요.">
      <div id="titleError" class="error"></div>
    </div>

    <!-- 내용 입력 -->
    <div class="boardCont">
      <p>내용</p>
      <textarea name="content" id="post_content" placeholder="content값">${dto.post_content}</textarea>
      <div id="contentError" class="error"></div>
    </div>

    <!-- 버튼 영역 -->
    <div class="formBtn">
      <input class="endBtn" type="submit" value="등록">
      <input class="endBtn" type="reset" value="취소">
      <a href="/post/searchListPage"><input type="button" value="뒤로 가기"></a>
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