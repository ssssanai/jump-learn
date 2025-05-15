package com.ssanai.jumplearn.service.member;

import com.ssanai.jumplearn.dto.BbsDefaultDTO;
import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.PostDTO;
import com.ssanai.jumplearn.dto.ReportDTO;
import com.ssanai.jumplearn.mapper.member.MemberMyPageMapper;
import com.ssanai.jumplearn.util.CommonDateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class MemberMyPageServiceImpl implements MemberMyPageServiceIf {
    private final MemberMyPageMapper memberMyPageMapper;

    @Override
    public MemberDTO MemberMyPageInfo(String memberId) {
        CommonDateUtil cUtil = new CommonDateUtil();
        MemberDTO dto = memberMyPageMapper.memberMyPageInfo(memberId);
        return dto;
    }

    @Override
    public int MemberMyPageUpdate(MemberDTO dto) {
        int rs = memberMyPageMapper.memberMyPageUpdate(dto);
        return rs;
    }

    @Override
    public MemberDTO memberMyPageDelete(MemberDTO memberId) {
        MemberDTO rs = memberMyPageMapper.memberMyPageDelete(memberId);
        return rs;
    }

    @Override
    public PostDTO PostMyPageInfo() {
        return memberMyPageMapper.PostMyPageInfo();
    }

    @Override
    public BbsDefaultDTO noticeMyPageInfo() {
        return memberMyPageMapper.noticeMyPageInfo();
    }

    @Override
    public BbsDefaultDTO eduMyPageInfo() {
        return memberMyPageMapper.eduMyPageInfo();
    }

    @Override
    public BbsDefaultDTO infoMyPageInfo() {
        return memberMyPageMapper.infoMyPageInfo();
    }

    @Override
    public BbsDefaultDTO activityMyPageInfo() {
        return memberMyPageMapper.activityMyPageInfo();
    }

    @Override
    public BbsDefaultDTO libMyPageInfo() {
        return memberMyPageMapper.libMyPageInfo();
    }

    @Override
    public BbsDefaultDTO newsMyPageInfo() {
        return memberMyPageMapper.newsMyPageInfo();
    }

    @Override
    public List<ReportDTO> reportList(String member_id) {return memberMyPageMapper.reportList(member_id);}
}
