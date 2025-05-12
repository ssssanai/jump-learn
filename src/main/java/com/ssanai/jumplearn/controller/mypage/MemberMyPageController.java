package com.ssanai.jumplearn.controller.mypage;


import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.mapper.comment.PostCommentMapper;
import com.ssanai.jumplearn.service.comment.CommentServiceIf;
import com.ssanai.jumplearn.service.course.EnrollmentsServiceIf;
import com.ssanai.jumplearn.service.mainpage.MainPageServiceIf;
import com.ssanai.jumplearn.service.plan.PlanServiceIf;
import com.ssanai.jumplearn.service.post.PostServiceIf;
import com.ssanai.jumplearn.util.BbsPage;
import com.ssanai.jumplearn.util.CommonUtil;
import com.ssanai.jumplearn.vo.PostCommentVO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/mypage")
public class MemberMyPageController {
	private final MainPageServiceIf mainPageService;
	private final PostServiceIf postService;
	private final EnrollmentsServiceIf enrollmentsService;
	private final CommentServiceIf commentService;
	private final PlanServiceIf planService;

	// 마이페이지
	@GetMapping
	public String myPage(
			HttpServletRequest req,
			@ModelAttribute("reqDTO") PageRequestDTO reqDTO,
			Model model
	) {
		log.info("MyPageController MyPage");
		// 회원 정보
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("loginInfo");
		// 자유게시판

		// 공지사항

		// 교육 정보 게시판

		// 대외활동 게시판

		// 자료실 게시판

		model.addAttribute("member", mDTO);
		return "member/mypage";
	}

	// 나의 강의실 진입
	@GetMapping("/studyroom")
	public String myStudyRoom(
			HttpServletRequest req,
			RedirectAttributes ra,
			@ModelAttribute("reqDTO") PageRequestDTO reqDTO,
			Model model
	) {
		log.info("MyPageController MyStudyRoom");
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
				"/mypage/studyroom/enroll?" +
						reqDTO.getLinkParamsWithoutNo() +
						(reqDTO.getSort_order() != null ? "&sort_order=" + reqDTO.getSort_order() : "")
		);

		// 2. 내가 작성한 글
		PageResponseDTO<PostDTO> PostDTOList = postService.myList(reqDTO, member_id);
		int totalCount_post = postService.getTotalCount(reqDTO, member_id);
		PostDTOList.setTotal_count(totalCount_post);
		// 내가 작성한 글 페이징
		String PostPaging = BbsPage.pagingArea(totalCount_post, reqDTO.getPage_no(), reqDTO.getPage_size(), reqDTO.getPage_block_size(),
				"/mypage/studyroom/post?" +
						reqDTO.getLinkParamsWithoutNo() +
						(reqDTO.getSort_order() != null ? "&sort_order=" + reqDTO.getSort_order() : "")
		);

		// 3. 내가 남긴 댓글
		PageResponseDTO<PostCommentVO> PostCommentVOList = commentService.getPostCommentList(reqDTO, member_id);
		int totalCount_post_comment = commentService.getPostCommentCount(reqDTO, member_id);
		PostCommentVOList.setTotal_count(totalCount_post_comment);
		// 내가 남긴 댓글 페이징
		String PostCommentPaging = BbsPage.pagingArea(totalCount_post, reqDTO.getPage_no(), reqDTO.getPage_size(), reqDTO.getPage_block_size(),
				"/mypage/studyroom/comment?" +
						reqDTO.getLinkParamsWithoutNo() +
						(reqDTO.getSort_order() != null ? "&sort_order=" + reqDTO.getSort_order() : "")
		);

		// 4. 성적표 보기
		List<EnrollmentsDTO> gradeList = enrollmentsService.getScoreList(member_id);

		// 5. 학습계획표
		List<PlanDTO> planList = planService.getPlanList(member_id);

		log.info(PostDTOList.getDtoList());
		log.info("EnrollDTOList: {}", EnrollDTOList.getDtoList().size());
		log.info("PostDTOList: {}", PostDTOList.getDtoList().size());
		log.info("PostCommentVOList: {}", PostCommentVOList.getDtoList().size());
		log.info("gradeList: {}", gradeList);
		log.info("planList: {}", planList);

		model.addAttribute("member", mDTO);
		model.addAttribute("EnrollDTOList", EnrollDTOList);
		model.addAttribute("EnrollPaging", EnrollPaging);
		model.addAttribute("PostDTOList", PostDTOList);
		model.addAttribute("PostPaging", PostPaging);
		model.addAttribute("PostCommentVOList", PostCommentVOList);
		model.addAttribute("PostCommentPaging", PostCommentPaging);
		model.addAttribute("GradeList", gradeList);
		model.addAttribute("PlanList", planList);
		return "member/studyroom";
	}

	@GetMapping("/studyroom/enroll")
	public String myStudyRoomEnroll(
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
		EnrollDTOList.setTotal_count(totalCount_enroll);
		// 강좌 페이징
		String EnrollPaging = BbsPage.pagingArea(
				totalCount_enroll, reqDTO.getPage_no(), reqDTO.getPage_size(), reqDTO.getPage_block_size(),
				"/mypage/studyroom/enroll?" +
						reqDTO.getLinkParamsWithoutNo() +
						(reqDTO.getSort_order() != null ? "&sort_order=" + reqDTO.getSort_order() : "")
		);
		PageRequestDTO emptyDTO = PageRequestDTO.builder().build();
		// 2. 내가 작성한 글
		PageResponseDTO<PostDTO> PostDTOList = postService.myList(emptyDTO, member_id);
		int totalCount_post = postService.getTotalCount(emptyDTO, member_id);
		PostDTOList.setTotal_count(totalCount_post);
		// 내가 작성한 글 페이징
		String PostPaging = BbsPage.pagingArea(totalCount_post, emptyDTO.getPage_no(), emptyDTO.getPage_size(), emptyDTO.getPage_block_size(),
				"/mypage/studyroom/post?" +
						emptyDTO.getLinkParamsWithoutNo() +
						(emptyDTO.getSort_order() != null ? "&sort_order=" + emptyDTO.getSort_order() : "")
		);

		// 3. 내가 남긴 댓글
		PageResponseDTO<PostCommentVO> PostCommentVOList = commentService.getPostCommentList(emptyDTO, member_id);
		int totalCount_post_comment = commentService.getPostCommentCount(emptyDTO, member_id);
		PostCommentVOList.setTotal_count(totalCount_post_comment);
		// 내가 남긴 댓글 페이징
		String PostCommentPaging = BbsPage.pagingArea(totalCount_post, emptyDTO.getPage_no(), emptyDTO.getPage_size(), emptyDTO.getPage_block_size(),
				"/mypage/studyroom/comment?" +
						reqDTO.getLinkParamsWithoutNo() +
						(emptyDTO.getSort_order() != null ? "&sort_order=" + emptyDTO.getSort_order() : "")
		);

		// 4. 성적표 보기
		List<EnrollmentsDTO> gradeList = enrollmentsService.getScoreList(member_id);
		// 5. 학습계획표
		List<PlanDTO> planList = planService.getPlanList(member_id);

		log.info("EnrollDTOList: {}", EnrollDTOList.getDtoList().size());
		log.info("PostDTOList: {}", PostDTOList.getDtoList().size());
		log.info("PostCommentVOList: {}", PostCommentVOList.getDtoList().size());
		log.info("gradeList: {}", gradeList);
		log.info("PostCommentPaging: {}", PostCommentPaging);

		model.addAttribute("member", mDTO);
		model.addAttribute("EnrollDTOList", EnrollDTOList);
		model.addAttribute("EnrollPaging", EnrollPaging);
		model.addAttribute("PostDTOList", PostDTOList);
		model.addAttribute("PostPaging", PostPaging);
		model.addAttribute("PostCommentVOList", PostCommentVOList);
		model.addAttribute("PostCommentPaging", PostCommentPaging);
		model.addAttribute("GradeList", gradeList);
		model.addAttribute("PlanList", planList);
		return "member/studyroom";
	}

	@GetMapping("/studyroom/post")
	public String myStudyRoomPost(
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

		// 안전한 값인지 체크
		if (reqDTO.getSearch_word() != null && !reqDTO.getSearch_word().isEmpty()) {
			if (!CommonUtil.isValidValue(reqDTO.getSearch_word())) {
				log.info("Prevent SQL Injection");
				ra.addFlashAttribute("msg", "포함할 수 없는 문자가 존재합니다.");
				return "redirect:/mypage/studyroom";
			}
		}
		PageRequestDTO emptyDTO = PageRequestDTO.builder().build();

		// 1. 강좌 목록
		PageResponseDTO<EnrollmentsDTO> EnrollDTOList = enrollmentsService.enrollList(emptyDTO, member_id);
		int totalCount_enroll = enrollmentsService.getTotalCount(emptyDTO, member_id);
		EnrollDTOList.setTotal_count(totalCount_enroll);
		// 강좌 페이징
		String EnrollPaging = BbsPage.pagingArea(
				totalCount_enroll, emptyDTO.getPage_no(), emptyDTO.getPage_size(), emptyDTO.getPage_block_size(),
				"/mypage/studyroom/enroll?" +
						emptyDTO.getLinkParamsWithoutNo() +
						(emptyDTO.getSort_order() != null ? "&sort_order=" + emptyDTO.getSort_order() : "")
		);

		// 2. 내가 작성한 글
		PageResponseDTO<PostDTO> PostDTOList = postService.myList(reqDTO, member_id);
		int totalCount_post = postService.getTotalCount(reqDTO, member_id);
		PostDTOList.setTotal_count(totalCount_post);
		// 내가 작성한 글 페이징
		String PostPaging = BbsPage.pagingArea(totalCount_post, reqDTO.getPage_no(), reqDTO.getPage_size(), reqDTO.getPage_block_size(),
				"/mypage/studyroom/post?" +
						reqDTO.getLinkParamsWithoutNo() +
						(reqDTO.getSort_order() != null ? "&sort_order=" + reqDTO.getSort_order() : "")
		);

		// 3. 내가 남긴 댓글
		PageResponseDTO<PostCommentVO> PostCommentVOList = commentService.getPostCommentList(emptyDTO, member_id);
		int totalCount_post_comment = commentService.getPostCommentCount(emptyDTO, member_id);
		PostCommentVOList.setTotal_count(totalCount_post_comment);
		// 내가 남긴 댓글 페이징
		String PostCommentPaging = BbsPage.pagingArea(totalCount_post, emptyDTO.getPage_no(), emptyDTO.getPage_size(), emptyDTO.getPage_block_size(),
				"/mypage/studyroom/comment?" +
						emptyDTO.getLinkParamsWithoutNo() +
						(emptyDTO.getSort_order() != null ? "&sort_order=" + emptyDTO.getSort_order() : "")
		);

		// 4. 성적표 보기
		List<EnrollmentsDTO> gradeList = enrollmentsService.getScoreList(member_id);
		// 5. 학습계획표
		List<PlanDTO> planList = planService.getPlanList(member_id);

		log.info("EnrollDTOList: {}", EnrollDTOList.getDtoList().size());
		log.info("PostDTOList: {}", PostDTOList.getDtoList().size());
		log.info("PostCommentVOList: {}", PostCommentVOList.getDtoList().size());

		model.addAttribute("member", mDTO);
		model.addAttribute("EnrollDTOList", EnrollDTOList);
		model.addAttribute("EnrollPaging", EnrollPaging);
		model.addAttribute("PostDTOList", PostDTOList);
		model.addAttribute("PostPaging", PostPaging);
		model.addAttribute("PostCommentVOList", PostCommentVOList);
		model.addAttribute("PostCommentPaging", PostCommentPaging);
		model.addAttribute("GradeList", gradeList);
		model.addAttribute("PlanList", planList);
		return "member/studyroom";
	}

	@GetMapping("/studyroom/comment")
	public String myStudyRoomComment(
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

		// 안전한 값인지 체크
		if (reqDTO.getSearch_word() != null && !reqDTO.getSearch_word().isEmpty()) {
			if (!CommonUtil.isValidValue(reqDTO.getSearch_word())) {
				log.info("Prevent SQL Injection");
				ra.addFlashAttribute("msg", "포함할 수 없는 문자가 존재합니다.");
				return "redirect:/mypage/studyroom";
			}
		}
		PageRequestDTO emptyDTO = PageRequestDTO.builder().build();

		// 1. 강좌 목록
		PageResponseDTO<EnrollmentsDTO> EnrollDTOList = enrollmentsService.enrollList(emptyDTO, member_id);
		int totalCount_enroll = enrollmentsService.getTotalCount(emptyDTO, member_id);
		EnrollDTOList.setTotal_count(totalCount_enroll);
		// 강좌 페이징
		String EnrollPaging = BbsPage.pagingArea(
				totalCount_enroll, emptyDTO.getPage_no(), emptyDTO.getPage_size(), emptyDTO.getPage_block_size(),
				"/mypage/studyroom/enroll?" +
						emptyDTO.getLinkParamsWithoutNo() +
						(emptyDTO.getSort_order() != null ? "&sort_order=" + emptyDTO.getSort_order() : "")
		);

		// 2. 내가 작성한 글
		PageResponseDTO<PostDTO> PostDTOList = postService.myList(emptyDTO, member_id);
		int totalCount_post = postService.getTotalCount(emptyDTO, member_id);
		PostDTOList.setTotal_count(totalCount_post);
		// 내가 작성한 글 페이징
		String PostPaging = BbsPage.pagingArea(totalCount_post, emptyDTO.getPage_no(), emptyDTO.getPage_size(), reqDTO.getPage_block_size(),
				"/mypage/studyroom/post?" +
						emptyDTO.getLinkParamsWithoutNo() +
						(emptyDTO.getSort_order() != null ? "&sort_order=" + emptyDTO.getSort_order() : "")
		);

		// 3. 내가 남긴 댓글
		PageResponseDTO<PostCommentVO> PostCommentVOList = commentService.getPostCommentList(reqDTO, member_id);
		int totalCount_post_comment = commentService.getPostCommentCount(reqDTO, member_id);
		PostCommentVOList.setTotal_count(totalCount_post_comment);
		// 내가 남긴 댓글 페이징
		String PostCommentPaging = BbsPage.pagingArea(totalCount_post, reqDTO.getPage_no(), reqDTO.getPage_size(), reqDTO.getPage_block_size(),
				"/mypage/studyroom/comment?" +
						reqDTO.getLinkParamsWithoutNo() +
						(reqDTO.getSort_order() != null ? "&sort_order=" + reqDTO.getSort_order() : "")
		);

		// 4. 성적표 보기
		List<EnrollmentsDTO> gradeList = enrollmentsService.getScoreList(member_id);
		// 5. 학습계획표
		List<PlanDTO> planList = planService.getPlanList(member_id);

		log.info("EnrollDTOList: {}", EnrollDTOList.getDtoList().size());
		log.info("PostDTOList: {}", PostDTOList.getDtoList().size());
		log.info("PostCommentVOList: {}", PostCommentVOList.getDtoList().size());

		model.addAttribute("member", mDTO);
		model.addAttribute("EnrollDTOList", EnrollDTOList);
		model.addAttribute("EnrollPaging", EnrollPaging);
		model.addAttribute("PostDTOList", PostDTOList);
		model.addAttribute("PostPaging", PostPaging);
		model.addAttribute("PostCommentVOList", PostCommentVOList);
		model.addAttribute("PostCommentPaging", PostCommentPaging);
		model.addAttribute("GradeList", gradeList);
		model.addAttribute("PlanList", planList);
		return "member/studyroom";
	}

}
