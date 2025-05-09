package com.ssanai.jumplearn.mapper.post;

import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PostDTO;
import com.ssanai.jumplearn.vo.PostVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostMapper {
	public List<PostDTO> list(PageRequestDTO dto); // 목록 출력
	public PostDTO selectById(@Param("id") int id); // 상세 보기
}
