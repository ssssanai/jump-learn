package com.ssanai.jumplearn.service;


import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.service.mainpage.MainPageServiceIf;
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
public class MainPageServiceTest {
	@Autowired(required = false)
	MainPageServiceIf mainPageService;

	@Test
	public void getMemberInfoTest(){
		log.info(mainPageService.getMemberInfo("member001"));
	}

	@Test
	public void getBottomCardsTest(){
		List<ClassDTO> list = mainPageService.getBottomCards();
		for(ClassDTO dto : list) {
			log.info(dto);
		}
	}

	@Test
	public void getRecommendClassWithoutTargetTest(){
		List<ClassDTO> list = mainPageService.getRecommendClassWithoutTarget();
		for(ClassDTO dto : list) {
			log.info(dto);
		}
	}

	@Test
	public void getRecommendClassWithTargetTest(){
		List<ClassDTO> list = mainPageService.getRecommendClassWithTarget("고1");
		for(ClassDTO dto : list) {
			log.info(dto);
		}
	}
}
