<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 2025. 5. 12.
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="cont4">
    <h2 class="ht">성적표</h2>
    <div class="myStudyList1">
        <p class="sc">번호</p>
        <p class="sc2">과목</p>
        <p class="sc5">강좌명</p>
        <p class="sc3">학습 진행률</p>
        <p class="sc2">중간고사 점수</p>
        <p class="sc2">기말고사 점수</p>
        <p class="sc2">최종 점수</p>
    </div>
    <c:choose>
        <c:when test="${GradeList.size() > 0}">
            <c:forEach items="${GradeList}" var="g">
                <div class="myStudyList2">
                    <p class="sc">${g.class_id}</p>
                    <p class="sc2">${g.class_category}</p>
                    <p class="sc5">${g.class_title}</p>
                    <p class="sc3">${g.progress}</p>
                    <p class="sc2">${g.midterm_score}</p>
                    <p class="sc2">${g.final_score}</p>
                    <p class="sc2">${g.final_grade_score}</p>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <div class="myStudyList2">
                수강한 강좌가 없습니다.
            </div>
        </c:otherwise>
    </c:choose>
</div>