<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-08
  Time: 오전 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link href="../../../resources/static/css/admin/ClassStyle.css" rel="stylesheet" type="text/css">
  <title>강좌 조회</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<div id="AdminInfo">
  <span>${loginInfo.status == 1 ? '슈퍼관리자' : (loginInfo.status == 2 ? '중간 관리자' : (loginInfo.status == 3 ? '말단 관리자' : ''))}</span>
  <span>${loginInfo.name}</span>
</div>
<h1>강좌 조회</h1>
<div id="total">
<%--  총 강좌 : ${pageInfo.total_count} 개--%>
  <button>
    <a href="/admin/class_video_create?class_id=${class_id}" class="button-link">강의 추가(내부)</a>
  </button>
  <button>
    <a href="/admin/class_video_create1?class_id=${class_id}" class="button-link">강의 추가(외부)</a>
  </button>
</div>
<table id="list">
  <thead>
  <tr>
    <th>강의 순서</th>
    <th>선생님 아이디</th>
    <th>강의 제목</th>
    <th>강의 영상(내부)</th>
    <th>강의 영상(외부)</th>
    <th>강의 자료</th>
    <th>강의 생성 일자</th>
    <th>강의 수정 일자</th>
    <th>강의 자료 추가</th>
    <th>강의 자료 수정</th>
    <th>강의 삭제</th>
  </tr>
  </thead>
  <tbody>
  <c:choose>
    <c:when test="${not empty dtoList}">
      <c:forEach var="list" items="${dtoList}" varStatus="loop">
        <tr>
          <td><a href="admin/class_video_update?video_id=?${list.id}">${list.video_order}</a></td>
          <td>${list.teacher_id}</td>
          <td>${list.title}</td>
          <td>
            <c:choose>
              <c:when test="${not empty list.video_name}">
                <a href="/upload/${list.video_name}" target="_blank">${list.video_name}</a>
              </c:when>
              <c:otherwise>
                X
              </c:otherwise>
            </c:choose>
          </td>
          <td>
            <c:choose>
              <c:when test="${not empty list.video_url}">
                <a href="${list.video_url}" target="_blank">외부 영상</a>
              </c:when>
              <c:otherwise>
                X
              </c:otherwise>
            </c:choose>
          </td>
          <td>
            <c:choose>
              <c:when test="${not empty list.data_name}">
                <a href="/upload/${list.data_name}" target="_blank">${list.data_name}</a>
              </c:when>
              <c:otherwise>
                X
              </c:otherwise>
            </c:choose>
          </td>
          <td>${list.created_at}</td>
          <td>${list.updated_at}</td>
          <td>
            <button>
              <a href="/admin/class_data_create?class_id=${list.class_id}&order=${list.video_order}" class="button-link">자료 추가</a>
            </button>
          </td>
          <td>
            <button>
              <c:choose>
                <c:when test="${not empty list.data_name}">
                  <a href="/admin/class_data_update?data_id=${list.data_id}" class="button-link">자료 수정</a>
                </c:when>
                <c:otherwise>
                  X
                </c:otherwise>
              </c:choose>
            </button>
          </td>
          <td>
            <button>
              <a href="/admin/class_video_delete?movie_id=${list.id}"
                 class="button-link"
                 onclick="return checkDataName('${list.data_name}');">
                삭제
              </a>
            </button>
          </td>
        </tr>
      </c:forEach>
    </c:when>
    <c:otherwise>
      <tr>
        <td colspan="10">강좌 정보가 없습니다.</td>
      </tr>
    </c:otherwise>
  </c:choose>
  </tbody>
</table>
<script>
  function checkDataName(dataName) {
    if (!dataName) {
      return true;
    }
    alert('강의 자료를 먼저 삭제하신 후 진행해주세요.');
    return false;
  }
</script>
</body>
</html>
