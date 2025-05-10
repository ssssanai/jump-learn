package com.ssanai.jumplearn.controller.mypage;


import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.service.course.EnrollmentsServiceIf;
import com.ssanai.jumplearn.service.mainpage.MainPageServiceIf;
import com.ssanai.jumplearn.util.BbsPage;
import com.ssanai.jumplearn.util.CommonUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/mypage")
public class MemberMyPageController {
    private final MainPageServiceIf mainPageService;
    private final EnrollmentsServiceIf enrollmentsService;

    // 마이페이지
    @GetMapping
    public String myPage(
            HttpServletRequest req,
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model
    ) {
        log.info("MyPageController MyPage");
        // 회원 정보
        MemberDTO mDTO = (MemberDTO) req.getSession().getAttribute("loginInfo");
        // 자유게시판

        // 공지사항

        // 교육 정보 게시판

        // 대외활동 게시판

        // 자료실 게시판

        model.addAttribute("member", mDTO);
        return "member/mypage";
    }

    // 나의 강의실 진입
    @GetMapping("/studyroom")
    public String myStudyRoom(
            HttpServletRequest req,
            RedirectAttributes ra,
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model
    ) {
        log.info("MyPageController MyStudyRoom");
        log.info(reqDTO);
        // 회원 정보
        MemberDTO loginInfo = (MemberDTO) req.getSession().getAttribute("loginInfo");
        // 로그인 체크
        if(loginInfo == null) {
            log.info("Not Logged In Member");
            ra.addFlashAttribute("msg", "로그인 후 사용 가능한 서비스입니다.");
            return "member/login";
        }
        MemberDTO mDTO = mainPageService.getMemberInfo(loginInfo.getId());
        log.info(mDTO);

        // 안전한 값인지 체크
        if(reqDTO.getSearch_word() != null && !reqDTO.getSearch_word().isEmpty() ) {
            if(!CommonUtil.isValidValue(reqDTO.getSearch_word())){
                log.info("Prevent SQL Injection");
                ra.addFlashAttribute("msg", "포함할 수 없는 문자가 존재합니다.");
                return "mypage/studyroom";
            }
        }
        // 1. 강좌 목록
        PageResponseDTO<EnrollmentsDTO> EnrollDTOList = enrollmentsService.enrollList(reqDTO);
        int totalCount = enrollmentsService.getTotalCount(reqDTO);
        EnrollDTOList.setTotal_count(totalCount);
        // 강좌 페이징
        String EnrollPaging = BbsPage.pagingArea(totalCount, reqDTO.getPage_no(), reqDTO.getPage_size(), reqDTO.getPage_block_size(), req.getContextPath());

        // 2. 내가 작성한 글
        PageResponseDTO<PostDTO> PostDTOList = null;
        // 내가 작성한 글 페이징

        // 3. 내가 남긴 댓글
        // 내가 남긴 댓글 페이징

        // 4. 성적표 보기

        // 5. 학습계획표

        log.info(EnrollDTOList);


        model.addAttribute("member", mDTO);
        model.addAttribute("EnrollDTOList", EnrollDTOList);
        model.addAttribute("EnrollPaging", EnrollPaging);
        return "member/studyroom";
    }

    @GetMapping("/bought")
    public String myBought(
            Model model
    ) {
        return "member/bought";
    }



}
