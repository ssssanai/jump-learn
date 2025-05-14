package com.ssanai.jumplearn.controller.mypage;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.service.comment.CommentServiceIf;
import com.ssanai.jumplearn.service.course.CourseServiceIf;
import com.ssanai.jumplearn.service.course.EnrollmentsServiceIf;
import com.ssanai.jumplearn.service.mainpage.MainPageServiceIf;
import com.ssanai.jumplearn.service.plan.PlanServiceIf;
import com.ssanai.jumplearn.service.post.PostServiceIf;
import com.ssanai.jumplearn.util.BbsPage;
import com.ssanai.jumplearn.util.CommonUtil;
import com.ssanai.jumplearn.vo.ClassQuestionCommentVO;
import com.ssanai.jumplearn.vo.ClassQuestionVO;
import com.ssanai.jumplearn.vo.PostCommentVO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/studyroom")
public class StudyRoomController {
	private final MainPageServiceIf mainPageService;
	private final PostServiceIf postService;
	private final EnrollmentsServiceIf enrollmentsService;
	private final CommentServiceIf commentService;
	private final PlanServiceIf planService;
	private final CourseServiceIf courseService;

	// 나의 강좌 리스트
	@GetMapping(value = {"/enroll", "/"})
	public String myStudyRoom(
			HttpServletRequest req,
			RedirectAttributes ra,
			@ModelAttribute("reqDTO") PageRequestDTO reqDTO,
			Model model
	) {
		log.info("/studyroom/enroll");
		log.info(reqDTO);
		// 회원 정보
		MemberDTO loginInfo = (MemberDTO) req.getSession().getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo == null) {
			log.info("Not Logged In Member");
			ra.addFlashAttribute("msg", "로그인 후 사용 가능한 서비스입니다.");
			return "redirect:/member/login";
		}
		String member_id = loginInfo.getId();
		MemberDTO mDTO = mainPageService.getMemberInfo(member_id);
		log.info(mDTO);

		// 안전한 값인지 체크
		if (reqDTO.getSearch_word() != null && !reqDTO.getSearch_word().isEmpty()) {
			if (!CommonUtil.isValidValue(reqDTO.getSearch_word())) {
				log.info("Prevent SQL Injection");
				ra.addFlashAttribute("msg", "포함할 수 없는 문자가 존재합니다.");
				return "redirect:/mypage/studyroom";
			}
		}

		// 1. 강좌 목록
		PageResponseDTO<EnrollmentsDTO> EnrollDTOList = enrollmentsService.enrollList(reqDTO, member_id);
		int totalCount_enroll = enrollmentsService.getTotalCount(reqDTO, member_id);
		log.info(totalCount_enroll);
		EnrollDTOList.setTotal_count(totalCount_enroll);

		// 강좌 페이징
		String EnrollPaging = BbsPage.pagingArea(
				totalCount_enroll, reqDTO.getPage_no(), reqDTO.getPage_size(), reqDTO.getPage_block_size(),
				"/studyroom/enroll?" +
						reqDTO.getLinkParamsWithoutNo() +
						(reqDTO.getSort_order() != null ? "&sort_order=" + reqDTO.getSort_order() : "")
		);

		log.info("EnrollDTOList: {}", EnrollDTOList.getDtoList().size());

		model.addAttribute("member", mDTO);
		model.addAttribute("EnrollDTOList", EnrollDTOList);
		model.addAttribute("EnrollPaging", EnrollPaging);
		return "member/studyroom";
	}

	@GetMapping("/enroll/{class_id}")
	public String enrollDetail(
			HttpServletRequest req,
			@PathVariable("class_id") int class_id,
			RedirectAttributes ra,
			@ModelAttribute("reqDTO") PageRequestDTO reqDTO,
			Model model
	) {
		log.info("수강 강좌 상세 화면 > class_id = {}", class_id);

		// 회원 정보
		MemberDTO loginInfo = (MemberDTO) req.getSession().getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo == null) {
			log.info("Not Logged In Member");
			ra.addFlashAttribute("msg", "로그인 후 사용 가능한 서비스입니다.");
			return "redirect:/member/login";
		}
		String member_id = loginInfo.getId();
		MemberDTO mDTO = mainPageService.getMemberInfo(member_id);

		ClassDetailDTO classDetailDTO = courseService.getClassDetailById(class_id);
		List<ReviewDTO> reviewList = courseService.getReviewListById(class_id);
		List<ClassVideoDTO> videoList = courseService.getClassVideoList(class_id);
		boolean isReviewed = false;
		for (ReviewDTO reviewDTO : reviewList) {
			if (reviewDTO.getMember_id().equals(member_id)
					&& reviewDTO.getReview() != null
					&& reviewDTO.getFeedback_score() > 0
			) {
				isReviewed = true;
			}
		}
//		log.info(isReviewed);
//		log.info("필터링 전 리뷰목록" + reviewList);
		reviewList = reviewList.stream().filter(dto -> dto.getReview() != null).toList();
//		log.info("필터링 후 리뷰목록" + reviewList);

		List<ClassQuestionDTO> qList = new ArrayList<>();
		// 내가 선생님한테 질문한 목록 가져오기
		List<ClassQuestionVO> questedList = courseService.getClassQuestionList(class_id, member_id);
		log.info("강좌 ID: {}", class_id);
//		log.info("내가 한 질문: {}", questedList);
		// 선생님이 답글 단 거 가져오기 -> Map에 담아서 전달
		if (questedList != null && !questedList.isEmpty()) {
			for (ClassQuestionVO vo : questedList) {
				// vo의 ID == tbl_class_question_comment.question_id 로 검사
				ClassQuestionCommentVO qc = courseService.getClassQuestionComment(vo.getId());
				if (qc != null) {
					qList.add(courseService.getQuestionDTO(vo, qc));
				} else {
					qList.add(
							ClassQuestionDTO.builder()
									.id(vo.getId())
									.class_id(vo.getClass_id())
									.member_id(vo.getMember_id())
									.title(vo.getTitle())
									.content(vo.getContent())
									.created_at(vo.getCreated_at())
									.updated_at(vo.getUpdated_at())
									.visibility(vo.getVisibility())
									.is_answered(vo.getIs_answered())
									.build()
					);
				}
			}
		}
//		log.info("qList: {}", qList);
		// 파일 가져오기
		List<ClassDataDTO> cdList = courseService.getClassDataList(class_id);
		log.info(cdList);

		model.addAttribute("member", mDTO);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("classDetailDTO", classDetailDTO);
		model.addAttribute("videoList", videoList);
		model.addAttribute("isReviewed", isReviewed);
		model.addAttribute("qList", qList);
		model.addAttribute("cdList", cdList);
		return "member/detail";
	}

	@PostMapping("/update_review")
	public String updateReview(
			@ModelAttribute("review") EnrollmentsDTO enrollments,
			RedirectAttributes ra,
			Model model
	) {
		log.info("리뷰 업데이트");
		log.info(model.getAttribute("member"));
		log.info(enrollments);

		if (!(enrollments.getFeedback_score() >= 1 && enrollments.getFeedback_score() <= 5)) {
			log.info("리뷰 점수 오류");
			ra.addFlashAttribute("msg", "평점은 1~5점에서 선택 가능합니다.");
			return "redirect:/studyroom/enroll/" + enrollments.getClass_id();
		}

		int result = enrollmentsService.updateReview(enrollments);
		if (result < 0) {
			log.info(enrollments);
			log.info("리뷰 등록 실패");
			ra.addFlashAttribute("msg", "리뷰 등록에 실패했습니다.");
		} else {
			log.info("리뷰 등록 성공");
			ra.addFlashAttribute("msg", "리뷰를 정상적으로 등록했습니다.");
		}
		return "redirect:/studyroom/enroll/" + enrollments.getClass_id();
	}

	@PostMapping("/class_question")
	public String classQuestion(
			@ModelAttribute("class_question") ClassQuestionDTO question,
			RedirectAttributes ra,
			Model model
	) {
		log.info("question: " + question);
		int result = courseService.createQuestion(question);
		if (result > 0) {
			ra.addFlashAttribute("msg", "질문을 등록했습니다.");
		} else {
			ra.addFlashAttribute("msg", "질문 등록에 실패했습니다.");
		}
		return "redirect:/studyroom/enroll/" + question.getClass_id();
	}

	// 내가 작성한 게시글
	@GetMapping("/post")
	public String myStudyRoomPost(
			HttpServletRequest req,
			RedirectAttributes ra,
			@ModelAttribute("reqDTO") PageRequestDTO reqDTO,
			Model model
	) {
		log.info("/studyroom/post");
		log.info(reqDTO);
		// 회원 정보
		MemberDTO loginInfo = (MemberDTO) req.getSession().getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo == null) {
			log.info("Not Logged In Member");
			ra.addFlashAttribute("msg", "로그인 후 사용 가능한 서비스입니다.");
			return "redirect:/member/login";
		}
		String member_id = loginInfo.getId();
		MemberDTO mDTO = mainPageService.getMemberInfo(member_id);
		log.info(mDTO);

		// 안전한 값인지 체크
		if (reqDTO.getSearch_word() != null && !reqDTO.getSearch_word().isEmpty()) {
			if (!CommonUtil.isValidValue(reqDTO.getSearch_word())) {
				log.info("Prevent SQL Injection");
				ra.addFlashAttribute("msg", "포함할 수 없는 문자가 존재합니다.");
				return "redirect:/mypage/studyroom";
			}
		}

		// 2. 내가 작성한 글
		PageResponseDTO<PostDTO> PostDTOList = postService.myList(reqDTO, member_id);
		int totalCount_post = postService.getTotalCount(reqDTO, member_id);
		PostDTOList.setTotal_count(totalCount_post);
		// 내가 작성한 글 페이징
		String PostPaging = BbsPage.pagingArea(totalCount_post, reqDTO.getPage_no(), reqDTO.getPage_size(), reqDTO.getPage_block_size(),
				"/studyroom/post?" +
						reqDTO.getLinkParamsWithoutNo() +
						(reqDTO.getSort_order() != null ? "&sort_order=" + reqDTO.getSort_order() : "")
		);

		log.info("PostDTOList: {}", PostDTOList.getDtoList().size());

		model.addAttribute("member", mDTO);
		model.addAttribute("PostDTOList", PostDTOList);
		model.addAttribute("PostPaging", PostPaging);
		return "member/studyroom";
	}

	@GetMapping("/comment")
	public String myStudyRoomComment(
			HttpServletRequest req,
			RedirectAttributes ra,
			@ModelAttribute("reqDTO") PageRequestDTO reqDTO,
			Model model
	) {
		log.info("/studyroom/comment");
		log.info(reqDTO);
		// 회원 정보
		MemberDTO loginInfo = (MemberDTO) req.getSession().getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo == null) {
			log.info("Not Logged In Member");
			ra.addFlashAttribute("msg", "로그인 후 사용 가능한 서비스입니다.");
			return "redirect:/member/login";
		}
		String member_id = loginInfo.getId();
		MemberDTO mDTO = mainPageService.getMemberInfo(member_id);
		log.info(mDTO);

		// 안전한 값인지 체크
		if (reqDTO.getSearch_word() != null && !reqDTO.getSearch_word().isEmpty()) {
			if (!CommonUtil.isValidValue(reqDTO.getSearch_word())) {
				log.info("Prevent SQL Injection");
				ra.addFlashAttribute("msg", "포함할 수 없는 문자가 존재합니다.");
				return "redirect:/mypage/studyroom";
			}
		}

		// 3. 내가 남긴 댓글
		PageResponseDTO<PostCommentVO> PostCommentVOList = commentService.getPostCommentList(reqDTO, member_id);
		int totalCount_post_comment = commentService.getPostCommentCount(reqDTO, member_id);
		PostCommentVOList.setTotal_count(totalCount_post_comment);
		// 내가 남긴 댓글 페이징
		String PostCommentPaging = BbsPage.pagingArea(totalCount_post_comment, reqDTO.getPage_no(), reqDTO.getPage_size(), reqDTO.getPage_block_size(),
				"/studyroom/comment?" +
						reqDTO.getLinkParamsWithoutNo() +
						(reqDTO.getSort_order() != null ? "&sort_order=" + reqDTO.getSort_order() : "")
		);

		log.info("PostCommentVOList: {}", PostCommentVOList.getDtoList().size());

		model.addAttribute("member", mDTO);
		model.addAttribute("PostCommentVOList", PostCommentVOList);
		model.addAttribute("PostCommentPaging", PostCommentPaging);
		return "member/studyroom";
	}


	@GetMapping("/score")
	public String myStudyRoomScore(
			HttpServletRequest req,
			RedirectAttributes ra,
			@ModelAttribute("reqDTO") PageRequestDTO reqDTO,
			Model model
	) {
		log.info("MyPageController MyStudyRoom Enroll");
		log.info(reqDTO);
		// 회원 정보
		MemberDTO loginInfo = (MemberDTO) req.getSession().getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo == null) {
			log.info("Not Logged In Member");
			ra.addFlashAttribute("msg", "로그인 후 사용 가능한 서비스입니다.");
			return "redirect:/member/login";
		}
		String member_id = loginInfo.getId();
		MemberDTO mDTO = mainPageService.getMemberInfo(member_id);
		log.info(mDTO);
		// 4. 성적표 보기
		List<EnrollmentsDTO> gradeList = enrollmentsService.getScoreList(member_id);

		model.addAttribute("member", mDTO);
		model.addAttribute("GradeList", gradeList);
		return "member/studyroom";
	}

	@GetMapping("/plan")
	public String myStudyRoomPlanList(
			HttpServletRequest req,
			RedirectAttributes ra,
			@ModelAttribute("reqDTO") PageRequestDTO reqDTO,
			Model model
	) {
		log.info("MyPageController MyStudyRoom Enroll");
		log.info(reqDTO);
		// 회원 정보
		MemberDTO loginInfo = (MemberDTO) req.getSession().getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo == null) {
			log.info("Not Logged In Member");
			ra.addFlashAttribute("msg", "로그인 후 사용 가능한 서비스입니다.");
			return "redirect:/member/login";
		}
		String member_id = loginInfo.getId();
		MemberDTO mDTO = mainPageService.getMemberInfo(member_id);
		log.info(mDTO);
		// 5. 학습계획표
		List<PlanDTO> planList = planService.getPlanListByDate(member_id, LocalDate.now());

		model.addAttribute("member", mDTO);
		model.addAttribute("PlanList", planList);
		model.addAttribute("date", LocalDate.now().toString());
		return "member/studyroom";
	}

	@GetMapping("/plan/{date}")
	public String myStudyRoomPlanList(
			HttpServletRequest req,
			RedirectAttributes ra,
			@ModelAttribute("reqDTO") PageRequestDTO reqDTO,
			@PathVariable("date") String date,
			Model model
	) {
		log.info("MyPageController MyStudyRoom Enroll");
		log.info(reqDTO);
		// 회원 정보
		MemberDTO loginInfo = (MemberDTO) req.getSession().getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo == null) {
			log.info("Not Logged In Member");
			ra.addFlashAttribute("msg", "로그인 후 사용 가능한 서비스입니다.");
			return "redirect:/member/login";
		}

		LocalDate lDate = null;
		// 날짜 체크
		try {
			lDate = LocalDate.parse(date);
		} catch (DateTimeParseException e) {
			ra.addFlashAttribute("msg", "날짜 형식이 잘못되었습니다.");
			return "redirect:/studyroom/plan";
		}

		String member_id = loginInfo.getId();
		MemberDTO mDTO = mainPageService.getMemberInfo(member_id);
		log.info(mDTO);
		// 5. 학습계획표
		List<PlanDTO> planList = planService.getPlanListByDate(member_id, lDate);

		model.addAttribute("member", mDTO);
		model.addAttribute("PlanList", planList);
		return "member/studyroom";
	}
	// 강좌 질문
}
