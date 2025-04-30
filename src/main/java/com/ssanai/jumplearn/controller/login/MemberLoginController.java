package com.ssanai.jumplearn.controller.login;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.service.login.MemberLoginServiceIf;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberLoginController {
    private final MemberLoginServiceIf mService;

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }
    @PostMapping("/login")
    public void login(
            MemberDTO dto,
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
        } else {
            // 로그인 성공 시 리디렉션
            log.info(dto.toString());
            log.info("로그인 성공");
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", dto);
            session.setMaxInactiveInterval(60 * 60 * 3); //3시간
            res.sendRedirect("/main");
        }
    }
}
