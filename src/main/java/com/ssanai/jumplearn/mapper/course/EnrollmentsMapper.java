package com.ssanai.jumplearn.mapper.course;

import com.ssanai.jumplearn.dto.EnrollmentsDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnrollmentsMapper {
	// 조회
	public int getTotalCount(PageRequestDTO dto);
	public List<EnrollmentsDTO> enrollList(PageRequestDTO dto); // 수강 목록 출력
	public EnrollmentsDTO getEnrollment(@Param("id") int id); // 상세 보기
}
