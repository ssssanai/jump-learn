package com.ssanai.jumplearn.service.course;

import com.ssanai.jumplearn.dto.EnrollmentsDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.mapper.course.EnrollmentsMapper;
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
	public int getTotalCount(PageRequestDTO dto) {
		return enrollmentsMapper.getTotalCount(dto);
	}

	@Override
	public PageResponseDTO<EnrollmentsDTO> enrollList(PageRequestDTO dto) {
		int totalCount = getTotalCount(dto);
		List<EnrollmentsDTO> list = enrollmentsMapper.enrollList(dto);
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
		return null;
	}
}
