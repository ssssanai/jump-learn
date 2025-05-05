package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.service.admin.TeacherListServiceIf;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
