package com.ssanai.jumplearn.mapper.course;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.EnrollmentsDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.vo.EnrollmentsVO;
import com.ssanai.jumplearn.vo.PayVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnrollmentsMapper {
	// 조회
	public int getTotalCount(@Param("dto") PageRequestDTO dto, @Param("member_id") String member_id);
	public List<EnrollmentsDTO> enrollList(@Param("dto") PageRequestDTO dto, @Param("member_id") String member_id); // 수강 목록 출력
	public EnrollmentsDTO getEnrollment(@Param("id") int id); // 상세 보기
	public List<EnrollmentsDTO> getScoreList(@Param("member_id") String member_id);
	public List<EnrollmentsVO> getList(@Param("member_id") String member_id);
	// 데이터 삽입
	public int createEnrollment(@Param("vo") PayVO vo);
}
