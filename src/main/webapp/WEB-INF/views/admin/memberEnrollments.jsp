<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-07
  Time: 오후 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link href="../../../resources/static/css/admin/memberListStyle.css" rel="stylesheet" type="text/css">
  <title>강좌 조회</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<h1>${id}님의 강좌 조회</h1>
<table id="list">
  <thead>
  <tr>
    <th>순서</th>
    <th>수강 아이디</th>
    <th>구매 아이디</th>
    <th>강좌 아이디</th>
    <th>진척도</th>
    <th>후기</th>
    <th>성적</th>
  </tr>
  </thead>
  <tbody>
  <c:choose>
    <c:when test="${not empty dtoList}">
      <c:forEach var="list" items="${dtoList}" varStatus="loop">
        <tr>
          <td>${loop.index + 1}</td>
          <td>${list.id}</td>
          <td>${list.pay_id}</td>
          <td>${list.class_id}</td>
          <td>${list.progress}</td>
          <td>
            <c:choose>
              <c:when test="${not empty list.review}">
                <a href="#" onclick="openReviewWindow('${list.review}','${list.feedback_score}')">상세보기</a>
              </c:when>
              <c:otherwise>
                X
              </c:otherwise>
            </c:choose>
          </td>
          <td>
            <c:choose>
              <c:when test="${not empty list.midterm_score}">
                <a href="#" onclick="openScoreWindow('${list.midterm_score}','${list.final_score}','${list.final_grade_score}')">성적보기</a>
              </c:when>
              <c:otherwise>
                성적X
              </c:otherwise>
            </c:choose>
          </td>
        </tr>
      </c:forEach>
    </c:when>
    <c:otherwise>
      <tr>
        <td colspan="8">구매 정보가 없습니다.</td>
      </tr>
    </c:otherwise>
  </c:choose>
  </tbody>
</table>
<script>
  function openReviewWindow(reviewContent, score) {
    const popup = window.open('', '_blank', 'width=400,height=300');
    popup.document.write('<h2>리뷰 상세</h2>' +
                          '<p>'+score+'</p>' +
                          '<p>' + reviewContent + '</p>');
  }

  function openScoreWindow(score1, score2,score3) {
    const popup = window.open('', '_blank', 'width=500,height=400');
    popup.document.write('<h2>점수 상세</h2>' +
                          '<span>중간 점수 : </span>'+'<sapn>'+score1+'</sapn>'+'<br/>'+
                          '<span>기말 점수 : </span>'+'<sapn>'+score2+'</sapn>'+'<br/>'+
                          '<span>총합 점수 : </span>'+'<sapn>'+score3+'</sapn>');
  }
</script>
</body>
