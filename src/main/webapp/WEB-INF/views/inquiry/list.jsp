<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 7.
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/community/qna/listPage.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb1.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>검색 결과 리스트 페이지</title>
    <script src="/resources/static/js/checkModule.js"></script>
</head>
<body>
<%--고정 헤더 파일--%>
<%@ include file="/resources/static/html/adminMsg.jsp"%>
<div class="wrap">
    <div class="main">
        <div class="writeTit">
            <h2>QnA 게시판입니다.</h2>
            <p>질문 사항을 편하게 작성해주세요</p>
            <div class="wtBtn">
                <a href="/inquiry/write">글쓰기</a>
            </div>
        </div>
        <form class="searchInput" method="GET" action="" name="frmSearch">
            <div class="searchBoxs">
                <select id="search_category" name="search_category" class="selectOption">
                    <option value="member_id">작성자</option>
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                </select>
                <input type="text" id="search_word" name="search_word" class="search_in" placeholder="검색어를 입력해주세요." value="#"/>
                <input type="submit" id="btnSubmit" class="search_btn" name="serch_btn" value="검색">
            </div>
        </form>
        <div class="writeList">
            <div class="wlHeader">
                <p class="listNo">글 번호</p>
                <p class="listTit">제목</p>
                <p class="listName">작성자</p>
                <p class="listContent">내용</p>
                <p class="listDate">작성일</p>
                <p class="listEditDate">수정일</p>
                <p class="listCnt">처리상태</p>
            </div>
            <c:forEach items="${dtoList}" var="i">
                <c:choose>
                    <c:when test="${i.visibility == 1}">
                        <td><a href="/inquiry/detail/${i.inquiry_id}"> ${i.inquiry_id}</a></td>
                        <td>${i.inquiry_title}</td>
                        <td>${i.member_id}</td>
                        <td>${i.inquiry_content}</td>
                        <td>${i.inquiry_created_at}</td>
                        <td>${i.inquiry_updated_at}</td>
                        <td>${i.inquiry_status}</td>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${i.member_id == loginInfo.id}">
                                <div class="wlBody">
                                    <a class="listNo" href="/inquiry/detail/${i.inquiry_id}">${i.inquiry_id}</a>
                                    <p class="listTit">${i.inquiry_title}</p>
                                    <p class="listName">${i.member_id}</p>
                                    <p class="listContent">${i.inquiry_content}</p>
                                    <p class="listDate">${i.inquiry_created_at}</p>
                                    <p class="listEditDate">${i.inquiry_updated_at}</p>
                                    <p class="listCnt">${i.inquiry_status}</p>
                                </div>
                                </c:when>
                                <c:otherwise>
                                    <p>${i.inquiry_id}</p>
                                    <p>비밀글입니다.</p>
                                </c:otherwise>

                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
<%--            <c:forEach items="${dtoList}" var="i">--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${i.visibility == 1}">--%>
<%--                        <td><a href="/inquiry/detail/${i.inquiry_id}"> ${i.inquiry_id}</a></td>--%>
<%--                        <td>${i.inquiry_title}</td>--%>
<%--                        <td>${i.member_id}</td>--%>
<%--                        <td>${i.inquiry_content}</td>--%>
<%--                        <td>${i.inquiry_created_at}</td>--%>
<%--                        <td>${i.inquiry_updated_at}</td>--%>
<%--                        <td>${i.inquiry_status}</td>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <c:choose>--%>
<%--                            <c:when test="${i.member_id == loginInfo.id}">--%>
<%--                                <td><a href="/inquiry/detail/${i.inquiry_id}">${i.inquiry_id}</a></td>--%>
<%--                                <td>${i.inquiry_title}</td>--%>
<%--                                <td>${i.member_id}</td>--%>
<%--                                <td>${i.inquiry_content}</td>--%>
<%--                                <td>${i.inquiry_created_at}</td>--%>
<%--                                <td>${i.inquiry_updated_at}</td>--%>
<%--                                <td>${i.inquiry_status}</td>--%>
<%--                            </c:when>--%>
<%--                            <c:otherwise>--%>
<%--                                <td>${i.inquiry_id}</td>--%>
<%--                                <td colspan="6">비밀글입니다.</td>--%>
<%--                            </c:otherwise>--%>
<%--                        </c:choose>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>
<%--                <div class="wlBody">--%>
<%--                    <a class="listNo" href="/inquiry/detail/${i.inquiry_id}">${i.inquiry_id}</a>--%>
<%--                    <p class="listTit">${i.inquiry_title}</p>--%>
<%--                    <p class="listName">${i.member_id}</p>--%>
<%--                    <p class="listContent">${i.inquiry_content}</p>--%>
<%--                    <p class="listDate">${i.inquiry_created_at}</p>--%>
<%--                    <p class="listEditDate">${i.inquiry_updated_at}</p>--%>
<%--                    <p class="listCnt">${i.inquiry_status}</p>--%>
<%--                    <c:otherwise>--%>
<%--                        <p>${i.inquiry_id}</p>--%>
<%--                        <p>비밀글입니다.</p>--%>
<%--                    </c:otherwise>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
            <div class="pagingBox">
                ${paging}
            </div>
        </div>
    </div>
</div>
</body>
</html>
