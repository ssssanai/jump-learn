package com.ssanai.jumplearn.service.course;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.ClassDetailDTO;
import com.ssanai.jumplearn.dto.ReviewDTO;
import com.ssanai.jumplearn.dto.course.SearchDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseServiceIf {
	public List<ClassDTO> getClassList(SearchDTO searchDTO);
	public int getListTotalCount(SearchDTO searchDTO);
	public ClassDetailDTO getClassDetailById(@Param("id") int id);
	public List<ReviewDTO> getReviewListById(@Param("id") int id);
}
