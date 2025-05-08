package com.ssanai.jumplearn.service.admin;


import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.dto.mainpage.ClassDataDTO;
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

    @Override
    public int classTotalCount(PageRequestDTO requestDTO) {
        return classListXmlMapper.classTotalCount(requestDTO);
    }

    @Override
    public int classCreate(ClassDetailDTO classDTO) {
        return classListXmlMapper.classCreate(classDTO);
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

    @Override
    public List<ClassVideoDTO> videoList(int id) {
        List<ClassVideoDTO> dtoList = classListXmlMapper.videoList(id);
        log.info("서비스단 "+dtoList.toString());
        return dtoList;
    }

    @Override
    public int createVideo1(ClassVideoDTO classVideoDTO) {
        return classListXmlMapper.createVideo1(classVideoDTO);
    }

    @Override
    public int createVideo2(ClassVideoDTO classVideoDTO) {
        return classListXmlMapper.createVideo2(classVideoDTO);
    }

    @Override
    public int createData(ClassDataDTO classDataDTO) {
        return classListXmlMapper.createData(classDataDTO);
    }
}
