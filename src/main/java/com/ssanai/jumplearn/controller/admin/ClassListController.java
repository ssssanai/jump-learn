package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.dto.mainpage.ClassDataDTO;
import com.ssanai.jumplearn.service.admin.ClassListServiceIf;
import com.ssanai.jumplearn.util.CommonFileUtil;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@MultipartConfig(
        maxFileSize = 104857600,
        maxRequestSize = 1048576000
)
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

    @GetMapping("/class")
    public String videoList(
            @RequestParam("id") String class_id,
            Model model
    ) {
        int id = Integer.parseInt(class_id);
        List<ClassVideoDTO> dtoList = classListService.videoList(id);
        model.addAttribute("dtoList", dtoList);
        model.addAttribute("class_id", class_id);
        log.info("강의" + dtoList.toString());
        return "admin/class";
    }

    @GetMapping("/class_video_create")
    public String videoCreate(
            @RequestParam("class_id") String id,
            Model model
    ) {
        model.addAttribute("id", id);
        return "admin/classVideoCreate";
    }

    @PostMapping("/class_video_create")
    public String videoCreate(
            ClassVideoDTO dto,
            RedirectAttributes redirectAttributes,
            @RequestParam(name = "video") MultipartFile file
    ) throws Exception {
        try {
            if (file != null && !file.isEmpty()) {
                String uploadDir = "D:\\git\\jump-learn\\src\\upload";
                String newName = file.getOriginalFilename();

                File target = new File(uploadDir, newName);
                file.transferTo(target);

                dto.setVideo_path("/upload");
                dto.setVideo_name(newName);
                dto.setVideo_extension(
                        file.getOriginalFilename()
                                .substring(file.getOriginalFilename()
                                        .lastIndexOf("."))
                );
                dto.setVideo_size(file.getSize());
                log.info(dto.toString());
                int rs = classListService.createVideo1(dto);
                if (rs != 1) {
                    redirectAttributes.addAttribute("msg", "영상 생성 실패 했습니다.");
                    return "redirect:/admin/classVideoCreate";
                } else {
                    redirectAttributes.addAttribute("msg", "영상 생성 성공 했습니다.");
                }
            }
        } catch (Exception e) {
            log.info("classCreate >> error : {}", e.getMessage());
            redirectAttributes.addFlashAttribute("msg", "업로드 실패: " + e.getMessage());
            return "redirect:/admin/classVideoCreate";
        }
        return "redirect:/admin/class?id="+dto.getClass_id();
    }
    @GetMapping("/class_video_create1")
    public String videoCreate1(
            @RequestParam("class_id") String id,
            Model model
    ) {
        model.addAttribute("id", id);
        return "admin/classVideoCreate1";
    }
    @PostMapping("/class_video_create1")
    public String videoCreate1(
            ClassVideoDTO dto,
            Model model,
            RedirectAttributes redirectAttributes
    ){
        log.info(dto.toString());
        int rs = classListService.createVideo2(dto);
        if (rs != 1) {
            model.addAttribute("msg","강의 업로드 실패.");
        }else{
            model.addAttribute("msg","강의 업로드 성공.");
        }
        return "redirect:/admin/class?id="+dto.getClass_id();
    }

    @GetMapping("/class_data_create")
    public String dataCreate(
            @RequestParam("class_id")String id,
            Model model
    ){
        model.addAttribute("id", id);
        return "admin/classDataCreate";
    }
    @PostMapping("class_data_create")
    public String dataCreate(
            ClassDataDTO dto,
            Model model,
            RedirectAttributes redirectAttributes,
            @RequestParam(name = "video") MultipartFile file
    ) throws Exception {
        try {
            if (file != null && !file.isEmpty()) {
                String uploadDir = "D:\\git\\jump-learn\\src\\upload";
                String newName = file.getOriginalFilename();

                File target = new File(uploadDir, newName);
                file.transferTo(target);

                dto.setData_path("/upload");
                dto.setData_name(newName);
                dto.setData_extension(
                        file.getOriginalFilename()
                                .substring(file.getOriginalFilename()
                                        .lastIndexOf("."))
                );
                dto.setData_size(file.getSize());
                log.info(dto.toString());
                int rs = classListService.createData(dto);
                if (rs != 1) {
                    redirectAttributes.addAttribute("msg", "영상 생성 실패 했습니다.");
                    return "redirect:/admin/classVideoCreate";
                } else {
                    redirectAttributes.addAttribute("msg", "영상 생성 성공 했습니다.");
                }
            }
        } catch (Exception e) {
            log.info("classCreate >> error : {}", e.getMessage());
            redirectAttributes.addFlashAttribute("msg", "업로드 실패: " + e.getMessage());
            return "redirect:/admin/classVideoCreate";
        }
        return "redirect:/admin/class?id="+dto.getClass_id();
    }
}
