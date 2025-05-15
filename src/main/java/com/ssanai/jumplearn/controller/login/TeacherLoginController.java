package com.ssanai.jumplearn.controller.login;

import com.ssanai.jumplearn.dto.TeacherDTO;
import com.ssanai.jumplearn.service.login.TeacherLoginServiceIf;
import com.ssanai.jumplearn.vo.TeacherVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherLoginController {
    private final TeacherLoginServiceIf TeacherLoginService;

    @GetMapping("/login")
    public String login(){
        return "teacher/teacherLogin";
    }
    @PostMapping("/login")
    public String loging(
            HttpServletRequest req,
            TeacherDTO dto,
            RedirectAttributes redirectAttributes
    ){
        TeacherDTO teacherDTO = TeacherLoginService.login(dto);
        if(teacherDTO != null && teacherDTO.getId() != null){
            HttpSession session = req.getSession();
            session.setAttribute("teacherInfo",  teacherDTO);
            log.info("선생님 로그인 정보" +teacherDTO );
            return "redirect:/teacher/myPage";
        }else{
            redirectAttributes.addFlashAttribute("msg", "Login 실패");
        }
        return "redirect:/teacher/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/teacher/login";
    }
}
