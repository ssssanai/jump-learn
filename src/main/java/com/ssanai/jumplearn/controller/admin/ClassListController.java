package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.dto.ClassDataDTO;
import com.ssanai.jumplearn.service.admin.ClassListServiceIf;
import com.ssanai.jumplearn.util.BbsPage;
import com.ssanai.jumplearn.util.FilePathConfig;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
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
    private final FilePathConfig filePathConfig;

    @GetMapping("/classList")
    public String classList(
            HttpSession session,
            HttpServletRequest req,
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model
    ) {
        log.info("classList시작");
        AdminDTO adminDTO = (AdminDTO) session.getAttribute("adminInfo");
        PageResponseDTO<ClassDetailDTO> resDTO = classListService.searchList(reqDTO);
        String paging = BbsPage.pagingArea(resDTO.getTotal_count(), resDTO.getPage_no(), resDTO.getPage_size(), resDTO.getPage_block_size(), req.getContextPath());
        model.addAttribute("loginInfo", adminDTO);
        model.addAttribute("dtoList", resDTO.getDtoList());
        model.addAttribute("pageInfo", resDTO);
        model.addAttribute("paging", paging);
        log.info(resDTO.getDtoList());
        return "admin/classList";
    }

    @GetMapping("/class_search_list")
    public String searchList(
            HttpServletRequest req,
            @ModelAttribute("reqDTO") PageRequestDTO reqDTO,
            Model model
    ) {
        log.info("검색조건" + reqDTO);
        PageResponseDTO<ClassDetailDTO> resDTO = classListService.searchList(reqDTO);
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
                String uploadDir = filePathConfig.getUploadPath();
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
        String title = classListService.className(id);

        log.info(title);
        model.addAttribute("dtoList", dtoList);
        model.addAttribute("class_id", class_id);
        model.addAttribute("class_title", title);
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
                String uploadDir = filePathConfig.getUploadPath();
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
            @RequestParam("order")String order_id,
            Model model
    ){
        model.addAttribute("id", id);
        model.addAttribute("order_id", order_id);
        return "admin/classDataCreate";
    }
    @PostMapping("/class_data_create")
    public String dataCreate(
            ClassDataDTO dto,
            Model model,
            RedirectAttributes redirectAttributes,
            @RequestParam(name = "pdf") MultipartFile file
    ) throws Exception {
        try {
            if (file != null && !file.isEmpty()) {
                String uploadDir = filePathConfig.getUploadPath();
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
                    return "redirect:/admin/class_data_create?class_id="+dto.getClass_id()+"order" + dto.getData_order();
                } else {
                    redirectAttributes.addAttribute("msg", "영상 생성 성공 했습니다.");
                }
            }
        } catch (Exception e) {
            log.info("classCreate >> error : {}", e.getMessage());
            redirectAttributes.addFlashAttribute("msg", "업로드 실패: " + e.getMessage());
            return "redirect:/admin/class_data_create?class_id="+dto.getClass_id()+"order" + dto.getData_order();
        }
        return "redirect:/admin/class?id="+dto.getClass_id();
    }
    @GetMapping("/class_video_delete")
    public String dataDelete(
            @RequestParam("movie_id") String id,
            Model model,
            @RequestHeader(value = "Referer", required = false) String referer,
            RedirectAttributes redirectAttributes
    ){
        int movie_id = Integer.parseInt(id);
        int rs = classListService.deleteClass(movie_id);
        if (rs != 1) {
            redirectAttributes.addFlashAttribute("msg", "삭제 실패");
        } else {
            redirectAttributes.addFlashAttribute("msg", "삭제 성공");
        }
        log.info(referer);
        if (referer != null) {
            return "redirect:" + referer;
        } else {
            return "redirect:/admin/class";
        }
    }
    @GetMapping("/class_data_update")
    public String dataUpdate(
            @RequestParam("data_id")String data_id,
            @RequestHeader(value = "Referer", required = false) String referer,
            Model model
    ){
        int id = Integer.parseInt(data_id);
        ClassDataDTO dto = classListService.dataDetail(id);
        log.info(dto.toString());
        model.addAttribute("dto", dto);
        return "admin/classDataUpdate";
    }
    @PostMapping("/class_data_update")
    public String dataUpdate(
            ClassDataDTO dto,
            @RequestParam("pdf") MultipartFile file,
            RedirectAttributes redirectAttributes
    ) throws Exception {
        try {
            if (file != null && !file.isEmpty()) {
                String uploadDir = filePathConfig.getUploadPath();
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
                int rs = classListService.classDataUpdate(dto);
                if (rs != 1) {
                    redirectAttributes.addAttribute("msg", "영상 생성 실패 했습니다.");
                    return "admin/class_data_update?data_id="+dto.getId();
                } else {
                    redirectAttributes.addAttribute("msg", "영상 생성 성공 했습니다.");
                }
            }
        } catch (Exception e) {
            log.info("classCreate >> error : {}", e.getMessage());
            redirectAttributes.addFlashAttribute("msg", "업로드 실패: " + e.getMessage());
            return"admin/class_data_update?data_id="+dto.getId();
        }
        return "redirect:/admin/class?id=" + dto.getClass_id();
    }
    @GetMapping("/class_data_delete")
    public String dataDelete(
            @RequestParam("data_id") String id,
            @RequestParam("class_id") String class_id,
            RedirectAttributes redirectAttributes
    ) {
        log.info("classID: {}", class_id);
        int rs = classListService.classDataDelete(Integer.parseInt(id));
        if (rs != 1) {
            redirectAttributes.addFlashAttribute("msg", "삭제 실패");
        } else {
            redirectAttributes.addFlashAttribute("msg", "삭제 성공");
        }
        return "redirect:/admin/class?id="+class_id;
    }
    @GetMapping("/class_video_update")
    public String videoUpdate(
            @RequestParam("video_id")String video_id,
            @RequestHeader(value = "Referer", required = false) String referer,
            Model model
    ){
        int id = Integer.parseInt(video_id);
        ClassVideoDTO dto = classListService.videoDetail(id);
        log.info(dto.toString());
        model.addAttribute("dto", dto);
        return "admin/classVideoUpdate";
    }
    //내부 영상
    @PostMapping("/class_video_update")
    public String videoUpdate(
            ClassVideoDTO dto,
            @RequestParam("video") MultipartFile file,
            @RequestHeader(value = "Referer", required = false) String referer,
            RedirectAttributes redirectAttributes
    ) throws Exception {
        try {
            if (file != null && !file.isEmpty()) {
                log.info("접근");
                String uploadDir = filePathConfig.getUploadPath();
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
                int rs = classListService.classVideoUpdate(dto);
                if (rs != 1) {
                    redirectAttributes.addAttribute("msg", "영상 생성 실패 했습니다.");
                    return "admin/class_video_update?video_id="+dto.getId();
                } else {
                    redirectAttributes.addAttribute("msg", "영상 생성 성공 했습니다.");
                }
            }
        } catch (Exception e) {
            log.info("classCreate >> error : {}", e.getMessage());
            redirectAttributes.addFlashAttribute("msg", "업로드 실패: " + e.getMessage());
            return"admin/class_video_update?video_id="+dto.getId();
        }
        return "redirect:/admin/class?id=" + dto.getClass_id();
    }
    //외부영상
    @PostMapping("/class_video_update1")
    public String videoUpdate1(
            ClassVideoDTO dto,
            @RequestHeader(value = "Referer", required = false) String referer,
            RedirectAttributes redirectAttributes
    ){
        int rs = classListService.classVideoUpdate1(dto);
        if (rs != 1) {
            redirectAttributes.addAttribute("msg", "영상 생성 실패 했습니다.");
            return "admin/class_video_update?video_id="+dto.getId();
        }
        redirectAttributes.addAttribute("msg", "영상 생성 성공 했습니다.");
        return "redirect:/admin/class?id=" + dto.getClass_id();
    }
}
