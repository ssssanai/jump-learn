<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 4. 30.
  Time: 오후 5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../../resources/static/css/registStyle.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>

    <title>JL - 회원가입</title>
</head>
<body>
<div class="wrap">
    <div class="registBox">
        <div class="registImg">
            <img src="../../../resources/static/images/registLogo.jpg" class="registLogo" alt="홈페이지 로고"/>
        </div>
        <div class="registContent">
            <form id="registerForm"class="regi_form" action="/member/register" method="post">
                <div class="regi_input_box">
                    <p class="regi_tit">아이디</p>
                    <input type="text" name="id" id="userId" autocomplete="off" class="regi_input1"  placeholder="8~20자 미만의 영문 소문자, 숫자" maxlength="20">
                    <input type="button" name="idVali" id="idVali"  autocomplete="off" class="idVali" value="중복확인">
                    <input type="hidden" id="idCheck" name="idCheck"  autocomplete="off" value=""/>
                    <div id="userIdError" class="error"></div>
                </div>
                <div class="regi_input_box">
                    <p class="regi_tit">비밀번호</p>
                    <input type="password" name="password" id="userPw" class="regi_input2" autocomplete="off" placeholder="8~20자 미만의 영문 소문자, 숫자, 특수문자 포함" maxlength="20">
                    <button id="togglePassword" type="button">👁️</button>
                    <div id="userPwError" class="error"></div>
                </div>
                <div class="regi_input_box">
                    <p class="regi_tit">비밀번호 확인</p>
                    <input type="password" id="userPwConfirm" name="passwordChk" class="regi_input2" autocomplete="off">
                    <div id="userPwConfirmError" class="error"></div>
                </div>
                <div class="regi_input_box">
                    <p class="regi_tit">이름</p>
                    <input id="realName" type="text" name="name" class="regi_input2" maxlength="10" autocomplete="off" placeholder="1~10자 미만의 한글" maxlength="10">
                    <div id="realNameError" class="error"></div>
                </div>
                <div class="regi_input_box">
                    <p class="regi_tit">생년월일</p>
                    <input type="date" name="birth" class="regi_input2" id="birthDate" name="birthdate" required min="1950-01-01">
                    <div id="birthDateError" class="error"></div>
                </div>
                <div class="regi_input_box1">
                    <p class="regi_tit">이메일</p>
                    <input id="userEmail" class="select_email" type="text" autocomplete="off" placeholder="ex) textmail01" maxlength="20">
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
                    <input type="hidden" name="email" id="hiddenEmail">
                    <input type="button" name="" id="emailCheck"  autocomplete="off" class="emailCheck" value="인증">
                </div>
                <div id="userEmailError" class="error"></div>
                <div class="regi_input_box1">
                    <p class="regi_tit">이메일 인증</p>
                    <input id="userCode" type="text" name="emailCheck" class="regi_input1" maxlength="10" autocomplete="off" maxlength="10">
                    <input type="button" name="emailCheck" id="codeCheck"  autocomplete="off" class="emailCheck" value="확인">
                    <input type="hidden" id="codeConfirm" value="false" >
                </div>
                <div class="error_mail"></div>
                <div class="regi_input_box1">
                    <div class="grade_choice">
                        <label class="radio_style1">
                            <input type="radio" name="grade" value="1">
                            <span>고등학교 1학년</span>
                        </label>
                        <label class="radio_style1">
                            <input type="radio" name="grade" value="2" />
                            <span>고등학교 2학년</span>
                        </label>
                        <label class="radio_style1">
                            <input type="radio" name="grade" value="3" />
                            <span>고등학교 3학년</span>
                        </label>
                        <label class="radio_style1">
                            <input type="radio" name="grade" value="N" />
                            <span>N 수생</span>
                        </label>
                    </div>
                    <div id="grade_error" class="generror"></div>
                </div>
                <div class="regi_input_box1">
                    <div class="sex_choice">
                        <label class="radio_style">
                            <input id="gender_man" type="radio" name="gender" value="M" />
                            <span>남자</span>
                        </label>
                        <label class="radio_style">
                            <input id="gender_woman" type="radio" name="gender" value="F" />
                            <span>여자</span>
                        </label>
                    </div>
                    <div id="gender_error" class="generror"></div>
                </div>
                <input id="checkKey1" class="regi_btn1" type="submit" name="regi_btn" value="회원가입하기">
                <input id="checkKey2" class="regi_btn2" type="reset" name="regi_btn" value="취소">
            </form>
        </div>
    </div>
</div>
<c:if test="${not empty errors}">
    <script>
        var errorMessage = '${errors[0].defaultMessage}';
        alert(errorMessage);
    </script>
</c:if>
<script src="../../../resources/static/js/registSc.js"></script>
</body>
</html>
