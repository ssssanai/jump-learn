package com.ssanai.jumplearn.service.course;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseServiceIf {
	public List<ClassDTO> getClassList();
	public List<BasketDTO> getBasketList(@Param("id") String id);
}
