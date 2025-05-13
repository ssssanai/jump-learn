<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 12.
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="cont1">
    <h2 class="ht">나의 강의실</h2>
    <form id="frm_search_enroll" name="frmSearch" class="searchBox" method="get"
          action="/studyroom/enroll">
        <input type="hidden" name="search_category" value="title"/>
        <input type="hidden" id="sort_order_enroll" name="sort_order" value=""/>
        <div class="btns">
            <button name="search_order_recent" id="search_order_recent_enroll" class="searchBtn">최신순</button>
            <button name="search_order_chars" id="search_order_chars_enroll" class="searchBtn">글자순</button>
        </div>
        <div class="searchBox2">
            <input type="text" class="serchIn" id="search_word_enroll" name="search_word"
                   placeholder="검색어를 입력해주세요."
                   value="">
            <input type="submit" class="serchBtn" id="btnSubmitEnroll" value="검색">
        </div>
    </form>
    <div class="myStudyList1">
        <p class="studyNo">번호</p>
        <p class="studyCate">과목명</p>
        <p class="studyTit1">제목</p>
        <p class="studyTeach">강사명</p>
        <p class="studyRegDate">구매날짜</p>
    </div>
    <c:choose>
        <c:when test="${EnrollDTOList.dtoList.size() > 0 }">
            <c:forEach items="${EnrollDTOList.dtoList}" var="dto">
                <div class="myStudyList2">
                    <p class="studyNo">${dto.id}</p>
                    <p class="studyCate">${dto.class_category}</p>
                    <a href="#" class="studyTit">${dto.class_title}</a>
                    <p class="studyTeach">${dto.teacher_name}</p>
                    <p class="studyRegDate">${dto.pay_created_at.toString().split("T")[0]}&nbsp;${dto.pay_created_at.toString().split("T")[1]}</p>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <div class="myStudyList2">
                수강중인 강좌가 없습니다.
            </div>
        </c:otherwise>
    </c:choose>
    <div class="pageBox">
        <p>${EnrollPaging}</p>
    </div>
</div>
<script>
    // Enroll 리스트
    document.getElementById('frm_search_enroll').addEventListener('submit', function (e) {
        e.preventDefault();
        e.stopPropagation();

        let search_word = document.getElementById('search_word_enroll');
        if (!checkSQLInjection(search_word.value)) {
            alert('포함할 수 없는 문자가 있습니다.');
            search_word.value = '';
        } else {
            document.getElementById('frm_search_enroll').submit();
        }
    });

    document.getElementById('frm_search_enroll').addEventListener('keydown', function (e) {
        if (e.code === "Enter") {
            e.preventDefault();
        }
    });

    document.getElementById('search_order_recent_enroll').addEventListener('click', function () {
        document.getElementById('sort_order_enroll').value = 'recent';
        document.getElementById('frm_search_enroll').submit();
    });


    document.getElementById('search_order_chars_enroll').addEventListener('click', function () {
        document.getElementById('sort_order_enroll').value = 'chars';
        document.getElementById('frm_search_enroll').submit();
    });
</script>