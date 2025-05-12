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
    <link href="/resources/static/css/member/memberChangeInfo.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>

    <title>JL - 강사정보수정</title>
</head>
<body>
<div class="wrap">
    <div class="registBox">
        <div class="registImg">
            <img src="/resources/static/images/registLogo.jpg" class="registLogo" alt="홈페이지 로고"/>
        </div>
        <div class="registContent">
            <form id="registerForm"class="regi_form" action="" method="">
                <div class="regi_input_box">
                    <p class="regi_tit">아이디</p>
                    <input type="text" name="id" id="userId" autocomplete="off" class="regi_input2" maxlength="20" readonly>
                    <input type="hidden" id="idCheck" name="idCheck"  autocomplete="off" value=""/>
                    <div id="userIdError" class="error"></div>
                </div>
                <div class="regi_input_box">
                    <p class="regi_tit">이름</p>
                    <input id="realName" type="text" name="name" class="regi_input2" maxlength="10" autocomplete="off" maxlength="10" readonly>
                    <div id="realNameError" class="error"></div>
                </div>
                <div class="regi_input_box">
                    <p class="regi_tit">생년월일</p>
                    <input type="date" name="birth" class="regi_input2" id="birthDate" name="birthdate" required min="1950-01-01" readonly>
                    <div id="birthDateError" class="error"></div>
                </div>
                <div class="regi_input_box1">
                    <p class="regi_tit">이메일</p>
                    <input id="userEmail" class="select_email" type="text" name="email" autocomplete="off" placeholder="ex) textmail01" maxlength="20">
                    <p class="email_between">@</p>
                    <select id="select_email1" name="select_email">
                        <option value="" disabled selected>도메인을 선택하세요</option>
                        <option value="naver.com">naver.com</option>
                        <option value="hanmail.net">hanmail.net</option>
                        <option value="hotmail.com">hotmail.com</option>
                        <option value="nate.com">nate.com</option>
                        <option value="korea.com">korea.com</option>
                        <option value="gmail.com">gmail.com</option>
                        <option value="hanmir.com">hanmir.com</option>
                        <option value="paran.com">paran.com</option>
                    </select>
                    <input type="button" name="" id="emailCheck"  autocomplete="off" class="emailCheck" value="인증">
                </div>
                <div id="userEmailError" class="error"></div>
                <div class="regi_input_box1">
                    <p class="regi_tit">이메일 인증</p>
                    <input id="userCode" type="text" name="name" class="regi_input1" maxlength="10" autocomplete="off" maxlength="10">
                    <input type="button" name="emailCheck" id="codeCheck"  autocomplete="off" class="emailCheck" value="확인">
                    <input type="hidden" id="codeConfirm" value="false" >
                </div>
                <div class="error_mail"></div>
                <div class="profileImage">
                    <p class="regi_tit">프로필 이미지</p>
                    <input class="regi_input2" type="file" name="">
                </div>
                <input id="checkKey" class="regi_btn1" type="submit" name="regi_btn" value="회원정보 수정하기">
                <input id="checkKey" class="regi_btn2" type="reset" name="regi_btn" value="취소">
            </form>
        </div>
    </div>
</div>
<script src="script/registSc.js"></script>
</body>
</html>