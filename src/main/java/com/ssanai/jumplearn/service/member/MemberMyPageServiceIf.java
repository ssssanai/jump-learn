package com.ssanai.jumplearn.service.member;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.TeacherDTO;

public interface MemberMyPageServiceIf {
    public MemberDTO MemberMyPageInfo(String memberId);
    public int MemberMyPageUpdate(MemberDTO dto);
}
