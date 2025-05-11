package com.ssanai.jumplearn.service;

import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.service.comment.CommentServiceImpl;
import com.ssanai.jumplearn.vo.PostCommentVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class CommentServiceImplTest {
	@Autowired(required = false)
	private CommentServiceImpl commentService;

	@Test
	void getPostCommentList() {
		PageResponseDTO<PostCommentVO> list = commentService.getPostCommentList(
				PageRequestDTO.builder().build(), "member001"
		);
		log.info(list);
	}

	@Test
	void getPostCommentCount() {
		int count = commentService.getPostCommentCount(PageRequestDTO.builder().build(), "member001");
		log.info(count);
	}
}