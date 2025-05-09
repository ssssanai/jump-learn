package com.ssanai.jumplearn.service.course;

import com.ssanai.jumplearn.dto.EnrollmentsDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import org.apache.ibatis.annotations.Param;

public interface EnrollmentsServiceIf {
	// 조회
	public int getTotalCount(PageRequestDTO dto);
	public PageResponseDTO<EnrollmentsDTO> enrollList(PageRequestDTO dto); // 목록 출력
	public EnrollmentsDTO getEnrollment(@Param("id") int id); // 상세 보기
}
