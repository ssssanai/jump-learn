package com.ssanai.jumplearn.mapper;

import com.ssanai.jumplearn.dto.EnrollmentsDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.mapper.course.EnrollmentsMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class EnrollmentsMapperTest {
	@Autowired(required = false)
	EnrollmentsMapper enrollmentsMapper;

	@Test
	public void test(){
		List<EnrollmentsDTO> list = enrollmentsMapper.enrollList(
				PageRequestDTO.builder()
						.page_no(1)
						.page_block_size(10)
						.page_size(10)
						.build(), "member006"
		);
		log.info(list.size());
		for(EnrollmentsDTO d : list){
			log.info(d.toString());
		}
	}

	@Test
	public void test2(){
		EnrollmentsDTO dto = enrollmentsMapper.getEnrollment(3);
		log.info(dto.toString());
	}
}
