package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.dto.ReportDTO;

import java.util.List;

public interface ReportListServiceIf {
    public PageResponseDTO<ReportDTO> searchList(PageRequestDTO requestDTO);
    public int reportTotalCount(PageRequestDTO requestDTO);
    public int reportDelete(ReportDTO reportDTO);
    public int reportResolution(ReportDTO reportDTO);
    public ReportDTO reportDetail(int id);
}
