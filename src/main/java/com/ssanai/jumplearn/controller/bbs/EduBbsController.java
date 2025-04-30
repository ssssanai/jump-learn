package com.ssanai.jumplearn.controller.bbs;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/edu")
public class EduBbsController {
    @GetMapping("/list")
    public String login() {
        return "member/login";
    }
}
