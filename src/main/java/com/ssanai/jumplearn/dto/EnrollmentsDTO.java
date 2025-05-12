package com.ssanai.jumplearn.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Log4j2
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollmentsDTO {
    private int id; //수강 id (PK)
    private String member_id; //회원 id
    private int pay_id; //구매 id
    private int class_id; //강좌 id
    private double progress; //진척도
    private String review; //강의 후기
    private String feedback_score; //강의 후기 점수
    private Integer midterm_score; // 강의 중간 점수
    private Integer final_score; //강의 기말 점수
    private Integer final_grade_score; //강의 최종 점수

    // tbl_class
    private String class_title; // 강좌명
    private String class_category; // 과목명
    private String class_introduce; // 강좌 소개
    private String class_file_path; // 강좌 사진 경로
    private String class_file_name; // 강좌 사진 이름
    private String class_file_ext; // 강좌 사진 확장자

    // tbl_teacher
    private String teacher_name; // 강사명

    // tbl_pay
    private int pay_cost; // 강좌 가격
    private LocalDateTime pay_created_at; // 강좌 구매일
    private LocalDateTime pay_canceled_at; // 구매 취소일시
    private int pay_complete; // 구매 확정 여부 (0: 취소, 1: 확정)
}
