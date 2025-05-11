package com.ssanai.jumplearn.mapper.comment;

import com.ssanai.jumplearn.vo.InquiryCommentVO;
import com.ssanai.jumplearn.vo.PostCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InquiryCommentMapper {
	public List<InquiryCommentVO> getInquiryCommentList(@Param("member_id") String member_id);
}
