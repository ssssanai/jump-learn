<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 5. 4.
  Time: 오후 4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../../resources/static/css/study/studyDetailPage.css" rel="stylesheet" type="text/css">
    <link href="../../../resources/static/css/headerGnb2.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
    <title>JL - 선생님 정보</title>
</head>
<body>

<%--고정 헤더 파일--%>q
<%@include file="../../../resources/static/html/headerGnb.jsp"%>

<div class="wrap">
    <div class="studyTit">
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
                    <img src="../resources/static/images/memberPage/slide01.jpg" alt="강의 사진">
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
                <h2>${classDetailDTO.teacher_name}강사님을 소개합니다!</h2>
                <p>여러분들의 학습을 도와주실 선생님입니다.</p>
            </div>
            <div class="sbB3">
                <div class="teacherPro">
<%--                    ${classDetailDTO.teacher_file_path}/${teacher_file_name}.${teacher_file_ext}--%>
                    <img src="../resources/static/images/memberPage/profileEx.jpg">
                </div>
                <div class="teacherIn">
                    <p>${classDetailDTO.teacher_introduce1}
                       ${classDetailDTO.teacher_introduce2}
                       ${classDetailDTO.teacher_introduce3}</p>
                </div>
                <div class="tBtn">
                    <a htef="#">수강후기</a>
                    <a htef="#">강사 정보 </a>
                    <a htef="#">질문하기</a>
                </div>
            </div>
        </div>
    </div>
    <div class="studyBox3">
        <table>
            <tr>
                <th>커리큘럼</th>
                <th>수강후기&nbsp; 별점: ${reviewRate}</th>
            </tr>
            <tr>
                <td>
                    <c:forEach items="${videoList}" var="video">
                        <div class="video_detail">
                            <span>${video.video_order}강</span><br>
                            <span>제목: ${video.title}</span><br>
                            <span>강의 소개: ${video.content}</span><br>
                            <span>업로드 날짜: ${video.created_at}</span>
                        </div>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${reviewList}" var="review">
                        <div class="review_detail">
                            <span>제목: ${review.member_id}</span><br>
                            <span>강의 소개: ${review.review} &nbsp;&nbsp;&nbsp;&nbsp;별점: ${review.feedback_score}</span><br>
                            <span>작성 날짜: ${review.feedback_score}</span>
                        </div>
                    </c:forEach>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
