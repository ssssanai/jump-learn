<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-05-15
  Time: 오전 6:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/resources/static/css/postUpdateFile.css" rel="stylesheet" type="text/css">
    <title>이미지 수정</title>
</head>
<body>
<%@ include file="../../../resources/static/html/adminMsg.jsp"%>
<div class="board-container">
    <p class="title">이미지 첨부 (최대 5개)</p><br><br><br>
    <p class="title">기존 이미지(${fileCount} 개)</p><br>
    <!-- 이미지 목록 -->
    <div class="image-container">
        <c:choose>
            <c:when test="${not empty fileList}">
                <c:forEach var="list" items="${fileList}">
                    <div class="image-box">
                        <img src="/upload/${list.fileName}" alt="이미지">
                        <form action="/post/deleteFile" method="post" class="delete-form">
                            <input type="hidden" name="file_id" value="${list.id}">
                            <input type="hidden" name="id" value="${id}">
                            <button type="submit">&times;</button>
                        </form>
                    </div>
                </c:forEach>
            </c:when>
        </c:choose>
    </div>

    <!-- 이미지 추가 -->
    <form action="/post/updateFile" method="post" enctype="multipart/form-data" class="upload-form">
        <p class="title">추가 이미지(${5-Integer.parseInt(fileCount)}개 추가 가능)</p><br>
        <input type="file" id="file1" name="file" multiple accept=".png, .jpg, .jpeg">
        <div id="contentError1" class="error"></div>
        <input type="hidden" name="id" value="${id}">
        <button type="submit" class="submit-btn">수정 완료</button>
        <a href="/post/view?id=${id}"><button type="button" class="submit-btn">뒤로 가기</button></a>
    </form>
</div>
<script>
    document.getElementById('file1').addEventListener('change', function (event) {
        const selectedFiles = event.target.files;
        const fileCount = parseInt("${fileCount}");
        const maxFiles = 5 - fileCount;

        if (selectedFiles.length > maxFiles) {
            document.getElementById('contentError1').innerText =
                `이미 ${fileCount}개의 이미지가 등록되어 있습니다. 최대 ${5-Integer.parseInt(fileCount)}개만 추가할 수 있습니다.`;

            event.target.value = "";
        } else {
            document.getElementById('contentError1').innerText = "";
        }
    });
</script>
</body>
</html>
