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
    <link href="/resources/static/css/community/freeBoard/viewPage.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb1.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>글 상세보기</title>
</head>
<body>
<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/headerGnb.jsp"%>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
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
            <a href="#" class="select">자유게시판</a>
            <a href="#">교육 정보 게시판</a>
            <a href="#">대입 정보 게시판</a>
            <a href="#">대외활동 게시판</a>
            <a href="#">자료실 게시판</a>
            <a href="#">뉴스 게시판</a>
            <a href="#">공지사항</a>
        </div>
    </div>
    <div class="main">
        <div class="writeTit">
            <h2>자유 게시판</h2>
            <p>자유롭게 소통하는 공간입니다.</p>
        </div>
        <div class="formBox">
            <form method="post" action="/edu/editPage" enctype="multipart/form-data">
                <div class="boardTitle">
                    <p>제목${dto.post_title}</p>
                </div>
                <div class="formHead">
                    <div class="boardId">
                        <p>번호 : ${dto.post_id}</p>
                    </div>
                    <div class="boardUser">
                        <p>${dto.post_member_id}</p>
                    </div>
                    <div class="boardRegDate">
                        <p>${dto.post_created_at}</p>
                    </div>
                    <div class="boardViewCnt">
                        <p>조회수 ${dto.view_count}회</p>
                    </div>
                </div>
                <div class="boardCont">
                    <p>${dto.post_content}</p>
                </div>
                <div class="boardImage">
                    <c:choose>
                        <c:when test="${not empty fileList}">
                            <c:forEach var="list" items="${fileList}" >
                                <img src="/upload/${list.fileName}" alt="이미지"/>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>

                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="formBtn">
                   <a href="/post/searchListPage"><input type="button" value="목록"></a>
                    <c:choose>
                        <c:when test="${loginInfo.id.equals(dto.post_member_id)}">
                            <a href="/post/updatePost?id=${dto.post_id}"><input type="button" value="게시글 수정"></a>
                            <a href="/post/updateFile?id=${dto.post_id}"><input type="button" value="사진 수정"></a>
                            <a href="/post/deletePost?id=${dto.post_id}"><input type="button" value="삭제"></a>
                        </c:when>
                    </c:choose>
                </div>
            </form>
            <div class="qnaCommentList">
                <c:choose>
                    <c:when test="${not empty commentList}">
                        <c:forEach var="list" items="${commentList}" varStatus="loop">
                            <div class="comment" id="${list.comment_id}">
                                <p>댓글 작성자 ID:  ${list.comment_member_id}</p>
                                <div class="commentBtn">
                                    <c:if test="${loginInfo.id.equals(list.comment_member_id)}">
                                        <a href=""><button class="btnCommentUpdate" onclick="comment_update_window('${list.comment_id}')">수정</button></a>
                                        &nbsp;<a href="/post/deleteComment?id=${list.comment_id}"><button class="btnCommentDelete">삭제</button></a>
                                    </c:if>
                                </div>
                            </div>
                            <div class="content">
                                <p class="contentPtage">댓글 내용: ${list.comment_content}</p>
                                <div class="contentDate">
                                    <c:choose>
                                        <c:when test="${empty list.updated_at}">
                                            <p>댓글 작성 시간: ${list.created_at}</p>
                                        </c:when>
                                        <c:otherwise>
                                            <p>댓글 수정 시간: ${list.updated_at}</p>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td>댓글이 없습니다.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </div>
            <c:if test="${ loginInfo.status == 1}" var="hasPermission">
                <form name="inquiry_comment_form" id="inquiry_comment_form" action="/post/insertComment"
                      method="post">
                    <div class="qnaCommentWrite">
                        <input type="hidden" name="comment_member_id" value="${loginInfo.id}" hidden/>
                        <input type="hidden" name="post_id" value="${dto.post_id}" hidden/>
                        <textarea id="inquiry_comment_content" name="comment_content" placeholder="댓글을 입력해주세요."></textarea>
                        <input type="submit" value="등록" id="btnSubmit"/>
                    </div>
                </form>
            </c:if>
            <c:if test="${not hasPermission}">
                <table>
                    <tr>
                        <td colspan="2">
                            <div>운영 정책 위반으로 인해 댓글을 입력할 수 없습니다.</div>
                        </td>
                    </tr>
                </table>
            </c:if>
        </div>
    </div>
</div>
<script>
    function comment_update_window(comment_id) {
        const url = '/post/updateComment?comment_id=' + comment_id;
        window.open(url, '_blank', 'width=400,height=300');
    }
</script>
</body>
</html>