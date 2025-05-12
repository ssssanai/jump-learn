<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 5. 11.
  Time: 오후 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/emailFoundPw.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb1.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
    <title>JL - 이메일 인증</title>
</head>
<body>
<div class="wrap">
    <header>
        <a href="#"><img class="header_logo" src="/resources/static/images/registLogo2.svg" alt="메인로고"></a>
        <p class="header_comment">"비밀번호 변경 전 이메일 인증 페이지입니다."</p>
    </header>
    <main>
        <form id="fpw_form"class="fpw_form" action="" method="">
            <div class="fpw_input_box">
                <p class="fpw_tit">가입 한 아이디</p>
                <input type="text" name="아이디" autocomplete="off" id="username" class="fpw_input" placeholder="가입하신 아이디를 입력해주세요.">
            </div>
            <div class="fpw_input_box2">
                <p class="fpw_tit">이메일</p>
                <input type="text" class="fpw_input2" autocomplete="off"  name="security_answers[]" placeholder="답변 입력" required>
                <input type="button" id="tempw_checked" autocomplete="off" class="tempw_checked" value="입력">
            </div>
            <div class="fpw_input_box2">
                <p class="fpw_tit">인증번호 확인</p>
                <input type="text" class="fpw_input2" autocomplete="off" name="security_answers[]" placeholder="답변 입력" required>
                <input type="button" id="tempw_checked" autocomplete="off" class="tempw_checked" value="인증 확인">
            </div>
            <div class="btm_line"></div>
            <input id="checkKey" class="fpw_btn" type="submit" name="fpw_btn" value="비밀번호 변경으로 이동">
        </form>
    </main>
</div>
</body>
</html>
