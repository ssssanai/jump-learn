package com.ssanai.jumplearn.mapper.teacher;

import com.ssanai.jumplearn.dto.*;

import java.util.List;

public interface TeacherMyPageMapper {
    public TeacherDTO teacherMyPageInfo(String teacherId);
    public List<TeacherClassDTO> teacherClassInfo(String teacherId);
    public int teacherMyPageUpdate(TeacherDTO dto);
    public List<EnrollmentsDTO> enrollmentsDetail(String class_id);
    public int enrollmentsMidterm(EnrollmentsDTO dto);
    public int enrollmentsFinal(EnrollmentsDTO dto);
    public int enrollmentsFinalGrade(EnrollmentsDTO dto);
    public int noticeUpdate(ClassVideoDTO dto);
    public List<TeacherQuestionDTO> teacherQuestionList(int class_id);
    public TeacherQuestionDTO teacherQuestionDetail(int question_id);
    public int teacherComment(TeacherQuestionDTO dto);
    public int questionIsAnsweredUpdate(int id);
}
