package com.ssanai.jumplearn.controller.login;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.service.login.AdminLoginServiceIf;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminLoginController {
    private final AdminLoginServiceIf aService;

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }
    @PostMapping("/login")
    public String login(
            AdminDTO dto,
            RedirectAttributes rAttribute,
            HttpServletRequest req
    ) {
        AdminDTO aDto= aService.login(dto);
        if(aDto!=null && aDto.getName() != null){
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", aDto);
            session.setMaxInactiveInterval(60 * 60 * 3); //3시간
            log.info("로그인성공");
            log.info(aDto.toString());
            return "redirect:/admin/memberList";
        }else {
            rAttribute.addFlashAttribute("msg", "로그인 실패");
            return "redirect:/admin/login";
        }
    }
}
