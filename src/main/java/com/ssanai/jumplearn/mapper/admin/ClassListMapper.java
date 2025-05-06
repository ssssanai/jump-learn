package com.ssanai.jumplearn.mapper.admin;

import com.ssanai.jumplearn.dto.ClassDetailDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;

import java.util.List;

public interface ClassListMapper {
    public int classTotalCount(PageRequestDTO requestDTO);
    public int classCreate(ClassDetailDTO classDetailDTO);
    public int classUpdate(ClassDetailDTO classDetailDTO);
    public List<ClassDetailDTO> searchList(PageRequestDTO requestDTO);
}
