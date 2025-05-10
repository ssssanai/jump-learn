package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.InquiryDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;

import java.util.List;

public interface InquiryListServiceIf {
    public int inquiryTotalCount(PageRequestDTO requestDTO);
    public PageResponseDTO<InquiryDTO> searchList(PageRequestDTO requestDTO);
    public int inquiryDelete(String inquiryId);
    public int inquiryResolution(InquiryDTO inquiryDTO);
    public InquiryDTO inquiryDetail(int inquiryId);
    public  List<InquiryDTO> inquiryCommnetDetail(int inquiryId);
    public int inquiryCommentInsert(InquiryDTO inquiryDTO);
}
