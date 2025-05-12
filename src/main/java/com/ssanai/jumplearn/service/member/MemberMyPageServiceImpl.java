package com.ssanai.jumplearn.service.member;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.TeacherDTO;
import com.ssanai.jumplearn.mapper.member.MemberMyPageMapper;
import com.ssanai.jumplearn.util.CommonDateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
