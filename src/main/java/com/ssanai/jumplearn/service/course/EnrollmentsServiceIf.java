package com.ssanai.jumplearn.service.course;

import com.ssanai.jumplearn.dto.EnrollmentsDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.vo.EnrollmentsVO;
import com.ssanai.jumplearn.vo.PayVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnrollmentsServiceIf {
	// 조회
	public int getTotalCount(@Param("dto") PageRequestDTO dto, @Param("member_id") String member_id);
	public PageResponseDTO<EnrollmentsDTO> enrollList(@Param("dto") PageRequestDTO dto, @Param("member_id") String member_id); // 목록 출력
	public EnrollmentsDTO getEnrollment(@Param("id") int id); // 상세 보기
	public List<EnrollmentsDTO> getScoreList(@Param("member_id") String member_id);
	public List<EnrollmentsVO> getList(@Param("member_id") String member_id);
	// 데이터 삽입
	public int createEnrollment(@Param("vo") PayVO vo);
}
