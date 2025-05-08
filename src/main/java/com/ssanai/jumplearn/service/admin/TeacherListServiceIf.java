package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.dto.TeacherClassDTO;
import com.ssanai.jumplearn.dto.TeacherDTO;

import java.util.List;

public interface TeacherListServiceIf {
    public int teacherTotalCount(PageRequestDTO requestDTO);
    public int teacherDelete(String id);
    public int teacherChange(String id, int status);
    public int teacherCreate(TeacherDTO teacherDTO);
    public PageResponseDTO<TeacherDTO> searchList(PageRequestDTO requestDTO);
    public TeacherDTO teacherDetail(String id);
    public List<TeacherClassDTO> teacherClass(String id);
}
