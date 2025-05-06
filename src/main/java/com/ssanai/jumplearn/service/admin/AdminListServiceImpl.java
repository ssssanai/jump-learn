package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.mapper.admin.AdminListMapper;
import com.ssanai.jumplearn.mapper.admin.MemberListMapper;
import com.ssanai.jumplearn.mapper.admin.ReportListMapper;
import com.ssanai.jumplearn.vo.AdminVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class AdminListServiceImpl implements AdminListServiceIf {
    private final AdminListMapper adminListXmlMapper;
    private final ModelMapper modelMapper;

    @Override
    public int adminTotalCount(PageRequestDTO requestDTO) {
        return adminListXmlMapper.adminTotalCount(requestDTO);
    }

    @Override
    public int adminDelete(String id) {
        return adminListXmlMapper.adminDelete(id);
    }

    @Override
    public int adminChange(String id, int status) {
        return adminListXmlMapper.adminChange(id, status);
    }

    @Override
    public int adminCreate(AdminDTO adminDTO) {
        AdminVO adminVO = modelMapper.map(adminDTO, AdminVO.class);
        return adminListXmlMapper.adminCreate(adminVO);
    }

    @Override
    public PageResponseDTO<AdminDTO> searchList(PageRequestDTO requestDTO) {
        int totalCount = adminListXmlMapper.adminTotalCount(requestDTO);
        List<AdminDTO> adminList = adminListXmlMapper.searchList(requestDTO);
        //vo --> DTO 객체 매핑
        List<AdminDTO> adminDTOList =
                adminList.stream().map(
                        admin -> modelMapper.map(admin, AdminDTO.class))
                        .collect(Collectors.toList());
        //DTO 객체 + UI 제어위한 파라미터 매핑
        PageResponseDTO<AdminDTO> responseDTO =
                PageResponseDTO
                        .<AdminDTO>withAll()
                        .reqDTO(requestDTO)
                        .dtoList(adminDTOList)
                        .total_count(totalCount)
                        .build();
        return responseDTO;
    }
}
