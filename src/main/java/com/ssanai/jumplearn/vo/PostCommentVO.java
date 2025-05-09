package com.ssanai.jumplearn.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostCommentVO {
	private int id;
	private String member_id;
	private int post_id;
	private String content;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
}
