package com.ssanai.jumplearn.service.basket;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.course.SearchDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasketServiceIf {
	public List<BasketDTO> getBasketList(@Param("id") String id);
}
