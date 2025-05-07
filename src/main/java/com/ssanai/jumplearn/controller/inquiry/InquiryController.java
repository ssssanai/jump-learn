package com.ssanai.jumplearn.controller.inquiry;

import com.ssanai.jumplearn.dto.InquiryDTO;
import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.service.inquiry.InquiryServiceIf;
import com.ssanai.jumplearn.util.BbsPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
@RequestMapping("/inquiry")
public class InquiryController {
	private final InquiryServiceIf inquiryService;

	@GetMapping("/list")
	public String list(
			HttpServletRequest req,
			@ModelAttribute("reqDTO") PageRequestDTO reqDTO,
			Model model
	) {
		log.info("Inquiry list() GET");
		MemberDTO dto = (MemberDTO) req.getSession().getAttribute("loginInfo");
		PageResponseDTO<InquiryDTO> resDTO = inquiryService.getInquiryList(reqDTO);
		int totalCount = inquiryService.getInquiryTotalCount(reqDTO);
		model.addAttribute("dtoList", resDTO.getDtoList());
		model.addAttribute("pageInfo", resDTO);
		model.addAttribute("loginInfo", dto);
		log.info(reqDTO);
		log.info(resDTO.getDtoList());
		log.info(resDTO);

		String paging = BbsPage.pagingArea(totalCount, reqDTO.getPage_no(), reqDTO.getPage_size(), reqDTO.getPage_block_size(), req.getContextPath());
		model.addAttribute("paging", paging);
		return "inquiry/list";
	}

	@GetMapping("/detail/{id}")
	public String detail(
			HttpServletRequest req,
			@PathVariable("id") int id,
			RedirectAttributes redirectAttributes,
			Model model
	) {
		log.info("Inquiry detail() GET");
		MemberDTO dto = (MemberDTO) req.getSession().getAttribute("loginInfo");
		List<InquiryDTO> inquiry = inquiryService.getInquiry(id);

		if (dto != null && inquiry != null) {
			if(inquiry.get(0).getVisibility() == 0 && !inquiry.get(0).getMember_id().equals(dto.getId())) {
				redirectAttributes.addFlashAttribute("msg", "잘못된 접근입니다.");
				return "redirect:/inquiry/list";
			} else {
				model.addAttribute("inquiry", inquiry);
				model.addAttribute("loginInfo", dto);
				return "inquiry/detail";
			}
		} else {
			redirectAttributes.addFlashAttribute("msg", " 로그인 후 사용 가능한 서비스입니다. ");
			return "redirect:/member/login";
		}
	}

	@GetMapping("/write")
	public String write(HttpServletRequest req, RedirectAttributes redirectAttributes, Model model) {
		log.info("Inquiry write() GET");
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("loginInfo");

		if (mDTO != null) {
			model.addAttribute("mDTO", mDTO);
			return "inquiry/write";
		} else {
			redirectAttributes.addFlashAttribute("msg", "로그인 후 가능한 서비스입니다.");
			return "redirect:/member/login";
		}
	}

	@PostMapping("/write")
	public String write(HttpServletRequest req, InquiryDTO dto, RedirectAttributes redirectAttributes, Model model) {
		log.info("Inquiry write() POST");
		log.info(dto);
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("loginInfo");
		if (mDTO != null) {
			if (mDTO.getId().equals(dto.getMember_id())) {
				if (!isValidValue(dto.getMember_id()) || !isValidValue(dto.getInquiry_title()) || !isValidValue(dto.getInquiry_content())) {
					redirectAttributes.addFlashAttribute("msg", "사용할 수 없는 특수 문자가 있습니다.");
					return "redirect:/inquiry/write";
				}

				if (dto.getInquiry_title().length() < 4 || dto.getInquiry_title().length() > 101) {
					redirectAttributes.addFlashAttribute("msg", "제목은 5자 이상 100자 이하여야 합니다.");
					model.addAttribute("inquiry", dto);
					return "redirect:/inquiry/write";
				}

				if (dto.getInquiry_content().length() < 9 || dto.getInquiry_content().length() > 1001) {
					redirectAttributes.addFlashAttribute("msg", "내용은 10자 이상 1000자 이하여야 합니다.");
					model.addAttribute("inquiry", dto);
					return "redirect:/inquiry/write";
				}
				// insert 실행
				int result = inquiryService.register(dto);
				if (result > 0) {
					redirectAttributes.addFlashAttribute("msg", "질문 등록이 완료되었습니다.");
					return "redirect:/inquiry/list";
				} else {
					redirectAttributes.addFlashAttribute("msg", "질문 등록에 실패했습니다.");
					return "redirect:/inquiry/write";
				}
			} else {
				// 오류 처리
				redirectAttributes.addFlashAttribute("msg", "작성자 ID와 접속한 ID가 달라 질문 등록에 실패했습니다.");
				return "redirect:/inquiry/write";
			}
		} else {
			redirectAttributes.addFlashAttribute("msg", "로그인 후 가능한 서비스입니다.");
			return "redirect:/member/login";
		}
	}

	@GetMapping("/modify/{id}")
	public String modify(
			HttpServletRequest req,
			@PathVariable("id") int id,
			RedirectAttributes redirectAttributes,
			Model model
	) {
		log.info("Inquiry modify() GET");
		MemberDTO dto = (MemberDTO) req.getSession().getAttribute("loginInfo");// 로그인 정보
		List<InquiryDTO> inquiry = inquiryService.getInquiry(id); // 질문
		if (dto != null && inquiry != null && inquiry.get(0).getMember_id().equals(dto.getId())) {
			// 로그인되어 있고 inquiry가 있고 로그인 정보와 inquiry memberid가 일치하는지 확인
			model.addAttribute("inquiry", inquiry);
			model.addAttribute("loginInfo", dto);
			return "inquiry/modify";
		} else {
			redirectAttributes.addFlashAttribute("msg", " 로그인 후 사용 가능한 서비스입니다. ");
			return "redirect:/member/login";
		}
	}

	@PostMapping("/modify/{id}")
	public String modify(
			HttpServletRequest req,
			@PathVariable("id") int id,
			InquiryDTO dto,
			RedirectAttributes redirectAttributes,
			Model model
	) {
		log.info("Inquiry modify() POST");
		MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("loginInfo");
		if (mDTO != null) {
			if (mDTO.getId().equals(dto.getMember_id())) {
				if (!isValidValue(dto.getMember_id()) || !isValidValue(dto.getInquiry_title()) || !isValidValue(dto.getInquiry_content())) {
					redirectAttributes.addFlashAttribute("msg", "사용할 수 없는 특수 문자가 있습니다.");
					return "redirect:/inquiry/write";
				}

				if (dto.getInquiry_title().length() < 4 || dto.getInquiry_title().length() > 101) {
					redirectAttributes.addFlashAttribute("msg", "제목은 5자 이상 100자 이하여야 합니다.");
					model.addAttribute("inquiry", dto);
					return "redirect:/inquiry/write";
				}

				if (dto.getInquiry_content().length() < 9 || dto.getInquiry_content().length() > 1001) {
					redirectAttributes.addFlashAttribute("msg", "내용은 10자 이상 1000자 이하여야 합니다.");
					model.addAttribute("inquiry", dto);
					return "redirect:/inquiry/write";
				}
				// modify 실행
				int result = inquiryService.modify(dto);
				if (result > 0) {
					redirectAttributes.addFlashAttribute("msg", "질문 수정이 완료되었습니다.");
					return "redirect:/inquiry/list";
				} else {
					redirectAttributes.addFlashAttribute("msg", "질문 수정에 실패했습니다.");
					return "redirect:/inquiry/write";
				}
			} else {
				// 오류 처리
				redirectAttributes.addFlashAttribute("msg", "작성자 ID와 접속한 ID가 달라 질문 수정에 실패했습니다.");
				return "redirect:/inquiry/write";
			}
		} else {
			redirectAttributes.addFlashAttribute("msg", "로그인 후 가능한 서비스입니다.");
			return "redirect:/member/login";
		}
	}

	@GetMapping("/delete/{id}")
	public String delete(
			HttpServletRequest req,
			@PathVariable("id") int id,
			RedirectAttributes redirectAttributes,
			Model model
	) {
		log.info("Inquiry delete() GET");
		log.info(id);

		MemberDTO dto = (MemberDTO) req.getSession().getAttribute("loginInfo");
		List<InquiryDTO> inquiry = inquiryService.getInquiry(id);

		if (dto != null && inquiry != null && inquiry.get(0).getMember_id().equals(dto.getId())) {
			int result = inquiryService.delete(id);
			if (result > 0) {
				redirectAttributes.addFlashAttribute("msg", "질문이 성공적으로 삭제되었습니다.");
				return "redirect:/inquiry/list";
			} else {
				redirectAttributes.addFlashAttribute("msg", "질문 삭제에 실패했습니다.");
				return "redirect:/inquiry/detail";
			}
		} else {
			redirectAttributes.addFlashAttribute("msg", "잘못된 접근입니다.");
			return "redirect:/inquiry/list";
		}
	}

	public boolean isValidValue(String s) {
		if (
				s.contains("--")
						|| s.contains("#")
						|| s.contains("/*")
						|| s.contains("'")
						|| s.contains("\"")
						|| s.contains("$$")
		) {
			return false;
		} else {
			return true;
		}
	}
}
