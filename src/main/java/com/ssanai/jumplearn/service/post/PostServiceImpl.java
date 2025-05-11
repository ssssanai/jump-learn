package com.ssanai.jumplearn.service.post;

import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.dto.PostDTO;
import com.ssanai.jumplearn.mapper.post.PostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostServiceIf {
	private final PostMapper postMapper;

	@Override
	public int getTotalCount(PageRequestDTO dto, String member_id) {
		return postMapper.getTotalCount(dto, member_id);
	}

	@Override
	public PageResponseDTO<PostDTO> myList(PageRequestDTO dto, String member_id) {
		int totalCount =getTotalCount(dto, member_id);
		List<PostDTO> list = postMapper.myList(dto, member_id);
		PageResponseDTO<PostDTO> pageResponseDTO = PageResponseDTO
				.<PostDTO>withAll()
				.reqDTO(dto)
				.dtoList(list)
				.total_count(totalCount)
				.build();
		return pageResponseDTO;
	}

	@Override
	public PostDTO selectById(int id) {
		return null;
	}
}
