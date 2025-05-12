package com.ssanai.jumplearn.controller.pay;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.EnrollmentsDTO;
import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.service.basket.BasketServiceIf;
import com.ssanai.jumplearn.service.course.EnrollmentsServiceIf;
import com.ssanai.jumplearn.service.mainpage.MainPageServiceIf;
import com.ssanai.jumplearn.service.pay.PayServiceIf;
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
@RequestMapping("/pay")
public class PayController {
	private final MainPageServiceIf mainPageService;
	private final EnrollmentsServiceIf enrollmentsService;
	private final PayServiceIf payService;
	private final BasketServiceIf basketService;

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
		return "pay/list";
	}

	@GetMapping("/buy")
	public String buy(
			HttpServletRequest req,
			Model model
	) {
		// 학생 정보
		MemberDTO reqDTO = (MemberDTO) req.getSession().getAttribute("loginInfo");
		if (reqDTO == null) {
			log.info("Not Logged In Member");
			return "redirect:/member/login";
		}
		String member_id = reqDTO.getId();
		// 1. 장바구니 리스트 불러오기
		List<BasketDTO> basketList = basketService.getBasketList(member_id);
		log.info(basketList);
		// 2. 장바구니에 있는 항목들을 결제 테이블에 넣기 + Enrollments 도 업데이트
		for (BasketDTO basket : basketList) {
			payService.createPay(basket);
		}

		List<PayVO> payList = payService.getList(member_id);
		log.info("payList: " + payList);
		List<Integer> notInsertedEnrollList = payService.getPayIdListFromEnrollDontHave(member_id);
		log.info("notInsertedEnrollList: " + notInsertedEnrollList);

		payList = payList.stream().filter(vo -> notInsertedEnrollList.contains(vo.getId())).toList();
		log.info("payList: " + payList);

		for (PayVO pay : payList) {
			int result = enrollmentsService.createEnrollment(pay);
			log.info(result > 0 ? "성공" : "실패");
		}
		// 3. 장바구니 목록 없애기
		int result = basketService.clearBasket(member_id);
		log.info(result);
//		basketList = basketService.getBasketList(member_id);
//		log.info(basketList);

		return "redirect:/course/list";
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

	@PostMapping("/refund")
	public String refund(
			@RequestParam("pay_id") int pay_id,
			@RequestParam("reason") String refundReason
	) {
		log.info("PayController refund POST");
		int result = payService.refund(pay_id);
		log.info(result);
		log.info("refundReason:{}", refundReason);
		return "redirect:/pay/list";
	}
}
