<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-12
  Time: 오후 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String comment_id = request.getParameter("comment_id");
%>
<html>
<head>
    <link href="/resources/static/css/teacher/popup.css" rel="stylesheet" type="text/css">
    <title>댓글 수정</title>
</head>
<body>
<h2>댓글 수정</h2>
<form class="registBox" action="/post/updateComment" method="post">
    <input class="regi_input" type="text" name="comment_content" placeholder="댓글 입력하세요"><br>
    <input type="hidden" name="comment_id" value="<%=comment_id%>">
    <div class="btn">
        <input type="submit" value="입력하기">
        <button type="button" onclick="window.close()">취소</button>
    </div>
</form>
<c:if test="${not empty msg}">
    <script>
        let msg = '${msg}';
        if (msg.trim() !== '') {
            alert(msg);
            window.close();
            window.opener.location.reload();
        }
    </script>
</c:if>

</body>
</html>


