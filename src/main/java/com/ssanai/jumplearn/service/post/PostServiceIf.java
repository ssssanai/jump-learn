package com.ssanai.jumplearn.service.post;

import com.ssanai.jumplearn.dto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostServiceIf {
	public int getTotalCount(PageRequestDTO dto, @Param("member_id") String member_id);
	public PageResponseDTO<PostDTO> myList(PageRequestDTO dto,@Param("member_id") String member_id); // 목록 출력
	public PostDTO selectById(@Param("id") int id); // 상세 보기



	//임경근 작품
	public PageResponseDTO<PostDTO> searchList(PageRequestDTO requestDTO);
	public int postTotalCount(PageRequestDTO requestDTO);
	public PostDetailDTO selectDetailById(int id);
	public List<BbsFileDTO> selectFileById(int id);
	public List<CommentDTO> selectCommentById(int id);
	public int insertFile(BbsFileDTO fileDTO);
	public int insertPost(PostDTO postDTO);
	public int bridgeFile(int f_id, int p_id);
	public int insertComment(CommentDTO commentDTO);
	public int updateComment(CommentDTO commentDTO);
	public int deleteComment(@Param("id") int id);
}
