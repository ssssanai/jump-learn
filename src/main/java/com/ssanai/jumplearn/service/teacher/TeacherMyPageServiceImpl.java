package com.ssanai.jumplearn.service.teacher;

import com.ssanai.jumplearn.dto.TeacherDTO;
import com.ssanai.jumplearn.mapper.teacher.TeacherMyPageMapper;
import com.ssanai.jumplearn.service.login.TeacherLoginServiceIf;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class TeacherMyPageServiceImpl implements TeacherMyPageServiceIf {

    private final TeacherMyPageMapper teacherMyPageXmlMapper;

    @Override
    public TeacherDTO teacherMyPageInfo(String teacherId) {
        TeacherDTO dto = teacherMyPageXmlMapper.teacherMyPageInfo(teacherId);
        log.info(dto.toString());
        return dto;
    }
}
