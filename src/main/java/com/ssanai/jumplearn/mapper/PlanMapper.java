package com.ssanai.jumplearn.mapper;

import com.ssanai.jumplearn.vo.PlanVO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

public interface PlanMapper {
	public int createPlan(@Param("vo") PlanVO vo);// 생성
	public PlanVO getPlan(@Param("id") int id); // 단일 조회
	public List<PlanVO> getPlanList(@Param("member_id") String member_id);// 계획 목록 조회
	public List<PlanVO> getPlanListByDate(@Param("member_id") String member_id, @Param("date") LocalDate date);// 날짜별 계획 조회
	public int updatePlan(@Param("vo") PlanVO vo, @Param("id") int id);// 업데이트
	public int deletePlan(@Param("id") int id);// 삭제
}
