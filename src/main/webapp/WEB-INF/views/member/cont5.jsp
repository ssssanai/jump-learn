<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 12.
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="cont5">
    <h2 class="ht">학습 계획표</h2>
    <div class="calendarBox">
        <div id="month"></div>
        <div id="calendar"></div>
    </div>
    <div class="hb">
        <a href="/plan/create/${date}" class="writeBtn">학습 계획 등록</a>
    </div>
    <c:choose>
        <c:when test="${PlanList.size() > 0}">
            <c:forEach items="${PlanList}" var="p">
                <div class="planBox">
                    <div class="pBHead">
                        <p>제목 : ${p.title}</p>
                    </div>
                    <div class="pBBody">
                        <p>${p.description}</p>
                    </div>
                    <div class="pBFooter">
                        <p>작성일 : ${p.study_date}</p>
                        <p>생성일 : ${p.created_at}</p>
                        <p>수정일 : ${p.updated_at}</p>
                    </div>
                    <div class="pBBtn">
                        <a href="/plan/update/${p.id}/${date}">학습 계획 수정</a>
                        <a class="delete" href="/plan/delete/${p.id}/${date}">학습 계획 삭제</a>
                    </div>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p class="nullListContent">등록된 계획이 없습니다.</p>
        </c:otherwise>
    </c:choose>
</div>
<script src="/resources/static/js/calendar.js">printMonth();</script>
<script>
    [...document.getElementsByClassName('delete')].map(
        function (el) {
            el.addEventListener('click', function (e) {
                e.preventDefault();
                e.stopPropagation();
                if (confirm('학습 계획을 삭제하시겠습니까?')) {
                    location.href = el.href;
                }
            })
        }
    )
</script>