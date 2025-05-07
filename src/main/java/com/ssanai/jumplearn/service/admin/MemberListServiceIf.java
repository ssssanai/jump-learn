package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.*;

import java.util.List;

public interface MemberListServiceIf {
    public List<MemberDTO> memberList();
    public int memberTotalCount(PageRequestDTO requestDTO);
    public int memberDelete(String id);
    public int memberChange(String id, int status);
    public PageResponseDTO<MemberDTO> searchList(PageRequestDTO requestDTO);
    public MemberDTO memberDetail(String id);
    public List<MemberCreateDetail> memberCreatePost(String id);
    public List<EnrollmentsDTO> memberEnrollments(String id);
}
