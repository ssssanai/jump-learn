package com.ssanai.jumplearn.controller.admin;

import com.ssanai.jumplearn.dto.SalesReportDTO;
import com.ssanai.jumplearn.service.admin.SalesReportIf;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class SalesReportListController {

    private final SalesReportIf salesReportIf;

    @GetMapping("/salesList")
    public String salesList(
            @RequestParam(value = "Sorting", defaultValue = "desc") String sorting,
            Model model) {
        List<SalesReportDTO> dtoList = salesReportIf.salesReportList(sorting);
        model.addAttribute("dtoList", dtoList);
        return "admin/salesReportList";
    }
    @GetMapping("/category_chart")
    public String categoryChart(
            Model model
    ) {
        List<SalesReportDTO> dtoList = salesReportIf.salesReportCategory();
        int koreanSales = 0;
        int englishSales = 0;
        int mathSales = 0;
        for (SalesReportDTO dto : dtoList) {
            switch (dto.getClass_category()) {
                case "KOREAN":
                    koreanSales = dto.getClass_total_cost();
                    break;
                case "ENGLISH":
                    englishSales = dto.getClass_total_cost();
                    break;
                case "MATH":
                    mathSales = dto.getClass_total_cost();
                    break;
            }
        }
        model.addAttribute("koreanSales", koreanSales);
        model.addAttribute("englishSales", englishSales);
        model.addAttribute("mathSales", mathSales);
        return "admin/categoryChart";
    }
    @GetMapping("/category_chart_month")
    public String categoryChartMonth(
            Model model,
            @RequestParam(value = "moth",defaultValue = "2025-05")String month
    ){
        List<SalesReportDTO> dtoList = salesReportIf.salesReportMonthCategory();
        int koreanSales = 0;
        int englishSales = 0;
        int mathSales = 0;
        for (int i = 0; i < dtoList.size(); i++) {
            SalesReportDTO dto = dtoList.get(i);
            log.info("개시발"+ i+"   "+ dto.getClass_month());
        }
        for (SalesReportDTO dto : dtoList) {
            if (dto.getClass_month().equals(month)) {
                log.info("카테고리:" + dto.getClass_category() + " 총비용: {}" +
                        dto.getClass_total_cost());
                switch (dto.getClass_category()) {
                    case "KOREAN":
                        koreanSales = dto.getClass_total_cost();
                        break;
                    case "ENGLISH":
                        englishSales = dto.getClass_total_cost();
                        break;
                    case "MATH":
                        mathSales = dto.getClass_total_cost();
                        break;
                }
            }
        }
        model.addAttribute("koreanSales", koreanSales);
        model.addAttribute("englishSales", englishSales);
        model.addAttribute("mathSales", mathSales);
        return "admin/categoryChart";
    }
}
