package com.ssanai.jumplearn.mapper;

import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.mapper.comment.PostCommentMapper;
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
class PostCommentMapperTest {
	@Autowired(required = false)
	private PostCommentMapper postCommentMapper;

	@Test
	void getPostCommentList() {
		List<PostCommentVO> list = postCommentMapper.getPostCommentList( PageRequestDTO.builder().build(), "member001");
		log.info(list.size());
		log.info(list);
	}
}