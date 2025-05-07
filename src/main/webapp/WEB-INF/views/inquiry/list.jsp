<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 7.
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<html>
<head>
    <title>Title</title>
    <style>
        table, tr, td, th {
            border: 2px solid gray;
            padding: 15px;
        }
    </style>
</head>
<body>
<form name="frmSearch" action="">
    <select name="search_category">
        <option value="member_id">작성자</option>
        <option value="title">제목</option>
        <option value="content">내용</option>
    </select>
    <input type="text" name="search_word"/>
    <input type="submit" id="btnSubmit" value="검색"/>
</form>
<table>
    <tr>
        <th>글 번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>내용</th>
        <th>작성일</th>
        <th>수정일</th>
        <th>처리 상태</th>
        <%-- 공개 여부 확인하여 비밀글처리 --%>
    </tr>
    <c:forEach items="${dtoList}" var="i">
        <tr>
            <c:choose>
                <c:when test="${i.visibility == 1}">
                    <td><a href="/inquiry/detail/${i.inquiry_id}"> ${i.inquiry_id}</a></td>
                    <td>${i.inquiry_title}</td>
                    <td>${i.member_id}</td>
                    <td>${i.inquiry_content}</td>
                    <td>${i.inquiry_created_at}</td>
                    <td>${i.inquiry_updated_at}</td>
                    <td>${i.inquiry_status}</td>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${i.member_id == loginInfo.id}">
                            <td><a href="/inquiry/detail/${i.inquiry_id}">${i.inquiry_id}</a></td>
                            <td>${i.inquiry_title}</td>
                            <td>${i.member_id}</td>
                            <td>${i.inquiry_content}</td>
                            <td>${i.inquiry_created_at}</td>
                            <td>${i.inquiry_updated_at}</td>
                            <td>${i.inquiry_status}</td>
                        </c:when>
                        <c:otherwise>
                            <td>${i.inquiry_id}</td>
                            <td colspan="6">비밀글입니다.</td>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7">${paging}</td>
    </tr>
    <tr>
        <td colspan="7">
            <a href="/inquiry/write">글쓰기</a>
        </td>
    </tr>
</table>

</body>
</html>
