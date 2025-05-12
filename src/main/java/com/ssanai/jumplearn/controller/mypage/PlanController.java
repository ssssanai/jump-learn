package com.ssanai.jumplearn.controller.mypage;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PlanDTO;
import com.ssanai.jumplearn.service.mainpage.MainPageServiceIf;
import com.ssanai.jumplearn.service.plan.PlanServiceIf;
import com.ssanai.jumplearn.util.CommonUtil;
import com.ssanai.jumplearn.vo.PlanVO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/plan")
public class PlanController {
	private final MainPageServiceIf mainPageService;
	private final PlanServiceIf planService;

	@GetMapping("/create/{date}")
	public String createPlan(
			HttpServletRequest req,
			RedirectAttributes ra,
			@PathVariable("date") String date,
			Model model
	) {
		log.info("/plan/create GET");
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
//		log.info(mDTO);
//		log.info(date);
		LocalDate lDate = null;
		// 날짜 체크
		try {
			lDate = LocalDate.parse(date);
		} catch (DateTimeParseException e) {
			ra.addFlashAttribute("msg", "날짜 형식이 잘못되었습니다.");
			return "redirect:/studyroom/plan";
		}

		model.addAttribute("mDTO", mDTO);
		model.addAttribute("date", date);
		return "member/calendarWrite";
	}

	@PostMapping("/create")
	public String createPlan(
			HttpServletRequest req,
			RedirectAttributes ra,
			@RequestParam("date") String date,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			Model model
	) {
		log.info("/plan/create POST");
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

		log.info(date);
		log.info(title);
		log.info(content);

		LocalDate lDate = null;
		// 날짜 체크
		try {
			lDate = LocalDate.parse(date);
		} catch (DateTimeParseException e) {
			ra.addFlashAttribute("msg", "날짜 형식이 잘못되었습니다.");
			return "redirect:/studyroom/plan";
		}

		log.info("lDate: {}", lDate);
		// 제목 체크
		if (!CommonUtil.isValidValue(title)) {
			ra.addAttribute("msg", "--, $$, #, /*, ', \" 은 포함될 수 없습니다.");
			return "redirect:/plan/create/" + date;
		} else if (title.length() < 4 || title.length() > 101) {
			ra.addAttribute("msg", "제목은 5자 이상 100자 이하여야 합니다.");
			return "redirect:/plan/create/" + date;
		}
		// 내용 체크
		if (!CommonUtil.isValidValue(content)) {
			ra.addAttribute("msg", "--, $$, #, /*, ', \" 은 포함될 수 없습니다.");
			return "redirect:/plan/create/" + date;
		} else if (content.length() < 10 || content.length() > 201) {
			ra.addAttribute("msg", "내용은 10자 이상 200자 이하여야 합니다.");
			return "redirect:/plan/create/" + date;
		}

		PlanDTO dto = PlanDTO.builder()
				.member_id(member_id)
				.title(title)
				.description(content)
				.study_date(lDate)
				.build();

		int result = planService.createPlan(dto);
		if (result > 0) {
			ra.addAttribute("msg", "학습 계획을 성공적으로 등록했습니다!");
		} else {
			ra.addAttribute("msg", "학습 계획 등록에 실패했습니다.");
		}

		return "redirect:/studyroom/plan";
	}

	@GetMapping("/update/{id}/{date}")
	public String updatePlan(
			HttpServletRequest req,
			RedirectAttributes ra,
			@PathVariable("id") int id,
			@PathVariable("date") String date,
			Model model
	) {
		log.info("/plan/update GET");
		// 회원 정보
		MemberDTO loginInfo = (MemberDTO) req.getSession().getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo == null) {
			log.info("Not Logged In Member");
			ra.addFlashAttribute("msg", "로그인 후 사용 가능한 서비스입니다.");
			return "redirect:/member/login";
		}
		String member_id = loginInfo.getId();
//		log.info(mDTO);
//		log.info(date);
		LocalDate lDate = null;
		// 날짜 체크
		try {
			lDate = LocalDate.parse(date);
		} catch (DateTimeParseException e) {
			ra.addFlashAttribute("msg", "날짜 형식이 잘못되었습니다.");
			return "redirect:/studyroom/plan";
		}

		PlanDTO plan = planService.getPlan(id);
		log.info("plan: {}", plan);

		model.addAttribute("date", date);
		model.addAttribute("plan", plan);
		return "member/calendarUpdate";
	}

	// TODO: update POST
	@PostMapping("/update")
	public String updatePlan(
			HttpServletRequest req,
			RedirectAttributes ra,
			@ModelAttribute("dto") PlanDTO dto,
			Model model
	) {
		log.info("/plan/create POST");
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


		LocalDate lDate = dto.getStudy_date();
		// 날짜 체크
		if (lDate == null) {
			ra.addFlashAttribute("msg", "잘못된 접근입니다.");
			return "redirect:/studyroom/plan";
		}

		log.info("lDate: {}", lDate);

		String title = dto.getTitle();
		String content = dto.getDescription();

		// 제목 체크
		if (!CommonUtil.isValidValue(title)) {
			ra.addAttribute("msg", "--, $$, #, /*, ', \" 은 포함될 수 없습니다.");
			return "redirect:/plan/create/" + lDate.toString();
		} else if (title.length() < 4 || title.length() > 101) {
			ra.addAttribute("msg", "제목은 5자 이상 100자 이하여야 합니다.");
			return "redirect:/plan/create/" + lDate.toString();
		}
		// 내용 체크
		if (!CommonUtil.isValidValue(content)) {
			ra.addAttribute("msg", "--, $$, #, /*, ', \" 은 포함될 수 없습니다.");
			return "redirect:/plan/create/" + lDate.toString();
		} else if (content.length() < 10 || content.length() > 201) {
			ra.addAttribute("msg", "내용은 10자 이상 200자 이하여야 합니다.");
			return "redirect:/plan/create/" + lDate.toString();
		}

		int result = planService.updatePlan(dto, dto.getId());
		if (result > 0) {
			ra.addAttribute("msg", "학습 계획을 성공적으로 수정했습니다!");
		} else {
			ra.addAttribute("msg", "학습 계획 수정에 실패했습니다.");
		}

		return "redirect:/studyroom/plan";
	}

	@GetMapping("/delete/{id}/{date}")
	public String deletePlan(
			HttpServletRequest req,
			RedirectAttributes ra,
			@PathVariable("id") int id,
			@PathVariable("date") String date,
			Model model
	) {
		log.info("/plan/create GET");
		// 회원 정보
		MemberDTO loginInfo = (MemberDTO) req.getSession().getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo == null) {
			log.info("Not Logged In Member");
			ra.addFlashAttribute("msg", "로그인 후 사용 가능한 서비스입니다.");
			return "redirect:/member/login";
		}
		String member_id = loginInfo.getId();
//		log.info(mDTO);
//		log.info(date);
		LocalDate lDate = null;
		// 날짜 체크
		try {
			lDate = LocalDate.parse(date);
		} catch (DateTimeParseException e) {
			ra.addFlashAttribute("msg", "날짜 형식이 잘못되었습니다.");
			return "redirect:/studyroom/plan";
		}
		int result = 0;
		if (planService.getPlan(id) != null) {
			result = planService.deletePlan(id);
		}

		if (result > 0) {
			ra.addFlashAttribute("msg", "학습 계획이 정상적으로 삭제되었습니다.");
		} else {
			ra.addFlashAttribute("msg", "학습 계획 삭제에 문제가 발생했습니다.");
		}

		model.addAttribute("date", date);
		return "redirect:/studyroom/plan/"+date;
	}

}
