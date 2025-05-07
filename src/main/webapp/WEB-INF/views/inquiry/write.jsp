<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 7.
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp" %>
<html>
<head>
    <title>QnA 작성 페이지</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
            padding: 15px;
        }
    </style>
    <script src="/resources/static/js/checkModule.js"></script>
</head>
<body>
<h1>QnA 작성</h1>

<form name="frmInquiry" id="frmInquiry" action="/inquiry/write" method="post">
    <input type="hidden" name="member_id" value="${mDTO.id}" hidden/>
    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" id="title" name="inquiry_title"/>
                ${ dto.inquiry_title != null ? dto.inquiry_title : ""}
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td>
                <textarea name="inquiry_content" id="content" rows="10"
                          cols="60">${ dto.inquiry_content != null ? dto.inquiry_content : ""}</textarea>
            </td>
        </tr>
        <tr>
            <th>공개 여부</th>
            <td>
                <input type="radio" name="visibility" value="1" checked/>공개
                <input type="radio" name="visibility" value="0"/>비공개
            </td>
        </tr>
    </table>
    <input type="submit" id="btnSubmit" value="질문 등록"/>
    <input type="reset" value="초기화"/>
    <input type="button" value="목록으로" id="btnList">
</form>
<script>
    document.getElementById('btnList').addEventListener('click', () => location.href = '/inquiry/list');
    document.getElementById('btnSubmit').addEventListener('click', function (e) {
        e.preventDefault();
        e.stopPropagation();
        let title = document.getElementById('title');
        let content = document.getElementById('content');

        let isValid = true;

        if (!checkSQLInjection(title.value) || !(title.value.length <= 100 && title.value.length >= 5)) {
            alert("제목은 5자 이상 100자 이하여야 하며, ', \", $$, #, --, /* 는 포함할 수 없습니다.")
            title.value = '';
            title.focus();
            isValid = false;
        } else if (!checkSQLInjection(content.value) || !(content.value.length <= 1000 && content.value.length >= 10)) {
            alert("내용은 10자 이상 1000자 이하여야 하며, ', \", $$, #, --, /* 는 포함할 수 없습니다.")
            content.value = '';
            content.focus();
            isValid = false;
        }

        if (isValid) {
            document.getElementById('frmInquiry').submit();
        }
    })
</script>
</body>
</html>
