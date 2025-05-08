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
    <title>JL - 게시글 열람</title>
    <script src="https://kit.fontawesome.com/2d74121aef.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="wrap">
    <header>
        <div class="head_img">
            <img src="/writer_page/img/header_logo.svg">
        </div>
        <div class="head_noti">
            <p>커뮤니티 게시물 열람</p>
        </div>
    </header>
    <main>
        <table>
            <tr>
                <td>
                    [${dto.id}]
                </td>
                <td>
                   [${dto.title}]
                </td>
                <td>
                    [${dto.admin_id}]
                </td>
                <td>
                    [${dto.created_at}]
                </td>
                <td>
                    [${dto.view_count}]
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
    <form id="frmView" name="frmView" method="get" action="/edu/editPage">
        <div class="imgMain">
            <input type="file" id="file"/>
        </div>
        <input class="endBtn" type="submit" value="수정">
        <input class="endBtn" type="button" value="삭제">
        <input class="endBtn" type="button" value="목록">

        <input type="text" hidden="hidden" id="id" name="id" value=${dto.id}>
    </form>
</div>
</body>
</html>