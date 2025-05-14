package com.ssanai.jumplearn.service.course;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.dto.course.SearchDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.mapper.basket.BasketMapper;
import com.ssanai.jumplearn.mapper.course.CourseMapper;
import com.ssanai.jumplearn.vo.ClassQuestionCommentVO;
import com.ssanai.jumplearn.vo.ClassQuestionVO;
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
public class CourseServiceImpl implements CourseServiceIf {
	private final CourseMapper courseMapper;
	private final ModelMapper modelMapper;

	@Override
	public List<ClassDTO> getClassList(SearchDTO searchDTO) {
		return courseMapper.getClassList(searchDTO);
	}

	@Override
	public int getListTotalCount(SearchDTO searchDTO) {
		return courseMapper.getListTotalCount(searchDTO);
	}

	@Override
	public ClassDetailDTO getClassDetailById(int id) {
		return courseMapper.getClassDetailById(id);
	}

	@Override
	public List<ClassVideoDTO> getClassVideoList(int id) {
		return courseMapper.getClassVideoList(id);
	}

	@Override
	public List<ReviewDTO> getReviewListById(int id) {
		return courseMapper.getReviewListById(id);
	}

	@Override
	public int checkReviewExist(int id) {
		return courseMapper.checkReviewExist(id);
	}

	@Override
	public double getReviewRate(int id) {
		if (checkReviewExist(id) > 0) {
			double rate = courseMapper.getReviewRate(id);
			log.info("Review Rate : {}", rate);
			return rate;
		} else {
			log.info("Review not exist");
			return 0;
		}
	}

	@Override
	public int isPurchased(int class_id, String member_id) {
		return courseMapper.isPurchased(class_id, member_id);
	}

	@Override
	public List<ClassQuestionVO> getClassQuestionList(int class_id, String member_id) {
		return courseMapper.getClassQuestionList(class_id, member_id);
	}

	@Override
	public ClassQuestionCommentVO getClassQuestionComment(int question_id) {
		return courseMapper.getClassQuestionComment(question_id);
	}

	@Override
	public ClassQuestionDTO getQuestionDTO(ClassQuestionVO q, ClassQuestionCommentVO qc) {
		return ClassQuestionDTO.builder()
				.id(q.getId()) // 질문 PK
				.class_id(q.getClass_id()) // 강좌 ID
				.member_id(q.getMember_id()) // 질문자
				.title(q.getTitle()) // 질문 제목
				.content(q.getContent()) // 질문 내용
				.created_at(q.getCreated_at()) // 질문 생성 일시
				.updated_at(q.getUpdated_at()) // 질문 업데이트 일시
				.visibility(q.getVisibility()) // 공개 비공개 여부
				.is_answered(q.getIs_answered()) // 답글되었는지 여부
				.comment_id(qc.getId()) // 답글 PK
				.commenter(qc.getCommenter()) // 답변자
				.comment_id_type(qc.getComment_id_type()) // 답변자 type
				.quested_content(qc.getContent()) // 답변 내용
				.quested_created_at(qc.getCreated_at()) // 답변 일시
				.quested_updated_at(qc.getUpdated_at()) // 답변 갱신 일시
				.build();
	}

	@Override
	public int createQuestion(ClassQuestionDTO dto) {
		return courseMapper.createQuestion(dto);
	}
}
