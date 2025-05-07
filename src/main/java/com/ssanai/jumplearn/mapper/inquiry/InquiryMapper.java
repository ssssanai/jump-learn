package com.ssanai.jumplearn.mapper.inquiry;

import com.ssanai.jumplearn.dto.InquiryDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.vo.InquiryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InquiryMapper {
	public int getInquiryTotalCount(PageRequestDTO dto);
	public List<InquiryDTO> getInquiryList(PageRequestDTO dto);
	public List<InquiryDTO> getInquiry(@Param("id") int id);

	public int register(InquiryVO vo);
	public int modify(InquiryVO vo);
	public int delete(@Param("id") int id);
}
