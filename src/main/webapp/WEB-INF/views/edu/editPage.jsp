<%--
  Created by IntelliJ IDEA.
  User: lsm01
  Date: 25. 5. 4.
  Time: 오후 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JL - 게시글 수정</title>
    <script src="https://kit.fontawesome.com/2d74121aef.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="wrap">
    <header>
        <div class="head_img">
            <img src="/writer_page/img/header_logo.svg">
        </div>
        <div class="head_noti">
            <p>커뮤니티 게시물 수정</p>
        </div>
    </header>
    <form method="post" action="/edu/editPage" enctype="multipart/form-data">
    <main>
        <table>
            <tr>
                <td>
                    <input type="text" name="id" id="id" value="${dto.id}" readonly>
                </td>
                <td>
                    <input type="text" name="title" id="title" value="${dto.title}" >
                </td>
                <td>
                    <input type="text" name="admin_id" id="admin_id" value="${dto.admin_id}" readonly >
                </td>
                <td>
                    <input type="text" name="created_at" id="created_at" value="${dto.created_at}" readonly >
                </td>
                <td>
                    <input type="text" name="view_count" id="view_count" value="${dto.view_count}" readonly>
                </td>
            </tr>
            <tr>
                <td colspan="5">
                    [본문 시작:
                    <c:forEach var="file" items="${fileDTO}" >
                        <c:if test="${fn:contains(file.file_ext, '.jpg') or fn:contains(file.file_ext, '.jpeg')}">
                            <img src="${file.file_path}" alt="${file.file_name}"/>
                            <br>
                        </c:if>
                    </c:forEach>
                    ${dto.content} :본문 끝]
                </td>
            </tr>
            <tr>
                <td>
                    <c:forEach var="file" items="${pdfFileDTO}" >
                        <a href="${file.file_path}" target="_blank">${file.file_name}${file.file_ext}</a>
                    </c:forEach>
                </td>
            </tr>
        </table>
    </main>
        <div class="contentMain">
            <textarea name="content" id="content" >${dto.content}</textarea>
        </div>
        <div class="imgMain">
            <input type="file" id="file">
        </div>
        <input class="endBtn" type="submit" value="수정">
        <input class="endBtn" type="submit" value="취소">
        <input class="endBtn" type="submit" value="목록">
    </form>
</div>
</body>
</html>