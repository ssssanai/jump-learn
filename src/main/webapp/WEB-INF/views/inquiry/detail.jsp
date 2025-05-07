<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 7.
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail Page</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
            padding: 15px;
        }
    </style>
</head>
<body>
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
<table>
    <tr>
        <td colspan="7">
            <c:choose>
                <c:when test="${inquiry[0].inquiry_commenter != null}">
                    <c:forEach items="${inquiry}" var="comment">
                        댓글 작성자 ID: ${comment.inquiry_commenter}<br>
                        ${comment.inquiry_comment_id_type}<br>
                        댓글 내용: ${comment.inquiry_comment_content}<br>
                        댓글 작성 시간: ${comment.inquiry_comment_created_at}<br>
                        댓글 수정 시간: ${comment.inquiry_comment_updated_at}
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    댓글이 없습니다.
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
</table>

<script>
    document.getElementById('btnList').addEventListener('click', () => location.href = '/inquiry/list');
    document.getElementById('btnModify').addEventListener('click', () => {
        location.href = '/inquiry/modify/${inquiry[0].inquiry_id}';
    });
    document.getElementById('btnDelete').addEventListener('click', () => {
        if (confirm('질문을 삭제하시겠습니까? 삭제한 질문은 복구할 수 없습니다!')) {
            location.href = '/inquiry/delete/${inquiry[0].inquiry_id}'
        }
    });

</script>
</body>
</html>
