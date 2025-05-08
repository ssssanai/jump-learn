package com.ssanai.jumplearn.mapper.admin;

import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.TeacherClassDTO;
import com.ssanai.jumplearn.dto.TeacherDTO;
import com.ssanai.jumplearn.vo.TeacherVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherListMapper {
    public int teacherTotalCount(PageRequestDTO requestDTO);
    public List<TeacherDTO> searchList(PageRequestDTO requestDTO);
    public int teacherDelete(String id);
    public int teacherChange(@Param("id") String id, @Param("status") int status);
    public int teacherCreate(TeacherVO teacherVO);
    public TeacherDTO teacherDetail(String id);
    public List<TeacherClassDTO> teacherClass(String id);
}
