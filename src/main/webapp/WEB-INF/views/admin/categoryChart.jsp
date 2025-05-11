<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-10
  Time: 오후 5:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .bar-container {
            display: flex;
            justify-content: space-around;
            align-items: flex-end;
            height: auto;
            min-height: 300px;
            width: 80%;
            margin: 0 auto;
            border: 1px solid #ddd;
            padding: 10px;
        }

        .bar {
            width: 30%;
            color: white;
            text-align: center;
            font-size: 16px;
            border-radius: 5px;
            transition: height 0.3s ease-in-out;
        }

        .bar:nth-child(1) {
            background-color: #f44336;
        }
        .bar:nth-child(2) {
            background-color: #2196F3;
        }
        .bar:nth-child(3) {
            background-color: #FF9800;
        }
    </style>
</head>
<body>
<%@ include file="../../../resources/static/html/adminGnb.jsp" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<h1>과목별 총 매출액 조회</h1>
<form action="/admin/category_chart_month" method="get">
    <label for="month">조회할 월:</label>
    <input type="month" id="month" name="moth" value="${month != null ? month : '2025-05'}">
    <button type="submit">조회</button>
</form>

<div class="bar-container">
    <div class="bar" style="height: ${koreanSales /10000 * 10}px;">국어 (${koreanSales}원)</div>
    <div class="bar" style="height: ${englishSales/ 10000 * 10}px;">영어 (${englishSales}원)</div>
    <div class="bar" style="height: ${mathSales/ 10000 * 10}px;">수학 (${mathSales}원)</div>
</div>
<a href="/admin/salesList"><button>뒤로가기</button></a>
</body>
</html>
