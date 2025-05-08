package com.ssanai.jumplearn.service.basket;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.mapper.basket.BasketMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketServiceIf{
	private final BasketMapper basketMapper;

	@Override
	public List<BasketDTO> getBasketList(String id) {
		List<BasketDTO> basketList = basketMapper.getBasketList(id);
		log.info("getBasketList: " + basketList);
		return basketList;
	}

	@Override
	public int addBasket(int id, String member_id) {
		return basketMapper.addBasket(id, member_id);
	}

	@Override
	public int isBasketExist(int id, String member_id) {
		return basketMapper.isBasketExist(id, member_id);
	}

	@Override
	public int removeBasket(int id, String member_id) {
		return basketMapper.removeBasket(id, member_id);
	}
}
