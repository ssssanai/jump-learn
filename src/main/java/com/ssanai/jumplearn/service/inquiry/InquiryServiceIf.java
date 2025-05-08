package com.ssanai.jumplearn.service.inquiry;

import com.ssanai.jumplearn.dto.InquiryDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.vo.InquiryCommentVO;
import com.ssanai.jumplearn.vo.InquiryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InquiryServiceIf {
	// QnA 조회
	public int getInquiryTotalCount(PageRequestDTO dto);
	public PageResponseDTO<InquiryDTO> getInquiryList(PageRequestDTO dto);
	public List<InquiryDTO> getInquiry(@Param("id") int id);
	// QnA 등록 수정 삭제
	public int register(InquiryDTO dto);
	public int modify(InquiryDTO dto);
	public int delete(@Param("id") int id);
	// QnA 댓글
	public int addComment(InquiryDTO dto);
}
