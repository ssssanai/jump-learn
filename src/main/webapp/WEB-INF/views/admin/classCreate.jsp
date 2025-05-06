<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-06
  Time: 오후 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/teacherCreateStyle.css" rel="stylesheet" type="text/css">
    <title>강좌 생성</title>
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
<h2 style="text-align:center;">강좌 등록</h2>

<form action="/admin/class_create" method="post" enctype="multipart/form-data">
    <label for="class_title">강좌 제목</label>
    <input type="text" id="class_title" name="class_title" required>

    <label for="class_category">과목</label>
    <select id="class_category" name="class_category" required>
        <option value="KOREAN">국어</option>
        <option value="MATH">수학</option>
        <option value="ENGLISH">영어</option>
    </select>

    <label for="class_teacher_id">담당 선생님 ID</label>
    <input type="text" id="class_teacher_id" name="class_teacher_id" required>

    <label for="class_target">대상 학년</label>
    <select id="class_target" name="class_target" required>
        <option value="고1">고1</option>
        <option value="고2">고2</option>
        <option value="고3">고3</option>
        <option value="N수생">N수생</option>
    </select>

    <label for="class_price">가격</label>
    <input type="text" id="class_price" name="class_price" required>

    <label for="class_introduce">강좌 소개</label>
    <textarea id="class_introduce" name="class_introduce" rows="5" cols="55" required></textarea>

    <label for="image">강좌 이미지</label>
    <input type="file" id="image" name="image" accept="image/*" required>

    <button type="submit">강좌 등록</button>
</form>
</body>
</html>
