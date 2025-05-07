package com.ssanai.jumplearn.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	private int visibility; // 공개 여부 (0: private, 1: public)

	// 답변 관련 필드
	private int resolution_id; //답변 ID
	private String admin_id; // 답변한 관리자 ID
	private String resolution_content; // 답변 내용
	private LocalDateTime resolution_created_at; //답변 시간
	private LocalDateTime resolution_updated_at; //답변 수정 시간

	// 문의 댓글
	private int comment_id; // 댓글 ID
	private String inquiry_commenter; // 댓글 단 사람
	private String inquiry_comment_id_type; // 댓글 단 사람 타입
	private String inquiry_comment_content; // 댓글 내용
	private LocalDateTime inquiry_comment_created_at; // 댓글 작성 날짜
	private LocalDateTime inquiry_comment_updated_at; // 댓글 수정 날짜
}
