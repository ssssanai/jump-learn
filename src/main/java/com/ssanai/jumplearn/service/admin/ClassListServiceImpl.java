package com.ssanai.jumplearn.service.admin;


import com.ssanai.jumplearn.dto.ClassDetailDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.dto.TeacherDTO;
import com.ssanai.jumplearn.mapper.admin.ClassListMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class ClassListServiceImpl implements ClassListServiceIf {
    private final ClassListMapper classListXmlMapper;
    private final ModelMapper modelMapper;

    @Override
    public int classTotalCount(PageRequestDTO requestDTO) {
        return classListXmlMapper.classTotalCount(requestDTO);
    }

    @Override
    public int classCreate(ClassDetailDTO classDTO) {
        return 0;
    }

    @Override
    public int classUpdate(ClassDetailDTO classDTO) {
        return 0;
    }

    @Override
    public PageResponseDTO<ClassDetailDTO> searchList(PageRequestDTO requestDTO) {
        int totalCount = classListXmlMapper.classTotalCount(requestDTO);
        List<ClassDetailDTO> classDetailList = classListXmlMapper.searchList(requestDTO);

        PageResponseDTO<ClassDetailDTO> responseDTO =
                PageResponseDTO
                        .<ClassDetailDTO>withAll()
                        .reqDTO(requestDTO)
                        .dtoList(classDetailList)
                        .total_count(totalCount)
                        .build();
        return responseDTO;
    }
}
