<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 4. 30.
  Time: 오후 5:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../../resources/static/css/loginStyle.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>

    <title>JL - 로그인</title>
</head>
<body>
<div class="wrap">
    <header>
        <img class="header_logo" src="../../../resources/static/images/registLogo.jpg" alt="메인로고">
    </header>
    <main>
        <div class="login_content">
            <form class="login_form" action="/member/login" method="post" onsubmit="return validateForm()">
                <div class="input_div one">
                    <div class="i">
                        <i class="fas fa-user"></i>
                    </div>
                    <div class="div">
                        <h5>아이디</h5>
                        <input type="text" class="input" name="id" autocomplete="off" value="">
                    </div>
                </div>
                <div class="input_div pass">
                    <div class="i">
                        <i class="fas fa-lock"></i>
                    </div>
                    <div class="div">
                        <h5>비밀번호</h5>
                        <input id="password" type="password" class="input" autocomplete="off" name="password">
                        <button id="togglePassword" type="button">😍</button>
                    </div>
                </div>
                <div class="save_id">
                    <p>아이디 저장</p><input name="saveId" type="checkbox" id="save_id" value="Y">
                </div>
                <input type="submit" class="btn" value="로그인">
                <div class="regi_chgpwd_div">
                    <a href="#">회원가입</a>
                    <a href="#">비밀번호 찾기</a>
                </div>
            </form>
        </div>
    </main>
</div>
<script src="../../../resources/static/js/loginSc.js"></script>
</body>
</html>
