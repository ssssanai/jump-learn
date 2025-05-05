package com.ssanai.jumplearn.mapper.course;

import com.ssanai.jumplearn.dto.ClassDetailDTO;
import com.ssanai.jumplearn.dto.ReviewDTO;
import com.ssanai.jumplearn.dto.course.SearchDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
	public List<ClassDTO> getClassList(SearchDTO searchDTO); // 검색 조건 없는 경우
	public int getListTotalCount(SearchDTO searchDTO);
	public ClassDetailDTO getClassDetailById(@Param("id") int id);
	public List<ReviewDTO> getReviewListById(@Param("id") int id);
}
