package com.ssanai.jumplearn.mapper.post;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.vo.PostLikeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostMapper {
	public int getTotalCount(@Param("dto") PageRequestDTO dto, @Param("member_id") String member_id);
	public List<PostDTO> myList(@Param("dto") PageRequestDTO dto, @Param("member_id") String member_id); // 목록 출력
	public PostDTO selectById(@Param("id") int id); // 상세 보기

	//임경근
	public List<PostDTO> searchList(PageRequestDTO requestDTO);
	public int postTotalCount(PageRequestDTO requestDTO);
	public PostDetailDTO selectDetailById(int id);
	public List<BbsFileDTO> selectFileById(int id);
	public List<CommentDTO> selectCommentById(int id);
	public int insertFile(BbsFileDTO fileDTO);
	public int insertPost(PostDTO postDTO);
	public int deletePost(int id);
	public int deleteFile(int post_id);
	public int updateFile(BbsFileDTO fileDTO);
	public int updatePost(PostDTO postDTO);
	public int bridgeFile(@Param("file_id") int f_id, @Param("post_id") int p_id);
	public int insertComment(CommentDTO commentDTO);
	public int updateComment(CommentDTO commentDTO);
	public int deleteComment(@Param("id") int id);
	public int insertReport(ReportDTO reportDTO);

	// 게시글 좋아요
	public Integer isLiked(@Param("post_id") int post_id, @Param("member_id") String member_id);
	public int cancelLike(@Param("id") int id);
	public int insertLike(@Param("post_id") int post_id, @Param("member_id") String member_id);
	public int viewCountMinus(@Param("post_id") int post_id);
}
