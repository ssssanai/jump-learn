package com.ssanai.jumplearn.controller.pay;

import com.ssanai.jumplearn.dto.EnrollmentsDTO;
import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.service.course.EnrollmentsServiceIf;
import com.ssanai.jumplearn.service.mainpage.MainPageServiceIf;
import com.ssanai.jumplearn.service.pay.PayServiceIf;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/pay")
public class PayController {
	private final MainPageServiceIf mainPageService;
	private final EnrollmentsServiceIf enrollmentsService;
	private final PayServiceIf payService;

	@GetMapping("/list")
	public String list(
			HttpServletRequest req,
			RedirectAttributes ra,
			@ModelAttribute("reqDTO") PageRequestDTO reqDTO,
			Model model
	) {
		log.info("PayController list");
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

		List<EnrollmentsDTO> payList = payService.getPayList(member_id);
		log.info(payList);

		model.addAttribute("payList", payList);
		return "member/bought";
	}

	@GetMapping("/purchase_ok/{id}")
	public String purchaseOk(@PathVariable("id") int id) {
		log.info("PayController purchase_ok");
		int result = payService.confirmPurchase(id);
		log.info(result);
		return "redirect:/pay/list";
	}

	@GetMapping("/refund/{class_id}")
	public String refund(
			@PathVariable("class_id") int class_id,
			Model model
	) {
		log.info("PayController refund GET");
		EnrollmentsDTO dto = enrollmentsService.getEnrollment(class_id);
		log.info(dto);
		model.addAttribute("dto", dto);
		return "pay/refund";
	}

	@PostMapping("/refund/{pay_id}")
	public String refund(
			@PathVariable("pay_id") int pay_id,
			String refundReason
	) {
		log.info("PayController refund POST");
		int result = payService.refund(pay_id);
		log.info(result);
		log.info("refundReason:{}", refundReason);
		return "redirect:/pay/list";
	}
}
