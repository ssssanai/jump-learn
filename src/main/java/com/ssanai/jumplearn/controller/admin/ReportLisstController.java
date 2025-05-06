package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.dto.ReportDTO;
import com.ssanai.jumplearn.service.admin.ReportListServiceIf;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ReportLisstController {
    private final ReportListServiceIf reportListService;

    @GetMapping("/reportList")
    public String reportList(
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model) {
        PageResponseDTO<ReportDTO> resDTO = reportListService.searchList(reqDTO);
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        log.info(resDTO.getDtoList());
        log.info(resDTO);
        return "admin/reportList";
    }
}
