package com.ssanai.jumplearn.service.comment;

import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.dto.PostDTO;
import com.ssanai.jumplearn.mapper.comment.PostCommentMapper;
import com.ssanai.jumplearn.vo.PostCommentVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentServiceIf{
	private final PostCommentMapper postCommentMapper;

	@Override
	public PageResponseDTO<PostCommentVO> getPostCommentList(PageRequestDTO dto, String member_id) {
		int totalCount = postCommentMapper.getPostCommentCount(dto, member_id);
		List<PostCommentVO> list = postCommentMapper.getPostCommentList(dto, member_id);
		PageResponseDTO<PostCommentVO> pageResponseDTO = PageResponseDTO
				.<PostCommentVO>withAll()
				.reqDTO(dto)
				.dtoList(list)
				.total_count(totalCount)
				.build();
		return pageResponseDTO;
	}

	@Override
	public int getPostCommentCount(PageRequestDTO dto, String member_id) {
		return postCommentMapper.getPostCommentCount(dto, member_id);
	}
}
