package com.ssanai.jumplearn.mapper.admin;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.vo.AdminVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminListMapper {
    public int adminTotalCount(PageRequestDTO requestDTO);
    public List<AdminDTO> searchList(PageRequestDTO requestDTO);
    public int adminDelete(String id);
    public int adminChange(@Param("id") String id, @Param("status") int status);
    public int adminCreate(AdminVO adminVO);
}
