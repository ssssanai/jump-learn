package com.ssanai.jumplearn.controller.login;

import com.oracle.wls.shaded.org.apache.xpath.objects.XString;
import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.service.login.MailSender;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
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
    @GetMapping("/register")
    public String register() {
        return "member/register";
    }
    @PostMapping("/register")
    public String register(
            @Valid MemberDTO dto,
            BindingResult bResult,
            RedirectAttributes rAttribute
    ){
        log.info(dto.toString());
        if(bResult.hasErrors()){
            log.info("에러발생1");
            log.info("에러 리스트: " + bResult.getAllErrors());  // 에러 메시지 로그 확인
            rAttribute.addFlashAttribute("errors", bResult.getAllErrors());
            return "redirect:/member/register";
        }else {
            int  rs= mService.register(dto);
            if(rs > 0) {
                log.info("DB저장 성공");
                rAttribute.addFlashAttribute("signupSuccess", "회원가입 성공! 로그인하세요.");
                return "redirect:/member/login";
            }else{
                log.info("DB저장 실패");
                rAttribute.addFlashAttribute("signupSuccess", "회원가입 실패, 다시 회원가입 진행 하세요.");
                return "redirect:/member/register";
            }
        }
    }
    @GetMapping("/checkId")
    @ResponseBody
    public String checkId(@RequestParam("id") String id) {
        MemberDTO dto = mService.registerIdCheck(id);
        return (dto == null) ? "OK" : "DUPLICATE";
    }
    @GetMapping("/emailCheck")
    @ResponseBody
    public String emailCheck(@RequestParam("email") String userEmail, HttpSession session) {
        // 인증코드 생성
        int code1 = (int) (Math.random() * 900000) + 100000;
        String code = String.valueOf(code1);

        String subject = "Jump Learn 에서 보낸 인증 메일 입니다.";
        String content = "인증번호 " + code + " 입니다.";

        try {
            MailSender mailSender = new MailSender();
            mailSender.sendEmail(userEmail, subject, content);
        } catch (MessagingException e) {
            e.printStackTrace();
            return "fail:메일 전송 중 오류가 발생했습니다.";
        }

        session.setAttribute("authCode", code);
        System.out.println("Generated auth code: " + code);
        return "success:" + code;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/main";
    }
}
