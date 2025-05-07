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
public class InquiryDTO {
    // 문의 관련 필드
    private int inquiry_id; //질문 ID
    private String member_id; //질문한 회원 ID
    private String inquiry_title; //질문 제목
    private String inquiry_content; //질문 내용
    private LocalDateTime inquiry_created_at; //질문 등록 시간
    private LocalDateTime inquiry_updated_at; //질문 수정 시간
    private String inquiry_status; //질문 처리 상태 (예: pending, completed)

    // 답변 관련 필드
    private int resolution_id; //답변 ID
    private String admin_id; // 답변한 관리자 ID
    private String resolution_content; // 답변 내용
    private LocalDateTime resolution_created_at; //답변 시간
    private LocalDateTime resolution_updated_at; //답변 수정 시간
}
