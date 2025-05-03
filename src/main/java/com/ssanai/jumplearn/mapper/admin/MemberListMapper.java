package com.ssanai.jumplearn.mapper.admin;

import com.ssanai.jumplearn.dto.MemberDTO;

import java.util.List;

public interface MemberListMapper {
    public List<MemberDTO> memberList();
    public int memberTotalCount();
}
