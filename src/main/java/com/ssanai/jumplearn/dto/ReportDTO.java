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
public class ReportDTO {
    private int report_id;       // 신고 ID
    private int target_id;       // 대상 ID
    private String target_type;  // 대상 타입
    private String member_id;       // 신고자 ID
    private String reason;       // 신고 사유
    private String report_status; // 신고 상태 질문 처리 상태 (예: pending, completed)
    private int resolution_id;   // 해결 ID
    private int admin_id;        // 관리자 ID (해결 처리하는 관리자)
    private String resolution;   // 해결 내용

    //신고 받은 테이블 정보
    private String report_title; //신고 받은 게시물 제목
    private String report_content; //신고 받은 게시물 내용
    private LocalDateTime report_create_date; //신고 받은 게시물 생성 날짜
    private LocalDateTime report_update_date; //신고 받은 게시물 수정 날짜

}
