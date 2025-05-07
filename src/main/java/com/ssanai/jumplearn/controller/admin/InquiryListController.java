package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.dto.InquiryDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.service.admin.InquiryListServiceIf;
import jakarta.servlet.http.HttpSession;
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
public class InquiryListController {
    private final InquiryListServiceIf inquiryListService;

    @GetMapping("/inquiryList")
    public String inquiryList(
            HttpSession session,
            @ModelAttribute("reqDTO") PageRequestDTO pageRequestDTO,
            Model model
    ){
        AdminDTO dto = (AdminDTO) session.getAttribute("loginInfo");
        PageResponseDTO<InquiryDTO> resDTO = inquiryListService.searchList(pageRequestDTO);
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        model.addAttribute("loginInfo", dto);
        log.info(resDTO.getDtoList());
        log.info(resDTO);
        return "admin/inquiryList";
    }
    @GetMapping("/inquiry_search_list")
    public String inquiry(
            HttpSession session,
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model
    ) {
        AdminDTO dto = (AdminDTO) session.getAttribute("loginInfo");
        PageResponseDTO<InquiryDTO> resDTO = inquiryListService.searchList(reqDTO);
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        model.addAttribute("loginInfo", dto);
        log.info(resDTO.getDtoList());
        log.info(resDTO);
        return "admin/inquiryList";
    }
}
