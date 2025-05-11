package com.ssanai.jumplearn.mapper.login;

import com.ssanai.jumplearn.dto.TeacherDTO;
import com.ssanai.jumplearn.vo.TeacherVO;

public interface TeacherLoginMapper {
    public TeacherDTO login(TeacherVO vo);
}
