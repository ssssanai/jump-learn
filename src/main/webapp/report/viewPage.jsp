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
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/report/viewPage.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb2.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>글 상세보기</title>
</head>
<body>
<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/memberGnb.jsp"%>
<%@ include file="/resources/static/html/adminMsg.jsp"%>
<div class="wrap">
    <div class="aside">
        <div class="profile">
            <div class="myInfo">
                <p>회원등급  ${loginInfo.status}</p>
                <h2>환영합니다 ${loginInfo.name}님!</h2>
            </div>
        </div>
        <div class="sideMenu">
            <h2 class="sideMenuTitle">커뮤니티</h2>
            <a href="/post/searchListPage" class="select">자유게시판</a>
            <a href="/notice/searchListPage" >공지사항 게시판</a>
            <a href="/edu/searchListPage">교육 정보 게시판</a>
            <a href="/info/searchListPage">대입 정보 게시판</a>
            <a href="/activity/searchListPage">대외활동 게시판</a>
            <a href="/lib/searchListPage">자료실 게시판</a>
            <a href="/news/searchListPage">뉴스 게시판</a>
        </div>
        <div class="reportPageBtn">
            <a href="#">신고 내역</a>
        </div>
    </div>
    <div class="main">
        <div class="writeTit">
            <h2>신고내역</h2>
            <p>신고내역에 처리상태를 확인할 수 있습니다.</p>
        </div>
        <div class="formBox">
            <form method="post" action="/edu/editPage" enctype="multipart/form-data">
                <div class="boardTitle">
                    <p>신고자 제목</p>
                </div>
                <div class="formHead">
                    <div class="boardId">
                        <p>번호 : 1</p>
                    </div>
                    <div class="boardUser">
                        <p>작성자 : 이동규</p>
                    </div>
                    <div class="boardRegDate">
                        <p>2025-01-03</p>
                    </div>
                    <div class="boardViewCnt">
                        <p>조회수 123회</p>
                    </div>
                    <div class="boardLikeCnt">
                        <p>좋아요 123 개</p>
                    </div>
                </div>
                <div class="boardCont">
                    <p>글 내용 으하하하</p>
                </div>
            </form>
            <div class="qnaCommentList">
                <div class="comment" id="#">
                    <p>관리자 ID : admin001</p>
                </div>
                <div class="content">
                    <p class="contentPtage">응답 내용: 어쩌라고요 ㅋㅋㅋ 니사정~</p>
                    <div class="contentDate">
                        <p>답변일 : 2025-01-03</p>
                    </div>
                </div>
            </div>
            <p class="qnaCommentList2">답변이 없습니다.</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>