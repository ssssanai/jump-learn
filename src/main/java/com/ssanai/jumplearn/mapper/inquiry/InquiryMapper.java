package com.ssanai.jumplearn.mapper.inquiry;

import com.ssanai.jumplearn.dto.InquiryDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.vo.InquiryCommentVO;
import com.ssanai.jumplearn.vo.InquiryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InquiryMapper {
	// QnA 조회
	public int getInquiryTotalCount(PageRequestDTO dto);
	public List<InquiryDTO> getInquiryList(PageRequestDTO dto);
	public List<InquiryDTO> getInquiry(@Param("id") int id);
	// QnA 등록 수정 삭제
	public int register(InquiryVO vo);
	public int modify(InquiryVO vo);
	public int delete(@Param("id") int id);
	// QnA 댓글
	public int addComment(InquiryCommentVO vo);
	public int updateComment(InquiryCommentVO vo);
	public int deleteComment(@Param("id") int id);
}
