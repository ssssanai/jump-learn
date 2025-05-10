package com.ssanai.jumplearn.dto;

import com.ssanai.jumplearn.vo.BbsFileVO;
import com.ssanai.jumplearn.vo.PostCommentVO;
import com.ssanai.jumplearn.vo.PostFileVO;
import com.ssanai.jumplearn.vo.PostLikeVO;
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
public class PostDTO {
	// tbl_post
	private int id; // 게시글 번호
	private String title; // 게시글 제목
	private String content; // 게시글 컨텐츠
	private LocalDateTime created_at; // 게시글 작성일
	private LocalDateTime updated_at; // 게시글 수정일
	private int view_count; // 게시글 조회수
	private String member_id; // 게시글 작성자 ID

	// tbl_member
	private String member_name; // 게시글 작성자 이름

	// tbl_post_like
	private List<PostLikeVO> postLikeVOList;
	private int like_count;

	// tbl_post_comment
	private List<PostCommentVO> postCommentVOList;

	// tbl_bbs_file
	private List<PostFileVO> postFileVOList;
	private List<BbsFileVO> bbsFileVOList;
}
