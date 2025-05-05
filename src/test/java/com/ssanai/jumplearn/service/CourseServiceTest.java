package com.ssanai.jumplearn.service;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.service.course.CourseServiceIf;
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
public class CourseServiceTest {
	@Autowired(required = false)
	CourseServiceIf courseService;

	@Test
	public void getClassListTest() {
		List<ClassDTO> list = courseService.getClassList();
		for (ClassDTO classDTO : list) {
			log.info(classDTO);
		}
	}

	@Test
	public void getBasketListTest() {
		List<BasketDTO> list = courseService.getBasketList("member001");
		for (BasketDTO basketDTO : list) {
			log.info(basketDTO);
		}
	}


}
