package com.ssanai.jumplearn.controller.bbs;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.service.bbs.BbsServiceInterface;
import com.ssanai.jumplearn.util.BbsPage;
import com.ssanai.jumplearn.util.FilePathConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/edu")
public class EduBbsController {
    private final BbsServiceInterface bbsService;
    private final FilePathConfig filePathConfig;

    @GetMapping("/writePage")
    public String writePageGET(
            @ModelAttribute("pageDTO") PageRequestDTO pageDTO,
            Model model,
            HttpSession session
    ){
        AdminDTO adto = (AdminDTO)session.getAttribute("loginInfo");
        log.info("adto", adto.toString());
        model.addAttribute("adto", adto);
        return "edu/writePage";
    }

    @PostMapping("/writePage")
    public String writePagePOST(
            BbsDefaultDTO dto,
            @ModelAttribute("pageDTO") PageRequestDTO pageDTO,
            @RequestParam(value = "file", required = false) MultipartFile file,
            RedirectAttributes redirectAttributes
    ) {
        try {
            int result = bbsService.insert(dto);
            if (result != 1) {
                redirectAttributes.addFlashAttribute("msg", "글 등록에 실패했습니다.");
                return "redirect:/edu/writePage?" + pageDTO.getLinkParams();
            }

            if (file != null && !file.isEmpty()) { bbsService.fileUpload(dto, file); }

            redirectAttributes.addFlashAttribute("msg", "등록 성공");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msg", "등록 실패: " + e.getMessage());
            return "redirect:/edu/writePage?" + pageDTO.getLinkParams();
        }
        return "redirect:/edu/searchListPage?" + pageDTO.getLinkParams();
    }

    @GetMapping("/viewPage")
    public String viewPage(
            @RequestParam(name="id", required=false, defaultValue="0") int id,
            @ModelAttribute("pageDTO") PageRequestDTO pageDTO,
            Model model
    ) {
        bbsService.viewCount(id);

        BbsDefaultDTO dto = bbsService.selectOne(id);
        List<BbsFileDTO> fileDTO = bbsService.attachedPic(id);
        List<BbsFileDTO> pdfFileDTO   = bbsService.attachedPdf(id);

        System.out.println(" attachedPic : " + fileDTO.size() + " items");
        System.out.println(" attachedPdf : " + pdfFileDTO.size() + " items");

        model.addAttribute("dto", dto);
        model.addAttribute("fileDTO", fileDTO);
        model.addAttribute("pdfFileDTO", pdfFileDTO);
        return "edu/viewPage";
    }

    @GetMapping("/editPage")
    public String editPage(
            @RequestParam(name="id", required=false, defaultValue="0") int id
            , @ModelAttribute("pageDTO") PageRequestDTO pageDTO
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
            ,@ModelAttribute("pageDTO") PageRequestDTO pageDTO
    ){
        bbsService.update(dto);
        return "redirect:/edu/searchListPage?" + pageDTO.getLinkParams();
    }

    @GetMapping("/delete")
    public String delete(
            @RequestParam(name="id", required=false, defaultValue="0") int id
            , @ModelAttribute("pageDTO") PageRequestDTO pageDTO
    ){

        bbsService.delete(id);
        return "redirect:/edu/searchListPage?" + pageDTO.getLinkParams();    }

    @GetMapping("/searchListPage")
    public String searchListPage(
            HttpServletRequest req
            ,@ModelAttribute("pageDTO") PageRequestDTO pageDTO,
//            HttpSession session,
            Model model
    ) {
        PageResponseDTO<BbsDefaultDTO> dto = bbsService.searchList(pageDTO);
        int totalCount = bbsService.getTotalCount(pageDTO);
//        AdminDTO adto = (AdminDTO)session.getAttribute("loginInfo");
//        log.info("adto", adto.toString());
//        model.addAttribute("adto", adto);
        model.addAttribute("dto", dto);

        StringBuilder URI = new StringBuilder()
                .append(req.getRequestURI())
                .append("?")
                .append(pageDTO.getLinkParamsWithoutNo());

        String paging = BbsPage.pagingArea(
                totalCount
                , pageDTO.getPage_no()
                , pageDTO.getPage_size()
                , pageDTO.getPage_block_size()
                , URI.toString() );
        model.addAttribute("paging", paging);
        return "edu/searchListPage";
    }

//    @PostMapping("/searchListPage")
//    public String searchListPOST(
//            @ModelAttribute("pageDTO") PageRequestDTO pageDTO
//    ){
//        bbsService.searchList(pageDTO);
//        return "redirect:/edu/searchListPage?" + pageDTO.getLinkParams();
//    }

}