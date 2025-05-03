package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.service.admin.AdminListServiceIf;
import com.ssanai.jumplearn.service.admin.MemberListServiceIf;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.Session;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class MemberListController {
    private final MemberListServiceIf memberListService;
    private final AdminListServiceIf adminListService;

    @GetMapping("/memberList")
    public String memberList(HttpSession session, Model model){
        AdminDTO dto = (AdminDTO) session.getAttribute("loginInfo");
        List<MemberDTO> dtoList =  memberListService.memberList();
        int rs = memberListService.memberTotalCount();
        model.addAttribute("loginInfo", dto);
        model.addAttribute("totalCount", rs);
        model.addAttribute("dtoList", dtoList);
        return "admin/memberList";
    }
}
