package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.SalesReportDTO;

import java.util.List;

public interface SalesReportIf {
    public List<SalesReportDTO> salesReportList(String orderBy);
    public List<SalesReportDTO> salesReportCategory();
    public List<SalesReportDTO> salesReportMonthCategory();
}
