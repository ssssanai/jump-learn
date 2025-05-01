package com.ssanai.jumplearn.controller.login;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.service.login.MemberLoginServiceIf;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Parameter;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberLoginController {
    private final MemberLoginServiceIf mService;

    @GetMapping("/login")
    public String login(HttpServletRequest req, Model model) {
        Cookie[] cookies = req.getCookies();
        String saveId = null;
        String saveIdFlag = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("saveId")) {
                    saveId = cookie.getValue();
                }
                if (cookie.getName().equals("saveIdFlag")) {
                    saveIdFlag = cookie.getValue();
                }
            }
        }
        model.addAttribute("saveId", saveId);
        model.addAttribute("saveIdFlag", saveIdFlag);
        return "member/login";
    }
    @PostMapping("/login")
    public void login(
            MemberDTO dto,
            @RequestParam(value = "saveId", required = false) String saveId,
            HttpServletResponse res,
            HttpServletRequest req
    ) throws IOException {
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();
        log.info(dto.toString());
        dto = mService.login(dto);;
        // 로그인 실패 시
        if (dto == null) {
            out.println("<script>alert('아이디 또는 비밀번호가 일치하지 않습니다.'); location.href='/member/login';</script>");
            return;
        } else {
            log.info(dto.toString());
            log.info("로그인 성공");

            //아이디저장 쿠키 사용 로직
            if(saveId != null && saveId.equals("Y")){
                Cookie cookie1 = new Cookie("saveId", dto.getId());
                Cookie cookie2 = new Cookie("saveIdFlag", "Y");
                cookie1.setPath("/");
                cookie2.setMaxAge(60*60*24*7); //7일간 유지
                cookie1.setPath("/");
                cookie2.setMaxAge(60*60*24*7);
                res.addCookie(cookie1);
                res.addCookie(cookie2);
            }else{
                Cookie cookie1 = new Cookie("saveId", null);
                Cookie cookie2 = new Cookie("saveIdFlag", null);
                cookie1.setPath("/");
                cookie1.setMaxAge(0);
                cookie2.setPath("/");
                cookie2.setMaxAge(0);
                res.addCookie(cookie1);
                res.addCookie(cookie2);
            }
        }
        HttpSession session = req.getSession();
        session.setAttribute("loginInfo", dto);
        session.setMaxInactiveInterval(60 * 60 * 3); //3시간
        res.sendRedirect("/main");
    }
}
