<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 5. 11.
  Time: 오전 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/teacher/teacherChangeInfo.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>

    <title>JL - 강사정보수정</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<div class="wrap">
    <div class="registBox">
        <div class="registImg">
            <img src="/resources/static/images/registLogo.jpg" class="registLogo" alt="홈페이지 로고"/>
        </div>
        <div class="registContent">
            <form id="registerForm"class="regi_form" action="/teacher/ChangeInfo" method="post" enctype="multipart/form-data">
                <div class="regi_input_box">
                    <p class="regi_tit">아이디</p>
                    <input type="text" name="id" id="userId" autocomplete="off" class="regi_input2" maxlength="20" value="${dto.id}" readonly>
                    <input type="hidden" id="idCheck" name="idCheck"  autocomplete="off"/>
                    <div id="userIdError" class="error"></div>
                </div>
                <div class="regi_input_box">
                    <p class="regi_tit">이름</p>
                    <input id="realName" type="text" name="name" class="regi_input2" maxlength="10" autocomplete="off" value="${dto.name}" readonly>
                    <div id="realNameError" class="error"></div>
                </div>
                <div class="regi_input_box">
                    <p class="regi_tit">생년월일</p>
                    <input type="date"class="regi_input2" id="birthDate" name="birth" required min="1950-01-01" value="${dto.birthday}">
                    <div id="birthDateError" class="error"></div>
                </div>
                <div class="regi_input_box">
                    <p class="regi_tit">이메일</p>
                    <input id="userEmail" class="select_email" type="text" name="email" autocomplete="off" value="${dto.email}" maxlength="20" readonly>
                </div>
                <div class="profileImage">
                    <p class="regi_tit">프로필 이미지</p>
                    <input class="regi_input2" type="file" name="file" >
                </div>
                <div class="introduceBox">
                    <p class="regi_tit3">자기소개</p>
                    <input class="regi_input3" type="text" name="introduce1" value="${dto.introduce1}"></input>
                    <input class="regi_input3" type="text"  name="introduce2" value="${dto.introduce2}"></input>
                    <input class="regi_input3" type="text" name="introduce3" value="${dto.introduce3}"></input>
                </div>
                <input id="checkKey" class="regi_btn1" type="submit" name="regi_btn" value="회원정보 수정하기">
                <input id="checkKey1" class="regi_btn2" type="reset" name="regi_btn" value="취소">
            </form>
        </div>
    </div>
</div>
<%--<script src="script/registSc.js"></script>--%>
</body>
</html>