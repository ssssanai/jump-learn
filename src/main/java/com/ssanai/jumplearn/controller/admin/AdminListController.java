package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.service.admin.AdminListServiceIf;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminListController {
    private final AdminListServiceIf adminListService;

    @GetMapping("/adminList")
    public String adminList(
            HttpSession session,
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model
    ) {
        log.info("adminList시작");
        AdminDTO dto = (AdminDTO) session.getAttribute("loginInfo");
        PageResponseDTO<AdminDTO> resDTO = adminListService.searchList(reqDTO);
        model.addAttribute("loginInfo", dto);
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        return "admin/adminList";
    }
    @GetMapping("/admin_search_list")
    public String adminSearchList(
            @ModelAttribute("reqDTO")PageRequestDTO reqDTO,
            Model model
    ){
        log.info("검색조건"+reqDTO);
        PageResponseDTO<AdminDTO> resDTO = adminListService.searchList(reqDTO);
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        log.info(resDTO);
        return "admin/adminList";
    }
    @GetMapping("/admin_create")
    public String adminCreate(
            HttpSession session,
            RedirectAttributes redirectAttributes
    ){
        AdminDTO dto = (AdminDTO) session.getAttribute("loginInfo");
        if(dto == null || dto.getStatus() != 1) {
            redirectAttributes.addFlashAttribute("msg","생성 권한이 없습니다.");
            return "redirect:/admin/adminList";
        }else{
            return "admin/adminCreate";
        }
    }
    @PostMapping("/admin_create")
    public String adminCreate(
            AdminDTO aDTO,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ){
        AdminDTO dto = (AdminDTO) session.getAttribute("loginInfo");
        if(dto==null || (dto.getStatus() != 1 && dto.getStatus() != 2) ){
            redirectAttributes.addFlashAttribute("msg", "생성 권한이 없습니다.");
            return "redirect:/admin/teacherList";
        }else{
            int rs = adminListService.adminCreate(aDTO);
            if(rs != 1){
                redirectAttributes.addAttribute("msg","변경 실패 했습니다.");
                return "redirect:/admin/adminCreate";
            } else{
                redirectAttributes.addAttribute("msg","변경 성공");
                return "redirect:/admin/adminList";
            }
        }
    }
    @GetMapping("/adminDelete")
    public String adminDelete(
            @RequestParam(name="id")String id,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ){
        AdminDTO dto = (AdminDTO) session.getAttribute("loginInfo");
        if(dto == null || dto.getStatus() != 1) {
            redirectAttributes.addFlashAttribute("msg","삭제권한이 없습니다.");
            return "redirect:/admin/adminList";
        }else{
            int rs = adminListService.adminDelete(id);
            if(rs > 0){
                redirectAttributes.addFlashAttribute("msg", "삭제 성공");
            } else {
                redirectAttributes.addFlashAttribute("msg", "삭제 실패");
            }
            return "redirect:/admin/adminList";
        }
    }
    @GetMapping("/adminChange")
    public String adminChange(
            @RequestParam(name = "id")String id,
            @RequestParam(name = "s") String s,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ){
        AdminDTO dto = (AdminDTO) session.getAttribute("loginInfo");
        if(dto == null || dto.getStatus() != 1) {
            redirectAttributes.addFlashAttribute("msg","변경 권한이 없습니다.");
            return "redirect:/admin/adminList";
        }else{
            int status = Integer.parseInt(s);
            int rs = adminListService.adminChange(id, status);
            if(rs > 0){
                redirectAttributes.addFlashAttribute("msg", "변경 성공");
            } else {
                redirectAttributes.addFlashAttribute("msg", "변경 실패");
            }
            return "redirect:/admin/adminList";
        }
    }
}
