package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.service.admin.AdminListServiceIf;
import com.ssanai.jumplearn.service.admin.MemberListServiceIf;
import com.ssanai.jumplearn.util.BbsPage;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String memberList(
            @RequestParam(value = "page_no", defaultValue = "1") String page_no,
            @RequestParam(value = "page_size", defaultValue = "10") String page_size,
            @RequestParam(value = "page_block_size", defaultValue = "10") String page_block_size,
            @RequestParam(value = "search_category", defaultValue = "") String search_category,
            @RequestParam(value = "search_word", defaultValue = "") String search_word,
            HttpSession session,
            Model model
    ){
        BbsPage cUtil = new BbsPage();
        int total_count = 0;
        int total_page = 1;
        page_no = (cUtil.isNumberic(page_no) ? page_no : "1");
        page_no = (cUtil.parseInt(page_no) > 0 ? page_no : "1");
        int page_skip_count = (cUtil.parseInt(page_no) - 1) * cUtil.parseInt(page_size);

        String queryString = "page_size=" + page_size;
        queryString += "&page_block_size=" + page_block_size;
        queryString += "&search_category=" + search_category;
        queryString += "&search_word=" + search_word;

        Map<String, Object> mMap = new HashMap<>();
        mMap.put("page_no", page_no);
        mMap.put("page_size", page_size);
        mMap.put("page_block_size", page_block_size);
        mMap.put("page_skip_count", page_skip_count);

        if (!search_category.isEmpty() && !search_word.isEmpty()) {
            mMap.put("search_category", search_category);
            mMap.put("search_word", search_word);
        }
        AdminDTO dto = (AdminDTO) session.getAttribute("loginInfo");
        List<MemberDTO> dtoList =  memberListService.memberList();
        int rs = memberListService.memberTotalCount();
        model.addAttribute("loginInfo", dto);
        model.addAttribute("totalCount", rs);
        model.addAttribute("dtoList", dtoList);
        return "admin/memberList";
    }
    @GetMapping("/memberDelete")
    public String memberDelete(
            HttpSession session,
            @RequestParam(name = "id")
            String id,
            Model model){
        AdminDTO loginInfo  = (AdminDTO)session.getAttribute("loginInfo");
        int adminStatus = loginInfo.getStatus();
        if(adminStatus != 1){
            model.addAttribute("msg", "삭제 권한이 없습니다.");
            return "redirect:/admin/memberList";
        }else {
            int rs = memberListService.memberDelete(id);
            if(rs>0) {
                model.addAttribute("msg", "삭제 성공");
                return "redirect:/admin/memberList";
            }else{
                model.addAttribute("msg", "삭제 실패");
                return "redirect:/admin/memberList";
            }
        }
    }

    @GetMapping("/memberChange")
    public String memberChange(
            HttpSession session,
            @RequestParam(name = "id")
            String id,
            @RequestParam(name = "s")
            String s,
            Model model){
        AdminDTO loginInfo  = (AdminDTO)session.getAttribute("loginInfo");
        int status = Integer.parseInt(s);
        int adminStatus = loginInfo.getStatus();
        if(adminStatus != 1 && adminStatus != 2){
            model.addAttribute("msg", "변경 권한이 없습니다.");
            return "redirect:/admin/memberList";
        }else{
            int rs = memberListService.memberChange(id, status);
            if(rs>0) {
                model.addAttribute("msg", "변경성공");
                log.info("변경성공");
                return "redirect:/admin/memberList";
            }else{
                model.addAttribute("msg", "변경 실패");
                return "redirect:/admin/memberList";
            }
        }
    }
}
