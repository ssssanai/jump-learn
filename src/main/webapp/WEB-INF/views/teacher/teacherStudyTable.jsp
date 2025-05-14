<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%@include file="/resources/static/html/tcheaderGnb.jsp"%>
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
                    <table class="tbH1">
                        <tr>
                            <th class="tbTeacherId">강의 순서</th>
                            <th class="tbTitle">강의 제목</th>
                            <th class="tbMediaIn">강의 영상(내부)</th>
                            <th class="tbMediaOut">강의 영상(외부)</th>
                            <th class="tbStudyData">강의 자료</th>
                            <th class="tbCreateDate">생성일자</th>
                            <th class="tbModifyDate">수정일자</th>
                            <th class="tbNotice">공지사항</th>
                        </tr>
                    </table>
                    <table class="tbB1">
                        <c:choose>
                            <c:when test="${not empty dtoList}">
                                <c:forEach var="list" items="${dtoList}" varStatus="loop">
                                    <tr>
                                        <td class="tbTeacherId"><p>${list.video_order}</p></td>
                                        <td class="tbTitle"><p>${list.title}<p></td>
                                        <td class="tbMediaIn">
                                            <c:choose>
                                                <c:when test="${not empty list.video_name}">
                                                    <a href="/upload/${list.video_name}" target="_blank">${list.video_name}</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <p>X</p>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="tbMediaOut">
                                            <c:choose>
                                                <c:when test="${not empty list.video_url}">
                                                    <a href="${list.video_url}" target="_blank">외부 영상</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <p>X</p>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="tbStudyData">
                                            <c:choose>
                                                <c:when test="${not empty list.data_name}">
                                                    <a href="/upload/${list.data_name}" target="_blank">${list.data_name}</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <p>X</p>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="tbCreateDate">
                                            <p>${list.created_at}</p>
                                        </td>
                                        <td class="tbModifyDate">
                                            <p>${list.updated_at}</p>
                                        </td>
                                        <td class="tbNotice">
                                            <c:choose>
                                                <c:when test="${not empty list.notice}">
                                                    <a href="#" onclick="notice_view_window('${list.notice}')">확인하기</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="#" onclick="notice_add_window('${list.id}')">추가하기</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <div class="nullTable">
                                    등록된 강의가 없습니다.
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function notice_add_window(id) {
        const url = '/teacher/notice_add_popup?id=' + id;
        window.open(url, '_blank', 'width=400,height=300');
    }
    function notice_view_window(notice) {
        const popup = window.open('', '_blank', 'width=400,height=300');
        popup.document.write('<h2>공지사항 상세</h2>' +
            '<span>'+notice + '</span>');
    }
</script>
</body>
</html>
