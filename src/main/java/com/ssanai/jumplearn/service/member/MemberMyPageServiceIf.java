package com.ssanai.jumplearn.service.member;

import com.ssanai.jumplearn.dto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    // 신고 내역 확인
    public List<ReportDTO> reportList(@Param("member_id") String member_id);
}
