package com.ssanai.jumplearn.service.comment;

import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.vo.PostCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentServiceIf {
	public PageResponseDTO<PostCommentVO> getPostCommentList(@Param("dto") PageRequestDTO dto, @Param("member_id") String member_id);
	public int getPostCommentCount(@Param("dto") PageRequestDTO dto, @Param("member_id") String member_id);
}
