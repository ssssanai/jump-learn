package com.ssanai.jumplearn.mapper;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.mapper.basket.BasketMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BasketMapperTest {
	@Autowired(required = false)
	BasketMapper basketMapper;

	@Test
	public void getBasketListTest() {
		List<BasketDTO> basketList = basketMapper.getBasketList("member006");
		for (BasketDTO basketVO : basketList) {
			log.info(basketVO);
		}
	}

	@Test
	public void addBasketTest(){
		log.info( basketMapper.addBasket(6, "member006"));
	}

	@Test
	public void isExistTest(){
		log.info(basketMapper.isBasketExist(6, "member006"));
	}
}
