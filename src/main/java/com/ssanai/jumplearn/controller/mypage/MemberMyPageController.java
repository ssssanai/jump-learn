package com.ssanai.jumplearn.controller.mypage;


import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.service.comment.CommentServiceIf;
import com.ssanai.jumplearn.service.course.EnrollmentsServiceIf;
import com.ssanai.jumplearn.service.mainpage.MainPageServiceIf;
import com.ssanai.jumplearn.service.plan.PlanServiceIf;
import com.ssanai.jumplearn.service.post.PostServiceIf;
import com.ssanai.jumplearn.util.BbsPage;
import com.ssanai.jumplearn.util.CommonUtil;
import com.ssanai.jumplearn.vo.PostCommentVO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/mypage")
public class MemberMyPageController {
	private final MainPageServiceIf mainPageService;
	private final PostServiceIf postService;
	private final EnrollmentsServiceIf enrollmentsService;
	private final CommentServiceIf commentService;
	private final PlanServiceIf planService;

	// 마이페이지
	@GetMapping
	public String myPage(
			HttpServletRequest req,
			@ModelAttribute("reqDTO") PageRequestDTO reqDTO,
			Model model
	) {
		log.info("MyPageController MyPage");
		// 회원 정보 id, status, name, grade
		MemberDTO loginInfo = (MemberDTO) req.getSession().getAttribute("loginInfo");
		String member_id = loginInfo.getId();
		MemberDTO member = mainPageService.getMemberInfo(member_id);
		// 자유게시판

		// 공지사항

		// 교육 정보 게시판

		// 대외활동 게시판

		// 자료실 게시판

		// 대입정보 게시판

		// 뉴스 게시판

		model.addAttribute("member", member);
		return "member/mypage";
	}
}
