package com.ssanai.jumplearn.controller.basket;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.service.basket.BasketServiceIf;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/basket")
public class BasketController {
	private final BasketServiceIf basketService;
	/**
	 * @desc 장바구니 담기
	 */
	@GetMapping("/add/{id}")
	public String addBasket(
			HttpServletRequest req,
			RedirectAttributes ra,
			@PathVariable("id") int id, // 강좌 ID
			@RequestHeader(value = "Referer", required = false) String referer,
			Model model
	) {
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("loginInfo");

		// 로그인되지 않은 상태인 경우
		if (mDTO == null) {
			log.info("Not Logged In Member");
			ra.addFlashAttribute("msg", "로그인 후 사용 가능한 서비스입니다.");
			return "member/login";
		}

		String member_id = mDTO.getId(); // 담은 사람
		int isExist = basketService.isBasketExist(id, member_id);
		log.info(referer);
		if(isExist == 1) {
			ra.addFlashAttribute("msg", "이미 장바구니에 담긴 강좌입니다.");
			return "redirect:/course/list";
		} else {
			int result = basketService.addBasket(id, member_id);
			log.info(result);
			if(referer != null) {
				model.addAttribute("isInBasket", true);
				return "redirect:" + referer;
			} else {
				return "redirect:/course/list";
			}
		}
	}

	@GetMapping("/remove/{id}")
	public String removeBasket(
			HttpServletRequest req,
			RedirectAttributes ra,
			@PathVariable("id") int id, // 강좌 ID
			@RequestHeader(value = "Referer", required = false) String referer
	) {
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("loginInfo");
		log.info(referer);
		// 로그인되지 않은 상태인 경우
		if (mDTO == null) {
			log.info("Not Logged In Member");
			ra.addFlashAttribute("msg", "로그인 후 사용 가능한 서비스입니다.");
			return "member/login";
		}

		String member_id = mDTO.getId(); // 담은 사람
		int isExist = basketService.isBasketExist(id, member_id);

		if(isExist == 1) {
			// 삭제 로직
			int result = basketService.removeBasket(id, member_id);
			log.info(result);

			if(referer != null) {
				return "redirect:" + referer;
			} else {
				return "redirect:/course/list";
			}
		} else {
			ra.addAttribute("msg", "장바구니에 없는 강좌입니다.");
			return "redirect:/course/list";
		}
	}


}
