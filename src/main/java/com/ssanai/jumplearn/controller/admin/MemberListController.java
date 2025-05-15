package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.service.admin.AdminListServiceIf;
import com.ssanai.jumplearn.service.admin.MemberListServiceIf;
import com.ssanai.jumplearn.util.BbsPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.Session;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class MemberListController {
    private final MemberListServiceIf memberListService;

    @GetMapping("/memberList")
    public String memberList(
            HttpSession session,
            HttpServletRequest req,
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model
    ){
        log.info("memberList시작");
        AdminDTO dto = (AdminDTO) session.getAttribute("adminInfo");
        PageResponseDTO<MemberDTO> resDTO = memberListService.searchList(reqDTO);
        model.addAttribute("pageInfo", resDTO);
        String paging = BbsPage.pagingArea(resDTO.getTotal_count(), resDTO.getPage_no(), resDTO.getPage_size(), resDTO.getPage_block_size(), req.getContextPath());
        model.addAttribute("loginInfo", dto);
        model.addAttribute("dtoList", resDTO.getDtoList());

        model.addAttribute("paging", paging);
        log.info("경"+resDTO);
        return "admin/memberList";
    }
    @GetMapping("member_search_list")
    public String searchList(
            HttpServletRequest req,
            @ModelAttribute("reqDTO")PageRequestDTO reqDTO,
            Model model
            ){
        log.info("검색 조건"+reqDTO);
        PageResponseDTO<MemberDTO> resDTO = memberListService.searchList(reqDTO);
        log.info(resDTO.getLinkParams());
        log.info(req.getRequestURI());
        StringBuilder URI = new StringBuilder()
                .append(req.getRequestURI())
                .append("?")
                .append(reqDTO.getLinkParamsWithoutNo());
        log.info("URI"+URI);
        String paging = BbsPage.pagingArea(resDTO.getTotal_count(), reqDTO.getPage_no(), reqDTO.getPage_size(), reqDTO.getPage_block_size(),URI.toString() );
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        model.addAttribute("paging", paging);
        log.info(resDTO);
        return "admin/memberList";
    }
    @GetMapping("/memberDelete")
    public String memberDelete(
            HttpSession session,
            @RequestParam(name = "id") String id,
            RedirectAttributes redirectAttributes) {

        AdminDTO loginInfo = (AdminDTO) session.getAttribute("adminInfo");
        if (loginInfo == null || loginInfo.getStatus() != 1)  {
            redirectAttributes.addFlashAttribute("msg", "삭제 권한이 없습니다.");
            return "redirect:/admin/memberList";
        }else {
            int rs = memberListService.memberDelete(id);
            if (rs > 0) {
                redirectAttributes.addFlashAttribute("msg", "삭제 성공");
            } else {
                redirectAttributes.addFlashAttribute("msg", "삭제 실패");
            }
        }
        return "redirect:/admin/memberList";
    }

    @GetMapping("/memberChange")
    public String memberChange(
            HttpSession session,
            @RequestParam(name = "id") String id,
            @RequestParam(name = "s") String s,
            RedirectAttributes redirectAttributes) {

        AdminDTO loginInfo = (AdminDTO) session.getAttribute("adminInfo");
        int status = Integer.parseInt(s);
        int adminStatus = loginInfo.getStatus();

        if (adminStatus != 1 && adminStatus != 2) {
            redirectAttributes.addFlashAttribute("msg", "변경 권한이 없습니다.");
            return "redirect:/admin/memberList";
        }

        int rs = memberListService.memberChange(id, status);
        if (rs > 0) {
            redirectAttributes.addFlashAttribute("msg", "변경 성공");
        } else {
            redirectAttributes.addFlashAttribute("msg", "변경 실패");
        }
        return "redirect:/admin/memberList";
    }
    @GetMapping("/member")
    public String member(
            HttpSession session,
            @RequestParam(name="id") String id,
            RedirectAttributes redirectAttributes,
            Model model
    ){
        AdminDTO loginInfo = (AdminDTO) session.getAttribute("adminInfo");
        MemberDTO dto = memberListService.memberDetail(id);
        log.info(dto.getFile_path()+"/"+dto.getFile_name());
        model.addAttribute("dto", dto);
        return "/admin/member";
    }
    @GetMapping("/memberCreate")
    public String memberCreate(
            @RequestParam(name="id")String id,
            Model model
    ){
        List<MemberCreateDetail> dtoList = memberListService.memberCreatePost(id);
        model.addAttribute("dtoList", dtoList);
        model.addAttribute("id",id);
        log.info(id);
        log.info(dtoList.toString());
        return "/admin/memberCreateBbs";
    }
    @GetMapping("/memberEnrollments")
    public String memberEnrollments(
            @RequestParam(name="id")String id,
            Model model
    ){
        List<EnrollmentsDTO> dtoList = memberListService.memberEnrollments(id);
        model.addAttribute("dtoList", dtoList);
        model.addAttribute("id",id);
        log.info(dtoList.toString());
        return "/admin/memberEnrollments";
    }
}
