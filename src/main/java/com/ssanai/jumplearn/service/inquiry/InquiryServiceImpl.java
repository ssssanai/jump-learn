package com.ssanai.jumplearn.service.inquiry;

import com.ssanai.jumplearn.dto.InquiryDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.mapper.inquiry.InquiryMapper;
import com.ssanai.jumplearn.vo.InquiryVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryServiceIf {
	private final InquiryMapper inquiryMapper;
	private final ModelMapper modelMapper;

	@Override
	public int getInquiryTotalCount(PageRequestDTO dto) {
		return inquiryMapper.getInquiryTotalCount(dto);
	}

	@Override
	public PageResponseDTO<InquiryDTO> getInquiryList(PageRequestDTO dto) {
		int totalCount = getInquiryTotalCount(dto);
		List<InquiryDTO> inquiryList = inquiryMapper.getInquiryList(dto);
		PageResponseDTO<InquiryDTO> pageResponseDTO =
				PageResponseDTO.<InquiryDTO>withAll().reqDTO(dto).dtoList(inquiryList).total_count(totalCount).build();
		return pageResponseDTO;
	}

	@Override
	public List<InquiryDTO> getInquiry(int id) {
		List<InquiryDTO> inquiry = inquiryMapper.getInquiry(id);
		log.info(inquiry);
		return inquiry;
	}

	@Override
	public int register(InquiryDTO dto) {
		InquiryVO vo = InquiryVO.builder()
				.title(dto.getInquiry_title())
				.member_id(dto.getMember_id())
				.content(dto.getInquiry_content())
				.visibility(dto.getVisibility())
				.build();
		log.info(vo);
		int result = inquiryMapper.register(vo);
		log.info(result);
		return result;
	}

	@Override
	public int modify(InquiryDTO dto) {
		InquiryVO vo = InquiryVO.builder()
				.id(dto.getInquiry_id())
				.title(dto.getInquiry_title())
				.content(dto.getInquiry_content())
				.visibility(dto.getVisibility())
				.build();
		log.info(vo);
		int result = inquiryMapper.modify(vo);
		log.info(result);
		return result;
	}

	@Override
	public int delete(int id) {
		return inquiryMapper.delete(id);
	}
}
