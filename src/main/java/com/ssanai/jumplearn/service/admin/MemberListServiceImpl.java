package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.mapper.admin.MemberListMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class MemberListServiceImpl implements MemberListServiceIf {
    private final MemberListMapper memberListMapper;

    @Override
    public List<MemberDTO> memberList(){
        List<MemberDTO> list;
        list = memberListMapper.memberList();
        return list;
    }

    @Override
    public int memberTotalCount(){
        int rs = memberListMapper.memberTotalCount();
        return rs;
    }
}
