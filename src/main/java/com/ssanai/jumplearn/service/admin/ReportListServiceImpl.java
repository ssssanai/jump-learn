package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.dto.ReportDTO;
import com.ssanai.jumplearn.mapper.admin.ReportListMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Log4j2
@Service
@RequiredArgsConstructor
@Transactional
public class ReportListServiceImpl implements  ReportListServiceIf{
    public final ReportListMapper reportListXmlMapper;
    @Override
    public PageResponseDTO<ReportDTO> searchList(PageRequestDTO requestDTO) {
        int totalCount = reportListXmlMapper.reportTotalCount(requestDTO);
        List<ReportDTO> reportDTOList = reportListXmlMapper.searchList(requestDTO);

        PageResponseDTO<ReportDTO> responseDTO =
                PageResponseDTO
                        .<ReportDTO>withAll()
                        .reqDTO(requestDTO)
                        .dtoList(reportDTOList)
                        .total_count(totalCount)
                        .build();
        return responseDTO;
    }

    @Override
    public int reportTotalCount(PageRequestDTO requestDTO) {
        return reportListXmlMapper.reportTotalCount(requestDTO);
    }

    @Override
    public int reportDelete(ReportDTO reportDTO) {
        return 0;
    }

    @Override
    public int reportResolution(ReportDTO reportDTO) {
        int rs = reportListXmlMapper.reportResolution(reportDTO);
        if(rs != 1){
            return  rs;
        }else {
            rs = reportListXmlMapper.reportUpdate(reportDTO.getReport_id());
        }
        return rs;
    }

    @Override
    public ReportDTO reportDetail(int id) {
        return reportListXmlMapper.reportDetail(id);
    }
}
