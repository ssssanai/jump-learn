<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 5. 4.
  Time: 오후 4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../resources/static/css/member/returnStudy.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
    <title>JL - 환불요청</title>
</head>
<body>
<div class="header">
    <img src="../resources/static/images/registLogo2.svg" alt="로고"/>
</div>
<div class="wrap">
    <div class="title">
        <h2>Jump Learn 환불 요청하기</h2>
        <p>구매하신 강좌에 대한 환불 요청을 할 수 있습니다. 환불내용 작성중 화면을 벗어날 시
        환불 요청내용이 사라질 수 있습니다.</p>
    </div>
    <div class="studyBox">
        <div class="imgBox">
            <img src="../resources/static/images/img.png" alt="이미지">
        </div>
        <div class="studyInfo">
            <h2>강의 제목입니다.</h2>
            <p class="p1">강의 설명입니다.</p>
            <p class="p2">가격 : 18,000원</p>
        </div>
    </div>
    <div class="retrunForm">
        <h2>강의에 대한 어떤 문제가 발생했는지 설명해주세요.</h2>
        <p>작성해주신 내용이 자세할수록 강의 품질 또는 서비스 개선에 도움이 됩니다!</p>
        <form action="" method="get">
            <textarea placeholder="250자 내로 작성해주세요."></textarea>
            <input type="submit" value="환불요청">
            <input type="reset" value="취소하기">
        </form>
    </div>
</div>
</body>
</html>