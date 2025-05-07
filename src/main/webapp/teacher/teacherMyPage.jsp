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
    <link href="../resources/static/css/teacher/teacherMyPage.css" rel="stylesheet" type="text/css">
    <link href="../resources/static/css/headerGnb1.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>JL - 강사 마이 페이지</title>
</head>
<body>

<%--고정 헤더 파일--%>
<%@include file="../resources/static/html/tcheaderGnb.jsp"%>

<div class="wrap">
    <div class="aside">
        <div class="myInfo2">
            <div class="myInfoHead2">
                <h2>Q&A 답변하기</h2>
            </div>
            <div class="myInfoBody1">
                <div class="testScore">
                    <div class="tsHead">
                        <h2>국어</h2>
                    </div>
                    <div class="tsBody">
                        <div class="testTitle">
                            <h2>질문제목입니다!</h2>
                        </div>
                        <div class="testSc">
                            <a href="#">답변하기</a>
                        </div>
                    </div>
                </div>
                <div class="testScore">
                    <div class="tsHead">
                        <h2>국어</h2>
                    </div>
                    <div class="tsBody">
                        <div class="testTitle">
                            <h2>질문제목입니다!</h2>
                        </div>
                        <div class="testSc">
                            <a href="#">답변하기</a>
                        </div>
                    </div>
                </div>
                <div class="testScore">
                    <div class="tsHead">
                        <h2>국어</h2>
                    </div>
                    <div class="tsBody">
                        <div class="testTitle">
                            <h2>질문제목입니다!</h2>
                        </div>
                        <div class="testSc">
                            <a href="#">답변하기</a>
                        </div>
                    </div>
                </div>
                <div class="testScore">
                    <div class="tsHead">
                        <h2>국어</h2>
                    </div>
                    <div class="tsBody">
                        <div class="testTitle">
                            <h2>질문제목입니다!</h2>
                        </div>
                        <div class="testSc">
                            <a href="#">답변하기</a>
                        </div>
                    </div>
                </div>
                <div class="testScore">
                    <div class="tsHead">
                        <h2>국어</h2>
                    </div>
                    <div class="tsBody">
                        <div class="testTitle">
                            <h2>질문제목입니다!</h2>
                        </div>
                        <div class="testSc">
                            <a href="#">답변하기</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="myInfo3">
            <a href="#">자료실 가기</a>
        </div>
    </div>
    <div class="main">
        <div class="userInfo">
            <div class="userInfoTit">
                <h2>기본정보</h2>
            </div>
            <div class="userInfoCont">
                <div class="userProfile">
                    <div class="radiusProfile2">
                        <img src="../resources/static/images/teacherPage/profileEx.jpg" alt="프로필 이미지">
                    </div>
                </div>
                <div class="userInfoP">
                    <table class="userTable">
                        <tr>
                            <td class="lfTd">아이디</td>
                            <td class="rtTd">test1234</td>
                        </tr>
                        <tr>
                            <td class="lfTd">비밀번호</td>
                            <td class="rtTd">a1234123!</td>
                        </tr>
                        <tr>
                            <td class="lfTd">이름</td>
                            <td class="rtTd">홍길동</td>
                        </tr>
                        <tr>
                            <td class="lfTd">생일</td>
                            <td class="rtTd">2005.01.03</td>
                        </tr>
                        <tr>
                            <td class="lfTd">이메일</td>
                            <td class="rtTd">test1234@naver.com</td>
                        </tr>
                        <tr>
                            <td class="lfTd">성별</td>
                            <td class="rtTd">남자</td>
                        </tr>
                    </table>
                    <div class="tbA">
                        <a href="#">강사정보수정</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="todayBest">
            <div class="boardBox">
                <div class="boardTit">
                    <h2>커뮤니티</h2>
                </div>
                <div class="boardLine1">
                    <h2>수강후기 / 최근 10개</h2>
                    <a href="#">더보기</a>
                    <table>
                        <tr class="tbH1">
                            <th class="tbNo"><p>번호</p></th>
                            <th class="tbTit">제목</th>
                            <th class="tbName">작성자</th>
                            <th class="tbDate">작성일</th>
                            <th class="tbView">좋아요</th>
                        </tr>
                        <tr class="tbB1">
                            <td class="tbNo">1</td>
                            <td class="tbTit"><a href="#">가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창</a></td>
                            <td class="tbName">홍길동</td>
                            <td class="tbDate">2025.05.01</td>
                            <td class="tbView">2341</td>
                        </tr>
                        <tr class="tbB1">
                            <td class="tbNo">1</td>
                            <td class="tbTit"><a href="#">가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창</a></td>
                            <td class="tbName">홍길동</td>
                            <td class="tbDate">2025.05.01</td>
                            <td class="tbView">2341</td>
                        </tr>
                        <tr class="tbB1">
                            <td class="tbNo">1</td>
                            <td class="tbTit"><a href="#">가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창</a></td>
                            <td class="tbName">홍길동</td>
                            <td class="tbDate">2025.05.01</td>
                            <td class="tbView">2341</td>
                        </tr>
                        <tr class="tbB1">
                            <td class="tbNo">1</td>
                            <td class="tbTit"><a href="#">가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창</a></td>
                            <td class="tbName">홍길동</td>
                            <td class="tbDate">2025.05.01</td>
                            <td class="tbView">2341</td>
                        </tr>
                        <tr class="tbB1">
                            <td class="tbNo">1</td>
                            <td class="tbTit"><a href="#">가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창</a></td>
                            <td class="tbName">홍길동</td>
                            <td class="tbDate">2025.05.01</td>
                            <td class="tbView">2341</td>
                        </tr>
                        <tr class="tbB1">
                            <td class="tbNo">1</td>
                            <td class="tbTit"><a href="#">가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창</a></td>
                            <td class="tbName">홍길동</td>
                            <td class="tbDate">2025.05.01</td>
                            <td class="tbView">2341</td>
                        </tr>
                        <tr class="tbB1">
                            <td class="tbNo">1</td>
                            <td class="tbTit"><a href="#">가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창가나다라마다바사자창창</a></td>
                            <td class="tbName">홍길동</td>
                            <td class="tbDate">2025.05.01</td>
                            <td class="tbView">2341</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
