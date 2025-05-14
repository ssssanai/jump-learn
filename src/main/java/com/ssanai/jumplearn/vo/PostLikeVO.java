package com.ssanai.jumplearn.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostLikeVO {
	private int id; //pk
	private String member_id; //좋아요 누른 사람 ID
	private int post_id; //좋아요 눌린 게시물
	private LocalDateTime created_at; //좋아요 눌린시간
}
