package com.ssanai.jumplearn.mapper.admin;

import com.ssanai.jumplearn.dto.EnrollmentsDTO;
import com.ssanai.jumplearn.dto.MemberCreateDetail;
import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberListMapper {
    public List<MemberDTO> memberList();
    public int memberTotalCount(PageRequestDTO requestDTO);
    public List<MemberDTO> searchList(PageRequestDTO requestDTO);
    public int memberDelete(String id);
    public int memberChange(@Param("id") String id, @Param("status") int status);
    public MemberDTO memberDetail(String id);
    public List<MemberCreateDetail> memberCreatePost(String id);
    public List<EnrollmentsDTO> memberEnrollments(String id);
}
