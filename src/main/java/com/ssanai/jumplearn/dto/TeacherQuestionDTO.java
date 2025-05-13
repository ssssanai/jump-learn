package com.ssanai.jumplearn.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Log4j2
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherQuestionDTO {
    private int id; //강의 질문 id
    private int class_id; //강의 id
    private String teacher_id; //선생님 id
    private String member_id; // 회원 id
    private String title; //질문 제목
    private String content; //질문 내용
    private LocalDateTime created_at; //질문시간
    private int is_answered; //답변 여부
    
    private String comment_content;//  선생님 답변
    private LocalDateTime comment_created_at; //선생님 답변 시간

    private String class_title; //강좌 제목
}
