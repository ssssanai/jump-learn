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
    <link href="/resources/static/css/community/edu/eduViewPage.css" rel="stylesheet" type="text/css">
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
                    <p>${dto.title}</p>
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
                    <div class="boardImage">
                    <c:forEach var="file" items="${fileDTO}">
                                <c:if test="${fn:contains(fn:toLowerCase(file.fileExt), '.jpg')
                                                 or fn:contains(fn:toLowerCase(file.fileExt), '.jpeg')}">
                                    <img src="${file.filePath}/${file.fileName}${file.fileExt}"
                                         alt="${file.fileName}${file.fileExt}" /><br/>
                                </c:if>
                        </c:forEach>
                    </div>
                    <p>${dto.content}</p>
                </div>
                <div class="boardFile">
                    <c:forEach var="pdfFile" items="${pdfFileDTO}">
                        <a href="${pdfFile.filePath}/${pdfFile.fileName}${pdfFile.fileExt}" target="_blank">
                                ${pdfFile.fileName}${pdfFile.fileExt}</a>
                        <br>
                    </c:forEach>
                </div>
                <div class="formBtn">
                    <input class="endBtn" type="button" value="목록" onClick="location.href='<c:url value='/edu/searchListPage?${pageDTO.linkParams}'/>'" />

                    <c:if test="${isAdmin}">
                        <input class="endBtn" type="button" value="수정" onClick="location.href='<c:url value='/edu/editPage?id=${dto.id}&${pageDTO.linkParams}'/>'" />
                        <input class="endBtn" type="button" value="삭제" onClick="if (confirm('${dto.title} 글을 삭제하시겠습니까?')) {location.href='<c:url value='/edu/delete'/>?id=${dto.id}&${pageDTO.linkParams}';}" />
                    </c:if>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>