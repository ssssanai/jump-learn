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
<%@include file="/resources/static/html/memberGnb.jsp" %>
<div class="wrap">
    <div class="aside">
        <div class="profile">
            <div class="myInfo">
                <p>회원등급 ${loginInfo.status}</p>
                <h2>환영합니다 ${loginInfo.name}님!</h2>
            </div>
        </div>
        <div class="sideMenu">
            <h2 class="sideMenuTitle">커뮤니티</h2>
            <a href="/post/searchListPage" class="select">자유게시판</a>
            <a href="/notice/searchListPage">공지사항 게시판</a>
            <a href="/edu/searchListPage">교육 정보 게시판</a>
            <a href="/info/searchListPage">대입 정보 게시판</a>
            <a href="/activity/searchListPage">대외활동 게시판</a>
            <a href="/lib/searchListPage">자료실 게시판</a>
            <a href="/news/searchListPage">뉴스 게시판</a>
        </div>
    </div>
    <div class="main">
        <div class="writeTit">
            <h2>신고내역</h2>
        </div>
        <div class="formBox">
            <div class="formHead">
                <div class="boardId">
                    <p>신고 번호 : ${reportDetail.report_id}</p>
                </div>
                <div class="boardUser">
                    <p>신고자 : ${reportDetail.member_id}</p>
                </div>
                <div class="boardRegDate">
                    <p>신고일자 : ${reportDetail.report_create_date.toString().replace("T", " ")}</p>
                </div>
                <div class="boardViewCnt">
                    <c:if test='${reportDetail.report_status.equals("complete")}' var="isComplete">
                        <p style="color: green">처리 완료</p>
                    </c:if>
                    <c:if test="${not isComplete}">
                        <p style="color: orangered">처리 중</p>
                    </c:if>
                </div>
            </div>
            <div class="boardCont">
                <p>${reportDetail.reason}</p>
            </div>
            <c:if test="${isComplete}">
                <div class="qnaCommentList">
                    <div class="comment" id="#">
                        <p>관리자 ID : ${reportDetail.admin_id}</p>
                    </div>
                    <div class="content">
                        <p class="contentPtage">응답 내용: ${reportDetail.resolution}</p>
                        <div class="contentDate">
                            <p>답변일 : ${reportDetail.resolution_create_date}</p>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${not isComplete}">
                <p class="qnaCommentList2">답변이 없습니다.</p>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>