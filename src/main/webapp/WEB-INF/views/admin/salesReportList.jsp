<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-10
  Time: 오후 3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../../../resources/static/css/admin/memberListStyle.css" rel="stylesheet" type="text/css">
    <title>강좌 매출 조회</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<h2>강좌 매출 조회</h2>
<a href="/admin/salesList?Sorting=desc"><button>총 판매액 내림차순</button></a>
<a href="/admin/salesList?Sorting=asc"><button>총 판매액 오름차순</button></a>
<a href="/admin/category_chart"><button>과목 별 총 매출</button></a>
<table>
    <thead>
    <tr>
        <th>강좌 ID</th>
        <th>강좌 제목</th>
        <th>강좌 선생님</th>
        <th>강좌 타겟 층</th>
        <th>강좌 유형</th>
        <th>강좌 금액</th>
        <th>총 판매개수</th>
        <th>총 판매액</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${dtoList}">
        <tr>
            <td>${list.class_id}</td>
            <td>${list.class_name}</td>
            <td>${list.teacher_name}</td>
            <td>${list.class_target}</td>
            <td>${list.class_category}</td>
            <td>${list.class_cost}</td>
            <td>${list.class_total_count}</td>
            <td>${list.class_total_cost}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
