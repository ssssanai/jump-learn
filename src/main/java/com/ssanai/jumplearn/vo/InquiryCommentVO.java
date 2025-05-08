package com.ssanai.jumplearn.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InquiryCommentVO {
	private int id; // 댓글 ID
	private int inquiry_id; // QnA ID
	private String commenter; // 댓글 작성자
	private String comment_id_type; // member, admin
	private String content; // 댓글 내용
	private LocalDateTime created_at; // 작성일
	private LocalDateTime updated_at; // 수정일
}
