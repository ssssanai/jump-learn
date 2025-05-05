package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.dto.TeacherDTO;
import com.ssanai.jumplearn.mapper.admin.TeacherListMapper;
import jdk.jfr.Label;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional
public class TeacherListServiceImpl implements TeacherListServiceIf{
    private final TeacherListMapper teacherListMapper;
    private final ModelMapper modelMapper;

    @Override
    public int teacherTotalCount(PageRequestDTO requestDTO) {
        return teacherListMapper.teacherTotalCount(requestDTO);
    }

    @Override
    public int teacherDelete(String id) {
        int rs = teacherListMapper.teacherDelete(id);
        return rs;
    }

    @Override
    public int teacherChange(String id, int status) {
        int rs = teacherListMapper.teacherChange(id, status);
        return rs;
    }

    @Override
    public int teacherCreate(TeacherDTO teacherDTO) {
        int rs = teacherListMapper.teacherCreate(teacherDTO);
        return rs;
    }

    @Override
    public PageResponseDTO<TeacherDTO> searchList(PageRequestDTO requestDTO) {
        // 조건에 따른 DB 조회
        int totalCount = teacherListMapper.teacherTotalCount(requestDTO);
        List<TeacherDTO> teacherList = teacherListMapper.searchList(requestDTO);
        // VO --> DTO 객체 매핑
        List<TeacherDTO> bbsDTOList =
                teacherList.stream().map(
                        vo->modelMapper.map(vo, TeacherDTO.class)
                ).collect(Collectors.toList());

        // DTO 객체 + UI 제어위한 파라미터 매핑
        PageResponseDTO<TeacherDTO> responseDTO =
                PageResponseDTO
                        .<TeacherDTO>withAll()
                        .reqDTO(requestDTO)
                        .dtoList(bbsDTOList)
                        .total_count(totalCount)
                        .build();
        return responseDTO;
    }
}
