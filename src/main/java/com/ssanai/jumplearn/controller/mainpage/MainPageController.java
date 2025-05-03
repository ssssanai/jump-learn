package com.ssanai.jumplearn.controller.mainpage;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.service.mainpage.MainPageServiceIf;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/main")
public class MainPageController {
	private final MainPageServiceIf mainPageService;

	@GetMapping
	public String mainPage(HttpServletRequest req, Model model) {
		log.info("MainPageController GET");
		log.info(req.getSession().getAttribute("loginInfo"));
		MemberDTO reqDTO = (MemberDTO) req.getSession().getAttribute("loginInfo");
		List<ClassDTO> recommendList;
		if (reqDTO != null) {
			MemberDTO memberDTO = mainPageService.getMemberInfo(reqDTO.getId()); // 멤버 정보 가져오기
			recommendList = mainPageService.getRecommendClassWithTarget(memberDTO.getGrade()); // 추천 강좌 목록
			model.addAttribute("member", memberDTO);
		} else {
			recommendList = mainPageService.getRecommendClassWithoutTarget(); // 추천 강좌 목록
		}
		model.addAttribute("recommendList", recommendList);

		List<ClassDTO> classDTOList = mainPageService.getBottomCards();
		List<ClassDTO> hs1List = classDTOList.stream().filter(dto -> dto.getTarget().equals("고1")).toList();
		List<ClassDTO> hs2List = classDTOList.stream().filter(dto -> dto.getTarget().equals("고2")).toList();
		List<ClassDTO> hs3List = classDTOList.stream().filter(dto -> dto.getTarget().equals("고3")).toList();
		List<ClassDTO> repeaterList = classDTOList.stream().filter(dto -> dto.getTarget().equals("N수생")).toList();

		model.addAttribute("hs1List", hs1List);
		model.addAttribute("hs2List", hs2List);
		model.addAttribute("hs3List", hs3List);
		model.addAttribute("repeaterList", repeaterList);

		return "mainPage/mainPage";
	}
}
