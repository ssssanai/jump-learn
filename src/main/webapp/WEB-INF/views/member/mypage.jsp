<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 5. 4.
  Time: 오후 4:34
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/member/memberMyPage.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb1.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
    <script src="/resources/static/js/checkModule.js"></script>
    <title>JL - 마이페이지</title>
</head>
<body>

<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/memberGnb.jsp" %>

<div class="wrap">
    <div class="aside">
        <div class="myInfo1">
            <div class="myInfoHead1">
                <div class="radiusProfile">
                    <c:choose>
                        <c:when test="${not empty member.file_name}">
                            <img src="/upload/${member.file_name}" alt="기본 이미지">
                        </c:when>
                        <c:otherwise>
                            <img src="/resources/static/images/notProfile.jpg" alt="기본 이미지">
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="myInfop">
                    <p>회원등급  ${loginInfo.status}</p>
                    <h2>환영합니다 ${member.name}</h2>
                </div>
            </div>
            <div class="myInfoMenu">
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox"><i class="fa-solid fa-pen"></i></div>
                    </div>
                    <div class="infoMenuBody">
                        <a href="/studyroom/post" class="noCnt">내 게시물</a>
                    </div>
                </div>
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox"><i class="fa-solid fa-cart-shopping"></i></div>
                    </div>
                    <div class="infoMenuBody">
                        <a href="/course/list" class="cnt1">장바구니</a>
                    </div>
                </div>
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox"><i class="fa-solid fa-credit-card"></i></div>
                    </div>
                    <div class="infoMenuBody">
                        <a href="/pay/list" class="noCnt">결제내역</a>
                    </div>

                </div>
                <div class="infoMenu">
                    <div class="infoMenuHead">
                        <div class="menuBox"><i class="fa-solid fa-headset"></i></div>
                    </div>
                    <div class="infoMenuBody">
                        <a href="/inquiry/list" class="noCnt">1:1 문의</a>
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
                        <c:choose>
                            <c:when test="${not empty member.file_name}">
                                <img src="/upload/${member.file_name}" alt="기본 이미지">
                            </c:when>
                            <c:otherwise>
                                <img src="/resources/static/images/notProfile.jpg" alt="기본 이미지">
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="userInfoP">
                    <table class="userTable">
                        <tr>
                            <td class="lfTd">아이디</td>
                            <td class="rtTd">${member.id}</td>
                        </tr>
                        <tr>
                            <td class="lfTd">이름</td>
                            <td class="rtTd">${member.name}</td>
                        </tr>
                        <tr>
                            <td class="lfTd">생일</td>
                            <td class="rtTd">${member.birth}</td>
                        </tr>
                        <tr>
                            <td class="lfTd">이메일</td>
                            <td class="rtTd">${member.email}</td>
                        </tr>
                        <tr>
                            <td class="lfTd">성별</td>
                            <td class="rtTd">${member.gender}</td>
                        </tr>
                    </table>
                    <div class="tbA">
                        <a href="/member/ChangeInfo?id=${member.id}">회원정보수정</a>
                        <a href="/member/delete?id=${member.id}">회원탈퇴</a>
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
                    <a href="/post/searchListPage">더보기</a>
                    <table>
                        <tr class="tbH1">
                            <th class="tbNo"><p>번호</p></th>
                            <th class="tbTit">제목</th>
                            <th class="tbName">작성자</th>
                            <th class="tbDate">작성일</th>
                            <th class="tbView">조회수</th>
                        </tr>
                        <tr class="tbB1">
                            <c:choose>
                                <c:when test="${not empty post.id}">
                                    <td class="tbNo">${post.id}</td>
                                    <td class="tbTit"><a href="/post/view?id=${post.id}">${post.title}</a></td>
                                    <td class="tbName">${post.member_id.length() >= 3 ? post.member_id.substring(0, 3).concat("...") : post.member_id}</td>
                                    <td class="tbDate">${post.created_at}</td>
                                    <td class="tbView">${post.view_count}</td>
                                </c:when>
                                <c:otherwise>
                                    <td colspan="5">추천 게시물이 없습니다.</td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </table>
                </div>
                <div class="boardLine2">
                    <div class="boards bs1">
                        <h2>공지사항</h2>
                        <a href="/notice/searchListPage">더보기</a>
                        <table>
                            <tr class="tbH2">
                                <th class="tbNo1">번호</th>
                                <th class="tbTit1">제목</th>
                                <th class="tbName1">작성자</th>
                            </tr>
                            <tr class="tbB2">
                                <c:choose>
                                    <c:when test="${not empty noticeDTO}">
                                        <td class="tbNo1">${noticeDTO.id}</td>
                                        <td class="tbTit1"><p class="tbTitP">
                                                ${noticeDTO.title.length() >= 10 ? noticeDTO.title.substring(0, 10).concat("...") : noticeDTO.title}
                                        </p></td>
                                        <td class="tbName1">${noticeDTO.admin_id}</td>
                                        <td class="tbDate1">${noticeDTO.created_at}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td colspan="3">추천 게시물이 없습니다.</td>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </table>
                    </div>
                    <div class="boards bs2">
                        <h2>교육 정보 게시판</h2>
                        <a href="/edu/searchListPage">더보기</a>
                        <table>
                            <tr class="tbH2">
                                <th class="tbNo1">번호</th>
                                <th class="tbTit1">제목</th>
                                <th class="tbName1">작성자</th>
                                <th class="tbDate1">작성일</th>
                            </tr>
                            <tr class="tbB2">
                                <c:choose>
                                    <c:when test="${not empty eduDTO}">
                                        <td class="tbNo1">${eduDTO.id}</td>
                                        <td class="tbTit1"><p class="tbTitP">${eduDTO.title.length() >= 10 ? eduDTO.title.substring(0, 10).concat("...") : eduDTO.title}</p></td>
                                        <td class="tbName1">${eduDTO.admin_id}</td>
                                        <td class="tbDate1">${eduDTO.created_at}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td colspan="4">추천 게시물이 없습니다.</td>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </table>
                    </div>
                    <div class="boards bs3">
                        <h2>대입 정보 게시판</h2>
                        <a href="/info/searchListPage">더보기</a>
                        <table>
                            <tr class="tbH2">
                                <th class="tbNo1">번호</th>
                                <th class="tbTit1">제목</th>
                                <th class="tbName1">작성자</th>
                                <th class="tbDate1">작성일</th>
                            </tr>
                            <tr class="tbB2">
                                <c:choose>
                                    <c:when test="${not empty libDTO}">
                                        <td class="tbNo1">${infoDTO.id}</td>
                                        <td class="tbTit1"><p class="tbTitP">${infoDTO.title.length() >= 10 ? infoDTO.title.substring(0, 10).concat("...") : infoDTO.title}</p></td>
                                        <td class="tbName1">${infoDTO.admin_id}</td>
                                        <td class="tbDate1">${infoDTO.created_at}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td colspan="4">추천 게시물이 없습니다.</td>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="boardLine2">
                    <div class="boards bs1">
                        <h2>대외활동 게시판</h2>
                        <a href="/activity/searchListPage">더보기</a>
                        <table>
                            <tr class="tbH2">
                                <th class="tbNo1">번호</th>
                                <th class="tbTit1">제목</th>
                                <th class="tbName1">작성자</th>
                            </tr>
                            <tr class="tbB2">
                                <c:choose>
                                    <c:when test="${not empty activityDTO}">
                                        <td class="tbNo1">${activityDTO.id}</td>
                                        <td class="tbTit1"><p class="tbTitP">${activityDTO.title.length() >= 10 ? activityDTO.title.substring(0, 10).concat("...") : activityDTO.title}</p></td>
                                        <td class="tbName1">${activityDTO.admin_id}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td colspan="3">추천 게시물이 없습니다.</td>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </table>
                    </div>
                    <div class="boards bs2">
                        <h2>자료실 게시판</h2>
                        <a href="/lib/searchListPage">더보기</a>
                        <table>
                            <tr class="tbH2">
                                <th class="tbNo1">번호</th>
                                <th class="tbTit1">제목</th>
                                <th class="tbName1">작성자</th>
                                <th class="tbDate1">작성일</th>
                            </tr>
                            <tr class="tbB2">
                                <c:choose>
                                    <c:when test="${not empty libDTO}">
                                        <td class="tbNo1">${libDTO.id}</td>
                                        <td class="tbTit1"><p class="tbTitP">${libDTO.title.length() >= 10 ? libDTO.title.substring(0, 10).concat("...") : libDTO.title}</p></td>
                                        <td class="tbName1">${libDTO.admin_id}</td>
                                        <td class="tbDate1">${libDTO.created_at}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td colspan="4">추천 게시물이 없습니다.</td>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </table>
                    </div>
                    <div class="boards bs3">
                        <h2>뉴스 게시판</h2>
                        <a href="/news/searchListPage">더보기</a>
                        <table>
                            <tr class="tbH2">
                                <th class="tbNo1">번호</th>
                                <th class="tbTit1">제목</th>
                                <th class="tbName1">작성자</th>
                                <th class="tbDate1">작성일</th>
                            </tr>
                            <tr class="tbB2">
                                <c:choose>
                                    <c:when test="${not empty newsDTO}">
                                        <td class="tbNo1">${newsDTO.id}</td>
                                        <td class="tbTit1"><p class="tbTitP">${newsDTO.title.length() >= 10 ? newsDTO.title.substring(0, 10).concat("...") : newsDTO.title}</p></td>
                                        <td class="tbName1">${newsDTO.admin_id}</td>
                                        <td class="tbDate1">${newsDTO.created_at}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td colspan="4">추천 게시물이 없습니다.</td>
                                    </c:otherwise>
                                </c:choose>
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