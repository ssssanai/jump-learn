package com.ssanai.jumplearn.mapper.member;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.TeacherDTO;

public interface MemberMyPageMapper {
    public MemberDTO memberMyPageInfo(String memberId);
    public int memberMyPageUpdate(MemberDTO dto);
}
