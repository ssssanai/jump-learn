package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.mapper.admin.AdminListMapper;
import com.ssanai.jumplearn.mapper.admin.MemberListMapper;
import com.ssanai.jumplearn.mapper.admin.ReportListMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class AdminListServiceImpl implements AdminListServiceIf {
    private final AdminListMapper adminListXmlMapper;
    private final ModelMapper modelMapper;

    @Override
    public int teacherTotalCount(PageRequestDTO requestDTO) {
        return 0;
    }

    @Override
    public int teacherDelete(String id) {
        return 0;
    }

    @Override
    public int teacherChange(String id, int status) {
        return 0;
    }

    @Override
    public int teacherCreate(TeacherDTO teacherDTO) {
        return 0;
    }

    @Override
    public PageResponseDTO<TeacherDTO> searchList(PageRequestDTO requestDTO) {
        return null;
    }
}
