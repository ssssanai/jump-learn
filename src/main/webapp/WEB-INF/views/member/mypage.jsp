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
    <link href="/resources/static/css/member/memberMyPage.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb1.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
    <title>JL - 마이페이지</title>
</head>
<body>

<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/headerGnb.jsp"%>

<div class="wrap">
    <div class="aside">
        <div class="myInfo1">
            <div class="myInfoHead1">
                <div class="radiusProfile">
                    <img src="../resources/static/images/memberPage/profileEx.jpg" alt="프로필 이미지">
                </div>
                <div class="myInfop">
                    <p>회원등급  ??</p>
                    <h2>환영합니다 OOO님!</h2>
                </div>
            </div>
            <div class="logoutBtn">
                <a href="#">로그아웃</a>
                <a href="#">회원탈퇴</a>
            </div>
            <div class="myInfoMenu">
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox"><i class="fa-solid fa-pen"></i></div>
                    </div>
                    <div class="infoMenuBody">
                        <a href="#" class="noCnt">내 게시물</a>
                    </div>
                </div>
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox"><i class="fa-solid fa-cart-shopping"></i></div>
                    </div>
                    <div class="infoMenuBody">
                        <a href="#" class="cnt1">장바구니</a>
                        <a href="#" class="cnt2">3</a>
                    </div>
                </div>
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox"><i class="fa-solid fa-bookmark"></i></div>
                    </div>
                    <div class="infoMenuBody">
                        <a href="#" class="cnt1">찜 목록</a>
                        <a href="#" class="cnt2">10</a>
                    </div>

                </div>
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox"><i class="fa-solid fa-credit-card"></i></div>
                    </div>
                    <div class="infoMenuBody">
                        <a href="#" class="noCnt">결제내역</a>
                    </div>

                </div>
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox"><i class="fa-solid fa-headset"></i></div>
                    </div>
                    <div class="infoMenuBody">
                        <a href="#" class="noCnt">1:1 문의</a>
                    </div>

                </div>
            </div>
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
                        <img src="../resources/static/images/memberPage/profileEx.jpg" alt="프로필 이미지">
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
                        <a href="#">회원정보수정</a>
                        <a href="#">회원탈퇴</a>
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
                    <h2>자유게시판</h2>
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
                    </table>
                </div>
                <div class="boardLine2">
                    <div class="boards bs1">
                        <h2>공지사항</h2>
                        <a href="#">더보기</a>
                        <table>
                            <tr class="tbH2">
                                <th class="tbNo1">번호</th>
                                <th class="tbTit1">제목</th>
                                <th class="tbDate1">작성일</th>
                            </tr>
                            <tr class="tbB2">
                                <td class="tbNo1">1</td>
                                <td class="tbTit1"><a href="#" class="tbTitP">제목입니다 테스트ddd</a></td>
                                <td class="tbDate1">2025.05.01</td>
                            </tr>
                        </table>
                    </div>
                    <div class="boards bs2">
                        <h2>교육 정보 게시판</h2>
                        <a href="#">더보기</a>
                        <table>
                            <tr class="tbH2">
                                <th class="tbNo1">번호</th>
                                <th class="tbTit1">제목</th>
                                <th class="tbName1">작성자</th>
                                <th class="tbDate1">작성일</th>
                            </tr>
                            <tr class="tbB2">
                                <td class="tbNo1">1</td>
                                <td class="tbTit1"><a href="#" class="tbTitP">제목입니다 테스트ddd</a></td>
                                <td class="tbName1">홍길동</td>
                                <td class="tbDate1">2025.05.01</td>
                            </tr>
                        </table>
                    </div>
                    <div class="boards bs3">
                        <h2>대입 정보 게시판</h2>
                        <a href="#">더보기</a>
                        <table>
                            <tr class="tbH2">
                                <th class="tbNo1">번호</th>
                                <th class="tbTit1">제목</th>
                                <th class="tbName1">작성자</th>
                                <th class="tbDate1">작성일</th>
                            </tr>
                            <tr class="tbB2">
                                <td class="tbNo1">1</td>
                                <td class="tbTit1"><a href="#" class="tbTitP">제목입니다 테스트ddd</a></td>
                                <td class="tbName1">홍길동</td>
                                <td class="tbDate1">2025.05.01</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="boardLine2">
                    <div class="boards bs1">
                        <h2>대외활동 게시판</h2>
                        <a href="#">더보기</a>
                        <table>
                            <tr class="tbH2">
                                <th class="tbNo1">번호</th>
                                <th class="tbTit1">제목</th>
                                <th class="tbDate1">작성일</th>
                            </tr>
                            <tr class="tbB2">
                                <td class="tbNo1">1</td>
                                <td class="tbTit1"><a href="#" class="tbTitP">제목입니다 테스트ddd</a></td>
                                <td class="tbDate1">2025.05.01</td>
                            </tr>
                        </table>
                    </div>
                    <div class="boards bs2">
                        <h2>자료실 게시판</h2>
                        <a href="#">더보기</a>
                        <table>
                            <tr class="tbH2">
                                <th class="tbNo1">번호</th>
                                <th class="tbTit1">제목</th>
                                <th class="tbName1">작성자</th>
                                <th class="tbDate1">작성일</th>
                            </tr>
                            <tr class="tbB2">
                                <td class="tbNo1">1</td>
                                <td class="tbTit1"><a href="#" class="tbTitP">제목입니다 테스트ddd</a></td>
                                <td class="tbName1">홍길동</td>
                                <td class="tbDate1">2025.05.01</td>
                            </tr>
                        </table>
                    </div>
                    <div class="boards bs3">
                        <h2>뉴스 게시판</h2>
                        <a href="#">더보기</a>
                        <table>
                            <tr class="tbH2">
                                <th class="tbNo1">번호</th>
                                <th class="tbTit1">제목</th>
                                <th class="tbName1">작성자</th>
                                <th class="tbDate1">작성일</th>
                            </tr>
                            <tr class="tbB2">
                                <td class="tbNo1">1</td>
                                <td class="tbTit1"><p class="tbTitP">제목입니다 테스트ddd</p></td>
                                <td class="tbName1">홍길동</td>
                                <td class="tbDate1">2025.05.01</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>