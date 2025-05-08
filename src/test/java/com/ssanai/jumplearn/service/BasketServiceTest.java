package com.ssanai.jumplearn.service;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.service.basket.BasketServiceIf;
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
public class BasketServiceTest {
	@Autowired(required = false)
	BasketServiceIf basketService;

	@Test
	public void getBasketListTest() {
		List<BasketDTO> list = basketService.getBasketList("member006");
		for (BasketDTO basketDTO : list) {
			log.info(basketDTO);
		}
	}

	@Test
	public void addBasketTest() {
		log.info(basketService.addBasket(1, "member006"));
	}

	@Test
	public void isExistBasketTest() {
		log.info(basketService.isBasketExist(6, "member106"));
	}
}
