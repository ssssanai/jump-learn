package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.mapper.admin.AdminListMapper;
import com.ssanai.jumplearn.mapper.admin.MemberListMapper;
import com.ssanai.jumplearn.mapper.admin.ReportListMapper;
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
public class AdminListServiceImpl implements AdminListServiceIf {
    private final AdminListMapper adminListXmlMapper;

    @Override
    public List<AdminDTO> adminList(){
        List<AdminDTO> list = new ArrayList<>();

        return list;
    }
}
