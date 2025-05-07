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
    <title>JL - 게시글 작성</title>
    <script src="https://kit.fontawesome.com/2d74121aef.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="wrap">
    <header>
        <div class="head_img">
            <img src="/writer_page/img/header_logo.svg">
        </div>
        <div class="head_noti">
            <p>커뮤니티 게시물 작성</p>
        </div>
    </header>
    <form id="frmWrite" name="frmWrite" action="/edu/writePage" method="post">
    <main>
        <div class="boardTitle">
            <p>제목</p>
        </div>
        <div class="boardCate">
            <p>카테고리 선택</p>
        </div>
        <div class="boardCont">
            <p>내용</p>
        </div>
        <div class="boardImg">
            <p>이미지 첨부</p>
        </div>
        <div>
            <input type="text"  name="admin_id" id="admin_id" placeholder="admin_id값">
        </div>
        <div class="titleMain">
            <input type="text" name="title" id="title" placeholder="title값">
        </div>
        <div class="contentMain">
            <textarea name="content" id="content"  placeholder="content값"></textarea>
        </div>
        <div class="imgMain">
            <input type="file" id="file">
        </div>
        <input class="endBtn" type="submit" value="작성완료">
        <input class="endBtn" type="reset"  value="취소">
        <input class="endBtn" type="button" value="목록">
    </main>
    </form>
</div>
</body>
</html>