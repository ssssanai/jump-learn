<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 7.
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp" %>
<html>
<head>
    <title>Detail Page</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
            padding: 15px;
        }
    </style>
    <script src="/resources/static/js/checkModule.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
<%@include file="/resources/static/html/memberGnb.jsp" %>
<h1>Q&A 상세</h1>
<table>
    <tr>
        <th>글 번호</th>
        <th>작성자</th>
        <th>글 제목</th>
        <th>작성일</th>
        <th>수정일</th>
        <th>처리 여부</th>
        <th>공개 여부</th>
    </tr>
    <tr>
        <td>${inquiry[0].inquiry_id}</td>
        <td>${inquiry[0].member_id}</td>
        <td>${inquiry[0].inquiry_title}</td>
        <td>${inquiry[0].inquiry_created_at}</td>
        <td>${inquiry[0].inquiry_updated_at}</td>
        <td>${inquiry[0].inquiry_status}</td>
        <td>${inquiry[0].visibility == 1 ? "공개" : "비공개"}</td>
    </tr>
    <tr>
        <td colspan="7">${inquiry[0].inquiry_content}</td>
    </tr>
    <tr>
        <td colspan="7">
            <input type="button" value="목록으로" id="btnList">
            <c:if test="${inquiry[0].member_id.equals(loginInfo.id)}">
                <input type="button" value="질문 수정" id="btnModify">
                <input type="button" value="질문 삭제" id="btnDelete">
            </c:if>
        </td>
    </tr>
</table>
<br><br>
<table>
    <tr>
        <td colspan="7">
            <c:choose>
                <c:when test="${inquiry[0].admin_id != null}">
                    관리자 ID: ${inquiry[0].admin_id}<br>
                    답변 내용: ${inquiry[0].resolution_content}<br>
                    답변 시간: ${inquiry[0].resolution_created_at}
                </c:when>
                <c:otherwise>
                    답변이 없습니다.
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
</table>
<br><br>
<c:if test="${ loginInfo.status == 1}" var="hasPermission">
    <form name="inquiry_comment_form" id="inquiry_comment_form" action="/inquiry/comment/add/${inquiry[0].inquiry_id}"
          method="post">
        <input type="hidden" name="inquiry_commenter" value="${loginInfo.id}" hidden/>
        <input type="hidden" name="inquiry_comment_id_type" value="member" hidden/>
        <table>
            <tr>
                <td>
                    <textarea id="inquiry_comment_content" name="inquiry_comment_content" placeholder="댓글을 입력해주세요."></textarea>
                </td>
                <td><input type="button" value="등록" id="btnSubmit"/></td>
            </tr>
        </table>
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

<table>
    <c:choose>
        <c:when test="${inquiry[0].inquiry_commenter != null}">
            <c:forEach items="${inquiry}" var="comment">
                <tr>
                    <td class="comment" id="${comment.comment_id}">
                        댓글 작성자 ID: <span class="commenter_id">${comment.inquiry_commenter}</span>
                        <c:if test="${loginInfo.id.equals(comment.inquiry_commenter)}">
                            <button class="btnCommentUpdate">수정</button>
                            &nbsp;<button class="btnCommentDelete">삭제</button>
                        </c:if>
                        <br><span class="commenter_type">${comment.inquiry_comment_id_type}</span>
                        <br>댓글 내용: <span class="comment_content">${comment.inquiry_comment_content}
                        <br>댓글 작성 시간: <span class="comment_created_at">${comment.inquiry_comment_created_at}</span>
                        <br>댓글 수정 시간: <span class="comment_updated_at">${comment.inquiry_comment_updated_at}</span>
                    </td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td>댓글이 없습니다.</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>


<script>
    $('#btnList').on('click', () => location.href = '/inquiry/list');
    $('#btnModify').on('click', () => location.href = '/inquiry/modify/${inquiry[0].inquiry_id}');
    $('#btnDelete').on('click', () => {
        if (confirm('질문을 삭제하시겠습니까? 삭제한 질문은 복구할 수 없습니다!')) {
            location.href = '/inquiry/delete/${inquiry[0].inquiry_id}'
        }
    });

    $('#btnSubmit').on('click', function (e) {
        let frm = $('#inquiry_comment_form');
        let cmt = $('#inquiry_comment_content');
        e.preventDefault();
        e.stopPropagation();
        let isValid = true;
        if (!checkSQLInjection(cmt.val()) || cmt.val().length < 9 || cmt.val().length > 101) {
            alert('댓글은 10자 이상 100자 이하여야 하며, \', \", $$, #, --, /* 는 포함할 수 없습니다.');
            cmt.val('');
            cmt.focus();
            isValid = false;
        }
        if (isValid) {frm.submit();}
    });

    $('.btnCommentUpdate').on('click', function () {
        let commenter = $(this).siblings()[0].innerText; // 댓글 작성자
        let comment_id = $(this).parent().attr('id'); // 댓글 ID
        let commenter_type = $(this).siblings()[3].innerText; // 댓글 작성자 타입
        let original_comment = $(this).siblings()[4].innerText; // 원래 댓글
        let url = '/inquiry/comment/update/' + comment_id;
        console.log($(this).parent());
        $(this).parent()[0].innerHTML = `
        <form id="inquiry_comment_update_form" name="inquiry_comment_update_form" action="` + url + `" method="post">
            <input type="hidden" name="inquiry_id" value="`+ ${inquiry[0].inquiry_id} +`"/>
            <input type="hidden" name="inquiry_commenter" value="` + commenter + `"/>
            <input type="hidden" name="inquiry_comment_id_type" value="` + commenter_type + `"/>
            <textarea id="inquiry_comment_content_update" name="inquiry_comment_content">` + original_comment + `</textarea>
            <input id="btnCommentModifyDone" type="submit" value="수정 완료"/>
        </form>`;

        $('#btnCommentModifyDone').on('click', function (e){
            e.preventDefault();
            e.stopPropagation();
            let frm = $('#inquiry_comment_update_form');
            let cmt = $('#inquiry_comment_content_update');
            e.preventDefault();
            e.stopPropagation();
            let isValid = true;
            if (!checkSQLInjection(cmt.val()) || cmt.val().length < 9 || cmt.val().length > 101) {
                alert('댓글은 10자 이상 100자 이하여야 하며, \', \", $$, #, --, /* 는 포함할 수 없습니다.');
                cmt.val('');
                cmt.focus();
                isValid = false;
            }
            if (isValid) {
                frm.submit();
            }
        });
    });

    $('.btnCommentDelete').on('click', function () {
        let commenter = $(this).siblings()[0].innerText; // 댓글 작성자
        let comment_id = $(this).parent().attr('id'); // 댓글 ID

        let url = '/inquiry/comment/delete/' + comment_id + "/" + commenter + "/" + ${inquiry[0].inquiry_id};
        console.log(commenter);
        console.log(comment_id);
        if (confirm('댓글을 삭제하시겠습니까?')) {
            location.href = url;
        }
    });
</script>
</body>
</html>
