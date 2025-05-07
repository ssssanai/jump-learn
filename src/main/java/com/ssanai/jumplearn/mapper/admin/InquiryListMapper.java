package com.ssanai.jumplearn.mapper.admin;

import com.ssanai.jumplearn.dto.InquiryDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;

import java.util.List;

public interface InquiryListMapper {
    public int inquiryTotalCount(PageRequestDTO requestDTO);
    public List<InquiryDTO> searchList(PageRequestDTO requestDTO);
    public int inquiryDelete(String inquiryId);
    public int inquiryResolution(InquiryDTO inquiryDTO);
    public InquiryDTO inquiryDetail(String inquiryId);
}
