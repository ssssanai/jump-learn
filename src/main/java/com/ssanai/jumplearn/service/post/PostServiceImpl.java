package com.ssanai.jumplearn.service.post;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.mapper.post.PostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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



	//임경근 작품
	@Override
	public PageResponseDTO<PostDTO> searchList(PageRequestDTO requestDTO) {
		int totalCount = postMapper.postTotalCount(requestDTO);
		List<PostDTO> postList = postMapper.searchList(requestDTO);

		PageResponseDTO<PostDTO> responseDTO =
				PageResponseDTO
						.<PostDTO>withAll()
						.reqDTO(requestDTO)
						.dtoList(postList)
						.total_count(totalCount)
						.build();
		return responseDTO;
	}
	@Override
	public int postTotalCount(PageRequestDTO requestDTO){
		return postMapper.postTotalCount(requestDTO);
	}

	@Override
	public PostDetailDTO selectDetailById(int id) {
		PostDetailDTO dto = postMapper.selectDetailById(id);
		return dto;
	}

	@Override
	public List<BbsFileDTO> selectFileById(int id) {
		return postMapper.selectFileById(id);
	}

	@Override
	public List<CommentDTO> selectCommentById(int id) {
		return postMapper.selectCommentById(id);
	}

	@Override
	public int insertFile(BbsFileDTO fileDTO) {
		int rs = postMapper.insertFile(fileDTO);
		if(rs > 0) {
			log.info("tbl_bbs_file ID: "+fileDTO.getId());
		return fileDTO.getId();
		}
		return rs;
	}

	@Override
	public int insertPost(PostDTO postDTO) {
		int rs = postMapper.insertPost(postDTO);
		if(rs > 0){
			log.info(postDTO.getId());
			return postDTO.getId();
		}
		return rs;
	}

	@Override
	public int deletePost(int id) {
		return postMapper.deletePost(id);
	}

	@Override
	public int updateFile(BbsFileDTO fileDTO) {
		return 0;
	}

	@Override
	public int updatePost(PostDTO postDTO) {
		return 0;
	}

	@Override
	public int bridgeFile(int f_id, int p_id) {
		return postMapper.bridgeFile(f_id,p_id);
	}

	@Override
	public int insertComment(CommentDTO commentDTO) {
		return postMapper.insertComment(commentDTO);
	}

	@Override
	public int updateComment(CommentDTO commentDTO) {
		return postMapper.updateComment(commentDTO);
	}

	@Override
	public int deleteComment(int id) {
		return postMapper.deleteComment(id);
	}

	@Override
	public int isLiked(int post_id, String member_id) {
		Integer result = postMapper.isLiked(post_id,member_id);
		if(result != null) return result;
		else return -1;
	}

	@Override
	public int cancelLike(int id) { return postMapper.cancelLike(id); }

	@Override
	public int insertLike(int post_id, String member_id) { return postMapper.insertLike(post_id,member_id); }
}
