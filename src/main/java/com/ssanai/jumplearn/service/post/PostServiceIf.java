package com.ssanai.jumplearn.service.post;

import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.dto.PostDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostServiceIf {
	public int getTotalCount(PageRequestDTO dto, @Param("member_id") String member_id);
	public PageResponseDTO<PostDTO> list(PageRequestDTO dto,@Param("member_id") String member_id); // 목록 출력
	public PostDTO selectById(@Param("id") int id); // 상세 보기
}
