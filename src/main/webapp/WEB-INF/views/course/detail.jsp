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
                <c:if test="class_file_path != null and class_file_name != null and class_file_ext != null"
                      var="isFileExist">
                    ${class_file_path}/${class_file_name}.${class_file_ext}
                </c:if>
                <c:if test="${not isFileExist}">
                    <img src="/resources/static/images/memberPage/slide01.jpg" alt="강의 사진">
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
            <div class="price">
                <p class="priCnt1" style="font-size: 13px; line-height: 28px;">총 강의 가격</p>
                <p class="priCnt2" style="font-size: 17px; line-height: 28px;">${classDetailDTO.class_price}</p>
                <p class="priCnt3" style="font-size: 13px; line-height: 28px;">원</p>
            </div>
            <div class="buyBtn">
                <a href="#">구매하기</a>
                <a href="#">찜 하기</a>
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
                    <%--${classDetailDTO.teacher_file_path}/${teacher_file_name}.${teacher_file_ext}--%>
                    <img src="../../../resources/static/images/memberPage/profileEx.jpg">
                </div>
                <div class="teacherIn">
                    <p>${classDetailDTO.teacher_introduce1}<br>
                        ${classDetailDTO.teacher_introduce2}<br>
                        ${classDetailDTO.teacher_introduce3}</p>
                </div>
                <div class="tBtn">
                    <a htef="#">강좌 공지사항</a>
                </div>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="studyBox3">
            <h2>강좌</h2>
            <div class="reviewList1">
                <p class="studyNo1">강좌 수</p>
                <p class="studyTit1">제목</p>
                <p class="studyContent1">강좌 내용</p>
                <p class="studyUploadDate1">업로드날짜</p>
            </div>
            <div class="reviewListBox">
                <c:forEach items="${videoList}" var="video">
                    <div class="reviewList2">
                        <p class="studyNo2">${video.video_order}강</p>
                        <p class="studyTit2">${video.title}</p>
                        <p class="studyContent2">${video.content}</p>
                        <p class="studyUploadDate2">${video.created_at}</p>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="studyBox3">
            <h2>작성된 후기</h2>
            <div class="reviewList1">
                <p class="studyContent4">학생 ID</p>
                <p class="studyTit4">후기</p>
                <p class="studyNo4">별점</p>
            </div>
            <div class="reviewListBox">
                <c:forEach items="${reviewList}" var="review">
                    <div class="reviewList2">
                        <p class="studyContent3">${review.member_id}</p>
                        <p class="studyTit3">${review.review}</p>
                        <p class="studyNo3"> ${review.feedback_score}</p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

<%--입력된 후기가 없을시--%>

    <div class="reviewBox">
        <h2>후기작성</h2>
        <form action="" method="">
            <div class="review1">
                <h2>별점 입력</h2>
                <p class="reviewComment">1 ~ 5점까지 입력가능합니다.</p>
                <input type="number" min="1" max="5" step="1" value="별점 1~5점">
            </div>
            <div class="review2">
                <h2>후기 입력</h2>
                <p class="reviewComment">최대 255자까지 입력 가능합니다.</p>
                <textarea type="text" name="" placeholder="후기를 작성하세요." maxlength="255"></textarea>
            </div>
            <input type="submit" name="" class="reviewBtn" value="후기작성">
        </form>
    </div>
</div>
</body>
</html>
