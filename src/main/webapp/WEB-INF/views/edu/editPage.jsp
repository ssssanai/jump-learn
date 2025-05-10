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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/community/edu/eduEditPage.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb1.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>검색 결과 리스트 페이지</title>
</head>
<body>
<%--고정 헤더 파일--%>
<%@include file="../../../resources/static/html/headerGnb.jsp"%>
<div class="wrap">
    <div class="aside">
        <div class="profile">
            <div class="myInfo">
                <p>회원등급  ??</p>
                <h2>환영합니다 OOO님!</h2>
            </div>
            <div class="logoutBtn">
                <a href="#">로그아웃</a>
                <a href="#">회원탈퇴</a>
            </div>
        </div>
        <div class="sideMenu">
            <h2 class="sideMenuTitle">커뮤니티</h2>
            <a href="#">자유게시판</a>
            <a href="#" class="select">교육 정보 게시판</a>
            <a href="#">대입 정보 게시판</a>
            <a href="#">대외활동 게시판</a>
            <a href="#">자료실 게시판</a>
            <a href="#">뉴스 게시판</a>
        </div>
    </div>
    <div class="main">
        <div class="writeTit">
            <h2>교육 정보 게시판</h2>
            <p>회원간 자유로운 주제로 대화를 나누는 게시판입니다.</p>
        </div>
        <div class="formBox">
            <form method="post" action="/edu/editPage" enctype="multipart/form-data">
                <div class="boardTitle">
                    <input type="text" name="title" id="title" value="${dto.title}"/>
                </div>
                <div class="formHead">
                    <div class="boardId">
                        <p>번호 : ${dto.id}</p>
                    </div>
                    <div class="boardUser">
                        <p>${dto.admin_id}</p>
                    </div>
                    <div class="boardRegDate">
                        <p>${dto.created_at}</p>
                    </div>
                    <div class="boardViewCnt">
                        <p>조회수 ${dto.view_count}회</p>
                    </div>
                </div>
                <div class="boardCont">
                    <textarea name="content" id="content" >${dto.content}</textarea>
                </div>
                <div class="boardFile">
                    <c:forEach var="file" items="${pdfFileDTO}" >
                        <a href="${file.file_path}" target="_blank">${file.file_name}${file.file_ext}</a>
                    </c:forEach>
                </div>
                <div class="boardImage">
                    <c:forEach var="file" items="${fileDTO}" >
                        <c:if test="${fn:contains(file.file_ext, '.jpg') or fn:contains(file.file_ext, '.jpeg')}">
                            <img src="${file.file_path}" alt="${file.file_name}"/>
                            <br>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="boardImg">
                    <p>이미지 첨부</p>
                    <input type="file" id="file">
                    <div id="contentError1" class="error"></div>
                </div>
                <div class="formBtn">
                    <input class="endBtn" type="submit" value="수정완료">
                    <input class="endBtn" type="reset"  value="취소">
                    <input class="endBtn" type="button" value="목록">
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    const writeForm = document.getElementById('frmWrite');
    const titleForm = document.getElementById('title');
    const contentForm = document.getElementById('content');

    const titleError = document.getElementById('titleError');
    const contentError = document.getElementById('contentError');

    function validateContentForm(value) {
        return false;
    }

    writeForm.addEventListener('submit', function(event) {
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
        return true;
    }
</script>
</body>
</html>