<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-06
  Time: 오후 4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/teacherCreateStyle.css" rel="stylesheet" type="text/css">
    <title>관리자 계정 생성</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<script>
    window.onload = function () {
        alert("관리자 정보를 정확히 입력해주세요." +
            "\n\n입력 항목:\n- 아이디: 영소문자 + 숫자, 8~20자\n- 비밀번호: 영문, 숫자, 특수문자(@, !) 포함 8~20자" +
            "\n- 이름: 한글 10자 이내\n- 생일: 과거 날짜만 허용\n- 이메일: 정확한 이메일 형식\n\n⚠️ 이후 잘못 생성 시에는 책임지지 않습니다.");
    };
</script>
<h2 style="text-align:center;">관리자 등록</h2>

<form action="/admin/admin_create" method="post">
    <label for="id">아이디</label>
    <input type="text" id="id" name="id" required>

    <label for="password">비밀번호</label>
    <input type="password" id="password" name="password" required>

    <label for="name">이름</label>
    <input type="text" id="name" name="name" required>

    <label for="birth">생년월일</label>
    <input type="date" id="birth" name="birth" required>

    <label for="email">이메일</label>
    <input type="email" id="email" name="email" required>

    <label for="status">상태</label>
    <select id="status" name="status" required>
        <option value="1">슈퍼 관리자</option>
        <option value="2">중간 관리자</option>
    </select>

    <button type="submit">등록</button>
</form>
</body>
</html>
