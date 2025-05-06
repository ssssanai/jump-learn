package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.service.admin.TeacherListServiceIf;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class TeacherListController {
    private final TeacherListServiceIf teacherListService;

    @GetMapping("/teacherList")
    public String teacherList(
            HttpSession session,
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model
    ){
        log.info("teacherList시작");
        AdminDTO dto = (AdminDTO) session.getAttribute("loginInfo");
        PageResponseDTO<TeacherDTO> resDTO = teacherListService.searchList(reqDTO);
        model.addAttribute("loginInfo", dto);
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        return "admin/teacherList";
    }
    @GetMapping("/teacher_search_list")
    public String searchList(
            @ModelAttribute("reqDTO")PageRequestDTO reqDTO,
            Model model
    ){
        log.info("검색 조건"+reqDTO);
        PageResponseDTO<TeacherDTO> resDTO = teacherListService.searchList(reqDTO);
        model.addAttribute("dtoList",resDTO.getDtoList());
        model.addAttribute("pageInfo",resDTO);
        log.info(resDTO);
        return "admin/teacherList";
    }
    @GetMapping("/teacher_create")
    public String teacherCreate(){
        return "admin/teacherCreate";
    }
    @PostMapping("/teacher_create")
    public String teacherCreate(
            TeacherDTO tDTO,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ){
        AdminDTO dto= (AdminDTO)session.getAttribute("loginInfo");
        if(dto==null || (dto.getStatus() != 1 && dto.getStatus() != 2) ){
            redirectAttributes.addFlashAttribute("msg", "생성 권한이 없습니다.");
            return "redirect:/admin/teacherList";
        }else{
            int rs = teacherListService.teacherCreate(tDTO);
            if(rs != 1){
                redirectAttributes.addAttribute("msg","변경 실패 했습니다.");
                return "redirect:/admin/teacherCreate";
            } else{
                redirectAttributes.addAttribute("msg","변경 성공");
                return "redirect:/admin/teacherList";
            }
        }
    }
    @GetMapping("/teacherDelete")
    public String teacherDelete(
            HttpSession session,
            RedirectAttributes redirectAttributes,
            @RequestParam(name = "id")String id
    ){
        AdminDTO dto = (AdminDTO)session.getAttribute("loginInfo");
        log.info(dto.getStatus());
        if(dto==null || dto.getStatus() != 1){
            redirectAttributes.addFlashAttribute("msg","삭제 권한이 없습니다.");
            return "redirect:/admin/teacherList";
        }else {
            int rs = teacherListService.teacherDelete(id);
            if(rs != 1){
                redirectAttributes.addFlashAttribute("msg","삭제 중 오류 발생");
                return "redirect:/admin/teacherList";
            }else {
                redirectAttributes.addFlashAttribute("msg","삭제 완료");
                return "redirect:/admin/teacherList";
            }
        }
    }
    @GetMapping("/teacherChange")
    public String teacherChange(
            HttpSession session,
            RedirectAttributes redirectAttributes,
            @RequestParam(name = "id")String id,
            @RequestParam(name="s")String s
    ){
        AdminDTO loginInfo = (AdminDTO) session.getAttribute("loginInfo");
        int status = Integer.parseInt(s);
        int adminStatus = loginInfo.getStatus();

        if (adminStatus != 1 && adminStatus != 2) {
            redirectAttributes.addFlashAttribute("msg", "변경 권한이 없습니다.");
            return "redirect:/admin/teacherList";
        }
        int rs = teacherListService.teacherChange(id, status);
            if (rs > 0) {
            redirectAttributes.addFlashAttribute("msg", "변경 성공");
        } else {
            redirectAttributes.addFlashAttribute("msg", "변경 실패");
        }
            return "redirect:/admin/teacherList";
    }
}
