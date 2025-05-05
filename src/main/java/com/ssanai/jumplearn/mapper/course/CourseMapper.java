package com.ssanai.jumplearn.mapper.course;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
	public List<ClassDTO> getClassList();
	public List<BasketDTO> getBasketList(@Param("id") String id);
//	public List<ClassDTO> getClassList(@Param("start") int start, @Param("limit") int limit);
}
