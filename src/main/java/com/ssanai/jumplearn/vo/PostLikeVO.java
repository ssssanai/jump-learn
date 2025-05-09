package com.ssanai.jumplearn.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostLikeVO {
	private int id;
	private String member_id;
	private int post_id;
	private LocalDateTime created_at;
}
