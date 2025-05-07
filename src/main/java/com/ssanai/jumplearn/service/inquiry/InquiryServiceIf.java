package com.ssanai.jumplearn.service.inquiry;

import com.ssanai.jumplearn.dto.InquiryDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.vo.InquiryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InquiryServiceIf {
	public int getInquiryTotalCount(PageRequestDTO dto);
	public PageResponseDTO<InquiryDTO> getInquiryList(PageRequestDTO dto);
	public List<InquiryDTO> getInquiry(@Param("id") int id);

	public int register(InquiryDTO dto);
	public int modify(InquiryDTO dto);
	public int delete(@Param("id") int id);
}
