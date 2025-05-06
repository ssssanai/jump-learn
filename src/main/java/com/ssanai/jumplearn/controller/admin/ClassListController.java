package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.dto.ClassDetailDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.service.admin.ClassListServiceIf;
import com.ssanai.jumplearn.util.CommonFileUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.nio.file.Paths;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ClassListController {
    private final ClassListServiceIf classListService;

    @GetMapping("/classList")
    public String classList(
            HttpSession session,
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model
    ) {
        log.info("classList시작");
        AdminDTO adminDTO = (AdminDTO) session.getAttribute("loginInfo");
        PageResponseDTO<ClassDetailDTO> resDTO = classListService.searchList(reqDTO);
        model.addAttribute("loginInfo", adminDTO);
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        log.info(resDTO.getDtoList());
        return "admin/classList";
    }

    @GetMapping("/class_search_list")
    public String searchList(
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model
    ) {
        log.info("검색조건" + reqDTO);
        PageResponseDTO<ClassDetailDTO> resDTO = classListService.searchList(reqDTO);
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        log.info(resDTO);
        return "admin/classList";
    }

    @GetMapping("/class_create")
    public String classCreate() {
        return "admin/classCreate";
    }

    @PostMapping("/class_create")
    public String classCreate(
            HttpSession session,
            ClassDetailDTO dto,
            @RequestParam(name = "image") MultipartFile file,
            RedirectAttributes redirectAttributes
    ) throws Exception {
        try {
            if (file != null && !file.isEmpty()) {
                String uploadDir = "D:\\git\\jump-learn\\src\\upload";
                String newName = file.getOriginalFilename();

                File target = new File(uploadDir, newName);
                file.transferTo(target);

                dto.setClass_file_path("/upload");
                dto.setClass_file_name(newName);
                dto.setClass_file_ext(
                        file.getOriginalFilename()
                                .substring(file.getOriginalFilename()
                                        .lastIndexOf("."))
                );
                dto.setClass_file_size(file.getSize());
                log.info(dto.toString());
                int rs = classListService.classCreate(dto);
                if (rs != 1) {
                    redirectAttributes.addAttribute("msg", "강좌 생성 실패 했습니다.");
                    return "redirect:/admin/classCreate";
                } else {
                    redirectAttributes.addAttribute("msg", "강좌 생성 성공 했습니다.");
                    return "redirect:/admin/classList";
                }
            }

            return "redirect:/bbs/list";

        } catch (Exception e) {
            log.info("classCreate >> error : {}", e.getMessage());
            redirectAttributes.addFlashAttribute("message", "업로드 실패: " + e.getMessage());
            return "redirect:/bbs/list";
        }
    }
}
