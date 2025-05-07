package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.*;

import java.util.List;

public interface AdminListServiceIf {
    public int adminTotalCount(PageRequestDTO requestDTO);
    public int adminDelete(String id);
    public int adminChange(String id, int status);
    public int adminCreate(AdminDTO adminDTO);
    public PageResponseDTO<AdminDTO> searchList(PageRequestDTO requestDTO);
}
