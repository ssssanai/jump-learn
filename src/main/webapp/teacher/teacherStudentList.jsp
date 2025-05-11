<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 5. 4.
  Time: 오후 3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/teacher/teacherStudentList.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb3.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>JL - 강사 마이 페이지</title>
</head>
<body>

<%--고정 헤더 파일--%>
<%@include file="../resources/static/html/tcheaderGnb.jsp"%>

<div id="modal1">
    <div class="modalwrap">
        <div class="modalBox">
            <h2>중간고사 점수 입력</h2>
            <form method="post" action="">
                <input class="scoreInput" type="text" placeholder="점수를 입력해주세요.">
                <input class="submitBtn" type="submit" value="입력하기">
            </form>
            <a href="#">닫기</a>
        </div>
    </div>
</div>
<div id="modal2">
    <div class="modalwrap">
        <div class="modalBox">
            <h2>기말고사 점수 입력</h2>
            <form method="post" action="">
                <input class="scoreInput" type="text" placeholder="점수를 입력해주세요.">
                <input class="submitBtn" type="submit" value="입력하기">
            </form>
            <a href="#">닫기</a>
        </div>
    </div>
</div>
<div id="modal3">
    <div class="modalwrap">
        <div class="modalBox">
            <h2>마무리시험 점수 입력</h2>
            <form method="post" action="">
                <input class="scoreInput" type="text" placeholder="점수를 입력해주세요.">
                <input class="submitBtn" type="submit" value="입력하기">
            </form>
            <a href="#">닫기</a>
        </div>
    </div>
</div>
<div id="modal4">
    <div class="modalwrap">
        <div class="modalBox2">
            <h2>학생 평가 상세보기</h2>
            <p>별점 : 3/5점</p>
            <textarea placeholder="입력된 후기가 없습니다." readonly></textarea>
            <a href="#">닫기</a>
        </div>
    </div>
</div>
<div id="scoreEdit1">
    <div class="modalwrap">
        <div class="modalBox">
            <h2>중간고사 점수수정</h2>
            <form method="post" action="">
                <input class="scoreInput" type="text" placeholder="점수를 입력해주세요.">
                <input class="submitBtn" type="submit" value="입력하기">
            </form>
            <a href="#">닫기</a>
        </div>
    </div>
</div>
<div id="scoreEdit2">
    <div class="modalwrap">
        <div class="modalBox">
            <h2>기말고사 점수수정</h2>
            <form method="post" action="">
                <input class="scoreInput" type="text" placeholder="점수를 입력해주세요.">
                <input class="submitBtn" type="submit" value="입력하기">
            </form>
            <a href="#">닫기</a>
        </div>
    </div>
</div>
<div id="scoreEdit3">
    <div class="modalwrap">
        <div class="modalBox">
            <h2>종합 점수 수정</h2>
            <form method="post" action="">
                <input class="scoreInput" type="text" placeholder="점수를 입력해주세요.">
                <input class="submitBtn" type="submit" value="입력하기">
            </form>
            <a href="#">닫기</a>
        </div>
    </div>
</div>
<div class="wrap">
    <div class="main">
        <div class="todayBest">
            <div class="boardBox">
                <div class="boardTit">
                    <h2>수강중인 학생</h2>
                </div>
                <div class="boardLine1">
                    <div class="tbH1">
                        <div class="tbUserId">학생 ID</div>
                        <div class="tbMidTest">중간고사</div>
                        <div class="tbLastTest">기말고사</div>
                        <div class="tbEndTest">종합 시험</div>
                        <div class="tbRegDate">수강시작일</div>
                        <div class="tbRateing">학생평가</div>
                    </div>
                    <div class="tbB1">
                        <div class="tbUserId">user01</div>
                        <div class="tbMidTest">
                            <!-- 점수 없으면 아래 a태그 화면에 출력-->
                            <a href="#modal1" class="">점수 추가</a>
                        </div>
                        <div class="tbLastTest">
                            <!-- 점수 없으면 아래 a태그 화면에 출력-->
                            <a href="#modal2">점수 추가</a>
                        </div>
                        <div class="tbEndTest"><a href="#scoreEdit3">62점</a></div>
                        <div class="tbRegDate">2025.01.03</div>
                        <div class="tbRateing"><a href="#modal4">상세보기</a></div>
                    </div>
                </div>
                <div class="paging">
                    <p>1 2 3 4 5 6</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
