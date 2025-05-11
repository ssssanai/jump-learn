package com.ssanai.jumplearn.service.login;

import com.ssanai.jumplearn.dto.TeacherDTO;
import com.ssanai.jumplearn.vo.TeacherVO;

public interface TeacherLoginServiceIf {
    public TeacherDTO login(TeacherDTO dto);
}
