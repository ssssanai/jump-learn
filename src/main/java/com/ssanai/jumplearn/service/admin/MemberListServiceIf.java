package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.MemberDTO;

import java.util.List;

public interface MemberListServiceIf {
    public List<MemberDTO> memberList();
    public int memberTotalCount();
    public int memberDelete(String id);
    public int memberChange(String id, int status);
}
