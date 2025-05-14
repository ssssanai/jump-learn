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
public class ClassQuestionDTO {

	private int id; // PK - 질문 ID == tcqc.question_id
	private int class_id;
	private String member_id;
	private String title;
	private String content;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private int visibility;
	private int is_answered;

	private int comment_id; // 답글 PK
	private String commenter; // 답글 단 사람
	private String comment_id_type; // 답글 단 사람 유형
	private String quested_content; // 답글 내용
	private LocalDateTime quested_created_at; // 답글 생성 시간
	private LocalDateTime quested_updated_at; // 답글 수정 시간
}
