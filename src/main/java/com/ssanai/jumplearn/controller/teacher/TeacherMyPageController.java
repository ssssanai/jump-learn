package com.ssanai.jumplearn.controller.teacher;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.service.admin.ClassListServiceIf;
import com.ssanai.jumplearn.service.login.TeacherLoginServiceIf;
import com.ssanai.jumplearn.service.teacher.TeacherMyPageServiceIf;
import com.ssanai.jumplearn.util.FilePathConfig;
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
@RequestMapping("/teacher")
public class TeacherMyPageController {

    private final TeacherMyPageServiceIf teacherMyPageService;
    private final ClassListServiceIf classListService;
    private final FilePathConfig filePathConfig;

    @GetMapping("/myPage")
    public String MyPage(
            HttpSession session,
            Model model
    ){
        TeacherDTO dto = (TeacherDTO) session.getAttribute("teacherInfo");
        dto = teacherMyPageService.teacherMyPageInfo(dto.getId());
        List<TeacherClassDTO> dtoClass = teacherMyPageService.teacherClassInfo(dto.getId());
        log.info(dto.toString());
        log.info("개 시발 조 같다"+dtoClass.toString());
        model.addAttribute("dto", dto);
        model.addAttribute("dtoClass", dtoClass);
        return "teacher/teacherMyPage";
    }
    @GetMapping("/ChangeInfo")
    public String ChangeInfo(
            @RequestParam("id") String id,
            Model model
    ){
        TeacherDTO dto = teacherMyPageService.teacherMyPageInfo(id);
        model.addAttribute("dto", dto);
        return "teacher/teacherChangeInfo";
    }
    @PostMapping("/ChangeInfo")
    public String ChangeInfo(
            TeacherDTO dto,
            @RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes
    ) {
        try {
            if (file != null && !file.isEmpty()) {
                String uploadDir = filePathConfig.getUploadPath();
                String newName = file.getOriginalFilename();

                File target = new File(uploadDir, newName);
                file.transferTo(target);

                dto.setFile_path("/upload");
                dto.setFile_name(newName);
                dto.setFile_ext(
                        file.getOriginalFilename()
                                .substring(file.getOriginalFilename()
                                        .lastIndexOf("."))
                );
                dto.setFile_size(file.getSize());
            }
            log.info("업로드 정보 입니다.   "+dto.toString());
            int rs = teacherMyPageService.teacherMyPageUpdate(dto);
            log.info("성공이냐 실패냐"+ rs);
            if (rs != 1) {
                redirectAttributes.addFlashAttribute("msg", "정보 수정 실패");
                return "redirect:/teacher/ChangeInfo?id=" + dto.getId();
            } else {
                redirectAttributes.addFlashAttribute("msg", "수정 성공");
                return "redirect:/teacher/myPage";
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msg", "업로드 실패: " + e.getMessage());
            return "redirect:/teacher/ChangeInfo?id=" + dto.getId();
        }
    }
    @GetMapping("/studentList")
    public String studentList(
            @RequestParam("class_id")String class_id,
            Model model
    ){
        List<EnrollmentsDTO> dtoList = teacherMyPageService.enrollmentsDetail(class_id);
        log.info(dtoList.toString());
        model.addAttribute("dtoList", dtoList);
        model.addAttribute("class_id", class_id);
        return "teacher/teacherStudentList";
    }
    //중간점수 입력
    @PostMapping("/midterm_score")
    public String midtermScore(
            EnrollmentsDTO dto,
            RedirectAttributes redirectAttributes
    ){
        log.info("점수 입력 받는 폼"+dto.toString());
        int rs = teacherMyPageService.enrollmentsMidterm(dto);
        if(rs != 1){
            redirectAttributes.addFlashAttribute("msg","점수입력 실패");
        }else{
            redirectAttributes.addFlashAttribute("msg","점수 입력 성공");
        }
        log.info("점수 성공"+ rs);
        return "redirect:midterm_score_popup?id=" + dto.getId()+"&class_id="+dto.getClass_id();
    }
    //중간점수 받는 창 보여주기
    @GetMapping("/midterm_score_popup")
    public String midtermScore(
            @RequestParam("id") String id,
            @RequestParam("class_id")String class_id,
            Model model
    ){
        model.addAttribute("id", id);
        model.addAttribute("class_id", class_id);
        return "teacher/midterm_score_popup";
    }

    //기말점수 받는 창 보여주기
    @GetMapping("/final_score_popup")
    public String finalScore(
            @RequestParam("id") String id,
            @RequestParam("class_id")String class_id,
            Model model
    ){
        model.addAttribute("id", id);
        model.addAttribute("class_id", class_id);
        return "teacher/final_score_popup";
    }
    //기말 점수 입력
    @PostMapping("/final_score_popup")
    public String finalScore(
            EnrollmentsDTO dto,
            RedirectAttributes redirectAttributes
    ){
        log.info("점수 입력 받는 폼"+dto.toString());
        int rs = teacherMyPageService.enrollmentsFinal(dto);
        if(rs != 1){
            redirectAttributes.addFlashAttribute("msg","점수입력 실패");
        }else{
            redirectAttributes.addFlashAttribute("msg","점수 입력 성공");
        }
        log.info("점수 성공"+ rs);
        return "redirect:final_score_popup?id=" + dto.getId()+"&class_id="+dto.getClass_id();
    }

    //전체점수 받는 창 보여주기
    @GetMapping("/final_grade_score_popup")
    public String finalGradeScore(
            @RequestParam("id") String id,
            @RequestParam("class_id")String class_id,
            Model model
    ){
        model.addAttribute("id", id);
        model.addAttribute("class_id", class_id);
        return "teacher/final_grade_score_popup";
    }
    //전체점수 점수 입력
    @PostMapping("/final_grade_score_popup")
    public String finalGradeScore(
            EnrollmentsDTO dto,
            RedirectAttributes redirectAttributes
    ){
        log.info("점수 입력 받는 폼"+dto.toString());
        int rs = teacherMyPageService.enrollmentsFinalGrade(dto);
        if(rs != 1){
            redirectAttributes.addFlashAttribute("msg","점수입력 실패");
        }else{
            redirectAttributes.addFlashAttribute("msg","점수 입력 성공");
        }
        log.info("점수 성공"+ rs);
        return "redirect:final_score_popup?id=" + dto.getId()+"&class_id="+dto.getClass_id();
    }
    @GetMapping("/class_detail")
    public String classDetail(
            @RequestParam("class_id")String class_id,
            Model model
    ){
        log.info("강의 리스트");
        int id = Integer.parseInt(class_id);
        List<ClassVideoDTO> dtoList = classListService.videoList(id);
        model.addAttribute("dtoList", dtoList);
        model.addAttribute("class_id", class_id);
        log.info("강의" + dtoList.toString());
        return "teacher/teacherStudyTable";
    }
    //공지사항 받는 창 보여주기
    @GetMapping("/notice_add_popup")
    public String noticeViewPopup(
            @RequestParam("id") String id,
            Model model
    ){
        model.addAttribute("id", id);
        return "teacher/notice_add_popup";
    }
    //공지사항 점수 입력
    @PostMapping("/notice_add_popup")
    public String noticeViewPopup(
            ClassVideoDTO dto,
            RedirectAttributes redirectAttributes
    ){
        log.info("공지사항 입력 받는 폼"+dto.toString());
        int rs = teacherMyPageService.noticeUpdate(dto);
        if(rs != 1){
            redirectAttributes.addFlashAttribute("msg","공지사항 입력 실패");
        }else{
            redirectAttributes.addFlashAttribute("msg","공지사항 입력 성공");
        }
        log.info("점수 성공"+ rs);
        return "redirect:notice_add_popup?id=" + dto.getId();
    }
    @GetMapping("/questionList")
    public String questionList(
            @RequestParam("class_id")String id,
            Model model
    ){
        List<TeacherQuestionDTO> dtoList = teacherMyPageService.teacherQuestionList(Integer.parseInt(id));
        String title = "";
        if (dtoList != null && !dtoList.isEmpty()) {
            title = dtoList.get(0).getClass_title();
        }
        model.addAttribute("dtoList", dtoList);
        model.addAttribute("title", title);
        return "teacher/questionList";
    }
    @GetMapping("/questionDetail")
    public String questionDetail(
            @RequestParam("id")String id,
            Model model
    ){
        TeacherQuestionDTO dto = teacherMyPageService.teacherQuestionDetail(Integer.parseInt(id));
        model.addAttribute("dto",dto);
        return "teacher/questionDetail";
    }
    @PostMapping("/questionDetail")
    public String questionDetail(
            HttpSession session,
            TeacherQuestionDTO dto,
            RedirectAttributes redirectAttributes
    ){
        log.info("입력받는폼"+dto.toString());
        TeacherDTO teacherDTO = (TeacherDTO) session.getAttribute("teacherInfo");
        dto.setTeacher_id(teacherDTO.getId());
        log.info("선생님 아이디 입력"+dto.toString());
        int rs = teacherMyPageService.teacherComment(dto);
        if(rs != 1){
            redirectAttributes.addFlashAttribute("msg","답변 실패");
        }else{
            redirectAttributes.addFlashAttribute("msg","답변 성공");
        }
        return "redirect:questionDetail?id=" + dto.getId();
    }
}
