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
    <c:choose>
        <c:when test="${PlanList.size() > 0}">
            <c:forEach items="${PlanList}" var="p">
                <p>${p.id}</p>
                <p>${p.member_id}</p>
                <p>${p.title}</p>
                <p>${p.description}</p>
                <p>${p.study_date}</p>
                <p>${p.created_at}</p>
                <p>${p.updated_at}</p>
            </c:forEach>
        </c:when>
        <c:otherwise>
            등록된 계획이 없습니다.
        </c:otherwise>
    </c:choose>
</div>
<script src="/resources/static/js/calendar.js">printMonth();</script>