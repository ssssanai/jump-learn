package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.service.admin.TeacherListServiceIf;
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
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class TeacherListController {
    private final TeacherListServiceIf teacherListService;

    @GetMapping("/teacherList")
    public String teacherList(
            HttpSession session,
            HttpServletRequest req,
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model
    ) {
        log.info("teacherList시작");
        AdminDTO dto = (AdminDTO) session.getAttribute("adminInfo");
        PageResponseDTO<TeacherDTO> resDTO = teacherListService.searchList(reqDTO);
        StringBuilder URI = new StringBuilder()
                .append(req.getRequestURI())
                .append("?")
                .append(reqDTO.getLinkParamsWithoutNo());
        log.info("URI"+URI);
        String paging = BbsPage.pagingArea(resDTO.getTotal_count(), reqDTO.getPage_no(), reqDTO.getPage_size(), reqDTO.getPage_block_size(),URI.toString() );
        model.addAttribute("loginInfo", dto);
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        model.addAttribute("paging", paging);
        return "admin/teacherList";
    }

    @GetMapping("/teacher_search_list")
    public String searchList(
            HttpServletRequest req,
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model
    ) {
        log.info("검색 조건" + reqDTO);
        PageResponseDTO<TeacherDTO> resDTO = teacherListService.searchList(reqDTO);
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
        return "admin/teacherList";
    }

    @GetMapping("/teacher_create")
    public String teacherCreate() {
        return "admin/teacherCreate";
    }

    @PostMapping("/teacher_create")
    public String teacherCreate(
            TeacherDTO tDTO,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) {
        AdminDTO dto = (AdminDTO) session.getAttribute("adminInfo");
        if (dto == null || (dto.getStatus() != 1 && dto.getStatus() != 2)) {
            redirectAttributes.addFlashAttribute("msg", "생성 권한이 없습니다.");
            return "redirect:/admin/teacherList";
        } else {
            int rs = teacherListService.teacherCreate(tDTO);
            if (rs != 1) {
                redirectAttributes.addAttribute("msg", "변경 실패 했습니다.");
                return "redirect:/admin/teacherCreate";
            } else {
                redirectAttributes.addAttribute("msg", "변경 성공");
                return "redirect:/admin/teacherList";
            }
        }
    }

    @GetMapping("/teacherDelete")
    public String teacherDelete(
            HttpSession session,
            RedirectAttributes redirectAttributes,
            @RequestParam(name = "id") String id
    ) {
        AdminDTO dto = (AdminDTO) session.getAttribute("adminInfo");
        log.info(dto.getStatus());
        if (dto == null || dto.getStatus() != 1) {
            redirectAttributes.addFlashAttribute("msg", "삭제 권한이 없습니다.");
            return "redirect:/admin/teacherList";
        } else {
            int rs = teacherListService.teacherDelete(id);
            if (rs != 1) {
                redirectAttributes.addFlashAttribute("msg", "삭제 중 오류 발생");
                return "redirect:/admin/teacherList";
            } else {
                redirectAttributes.addFlashAttribute("msg", "삭제 완료");
                return "redirect:/admin/teacherList";
            }
        }
    }

    @GetMapping("/teacherChange")
    public String teacherChange(
            HttpSession session,
            RedirectAttributes redirectAttributes,
            @RequestParam(name = "id") String id,
            @RequestParam(name = "s") String s
    ) {
        AdminDTO loginInfo = (AdminDTO) session.getAttribute("adminInfo");
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

    @GetMapping("/teacher")
    public String teacher(
            Model model,
            @RequestParam("id")String id
    ){
        TeacherDTO dto = teacherListService.teacherDetail(id);
        log.info(dto.toString());
        model.addAttribute("dto", dto);
        return "admin/teacher";
    }
    @GetMapping("/teacherClass")
    public String teacherClass(
            Model model,
            @RequestParam("id")String id
    ){
        List<TeacherClassDTO> dtoList = teacherListService.teacherClass(id);
        model.addAttribute("dtoList", dtoList);
        model.addAttribute("id",id);
        log.info(dtoList.toString());
        return "admin/teacherClass";
    }
}
