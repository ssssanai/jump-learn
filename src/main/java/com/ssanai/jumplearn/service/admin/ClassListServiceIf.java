package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.ClassDetailDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;

public interface ClassListServiceIf {
    public int classTotalCount(PageRequestDTO requestDTO);
    public int classCreate(ClassDetailDTO classDTO);
    public int classUpdate(ClassDetailDTO classDTO);
    public PageResponseDTO<ClassDetailDTO> searchList(PageRequestDTO requestDTO);
}
