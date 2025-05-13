<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 12.
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="cont3">
    <h2 class="ht">내가 남긴 댓글</h2>
    <form id="frm_search_enroll" name="frmSearch" class="searchBox" method="get"
          action="/studyroom/comment">
        <input type="hidden" name="search_category" value="title"/>
        <input type="hidden" id="sort_order_comment" name="sort_order" value=""/>
        <div class="btns">
            <button name="search_order_recent" id="search_order_recent_comment" class="searchBtn">최신순</button>
            <button name="search_order_chars" id="search_order_chars_comment" class="searchBtn">글자순</button>
        </div>
        <div class="searchBox2">
            <input type="text" class="serchIn" id="search_word_comment" name="search_word"
                   placeholder="검색어를 입력해주세요."
                   value="">
            <input type="submit" class="serchBtn" id="btnSubmitComment" value="검색">
        </div>
    </form>
    <div class="myStudyList1">
        <p class="comuNo">번호</p>
        <p class="comuTit">게시글 제목</p>
        <p class="comuCont">내용</p>
        <p class="comuRegDate">작성날짜</p>
    </div>
    <c:choose>
        <c:when test="${PostCommentVOList.dtoList.size() > 0 }">
            <c:forEach items="${PostCommentVOList.dtoList}" var="dto">
                <div class="myStudyList2">
                    <p class="comuNo">${dto.id}</p>
                    <p class="comuTit1">${dto.post_id}</p>
                    <a href="#"
                       class="comuCont">${dto.content.length() >= 26 ? dto.content.substring(0, 30) + "..." : dto.content}</a>
                    <p class="comuRegDate">${dto.created_at.toString().split("T")[0]}&nbsp;${dto.created_at.toString().split("T")[1]}</p>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <div class="myStudyList2">
                내가 작성한 댓글이 없습니다.
            </div>
        </c:otherwise>
    </c:choose>
    <div class="pageBox">
        <p>${PostCommentPaging}</p>
    </div>
</div>
<script>
    // Comment 리스트
    document.getElementById('frm_search_comment').addEventListener('submit', function (e) {
        e.preventDefault();
        e.stopPropagation();

        let search_word = document.getElementById('search_word_comment');
        if (!checkSQLInjection(search_word.value)) {
            alert('포함할 수 없는 문자가 있습니다.');
            search_word.value = '';
        } else {
            document.getElementById('frm_search_comment').submit();
        }
    });

    document.getElementById('frm_search_comment').addEventListener('keydown', function (e) {
        if (e.code === "Enter") {
            e.preventDefault();
        }
    });

    document.getElementById('search_order_recent_comment').addEventListener('click', function () {
        document.getElementById('sort_order_comment').value = 'recent';
        document.getElementById('frm_search_comment').submit();
    });


    document.getElementById('search_order_chars_comment').addEventListener('click', function () {
        document.getElementById('sort_order_comment').value = 'chars';
        document.getElementById('frm_search_comment').submit();
    });
</script>