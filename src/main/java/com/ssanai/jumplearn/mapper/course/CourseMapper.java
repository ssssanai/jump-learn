package com.ssanai.jumplearn.mapper.course;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.course.SearchDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
	public List<ClassDTO> getClassList(SearchDTO searchDTO); // 검색 조건 없는 경우
	public int getListTotalCount(SearchDTO searchDTO);
	public List<BasketDTO> getBasketList(@Param("id") String id);
}
