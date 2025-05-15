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
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/report/list.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb2.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>신고내역</title>
</head>
<body>
<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/memberGnb.jsp"%>
<div class="wrap">
    <div class="aside">
        <div class="profile">
            <div class="myInfo">
                <p>회원등급  ??</p>
                <h2>환영합니다 OOO님!</h2>
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
        <div class="writeList">
            <table class="wlHeader">
                <tr>
                    <th class="listReportNo"><p >번호</p></th>
                    <th class="listReportBoardNo"><p >게시글 번호</p></th>
                    <th class="listReportName"><p >신고 대상</p></th>
<%--                    <th><p class="listName">신고자</p></th>--%>
                    <th class="listReportBecause"><p >신고 사유</p></th>
                    <th class="listReportDate"><p >신고 일시</p></th>
                    <th class="listReportState"><p >처리상태</p></th>
                </tr>
            </table>
            <table class="wlBody">
                <tr>
                    <td class="listReportNo"><p >1</p></td>
                    <td class="listReportBoardNo"><p >009</p></td>
                    <td class="listReportName"><p >이동규</p></td>
<%--                    <td><p class="listName">임경근</p></td>--%>
                    <td class="listReportBecause"><p>코드가 더러워요코드가 더러워요코드가 더러워요코드가 더러워요코드가 더러워요</p></td>
                    <td class="listReportDate"><p >2025.01.03</p></td>
                    <td class="listReportState"><p >processing</p></td>
                </tr>
            </table>

            <div class="pagingBox">
                <p>123456</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
