package com.ssanai.jumplearn.controller.bbs;

import com.ssanai.jumplearn.dto.BbsDefaultDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.service.bbs.BbsServiceInterface;
import com.ssanai.jumplearn.util.BbsPage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/edu")
public class EduBbsController {
    private final BbsServiceInterface bbsService;

    @GetMapping("/writePage")
    public String writePageGET(){
        return "edu/writePage";
    }

    @PostMapping("/writePage")
    public String writePagePOST(
            BbsDefaultDTO dto
    ){
//        dto = BbsDefaultDTO.builder()
//                    .admin_id("admin001")
//                    .title("null 입력 대체 제목")
//                    .content("null 입력 대체 본문")
//                    .created_at(now())
//                    .build();
        bbsService.insert(dto);
        return "redirect:/edu/searchListPage";
    }

    @GetMapping("/viewPage")
    public String viewPage(
            @RequestParam(name="id", required=false, defaultValue="0") int id
            , Model model
    ){
        model.addAttribute("dto", bbsService.selectOne(id));
        model.addAttribute("fileDTO", bbsService.attachedPic(id));
        model.addAttribute("pdfFileDTO", bbsService.attachedPdf(id));
        return "edu/viewPage";
    }

    @GetMapping("/editPage")
    public String editPage(
            @RequestParam(name="id", required=false, defaultValue="0") int id
            , Model model
    ){
        model.addAttribute("dto", bbsService.selectOne(id));
        model.addAttribute("fileDTO", bbsService.attachedPic(id));
        model.addAttribute("pdfFileDTO", bbsService.attachedPdf(id));
        return "edu/editPage";
    }

    @PostMapping("/editPage")
    public String editPagePOST(
            BbsDefaultDTO dto
    ){
        bbsService.update(dto);
        return "redirect:/edu/searchListPage";
    }

    @GetMapping("/delete")
    public String delete(
            @RequestParam(name="id", required=false, defaultValue="0") int id
    ){

        bbsService.delete(id);
        return "redirect:/edu/searchListPage";
    }

    @GetMapping("/searchListPage")
    public String searchListPage(
            HttpServletRequest req
            ,@ModelAttribute("pageDTO") PageRequestDTO pageDTO,
            Model model
    ) {
        PageResponseDTO<BbsDefaultDTO> dto = bbsService.searchList(pageDTO);
        int totalCount = bbsService.getTotalCount(pageDTO);

        model.addAttribute("dto", dto);
        String paging = BbsPage.pagingArea(totalCount, pageDTO.getPage_no(), pageDTO.getPage_size(), pageDTO.getPage_block_size(), req.getContextPath());
        model.addAttribute("paging", paging);
        return "edu/searchListPage";
    }

    @PostMapping("/searchListPage")
    public String searchListPOST(
            PageRequestDTO pageDTO
    ){
        bbsService.searchList(pageDTO);
        return "redirect:/edu/searchListPage";
    }

}
