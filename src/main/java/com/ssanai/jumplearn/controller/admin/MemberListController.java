package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.service.admin.AdminListServiceIf;
import com.ssanai.jumplearn.service.admin.MemberListServiceIf;
import com.ssanai.jumplearn.util.BbsPage;
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
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model
    ){
        log.info("memberList시작");
        AdminDTO dto = (AdminDTO) session.getAttribute("loginInfo");
        PageResponseDTO<MemberDTO> resDTO = memberListService.searchList(reqDTO);
        model.addAttribute("loginInfo", dto);
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        return "admin/memberList";
    }
    @GetMapping("member_search_list")
    public String searchList(
            @ModelAttribute("reqDTO")PageRequestDTO reqDTO,
            Model model
            ){
        log.info("검색 조건"+reqDTO);
        PageResponseDTO<MemberDTO> resDTO = memberListService.searchList(reqDTO);
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        log.info(resDTO);
        return "admin/memberList";
    }
    @GetMapping("/memberDelete")
    public String memberDelete(
            HttpSession session,
            @RequestParam(name = "id") String id,
            RedirectAttributes redirectAttributes) {

        AdminDTO loginInfo = (AdminDTO) session.getAttribute("loginInfo");
        int adminStatus = loginInfo.getStatus();

        if (adminStatus != 1) {
            redirectAttributes.addFlashAttribute("msg", "삭제 권한이 없습니다.");
            return "redirect:/admin/memberList";
        }

        int rs = memberListService.memberDelete(id);
        if (rs > 0) {
            redirectAttributes.addFlashAttribute("msg", "삭제 성공");
        } else {
            redirectAttributes.addFlashAttribute("msg", "삭제 실패");
        }

        return "redirect:/admin/memberList";
    }

    @GetMapping("/memberChange")
    public String memberChange(
            HttpSession session,
            @RequestParam(name = "id") String id,
            @RequestParam(name = "s") String s,
            RedirectAttributes redirectAttributes) {

        AdminDTO loginInfo = (AdminDTO) session.getAttribute("loginInfo");
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

}
