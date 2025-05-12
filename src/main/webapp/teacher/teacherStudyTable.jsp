<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 5. 4.
  Time: 오후 3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/teacher/teacherStudyTable.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb3.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>JL - 강의표 페이지</title>
</head>
<body>
<div id="noticeModal">
    <div class="modalwrap">
        <div class="modalBox">
            <h2>공지사항 추가</h2>
            <form method="post" action="">
                <textarea class="scoreInput" type="text" placeholder="공지사항"></textarea>
                <input class="submitBtn" type="submit" value="입력하기">
            </form>
            <a href="#">닫기</a>
        </div>
    </div>
</div>
<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/tcheaderGnb.jsp"%>

<div class="wrap">
    <div class="main">
        <div class="todayBest">
            <div class="boardBox">
                <div class="boardTit">
                    <h2>강의표</h2>
                </div>
                <div class="boardLine1">
                    <div class="tbH1">
                        <div class="tbTeacherId">강사 ID</div>
                        <div class="tbTitle">강의 제목</div>
                        <div class="tbMediaIn">강의 영상(내부)</div>
                        <div class="tbMediaOut">강의 영상(외부)</div>
                        <div class="tbStudyData">강의 자료</div>
                        <div class="tbCreateDate">생성일자</div>
                        <div class="tbModifyDate">수정일자</div>
                        <div class="tbNotice">공지사항</div>
                    </div>
                    <div class="tbB1">
                        <div class="tbTeacherId">
                            <p>teacher001</p>
                        </div>
                        <div class="tbTitle">
                            <a href="#">강의제목입니다.</a>
                        </div>
                        <div class="tbMediaIn">
                            <a href="#">영상입니다</a>
                        </div>
                        <div class="tbMediaOut">
                            <a href="#">영상입니다</a>
                        </div>
                        <div class="tbStudyData">
                            <a href="#">강의 자료</a>
                        </div>
                        <div class="tbCreateDate">
                            <p>2025.01.03</p>
                        </div>
                        <div class="tbModifyDate">
                            <p>수정내역 없음</p>
                        </div>
                        <div class="tbNotice">
                            <a href="#noticeModal">추가하기</a>
                        </div>
                    </div>
                </div>
                <div class="paging">
                    <p>1 2 3 4 5 6</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
