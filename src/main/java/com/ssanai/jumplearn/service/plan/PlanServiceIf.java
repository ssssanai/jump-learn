package com.ssanai.jumplearn.service.plan;

import com.ssanai.jumplearn.dto.PlanDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

public interface PlanServiceIf {
	public int createPlan(@Param("dto") PlanDTO dto);// 생성
	public PlanDTO getPlan(@Param("id") int id); // 단일 조회
	public List<PlanDTO> getPlanList(@Param("member_id") String member_id);// 계획 목록 조회
	public List<PlanDTO> getPlanListByDate(@Param("member_id") String member_id, @Param("date") LocalDate date);// 날짜별 계획 조회
	public int updatePlan(@Param("dto") PlanDTO dto,@Param("id") int id);// 업데이트
	public int deletePlan(@Param("id") int id);// 삭제
}
