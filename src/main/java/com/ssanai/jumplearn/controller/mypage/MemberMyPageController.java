package com.ssanai.jumplearn.controller.mypage;


import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.service.admin.ReportListServiceIf;
import com.ssanai.jumplearn.service.comment.CommentServiceIf;
import com.ssanai.jumplearn.service.course.EnrollmentsServiceIf;
import com.ssanai.jumplearn.service.mainpage.MainPageServiceIf;
import com.ssanai.jumplearn.service.member.MemberMyPageServiceIf;
import com.ssanai.jumplearn.service.plan.PlanServiceIf;
import com.ssanai.jumplearn.service.post.PostServiceIf;
import com.ssanai.jumplearn.util.BbsPage;
import com.ssanai.jumplearn.util.CommonUtil;
import com.ssanai.jumplearn.util.FilePathConfig;
import com.ssanai.jumplearn.vo.PostCommentVO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberMyPageController {

	private final MainPageServiceIf mainPageService;
	private final PostServiceIf postService;
	private final EnrollmentsServiceIf enrollmentsService;
	private final CommentServiceIf commentService;
	private final PlanServiceIf planService;
	private final MemberMyPageServiceIf memberMyPageService;
	private final FilePathConfig filePathConfig;
	private final ReportListServiceIf reportService;

	// 마이페이지
	@GetMapping("/mypage")
	public String myPage(
			HttpServletRequest req,
			@ModelAttribute("reqDTO") PageRequestDTO reqDTO,
			Model model
	) {
		log.info("MyPageController MyPage");
		// 회원 정보 id, status, name, grade
		MemberDTO loginInfo = (MemberDTO) req.getSession().getAttribute("loginInfo");
		loginInfo = memberMyPageService.MemberMyPageInfo(loginInfo.getId());
		log.info(loginInfo);
		PostDTO postDTO = memberMyPageService.PostMyPageInfo();
		log.info(postDTO);
		BbsDefaultDTO noticeDTO = memberMyPageService.noticeMyPageInfo();
		BbsDefaultDTO eduDTO = memberMyPageService.eduMyPageInfo();
		BbsDefaultDTO infoDTO = memberMyPageService.infoMyPageInfo();
		BbsDefaultDTO activityDTO = memberMyPageService.activityMyPageInfo();
		BbsDefaultDTO libDTO = memberMyPageService.libMyPageInfo();
		BbsDefaultDTO newsDTO = memberMyPageService.newsMyPageInfo();
		model.addAttribute("noticeDTO", noticeDTO);
		model.addAttribute("eduDTO", eduDTO);
		model.addAttribute("infoDTO", infoDTO);
		model.addAttribute("activityDTO", activityDTO);
		model.addAttribute("libDTO", libDTO);
		model.addAttribute("newsDTO", newsDTO);
		model.addAttribute("member", loginInfo);
		model.addAttribute("post", postDTO);
		return "member/mypage";
	}

	// 회원 정보 수정
	@GetMapping("/ChangeInfo")
	public String ChangeInfo(
			@RequestParam("id") String id,
			Model model
	){
		MemberDTO loginInfo = memberMyPageService.MemberMyPageInfo(id);
		model.addAttribute("member", loginInfo);
		return "member/memberChangeInfo";
	}

	@PostMapping("/ChangeInfo")
	public String ChangeInfo(
			MemberDTO dto,
			@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes
	) {
		try {
			if (file != null && !file.isEmpty()) {
				String uploadDir = filePathConfig.getUploadPath();
				String newName = file.getOriginalFilename();

				File target = new File(uploadDir, newName);
				file.transferTo(target);

				dto.setFile_path("/upload");
				dto.setFile_name(newName);
				dto.setFile_ext(
						file.getOriginalFilename()
								.substring(file.getOriginalFilename()
										.lastIndexOf("."))
				);
				dto.setFile_size(file.getSize());
			}
			int rs = memberMyPageService.MemberMyPageUpdate(dto);
			if (rs != 1) {
				redirectAttributes.addFlashAttribute("msg", "정보 수정 실패");
				return "redirect:/member/ChangeInfo?id=" + dto.getId();
			} else {
				redirectAttributes.addFlashAttribute("msg", "수정 성공");
				return "redirect:/member/mypage";
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("msg", "업로드 실패: " + e.getMessage());
			return "redirect:/member/ChangeInfo?id=" + dto.getId();
		}
	}


	// 회원 탈퇴
	@GetMapping("/delete")
	public String delete(
			MemberDTO dto,
			@RequestParam("id") String id,
			Model model
	){

		MemberDTO loginInfo = memberMyPageService.memberMyPageDelete(dto);
		model.addAttribute("member", loginInfo);
		return "redirect:/main";
	}

	@GetMapping("/report_list")
	public String reportList(
			HttpServletRequest req,
			Model model
	){
		MemberDTO reqId = (MemberDTO) req.getSession().getAttribute("loginInfo");
		MemberDTO loginInfo = mainPageService.getMemberInfo(reqId.getId());
		List<ReportDTO> reportList = memberMyPageService.reportList(loginInfo.getId());
		model.addAttribute("reportList", reportList);
		model.addAttribute("loginInfo", loginInfo);
		return "member/report_list";
	}

	@GetMapping("/report_detail/{report_id}")
	public String reportDetail(
			HttpServletRequest req,
			@PathVariable("report_id") int report_id,
			Model model
	) {
		MemberDTO reqId = (MemberDTO) req.getSession().getAttribute("loginInfo");
		MemberDTO loginInfo = mainPageService.getMemberInfo(reqId.getId());
		ReportDTO reportDetail = reportService.reportDetail(report_id);
		model.addAttribute("reportDetail", reportDetail);
		model.addAttribute("loginInfo", loginInfo);
		return "member/report_detail";
	}
}
