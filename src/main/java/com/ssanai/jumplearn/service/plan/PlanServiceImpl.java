package com.ssanai.jumplearn.service.plan;

import com.ssanai.jumplearn.dto.PlanDTO;
import com.ssanai.jumplearn.mapper.PlanMapper;
import com.ssanai.jumplearn.vo.PlanVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanServiceIf {
	private final PlanMapper planMapper;
	private final ModelMapper modelMapper;

	@Override
	public int createPlan(PlanDTO dto) {
		PlanVO vo = modelMapper.map(dto, PlanVO.class);
		return planMapper.createPlan(vo);
	}

	@Override
	public PlanDTO getPlan(int id) {
		return modelMapper.map(planMapper.getPlan(id), PlanDTO.class);
	}

	@Override
	public List<PlanDTO> getPlanList(String member_id) {
		List<PlanDTO> list = planMapper.getPlanList(member_id).stream().map(el -> modelMapper.map(el, PlanDTO.class)).toList();
		return list;
	}

	@Override
	public List<PlanDTO> getPlanListByDate(String member_id, LocalDate date) {
		List<PlanDTO> list = planMapper.getPlanListByDate(member_id, date).stream().map(el -> modelMapper.map(el, PlanDTO.class)).toList();
		return list;
	}

	@Override
	public int updatePlan(PlanDTO dto, int id) {
		PlanVO vo = modelMapper.map(dto, PlanVO.class);
		return planMapper.updatePlan(vo, id);
	}

	@Override
	public int deletePlan(int id) {
		return planMapper.deletePlan(id);
	}
}
