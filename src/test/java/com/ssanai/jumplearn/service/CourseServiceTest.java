package com.ssanai.jumplearn.service;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.ClassDetailDTO;
import com.ssanai.jumplearn.dto.ReviewDTO;
import com.ssanai.jumplearn.dto.course.SearchDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.service.basket.BasketServiceIf;
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
		List<ClassDTO> list = courseService.getClassList(new SearchDTO());
		for (ClassDTO classDTO : list) {
			log.info(classDTO);
		}
	}

	@Test
	public void getSearchListTest() {
		List<ClassDTO> classList = courseService.getClassList(SearchDTO.builder().search_word("강사").search_condition1("강사").search_condition2("고2").build());
		for (ClassDTO classDTO : classList) {
			log.info(classDTO);
		}
	}

	@Test
	public void getSearchListTest2() {
		List<ClassDTO> classList = courseService.getClassList(
				new SearchDTO(1, 10, 0, 10,
						"", "제목",  "none","none"
						, "lower_price")
		);
		for (ClassDTO classDTO : classList) {
			log.info(classDTO);
		}
	}
	@Test
	public void getListTotalCountTest1() {
		int total_count = courseService.getListTotalCount(
				SearchDTO.builder()
						.search_condition1("제목")
						.sort_condition("lower_price")
						.build()
		);
		log.info(total_count);
	}

	@Test
	public void getListTotalCountTest2() {
		int total_count = courseService.getListTotalCount(
				SearchDTO.builder()
						.search_word("강사")
						.search_condition1("강사")
						.search_condition2("고2")
						.build()
		);
		log.info(total_count);
	}

	@Test
	public void getClassDetailByIdTest(){
		ClassDetailDTO classDetailDTO = courseService.getClassDetailById(6);
		log.info(classDetailDTO);
	}

	@Test
	public void getReviewListById(){
		List<ReviewDTO> reviewList = courseService.getReviewListById(6);
		for (ReviewDTO reviewDTO : reviewList) {
			log.info(reviewDTO);
		}
	}
}
