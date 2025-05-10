package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.SalesReportDTO;
import com.ssanai.jumplearn.mapper.admin.SalesReportMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional
public class SalesReportImpl implements SalesReportIf {

    private final SalesReportMapper salesReportXmlMapper;
    @Override
    public List<SalesReportDTO> salesReportList(String orderBy) {
        return salesReportXmlMapper.salesReportList(orderBy);
    }

    @Override
    public List<SalesReportDTO> salesReportCategory() {
        return salesReportXmlMapper.salesReportCategory();
    }

    @Override
    public List<SalesReportDTO> salesReportMonthCategory() {
        return salesReportXmlMapper.salesReportMonthCategory();
    }

}
