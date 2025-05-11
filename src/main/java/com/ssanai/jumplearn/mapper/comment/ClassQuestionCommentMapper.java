package com.ssanai.jumplearn.mapper.comment;

import com.ssanai.jumplearn.vo.ClassQuestionCommentVO;
import com.ssanai.jumplearn.vo.PostCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassQuestionCommentMapper {
	public List<ClassQuestionCommentVO> getClassQuestionCommentList(@Param("member_id") String member_id);
}
