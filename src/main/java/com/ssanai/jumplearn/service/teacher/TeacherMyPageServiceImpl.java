package com.ssanai.jumplearn.service.teacher;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.mapper.teacher.TeacherMyPageMapper;
import com.ssanai.jumplearn.service.login.TeacherLoginServiceIf;
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
public class TeacherMyPageServiceImpl implements TeacherMyPageServiceIf {

    private final TeacherMyPageMapper teacherMyPageXmlMapper;

    @Override
    public TeacherDTO teacherMyPageInfo(String teacherId) {
        CommonDateUtil cUtil = new CommonDateUtil();
        TeacherDTO dto = teacherMyPageXmlMapper.teacherMyPageInfo(teacherId);
        dto.setBirthday(cUtil.dateToString(dto.getBirth()));
        log.info(dto.toString());
        return dto;
    }

    @Override
    public List<TeacherClassDTO> teacherClassInfo(String teacherId) {
        return teacherMyPageXmlMapper.teacherClassInfo(teacherId);
    }

    @Override
    public int teacherMyPageUpdate(TeacherDTO dto) {
        log.info("컨트롤러 진입: ChangeInfo 메서드 실행 시작");
        int rs = teacherMyPageXmlMapper.teacherMyPageUpdate(dto);
        log.info("서비스단 성공"+rs);
        return rs;
    }

    @Override
    public List<EnrollmentsDTO> enrollmentsDetail(String class_id) {
        return teacherMyPageXmlMapper.enrollmentsDetail(class_id);
    }

    @Override
    public int enrollmentsMidterm(EnrollmentsDTO dto) {
        return teacherMyPageXmlMapper.enrollmentsMidterm(dto);
    }

    @Override
    public int enrollmentsFinal(EnrollmentsDTO dto) {
        return teacherMyPageXmlMapper.enrollmentsFinal(dto);
    }

    @Override
    public int enrollmentsFinalGrade(EnrollmentsDTO dto) {
        return teacherMyPageXmlMapper.enrollmentsFinalGrade(dto);
    }

    @Override
    public int noticeUpdate(ClassVideoDTO dto) {
        return teacherMyPageXmlMapper.noticeUpdate(dto);
    }

    @Override
    public List<TeacherQuestionDTO> teacherQuestionList(int class_id) {
        return teacherMyPageXmlMapper.teacherQuestionList(class_id);
    }

    @Override
    public TeacherQuestionDTO teacherQuestionDetail(int question_id) {
        return teacherMyPageXmlMapper.teacherQuestionDetail(question_id);
    }

    @Override
    public int teacherComment(TeacherQuestionDTO dto) {
        int rs = teacherMyPageXmlMapper.teacherComment(dto);
        if(rs != 1){
            return rs;
        }else{
           rs = teacherMyPageXmlMapper.questionIsAnsweredUpdate(dto.getId());
        }
        return rs;
    }
}
