package com.ssanai.jumplearn.mapper.admin;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.TeacherDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminListMapper {
    public int teacherTotalCount(PageRequestDTO requestDTO);
    public List<TeacherDTO> searchList(PageRequestDTO requestDTO);
    public int teacherDelete(String id);
    public int teacherChange(@Param("id") String id, @Param("status") int status);
}
