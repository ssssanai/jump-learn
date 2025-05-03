package com.ssanai.jumplearn.mapper.login;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.vo.AdminVO;

public interface AdminLoginMapper {
    public AdminDTO login(AdminVO vo);

}
