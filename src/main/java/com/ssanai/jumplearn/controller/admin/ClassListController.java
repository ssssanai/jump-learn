package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.dto.ClassDetailDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.service.admin.ClassListServiceIf;
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
public class ClassListController {
    private final ClassListServiceIf classListService;

    @GetMapping("/classList")
    public String classList(
            HttpSession session,
            @ModelAttribute("reqDTO")PageRequestDTO reqDTO,
            Model model
            ) {
        log.info("classList시작");
        AdminDTO adminDTO = (AdminDTO) session.getAttribute("loginInfo");
        PageResponseDTO<ClassDetailDTO> resDTO = classListService.searchList(reqDTO);
        model.addAttribute("loginInfo", adminDTO);
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo",resDTO);
        log.info(resDTO.getDtoList());
        return "admin/classList";
    }
}
