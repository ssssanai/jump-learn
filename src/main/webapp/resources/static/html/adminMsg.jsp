<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-04
  Time: 오전 3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty errors}">
    <script>
        var errorMessage = '${errors[0].defaultMessage}';
        if(errorMessage.trim() !== ''){
            alert(errorMessage);
        }
    </script>
</c:if>
<c:if test="${not empty msg}">
    <script>
        let msg = '${msg}';
        if (msg.trim() !== '') {
            alert(msg);
        }
    </script>
</c:if>
</body>
</html>
