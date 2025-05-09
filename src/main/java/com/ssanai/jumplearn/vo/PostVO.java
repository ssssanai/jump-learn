package com.ssanai.jumplearn.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostVO {
	private int id; // 게시글 번호
	private String title; // 게시글 제목
	private String content; // 게시글 컨텐츠
	private LocalDateTime created_at; // 게시글 작성일
	private LocalDateTime updated_at; // 게시글 수정일
	private int view_count; // 게시글 조회수
	private String member_id; // 게시글 작성자 ID
}
