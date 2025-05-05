package com.ssanai.jumplearn.mapper;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.mapper.course.CourseMapper;
import com.ssanai.jumplearn.vo.BasketVO;
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
public class CourseMapperTest {
	@Autowired(required = false)
	CourseMapper courseMapper;

	@Test
	public void getClassListTest() {
		List<ClassDTO> classList = courseMapper.getClassList();
		for (ClassDTO classDTO : classList) {
			log.info(classDTO);
		}
	}

	@Test
	public void getBasketListTest() {
		List<BasketDTO> basketList = courseMapper.getBasketList("member002");
		for(BasketDTO basketVO : basketList){
			log.info(basketVO);
		}
	}
}
