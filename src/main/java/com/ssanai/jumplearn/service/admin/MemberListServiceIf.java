package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.MemberDTO;

import java.util.List;

public interface MemberListServiceIf {
    public List<MemberDTO> memberList();
    public int memberTotalCount();
}
