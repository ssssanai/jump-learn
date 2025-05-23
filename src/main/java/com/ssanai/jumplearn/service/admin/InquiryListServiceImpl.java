package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.InquiryDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.mapper.admin.InquiryListMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional
public class InquiryListServiceImpl implements InquiryListServiceIf{
    private final InquiryListMapper inquiryListXmlMapper;
    @Override
    public int inquiryTotalCount(PageRequestDTO requestDTO) {
        return inquiryListXmlMapper.inquiryTotalCount(requestDTO);
    }

    @Override
    public PageResponseDTO<InquiryDTO> searchList(PageRequestDTO requestDTO) {
        int totalCount = inquiryListXmlMapper.inquiryTotalCount(requestDTO);
        List<InquiryDTO> InquiryList = inquiryListXmlMapper.searchList(requestDTO);
        PageResponseDTO<InquiryDTO> pageResponseDTO =
                PageResponseDTO
                        .<InquiryDTO>withAll()
                        .reqDTO(requestDTO)
                        .dtoList(InquiryList)
                        .total_count(totalCount)
                        .build();
        return pageResponseDTO;
    }

    @Override
    public int inquiryDelete(String inquiryId) {
        return inquiryListXmlMapper.inquiryDelete(inquiryId);
    }

    @Override
    public int inquiryResolution(InquiryDTO inquiryDTO) {
        int rs = inquiryListXmlMapper.inquiryResolution(inquiryDTO);
        if(rs != 1){
            return rs;
        }else{
            rs = inquiryListXmlMapper.inquiryResponseComplete(inquiryDTO.getInquiry_id());
        }
        return  rs;
    }

    @Override
    public InquiryDTO inquiryDetail(int inquiryId) {
        return inquiryListXmlMapper.inquiryDetail(inquiryId);
    }

    @Override
    public List<InquiryDTO> inquiryCommnetDetail(int inquiryId) {
        return inquiryListXmlMapper.inquiryCommnetDetail(inquiryId);
    }

    @Override
    public int inquiryCommentInsert(InquiryDTO inquiryDTO) {
        return inquiryListXmlMapper.inquiryCommentInsert(inquiryDTO);
    }
}
