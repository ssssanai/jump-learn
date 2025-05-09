package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.dto.ReportDTO;
import com.ssanai.jumplearn.service.admin.ReportListServiceIf;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ReportLisstController {
    private final ReportListServiceIf reportListService;

    @GetMapping("/reportList")
    public String reportList(
            HttpSession session,
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model) {
        AdminDTO dto = (AdminDTO) session.getAttribute("loginInfo");
        PageResponseDTO<ReportDTO> resDTO = reportListService.searchList(reqDTO);
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        model.addAttribute("loginInfo", dto);
        log.info(resDTO.getDtoList());
        log.info(resDTO);
        return "admin/reportList";
    }
    @GetMapping("/report_search_list")
    public String searchList(
            HttpSession session,
            @ModelAttribute("reqDTO")PageRequestDTO reqDTO,
            Model model
    ){
        AdminDTO dto = (AdminDTO) session.getAttribute("loginInfo");
        PageResponseDTO<ReportDTO> resDTO = reportListService.searchList(reqDTO);
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("loginInfo", dto);
        model.addAttribute("pageInfo", resDTO);
        log.info(resDTO.getDtoList());
        log.info(resDTO);
        return "admin/reportList";
    }
    @GetMapping("/report")
    public String reportDetail(
            @RequestParam("id") String report_id,
            Model model
    ) {
        int id = Integer.parseInt(report_id);
        ReportDTO dto = reportListService.reportDetail(id);
        log.info(dto.toString());
        model.addAttribute("dto", dto);
        return "admin/report";
    }
    @PostMapping("/resolution")
    public String resolution(
            HttpSession session,
            ReportDTO dto,
            RedirectAttributes redirectAttributes,
            @RequestHeader(value = "Referer", required = false) String referer
    ){
        AdminDTO dtoAdmin = (AdminDTO) session.getAttribute("loginInfo");
        dto.setAdmin_id(dtoAdmin.getId());
        log.info("여기까지"+dto.toString());
        int rs = reportListService.reportResolution(dto);
        if(rs!=1){
            redirectAttributes.addFlashAttribute("msg","답변 실패");
        }else {
            redirectAttributes.addFlashAttribute("msg","답변 성공");
        }
        if (referer != null) {
            return "redirect:" + referer;
        } else {
            return "redirect:/admin/reportList";
        }
    }
}
