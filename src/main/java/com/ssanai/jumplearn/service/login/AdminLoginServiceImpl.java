package com.ssanai.jumplearn.service.login;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.mapper.login.AdminLoginMapper;
import com.ssanai.jumplearn.vo.AdminVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class AdminLoginServiceImpl implements AdminLoginServiceIf {
    private final AdminLoginMapper AdminLoginXmlMapper;
    private  final ModelMapper modelMapper;

    @Override
    public AdminDTO login(AdminDTO dto) {
        log.info("로그인시도");
        AdminVO vo = modelMapper.map(dto, AdminVO.class);
        AdminDTO Mdto =  AdminLoginXmlMapper.login(vo);
        return Mdto;
    }
}
