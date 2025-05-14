package com.ssanai.jumplearn.mapper.course;

import com.ssanai.jumplearn.dto.ClassDetailDTO;
import com.ssanai.jumplearn.dto.ClassQuestionDTO;
import com.ssanai.jumplearn.dto.ClassVideoDTO;
import com.ssanai.jumplearn.dto.ReviewDTO;
import com.ssanai.jumplearn.dto.course.SearchDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.vo.ClassQuestionCommentVO;
import com.ssanai.jumplearn.vo.ClassQuestionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
	public List<ClassDTO> getClassList(SearchDTO searchDTO); // 검색 조건 없는 경우
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
	public int createQuestion(@Param("dto") ClassQuestionDTO dto);
}
