package com.ssanai.jumplearn.mapper.admin;

import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.ReportDTO;

import java.util.List;

public interface ReportListMapper {
    public List<ReportDTO> searchList(PageRequestDTO requestDTO);
    public int reportTotalCount(PageRequestDTO requestDTO);
    public int reportDelete(String reportId);
    public int reportResolution(ReportDTO reportDTO);
    public ReportDTO reportDetail(String reportId);
}
