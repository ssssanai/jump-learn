<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 7.
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/static/html/adminMsg.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/community/qna/writePage.css" rel="stylesheet" type="text/css">
    <title>QnA 작성 페이지</title>
    <script src="/resources/static/js/checkModule.js"></script>
    <script src="https://kit.fontawesome.com/2d74121aef.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="header">
    <img src="/resources/static/images/registLogo2.svg" alt="로고">
    <p>Q&A 작성</p>
</div>
<div class="wrap">
    <form name="frmInquiry" id="frmInquiry" action="/inquiry/write" method="post">
        <input type="hidden" name="member_id" value="${mDTO.id}" hidden/>
        <div class="boardTitle">
            <p>제목</p>
            <input type="text" id="title" name="inquiry_title" placeholder="글 제목을 입력해주세요."/>
            ${ dto.inquiry_title != null ? dto.inquiry_title : ""}
        </div>
        <div id="titleError" class="error"></div>
        <div class="boardCont">
            <p>내용</p>
            <textarea name="inquiry_content" id="content">
                ${ dto.inquiry_content != null ? dto.inquiry_content : ""}
            </textarea>
        </div>
        <div id="contentError" class="error"></div>
        <div class="boardImg">
            <p>공개여부</p>
            <label class='radioStyle'>
                <input type="radio" name="visibility" value="1" checked/>
                <span>공개</span>
            </label>
            <label class='radioStyle'>
                <input type="radio" name="visibility" value="0"/>
                <span>비공개</span>
            </label>
        </div>
        <div id="contentError1" class="error"></div>
        <div class="formBtn">
            <input class="endBtn" type="submit" id="btnSubmit" value="질문 등록"/>
            <input class="endBtn" type="reset" value="초기화"/>
            <input class="endBtn" type="button" value="목록으로" id="btnList">
        </div>
    </form>
</div>
<script>
    document.getElementById('btnList').addEventListener('click', () => location.href = '/inquiry/list');
    document.getElementById('btnSubmit').addEventListener('click', function (e) {
        e.preventDefault();
        e.stopPropagation();
        let title = document.getElementById('title');
        let content = document.getElementById('content');

        let isValid = true;

        if (!checkSQLInjection(title.value) || !(title.value.length <= 100 && title.value.length >= 5)) {
            alert("제목은 5자 이상 100자 이하여야 하며, ', \", $$, #, --, /* 는 포함할 수 없습니다.")
            title.value = '';
            title.focus();
            isValid = false;
        } else if (!checkSQLInjection(content.value) || !(content.value.length <= 1000 && content.value.length >= 10)) {
            alert("내용은 10자 이상 1000자 이하여야 하며, ', \", $$, #, --, /* 는 포함할 수 없습니다.")
            content.value = '';
            content.focus();
            isValid = false;
        }

        if (isValid) {
            document.getElementById('frmInquiry').submit();
        }
    })
</script>
</body>
</html>
