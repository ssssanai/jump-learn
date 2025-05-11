package com.ssanai.jumplearn.controller.teacher;

import com.ssanai.jumplearn.dto.TeacherDTO;
import com.ssanai.jumplearn.service.login.TeacherLoginServiceIf;
import com.ssanai.jumplearn.service.teacher.TeacherMyPageServiceIf;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherMyPageController {

    private final TeacherMyPageServiceIf teacherMyPageService;

    @GetMapping("/myPage")
    public String MyPage(
            HttpSession session,
            Model model
    ){
        TeacherDTO dto = (TeacherDTO) session.getAttribute("loginInfo");
        dto = teacherMyPageService.teacherMyPageInfo(dto.getId());
        log.info(dto.toString());
        model.addAttribute("dto", dto);
        return "teacher/teacherMyPage";
    }
}
