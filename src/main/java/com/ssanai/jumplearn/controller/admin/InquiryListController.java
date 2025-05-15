package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.dto.InquiryDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.service.admin.InquiryListServiceIf;
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
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class InquiryListController {
    private final InquiryListServiceIf inquiryListService;

    @GetMapping("/inquiryList")
    public String inquiryList(
            HttpServletRequest req,
            HttpSession session,
            @ModelAttribute("reqDTO") PageRequestDTO pageRequestDTO,
            Model model
    ){
        AdminDTO dto = (AdminDTO) session.getAttribute("adminInfo");
        PageResponseDTO<InquiryDTO> resDTO = inquiryListService.searchList(pageRequestDTO);
        String paging = BbsPage.pagingArea(resDTO.getTotal_count(), resDTO.getPage_no(), resDTO.getPage_size(), resDTO.getPage_block_size(), req.getContextPath());
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        model.addAttribute("loginInfo", dto);
        model.addAttribute("paging", paging);
        log.info(resDTO.getDtoList());
        log.info(resDTO);
        return "admin/inquiryList";
    }
    @GetMapping("/inquiry_search_list")
    public String inquiry(
            HttpServletRequest req,
            HttpSession session,
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model
    ) {
        AdminDTO dto = (AdminDTO) session.getAttribute("adminInfo");
        PageResponseDTO<InquiryDTO> resDTO = inquiryListService.searchList(reqDTO);
        StringBuilder URI = new StringBuilder()
                .append(req.getRequestURI())
                .append("?")
                .append(reqDTO.getLinkParamsWithoutNo());
        log.info("URI"+URI);
        String paging = BbsPage.pagingArea(resDTO.getTotal_count(), reqDTO.getPage_no(), reqDTO.getPage_size(), reqDTO.getPage_block_size(),URI.toString() );
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        model.addAttribute("loginInfo", dto);
        model.addAttribute("paging", paging);
        log.info(resDTO.getDtoList());
        log.info(resDTO);
        return "admin/inquiryList";
    }
    @GetMapping("/inquiry")
    public String inquiry(
            @RequestParam("id")String inquiry_id,
            Model model
    ){
        InquiryDTO dto = inquiryListService.inquiryDetail(Integer.parseInt(inquiry_id));
        log.info("문의 상세"+dto);
        List<InquiryDTO> dtoList = inquiryListService.inquiryCommnetDetail(Integer.parseInt(inquiry_id));
        log.info("문의 댓글 상세"+dtoList);
        model.addAttribute("dto", dto);
        model.addAttribute("dtoList", dtoList);
        return "admin/inquiry";
    }
    @PostMapping("/inquiry_resolution")
    public String inquiryResolution(
            HttpSession session,
            InquiryDTO dto,
            RedirectAttributes redirectAttributes
    ){
        AdminDTO dtoAdmin = (AdminDTO) session.getAttribute("adminInfo");
        dto.setAdmin_id(dtoAdmin.getId());
        log.info("전송 데이터 {}", dto.toString());
        int rs = inquiryListService.inquiryResolution(dto);
        if(rs != 1){
            redirectAttributes.addFlashAttribute("msg","답변 실패");
        }else{
            redirectAttributes.addFlashAttribute("msg","답변 성공");
        }
        return "redirect:/admin/inquiry?id="+dto.getInquiry_id();
    }
    @PostMapping("/inquiry_comment_resolution")
    public String inquiryCommentResolution(
            HttpSession session,
            InquiryDTO dto,
            RedirectAttributes redirectAttributes
    ){
        AdminDTO dtoAdmin = (AdminDTO) session.getAttribute("adminInfo");
        dto.setAdmin_id(dtoAdmin.getId());
        log.info("전송 데이터 {}", dto.toString());
        int rs = inquiryListService.inquiryCommentInsert(dto);
        if(rs != 1){
            redirectAttributes.addFlashAttribute("msg","답변 실패");
        }else{
            redirectAttributes.addFlashAttribute("msg","답변 성공");
        }
        return "redirect:/admin/inquiry?id="+dto.getInquiry_id();
    }
}
