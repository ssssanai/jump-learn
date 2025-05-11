package com.ssanai.jumplearn.mapper.admin;

import com.ssanai.jumplearn.dto.SalesReportDTO;

import java.util.List;

public interface SalesReportMapper {
    public List<SalesReportDTO> salesReportList(String orderBy);
    public List<SalesReportDTO> salesReportCategory();
    public List<SalesReportDTO> salesReportMonthCategory();
}
