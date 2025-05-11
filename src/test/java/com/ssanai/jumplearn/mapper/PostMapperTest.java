package com.ssanai.jumplearn.mapper;

import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PostDTO;
import com.ssanai.jumplearn.mapper.post.PostMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class PostMapperTest {
	@Autowired(required = false)
	private PostMapper postMapper;

	@Test
	void myList() {
		List<PostDTO> list = postMapper.myList(PageRequestDTO.builder().build(), "member001");
		log.info(list.size());
		log.info(list);
	}
}