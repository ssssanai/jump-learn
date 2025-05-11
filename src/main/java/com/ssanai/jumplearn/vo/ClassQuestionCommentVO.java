package com.ssanai.jumplearn.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClassQuestionCommentVO {
	private int id;
	private int comment_id;
	private String commenter;
	private String comment_id_type;
	private String content;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
}
