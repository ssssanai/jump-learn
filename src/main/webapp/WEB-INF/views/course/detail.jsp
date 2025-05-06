<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 4.
  Time: 02:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>강좌 상세</title>
    <style>
        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        .teacher_container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        ul {
            list-style: none;
        }

        table, tr, th, td {
            border-collapse: collapse;
            border: 2px solid black;
            padding: 10px;
        }

        table {
            width: 70%;
        }

        .thumbnail {
            width: 300px;
            height: 200px;
        }

        .video_detail {
            border: 1px dashed green;
            padding: 15px;
        }

        .class_video_list_container {
            display: flex;
            align-items: center;
            justify-content: center;
            width: 100%;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>${classDetailDTO.class_title}</h1>
    <table>
        <tr>
            <td>
                <span>강사: ${classDetailDTO.teacher_name}</span>
                <span>학습수준: ${classDetailDTO.class_target}</span>
                <span>과목: ${classDetailDTO.class_category}</span>
                <span>강의 수: ${classDetailDTO.total_video_count}</span>
            </td>
            <td>${classDetailDTO.class_title}</td>
        </tr>
        <tr>
            <td class="thumbnail" rowspan="3">
                <c:if test="class_file_path != null and class_file_name != null and class_file_ext != null"
                      var="isFileExist">
                    ${class_file_path}/${class_file_name}.${class_file_ext}
                </c:if>
                <c:if test="${not isFileExist}">
                    썸네일 없음
                </c:if>
            </td>
            <td>${classDetailDTO.class_introduce}</td>
        </tr>
        <tr>
            <td>강의 가격: ${classDetailDTO.class_price} 원</td>
        </tr>
        <tr>
            <td>
                <button>구매하기</button>
                <button>찜 하기</button>
            </td>
        </tr>
    </table>
    <div class="teacher_container">
        <h2>강사 소개</h2>
        <ul>
            <li><h3>${classDetailDTO.teacher_name}</h3></li>
            <li>${classDetailDTO.teacher_file_path}/${teacher_file_name}.${teacher_file_ext}</li>
            <li>${classDetailDTO.teacher_introduce1}</li>
            <li>${classDetailDTO.teacher_introduce2}</li>
            <li>${classDetailDTO.teacher_introduce3}</li>
        </ul>
        <div>
            <button>수강후기</button>
            <button>강사 상세</button>
            <button>질문하기</button>
        </div>
    </div>
    <div class="class_video_list_container">
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
