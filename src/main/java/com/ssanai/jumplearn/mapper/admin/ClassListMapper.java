package com.ssanai.jumplearn.mapper.admin;

import com.ssanai.jumplearn.dto.ClassDetailDTO;
import com.ssanai.jumplearn.dto.ClassVideoDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.ClassDataDTO;

import java.util.List;

public interface ClassListMapper {
    public int classTotalCount(PageRequestDTO requestDTO);
    public int classCreate(ClassDetailDTO classDetailDTO);
    public int classUpdate(ClassDetailDTO classDetailDTO);
    public List<ClassDetailDTO> searchList(PageRequestDTO requestDTO);
    public List<ClassVideoDTO> videoList(int id);
    public int createVideo1(ClassVideoDTO classVideoDTO);
    public int createVideo2(ClassVideoDTO classVideoDTO);
    public int createData(ClassDataDTO classDataDTO);
    public int deleteClass(int id);
    public int deleteData(int id);
    public ClassDataDTO dataDetail(int id);
    public int classDataUpdate(ClassDataDTO classDataDTO);
    public int classDataDelete(int id);
    public int classVideoUpdate(ClassVideoDTO classVideoDTO);
    public int classVideoDelete(int id);
}
