package com.ssanai.jumplearn.service.admin;


import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.dto.ClassDataDTO;
import com.ssanai.jumplearn.mapper.admin.ClassListMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public int deleteClass(int id) {
        return classListXmlMapper.deleteClass(id);
    }

    @Override
    public ClassDataDTO dataDetail(int id) {
        return classListXmlMapper.dataDetail(id);
    }

    @Override
    public int classDataUpdate(ClassDataDTO classDataDTO) {
        return classListXmlMapper.classDataUpdate(classDataDTO);
    }

    @Override
    public int classDataDelete(int id) {
        return classListXmlMapper.classDataDelete(id);
    }

}
