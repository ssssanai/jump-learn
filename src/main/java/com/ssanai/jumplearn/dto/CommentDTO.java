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
	// tbl_post_comment
	List<PostCommentVO> postComments;
//	// tbl_inquiry_comment
//	private int inquiry_id;
//	private int inquiry_comment_id;
//	private String inquiry_commenter;
//	private String inquiry_comment_id_type;
//	private String inquiry_content;
//	private LocalDateTime inquiry_created_at;
//	private LocalDateTime inquiry_updated_at;
//	// tbl_class_question_comment
//	private int class_question_id;
//	private int class_question_comment_id;
//	private String class_question_commenter;
//	private String class_question_comment_id_type;
//	private String class_question_content;
//	private LocalDateTime class_question_created_at;
//	private LocalDateTime class_question_updated_at;
}
