package com.ssanai.jumplearn.mapper.basket;

import com.ssanai.jumplearn.dto.BasketDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasketMapper {
	public List<BasketDTO> getBasketList(@Param("id") String id);
}
