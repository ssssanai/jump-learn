package com.ssanai.jumplearn.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollmentsDTO {
    private String id; //회원 id
    private int enrollments_id; //수강 id
    private int pay_id; //구매 id
    private int class_id; //강좌 id
    private double progress; //진척도
    private String review; //강의 후기
    private String feedback_score; //강의 후기 점수
    private int midterm_score; // 강의 중간 점수
    private int final_score; //강의 기말 점수
    private int final_grade_score; //강의 최종 점수
}
