package com.ssanai.jumplearn.vo;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClassQuestionVO {
	private int id;
	private int class_id;
	private String member_id;
	private String title;
	private String content;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private int visibility;
	private int is_answered;
}
