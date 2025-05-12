package com.ssanai.jumplearn.mapper.teacher;

import com.ssanai.jumplearn.dto.EnrollmentsDTO;
import com.ssanai.jumplearn.dto.TeacherClassDTO;
import com.ssanai.jumplearn.dto.TeacherDTO;

import java.util.List;

public interface TeacherMyPageMapper {
    public TeacherDTO teacherMyPageInfo(String teacherId);
    public List<TeacherClassDTO> teacherClassInfo(String teacherId);
    public int teacherMyPageUpdate(TeacherDTO dto);
    public List<EnrollmentsDTO> enrollmentsDetail(String class_id);
    public int enrollmentsMidterm(EnrollmentsDTO dto);
    public int enrollmentsFinal(EnrollmentsDTO dto);
    public int enrollmentsFinalGrade(EnrollmentsDTO dto);
}
