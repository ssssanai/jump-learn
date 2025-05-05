package com.ssanai.jumplearn.controller.course;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.course.SearchDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.service.course.CourseServiceIf;
import com.ssanai.jumplearn.service.mainpage.MainPageServiceIf;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/course")
public class CourseController {
	private final CourseServiceIf courseService;
	private final MainPageServiceIf mainPageService;

	// 최초 진입 시
	@GetMapping("/list")
	public String list(HttpServletRequest req, Model model) {
		log.info("CourseController GET");
		// 학생 정보
		MemberDTO reqDTO = (MemberDTO) req.getSession().getAttribute("loginInfo");
		MemberDTO memberDTO = mainPageService.getMemberInfo(reqDTO.getId());
		log.info(memberDTO);
		// 장바구니 목록
		List<BasketDTO> basketList = courseService.getBasketList(reqDTO.getId());
		log.info(basketList);

		// 강좌 목록
		List<ClassDTO> courseList = courseService.getClassList();
		log.info(courseList);

		model.addAttribute("member", memberDTO);
		model.addAttribute("basketList", basketList);
		model.addAttribute("courseList", courseList);
		return "course/list";
	}

	// TODO 2: course list POST (검색시)
	@PostMapping("/list")
	public String list(
			@ModelAttribute("frm_search") SearchDTO searchDTO,
			Model model
	) {
		log.info(searchDTO.toString());
		return "course/list";
	}
	// TODO 3: course detail GET (진입시)

}
