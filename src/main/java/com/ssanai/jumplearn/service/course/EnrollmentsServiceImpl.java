package com.ssanai.jumplearn.service.course;

import com.ssanai.jumplearn.dto.EnrollmentsDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.mapper.course.EnrollmentsMapper;
import com.ssanai.jumplearn.vo.EnrollmentsVO;
import com.ssanai.jumplearn.vo.PayVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class EnrollmentsServiceImpl implements EnrollmentsServiceIf{
	private final EnrollmentsMapper enrollmentsMapper;

	@Override
	public int getTotalCount(PageRequestDTO dto, String id) {
		return enrollmentsMapper.getTotalCount(dto, id);
	}

	@Override
	public PageResponseDTO<EnrollmentsDTO> enrollList(PageRequestDTO dto, String id) {
		int totalCount = getTotalCount(dto, id);
		List<EnrollmentsDTO> list = enrollmentsMapper.enrollList(dto, id);
		PageResponseDTO<EnrollmentsDTO> pageResponseDTO =
				PageResponseDTO.<EnrollmentsDTO>withAll()
						.reqDTO(dto)
						.dtoList(list)
						.total_count(totalCount)
						.build();
		log.info(pageResponseDTO);
		return pageResponseDTO;
	}

	@Override
	public EnrollmentsDTO getEnrollment(int id) {
		return enrollmentsMapper.getEnrollment(id);
	}

	@Override
	public List<EnrollmentsDTO> getScoreList(String member_id) {
		return enrollmentsMapper.getScoreList(member_id);
	}

	@Override
	public int createEnrollment(PayVO vo) {
		return enrollmentsMapper.createEnrollment(vo);
	}

	@Override
	public List<EnrollmentsVO> getList(String member_id) {
		return enrollmentsMapper.getList(member_id);
	}
}
