package com.ssanai.jumplearn.controller.course;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.dto.course.SearchDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.service.basket.BasketServiceIf;
import com.ssanai.jumplearn.service.course.CourseServiceIf;
import com.ssanai.jumplearn.service.course.EnrollmentsServiceIf;
import com.ssanai.jumplearn.service.mainpage.MainPageServiceIf;
import com.ssanai.jumplearn.util.BbsPage;
import com.ssanai.jumplearn.vo.EnrollmentsVO;
import com.ssanai.jumplearn.vo.PayVO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/course")
public class CourseController {
	private final BasketServiceIf basketService;
	private final CourseServiceIf courseService;
	private final EnrollmentsServiceIf enrollmentsService;
	private final MainPageServiceIf mainPageService;

	@RequestMapping("/list")
	public String list(
			HttpServletRequest req,
			@ModelAttribute("frm_search") SearchDTO searchDTO, // 자동 바인딩
			Model model
	) {
		log.info(searchDTO.toString());
		searchDTO.setSearch_word(searchDTO.getSearch_word() != null ? searchDTO.getSearch_word().trim() : "");
		searchDTO.setSearch_condition1(searchDTO.getSearch_condition1() != null ? searchDTO.getSearch_condition1().trim() : "");
		searchDTO.setSearch_condition2(searchDTO.getSearch_condition2() != null ? searchDTO.getSearch_condition2().trim() : "");
		searchDTO.setSearch_condition3(searchDTO.getSearch_condition3() != null ? searchDTO.getSearch_condition3().trim() : "");
		searchDTO.setSort_condition(searchDTO.getSort_condition() != null ? searchDTO.getSort_condition().trim() : "");

		// 학생 정보
		MemberDTO reqDTO = (MemberDTO) req.getSession().getAttribute("loginInfo");
		MemberDTO memberDTO = mainPageService.getMemberInfo(reqDTO.getId());
		// 장바구니 목록
		List<BasketDTO> basketList = basketService.getBasketList(memberDTO.getId());
		log.info(basketList);

		// 강좌 목록
		List<ClassDTO> courseList = courseService.getClassList(searchDTO);
		log.info(courseList);

		// 제외목록
		List<Integer> exceptList = new ArrayList<>();
		for (ClassDTO classDTO : courseList) {
			for (BasketDTO basketDTO : basketList) {
				if (basketDTO.getClass_id() == classDTO.getId()) {
					exceptList.add(classDTO.getId());
				}
			}
		}
		List<EnrollmentsVO> enrollList = enrollmentsService.getList(memberDTO.getId());

		for(ClassDTO classDTO : courseList) {
			for (EnrollmentsVO vo: enrollList){
				if(vo.getClass_id() == classDTO.getId()){
					exceptList.add(classDTO.getId());
				}
			}
		}
		// 검색된 강좌 개수
		int total_count = courseService.getListTotalCount(searchDTO);
		log.info(total_count);

		int page_no = searchDTO.getPage_no();

		int total_page = (int) Math.ceil(total_count / (double) searchDTO.getPage_size());
		total_page = Math.max(total_page, 1);
		int startPage = (int) Math.floor((page_no - 1) / (double) searchDTO.getPage_size()) * searchDTO.getPage_size() + 1;
		int endPage = (int) Math.ceil(page_no / (double) searchDTO.getPage_size()) * searchDTO.getPage_size();
		endPage = Math.min(endPage, total_page);

		model.addAttribute("total_count", total_count);
		model.addAttribute("total_page", total_page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		model.addAttribute("total_count", total_count);
		model.addAttribute("member", memberDTO);
		model.addAttribute("basketList", basketList);
		model.addAttribute("courseList", courseList);
		model.addAttribute("exceptList", exceptList);
		model.addAttribute("searchDTO", searchDTO);
		return "course/list";
	}

	@GetMapping("/detail/{class_id}")
	public String detail(
			HttpServletRequest req
			, RedirectAttributes ra
			, @PathVariable("class_id") int id // 강좌 ID
			, Model model
	) {
		log.info(id);
//		 회원 정보
		MemberDTO loginInfo = (MemberDTO) req.getSession().getAttribute("loginInfo");

		// 로그인 체크
		if (loginInfo == null) {
			log.info("Not Logged In Member");
			ra.addFlashAttribute("msg", "로그인 후 사용 가능한 서비스입니다.");
			return "redirect:/member/login";
		}
		String member_id = loginInfo.getId();

		// pay에 있는 강좌인 경우 수강 목록으로 이동
		int isPurchased = courseService.isPurchased(id, member_id);
		if(isPurchased > 0) {
			return "redirect:/studyroom/enroll/"+id ;
		}

		int isInBasket = basketService.isBasketExist(id, member_id);
		if(isInBasket > 0) {
			model.addAttribute("isInBasket", true);
		}

		ClassDetailDTO classDetailDTO = courseService.getClassDetailById(id);
		List<ReviewDTO> reviewList = courseService.getReviewListById(id);
		reviewList = reviewList.stream().filter(dto -> dto.getReview() != null).toList();
		List<ClassVideoDTO> videoList = courseService.getClassVideoList(id);
		double rate = courseService.getReviewRate(id);


		model.addAttribute("classDetailDTO", classDetailDTO);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("videoList", videoList);
		model.addAttribute("reviewRate", rate);
		return "course/detail";
	}


}
