package com.ssanai.jumplearn.service.teacher;

import com.ssanai.jumplearn.dto.ClassVideoDTO;
import com.ssanai.jumplearn.dto.EnrollmentsDTO;
import com.ssanai.jumplearn.dto.TeacherClassDTO;
import com.ssanai.jumplearn.dto.TeacherDTO;

import java.util.List;

public interface TeacherMyPageServiceIf {
    public TeacherDTO teacherMyPageInfo(String teacherId);
    public List<TeacherClassDTO> teacherClassInfo(String teacherId);
    public int teacherMyPageUpdate(TeacherDTO dto);
    public List<EnrollmentsDTO> enrollmentsDetail(String class_id);
    public int enrollmentsMidterm(EnrollmentsDTO dto);
    public int enrollmentsFinal(EnrollmentsDTO dto);
    public int enrollmentsFinalGrade(EnrollmentsDTO dto);
    public int noticeUpdate(ClassVideoDTO dto);
}
