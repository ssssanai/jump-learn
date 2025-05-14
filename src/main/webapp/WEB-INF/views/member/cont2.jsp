<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 12.
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="cont2">
    <h2 class="ht">내가 작성한 글</h2>
    <form id="frm_search_post" name="frmSearch" class="searchBox" method="get" action="/studyroom/post">
        <input type="hidden" name="search_category" value="title"/>
        <input type="hidden" id="sort_order_post" name="sort_order" value=""/>
        <div class="btns">
            <button name="search_order_recent" id="search_order_recent_post" class="searchBtn">최신순</button>
            <button name="search_order_popular" id="search_order_chars_post" class="searchBtn">인기순</button>
        </div>
        <div class="searchBox2">
            <input type="text" class="serchIn" id="search_word_post" name="search_word"
                   placeholder="검색어를 입력해주세요."
                   value="">
            <input type="submit" class="serchBtn" id="btnSubmitPost" value="검색">
        </div>
    </form>
    <div class="myStudyList1">
        <p class="studyNo">번호</p>
        <p class="studyTit">제목</p>
        <p class="studyTit1">내용</p>
        <p class="studyTeach">좋아요</p>
        <p class="studyTeach">조회수</p>
        <p class="studyRegDate">작성날짜</p>
    </div>
    <c:choose>
        <c:when test="${PostDTOList.dtoList.size() > 0 }">
            <c:forEach items="${PostDTOList.dtoList}" var="dto">
                <div class="myStudyList2">
                    <p class="studyNo">${dto.id}</p>
                    <a href="/post/view?id=${dto.id}" class="studyTit">${dto.title}</a>
                    <p class="studyTit1">${dto.content}</p>
                    <p class="studyTeach">${dto.like_count}</p>
                    <p class="studyTeach">${dto.view_count}</p>
                    <p class="studyRegDate">${dto.created_at.toString().split("T")[0]}&nbsp;${dto.created_at.toString().split("T")[1]}</p>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <div class="myStudyList2">
                내가 작성한 글이 없습니다.
            </div>
        </c:otherwise>
    </c:choose>
    <div class="pageBox">
        <p>${PostPaging}</p>
    </div>
</div>
<script>
    // Post 리스트
    document.getElementById('frm_search_post').addEventListener('submit', function (e) {
        e.preventDefault();
        e.stopPropagation();

        let search_word = document.getElementById('search_word_post');
        if (!checkSQLInjection(search_word.value)) {
            alert('포함할 수 없는 문자가 있습니다.');
            search_word.value = '';
        } else {
            document.getElementById('frm_search_post').submit();
        }
    });

    document.getElementById('frm_search_post').addEventListener('keydown', function (e) {
        if (e.code === "Enter") {
            e.preventDefault();
        }
    });

    document.getElementById('search_order_recent_post').addEventListener('click', function () {
        document.getElementById('sort_order_post').value = 'recent';
        document.getElementById('frm_search_post').submit();
    });


    document.getElementById('search_order_popular_post').addEventListener('click', function () {
        document.getElementById('sort_order_post').value = 'popular';
        document.getElementById('frm_search_post').submit();
    });
</script>
