package com.ssanai.jumplearn.dto;

import com.ssanai.jumplearn.vo.PostCommentVO;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
	private int comment_id;
	private String comment_member_id;
	private String comment_content;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private int post_id;
}
