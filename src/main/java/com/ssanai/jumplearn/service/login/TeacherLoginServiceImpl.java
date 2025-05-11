package com.ssanai.jumplearn.service.login;

import com.ssanai.jumplearn.config.ModelMapperConfig;
import com.ssanai.jumplearn.dto.TeacherDTO;
import com.ssanai.jumplearn.mapper.login.TeacherLoginMapper;
import com.ssanai.jumplearn.vo.TeacherVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class TeacherLoginServiceImpl implements TeacherLoginServiceIf{

    private final TeacherLoginMapper TeacherLoginXmlMapper;
    private final ModelMapperConfig ModelMapperConfig;

    public TeacherDTO login(TeacherDTO dto){
        TeacherVO vo = ModelMapperConfig.getModelMapper().map(dto, TeacherVO.class);
        return TeacherLoginXmlMapper.login(vo);
    }
}
