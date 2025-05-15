package com.ssanai.jumplearn.mapper.member;

import com.ssanai.jumplearn.dto.BbsDefaultDTO;
import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.PostDTO;
import com.ssanai.jumplearn.dto.ReportDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMyPageMapper {
    public MemberDTO memberMyPageInfo(String memberId);
    public int memberMyPageUpdate(MemberDTO dto);
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
