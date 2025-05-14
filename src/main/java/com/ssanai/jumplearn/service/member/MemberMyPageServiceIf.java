package com.ssanai.jumplearn.service.member;

import com.ssanai.jumplearn.dto.BbsDefaultDTO;
import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.PostDTO;
import com.ssanai.jumplearn.dto.TeacherDTO;

public interface MemberMyPageServiceIf {
    public MemberDTO MemberMyPageInfo(String memberId);
    public int MemberMyPageUpdate(MemberDTO dto);
    public MemberDTO memberMyPageDelete(MemberDTO dto);
    public PostDTO PostMyPageInfo();
    public BbsDefaultDTO noticeMyPageInfo();
    public BbsDefaultDTO eduMyPageInfo();
    public BbsDefaultDTO infoMyPageInfo();
    public BbsDefaultDTO activityMyPageInfo();
    public BbsDefaultDTO libMyPageInfo();
    public BbsDefaultDTO newsMyPageInfo();

}
