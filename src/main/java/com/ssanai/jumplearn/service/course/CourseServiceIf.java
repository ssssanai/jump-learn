package com.ssanai.jumplearn.service.course;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.dto.course.SearchDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.vo.ClassQuestionCommentVO;
import com.ssanai.jumplearn.vo.ClassQuestionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseServiceIf {
	public List<ClassDTO> getClassList(SearchDTO searchDTO);
	public int getListTotalCount(SearchDTO searchDTO);
	public ClassDetailDTO getClassDetailById(@Param("id") int id);
	public List<ClassVideoDTO> getClassVideoList(@Param("id") int id);
	public int checkReviewExist(@Param("id") int id);
	public double getReviewRate(@Param("id") int id);
	public List<ReviewDTO> getReviewListById(@Param("id") int id);
	public int isPurchased(@Param("class_id") int class_id, @Param("member_id") String member_id);
	// 강좌 질문
	public List<ClassQuestionVO> getClassQuestionList(@Param("class_id") int class_id, @Param("member_id") String member_id);
	public ClassQuestionCommentVO getClassQuestionComment(@Param("question_id") int id);
	public ClassQuestionDTO getQuestionDTO(ClassQuestionVO q, ClassQuestionCommentVO qc);
	public int createQuestion(@Param("dto") ClassQuestionDTO dto);
	// 강의 자료
	public List<ClassDataDTO> getClassDataList(@Param("class_id") int class_id);
}
