package com.ssanai.jumplearn.mapper.member;

import com.ssanai.jumplearn.dto.MemberDTO;

public interface MemberMyPageMapper {
    public MemberDTO memberMyPageInfo(String memberId);
    public int memberMyPageUpdate(MemberDTO dto);
    public MemberDTO memberMyPageDelete(MemberDTO dto);
}
