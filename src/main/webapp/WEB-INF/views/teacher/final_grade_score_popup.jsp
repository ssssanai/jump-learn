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
    String id = request.getParameter("id");
    String classId = request.getParameter("class_id");
%>
<html>
<head>
    <title>전체 점수 입력</title>
</head>
<body>
<h2>전체 점수 입력</h2>
<form action="/teacher/final_grade_score_popup" method="post">
    <input type="text" name="final_grade_score" placeholder="점수를 입력하세요"><br>
    <input type="hidden" name="id" value="<%= id %>">
    <input type="hidden" name="class_id" value="<%= classId %>">
    <input type="submit" value="입력하기">
    <button type="button" onclick="window.close()">취소</button>
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


