package com.ssanai.jumplearn.mapper.basket;

import com.ssanai.jumplearn.dto.BasketDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasketMapper {
	public List<BasketDTO> getBasketList(@Param("id") String id); // 목록 출력
	public int isBasketExist(@Param("id") int id, @Param("member_id") String member_id);
	public int addBasket(@Param("id") int id, @Param("member_id") String member_id);
	public int removeBasket(@Param("id") int id, @Param("member_id") String member_id);
}
