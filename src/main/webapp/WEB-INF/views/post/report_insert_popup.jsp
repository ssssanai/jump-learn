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
    String member_id = request.getParameter("member_id");
    String post_id = request.getParameter("post_id");
%>
<html>
<head>
    <link href="/resources/static/css/teacher/popup.css" rel="stylesheet" type="text/css">
    <title>게시글 신고</title>
</head>
<body>
<h2>게시글 신고</h2>
<form class="registBox" action="/post/report_insert_popup" method="post">
    <input class="regi_input" type="text" name="reason" placeholder="신고 내용 입력하세요"><br>
    <input type="hidden" name="member_id" value="<%=member_id%>">
    <input type="hidden" name="target_id" value="<%=post_id%>">
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


