package com.ssanai.jumplearn.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClassQuestionCommentVO {
	private int id; // PK
	private int question_id; // 답글을 단 질문
	private String commenter; // 답글 단 사람
	private String comment_id_type; // 답글 단 사람 유형
	private String content; // 답글 내용
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
}
