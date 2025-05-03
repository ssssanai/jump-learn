package com.ssanai.jumplearn.mapper.admin;

import com.ssanai.jumplearn.dto.MemberDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberListMapper {
    public List<MemberDTO> memberList();
    public int memberTotalCount();
    public int memberDelete(String id);
    public int memberChange(@Param("id") String id, @Param("status") int status);
}
