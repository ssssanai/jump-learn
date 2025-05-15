<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 4.
  Time: 02:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/study/studyDetailPage.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb2.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
    <title>JL - 강좌 정보</title>
</head>
<body>
<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/memberGnb.jsp" %>
<%@include file="/resources/static/html/adminMsg.jsp" %>
<div class="wrap">
    <div class="studyTitle">
        <h1>${classDetailDTO.class_title}</h1>
    </div>
    <div class="studyBox1">
        <div class="study1">
            <div class="sbH1">
                <p>강사 : ${classDetailDTO.teacher_name}</p>
                <p>학습수준 : ${classDetailDTO.class_target}</p>
                <p>과목 : ${classDetailDTO.class_category}</p>
                <p>강의 수: ${classDetailDTO.total_video_count}</p>
            </div>
            <div class="sbB1">
                <c:if test="${classDetailDTO.class_file_name != null}" var="isFileExist">
                    <img src="/upload/${classDetailDTO.class_file_name}" alt="강좌 사진">
                </c:if>
                <c:if test="${not isFileExist}">
                    <img src="/resources/static/images/memberPage/slide01.jpg" alt="강좌 사진">
                </c:if>
            </div>
        </div>
        <div class="study2">
            <div class="sbH2">
                <h2>${classDetailDTO.class_title}</h2>
            </div>
            <div class="sbB2">
                <p>${classDetailDTO.class_introduce}</p>
            </div>
        </div>
    </div>
    <div class="studyBox2">
        <div class="studyDetail">
            <div class="sbH3">
                <h2>${classDetailDTO.teacher_name} 강사님을 소개합니다!</h2>
                <p>여러분들의 학습을 도와주실 선생님입니다.</p>
            </div>
            <div class="sbB3">
                <div class="teacherPro">
                    <c:if test="${classDetailDTO.teacher_file_name != null}" var="isFileExist">
                        <img src="/upload/${classDetailDTO.teacher_file_name}" alt="강사 프로필 사진">
                    </c:if>
                    <c:if test="${not isFileExist}">
                        <img src="/resources/static/images/notProfile.jpg" alt="강좌 사진">
                    </c:if>
                </div>
                <div class="teacherIn">
                    <p>${classDetailDTO.teacher_introduce1}<br>
                        ${classDetailDTO.teacher_introduce2}<br>
                        ${classDetailDTO.teacher_introduce3}</p>
                </div>
                <div class="tBtn">
                    <button id="btnClassNotice">강좌 공지사항</button>
                </div>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="box">
            <div class="studyBox3">
                <h2>강좌</h2>
                <div class="reviewList1">
                    <p class="studyNo1">순서</p>
                    <p class="studyTit1">제목</p>
                    <p class="studyContent1">내용</p>
                    <p class="studyUploadDate1">업로드날짜</p>
                    <p class="studyUploadDate3">강의 시청</p>
                    <p class="studyUploadDate3">강의 자료</p>
                    <p class="studyUploadDate3">공지사항</p>
                </div>
                <div class="reviewListBox">
                    <c:forEach items="${videoList}" var="video">
                        <div class="reviewList2">
                            <p class="studyNo2">${video.video_order}강</p>
                            <p class="studyTit2">${video.title}</p>
                            <p class="studyContent2">${video.content}</p>
                            <p class="studyUploadDate2">${video.created_at.toString().replace("T", " ")}</p>
                            <c:if test="${video.video_name != null}" var="isLocal">
                                <button class="btnVideoPlay" id="${video.video_name}">재생</button>
                            </c:if>
                            <c:if test="${not isLocal}">
                                <button class="btnVideoPlay" id="${video.video_url}">재생</button>
                            </c:if>
                            <c:if test="${cdList != null and cdList.size() > 0}" var="isDataExist">
                                <button class="btnDataDownload"><a href="/upload/${cdList.get(video.video_order - 1).data_name}" download="${classDetailDTO.class_title}_강의자료_${video.video_order}강.pdf">다운로드</a> </button>
                            </c:if>
                            <c:if test="${not isDataExist}">
                                <button>X</button>
                            </c:if>
                            <button class="btnVideoNotice" id="${video.notice}">공지 확인</button>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="studyBox3">
                <h2>작성된 후기</h2>
                <div class="reviewList3">
                    <p class="studyContent4">학생 ID</p>
                    <p class="studyTit4">후기</p>
                    <p class="studyNo4">별점</p>
                </div>
                <div class="reviewListBox">
                    <c:if test="${reviewList.size() > 0}" var="isReviewExist">
                        <c:forEach items="${reviewList}" var="review">
                            <div class="reviewList2">
                                <p class="studyContent3">${review.member_id}</p>
                                <p class="studyTit3">${review.review}</p>
                                <p class="studyNo3"> ${review.feedback_score}</p>
                            </div>
                        </c:forEach>
                    </c:if>
                    <c:if test="${not isReviewExist}">
                        <div class="reviewList2">
                            아직 후기가 없습니다.
                        </div>
                    </c:if>
                </div>
            </div>
            <%-- 질문 목록 (내가 한 질문만 가져오기) --%>
        </div>
        <div class="box2">

                <c:if test="${qList.size() > 0}">
                    <h3>질문</h3>
                    <c:forEach items="${qList}" var="q">
                    <div class="questionList">
                        <%--질문--%>
                        <div class="questionContent">
                            <div class="contentP">
                                <h3>${q.title}</h3>
                                <p>${q.content}</p>
                            </div>
                            <div class="contentDate">
                                <p>질문 일시:${q.created_at.toString().replace("T", " ")}</p>
                                <c:if test="${q.updated_at != null}">
                                    <p>수정 일시: ${q.updated_at.toString().replace("T", " ")}</p>
                                </c:if>
                            </div>
                        </div>
                        <%--답글--%>
                        <div class="questionContent2">
                            <c:if test="${q.quested_content != null}">
                                <div class="contentP2">
                                    <h3>${q.commenter}</h3>
                                    <p>${q.quested_content}</p>
                                </div>
                                <div class="contentDate2">
                                    <p>질문 일시:${q.quested_created_at.toString().replace("T", " ")}</p>
                                    <c:if test="${q.quested_updated_at != null}">
                                        <p>수정 일시: ${q.quested_updated_at.toString().replace("T", " ")}</p>
                                    </c:if>
                                </div>
                            </c:if>
                        </div>
                    </div>
                    </c:forEach>
                </c:if>
        </div>
        <div class="box3">
            <%-- TODO: 질문 폼 CSS 수정 --%>
            <div class="questionForm">
                <h3 class="questionFormp">질문하기</h3>
                <form class="formBox" name="class_question" action="/studyroom/class_question" method="post">
                    <input type="hidden" value="${member.id}" name="member_id"/>
                    <input type="hidden" value="${classDetailDTO.class_id}" name="class_id"/>
                    <div class="questionInputTitle">
                        <p>질문 제목 : </p><input type="text" name="title"/>
                    </div>
                    <div class="questionInputContent">
                        <p class="questionFormp">질문 내용: </p><textarea name="content"></textarea>
                    </div>
                    <input class="questionContentBtn" type="submit" value="질문 등록"/>
                </form>
            </div>
            <%--입력된 후기가 없을시--%>
            <c:if test="${not isReviewed}">
                <div class="reviewBox">
                        <%-- 후기 추가 메소드 --%>
                    <h2>별점 입력</h2>
                    <form class="reviewForm" action="/studyroom/update_review" name="review" method="post">
                        <input type="hidden" name="member_id" value="${member.id}"/>
                        <input type="hidden" name="class_id" value="${classDetailDTO.class_id}"/>
                        <div class="review1">
                            <p class="reviewComment">1 ~ 5점까지 입력가능합니다.</p>
                            <input type="number" min="1" max="5" step="1" value="5" name="feedback_score">
                        </div>
                        <div class="review2">
                            <h2>후기 입력</h2>
                            <p class="reviewComment">최대 255자까지 입력 가능합니다.</p>
                            <textarea type="text" name="review" placeholder="후기를 작성하세요." maxlength="255"></textarea>
                        </div>
                        <input type="submit" name="" class="reviewBtn" value="후기작성">
                    </form>
                </div>
            </c:if>
        </div>
        <script>
            // 강좌 공지사항
            document.getElementById('btnClassNotice').addEventListener('click', function () {
                const popup = window.open('', '_blank', 'width=500,height=400, left=100, top=200');
                popup.document.write(
                    `<h2 style="height:55px; line-height:53px; color:#333; text-align: center; border-bottom: 3px solid #d6d6d6b3;">강좌 공지사항</h2>
            <div style="height:300px; padding:0 15px; color:#333; text-align: left; border-bottom: 3px solid #d6d6d6b3;">${classDetailDTO.class_notice}</div>
            `
                );
            });
            // 강의 공지사항
            [...document.getElementsByClassName('btnVideoNotice')].forEach(function (el) {
                let notice = el.id;
                el.addEventListener('click', function () {
                    const popup = window.open('', '_blank', 'width=500,height=400, left=100, top=200');
                    popup.document.write(
                        `<div class="popupBox"><h2 style="height:55px; line-height:53px; color:#333; text-align: center; border-bottom: 3px solid #d6d6d6b3;">강의 공지사항</h2>
                <div class="body">` + notice + `</div></div>
                `
                    );
                })
            });
            // 강의 재생
            [...document.getElementsByClassName('btnVideoPlay')].forEach(function (el) {
                let video = el.id;
                el.addEventListener('click', function () {
                    const popup = window.open('', '_blank', 'width=800, height = 700');
                    if (!video.includes('http')) {
                        video = '/upload/' + video;
                        let src = `<video autoplay controls width="780" height="680" src="` + video + `"></video>`;
                        popup.document.write(src);
                    } else {
                        console.log(video);
                        window.open(video, '_blank', '');
                    }
                })
            });


        </script>
</body>
</html>
