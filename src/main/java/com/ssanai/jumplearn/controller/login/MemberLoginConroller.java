package com.ssanai.jumplearn.controller.login;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.service.login.MemberLoginServiceIf;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberLoginConroller {
    private final MemberLoginServiceIf mService;

    @PostMapping("/login")
    public void login(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "password") String password
    ){
        MemberDTO dto = MemberDTO.builder()
                .id(id)
                .password(password)
                .build();
        mService.login(dto);
    }
}
