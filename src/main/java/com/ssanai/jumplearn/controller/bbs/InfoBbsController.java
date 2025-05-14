package com.ssanai.jumplearn.controller.bbs;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.dto.BbsDefaultDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.service.bbs.BbsServiceInterface;
import com.ssanai.jumplearn.util.BbsPage;
import com.ssanai.jumplearn.util.FilePathConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/info")
public class InfoBbsController {
	private final BbsServiceInterface bbsService;
	private final FilePathConfig filePathConfig;

	@GetMapping("/writePage")
	public String writePageGET(
			@ModelAttribute("pageDTO") PageRequestDTO pageDTO,
			Model model,
			HttpSession session
	) {
		AdminDTO adto = (AdminDTO) session.getAttribute("loginInfo");
		log.info("adto", adto.toString());
		model.addAttribute("adto", adto);
		return "info/writePage";
	}

	@PostMapping("/writePage")
	@Transactional
	public String writePagePOST(
			BbsDefaultDTO dto,
			@ModelAttribute("pageDTO") PageRequestDTO pageDTO,
			@RequestParam(value = "pdf", required = false) MultipartFile pdf,
			RedirectAttributes redirectAttributes
	) {
		try {
			int result = bbsService.insert(dto, "tbl_info");
			if (result < 0) {
				log.info("글 등록 실패");
				redirectAttributes.addFlashAttribute("msg", "글 등록에 실패했습니다.");
				return "redirect:/info/writePage?" + pageDTO.getLinkParams();
			}

			redirectAttributes.addFlashAttribute("msg", "등록 성공");
			log.info("등록 성공");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("msg", "등록 실패: " + e.getMessage());
			log.info(e.getMessage());
			return "redirect:/info/writePage?" + pageDTO.getLinkParams();
		}
		return "redirect:/info/searchListPage?" + pageDTO.getLinkParams();
	}

	@GetMapping("/viewPage")
	public String viewPage(
			@RequestParam(name = "id", required = false, defaultValue = "0") int id,
			@ModelAttribute("pageDTO") PageRequestDTO pageDTO,
			Model model
			, HttpSession session
	) {
		bbsService.viewCount(id, "tbl_info");

		Object loginInfo = session.getAttribute("loginInfo");

		if (loginInfo instanceof AdminDTO adto) {
			log.info("관리자 로그인: {}", adto.toString());
			model.addAttribute("isAdmin", true);
			model.addAttribute("adto", adto);
		} else {
			model.addAttribute("isAdmin", false);
		}

		BbsDefaultDTO dto = bbsService.selectOne(id, "tbl_info");

		model.addAttribute("dto", dto);
		model.addAttribute("pageDTO", pageDTO);
		return "info/viewPage";
	}

	@GetMapping("/editPage/{id}")
	public String editPage(
			@PathVariable("id") int id
			, @ModelAttribute("pageDTO") PageRequestDTO pageDTO
			, Model model
			, HttpSession session

	) {

		AdminDTO adto = (AdminDTO) session.getAttribute("loginInfo");
		log.info("adto", adto.toString());
		model.addAttribute("adto", adto);
		model.addAttribute("dto", bbsService.selectOne(id, "tbl_info")); // 게시글 정보
		model.addAttribute("pageDTO", pageDTO);
		return "info/editPage";
	}

	@PostMapping("/editPage/{id}")
	public String editPagePOST(
			@PathVariable("id") int id,
			BbsDefaultDTO dto,
			@ModelAttribute("pageDTO") PageRequestDTO pageDTO
	) {
		bbsService.update(dto, "tbl_info");
		return "redirect:/info/searchListPage?" + pageDTO.getLinkParams();
	}

	@GetMapping("/delete/{id}")
	public String delete(
			@PathVariable("id") int id,
			@ModelAttribute("pageDTO") PageRequestDTO pageDTO
	) {
		bbsService.delete(id, "tbl_info");
		return "redirect:/info/searchListPage?" + pageDTO.getLinkParams();
	}

	@GetMapping("/searchListPage")
	public String searchListPage(
			HttpServletRequest req,
			@ModelAttribute("pageDTO") PageRequestDTO pageDTO,
			HttpSession session,
			Model model
	) {
		model.addAttribute("pageDTO", pageDTO);
		PageResponseDTO<BbsDefaultDTO> dto = bbsService.searchList(pageDTO, "tbl_info");
		int totalCount = bbsService.getTotalCount(pageDTO, "tbl_info");

		Object loginInfo = session.getAttribute("loginInfo");

		if (loginInfo instanceof AdminDTO adto) {
			log.info("관리자 로그인: {}", adto.toString());
			model.addAttribute("isAdmin", true);
			model.addAttribute("adto", adto);
		} else {
			model.addAttribute("isAdmin", false);
		}

		model.addAttribute("dto", dto);

		StringBuilder URI = new StringBuilder()
				.append(req.getRequestURI())
				.append("?")
				.append(pageDTO.getLinkParamsWithoutNo());

		String paging = BbsPage.pagingArea(
				totalCount,
				pageDTO.getPage_no(),
				pageDTO.getPage_size(),
				pageDTO.getPage_block_size(),
				URI.toString()
		);
		model.addAttribute("paging", paging);

		return "info/searchListPage";
	}


}