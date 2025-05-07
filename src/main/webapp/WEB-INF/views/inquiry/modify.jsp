<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 7.
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/static/js/checkModule.js"></script>
</head>
<body>
<form name="frmInquiry" id="frmInquiry" action="/inquiry/modify/${inquiry[0].inquiry_id}" method="post">
    <input type="hidden" name="member_id" value="${loginInfo.id}" hidden/>
    <input type="hidden" name="inquiry_id" value="${inquiry[0].inquiry_id}" hidden/>
    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" name="inquiry_title"  id="title" value="${inquiry[0].inquiry_title}"/></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="inquiry_content" id="content" rows="10" cols="60">${inquiry[0].inquiry_content}</textarea></td>
        </tr>
        <tr>
            <th>공개 여부</th>
            <td>
                <input type="radio" name="visibility" value="1" ${inquiry[0].visibility == 1? "checked" : ""}/>공개
                <input type="radio" name="visibility" value="0" ${inquiry[0].visibility == 0? "checked" : ""}/>비공개
            </td>
        </tr>
    </table>
    <input type="submit" id="btnSubmit" value="수정 완료"/>
    <input type="button" value="목록으로" id="btnList">
</form>
<script>
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
