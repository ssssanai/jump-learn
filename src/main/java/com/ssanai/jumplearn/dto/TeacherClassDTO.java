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
public class TeacherClassDTO {
    private String id; // 선생님ID
    private int class_id; //강좌ID
    private String target; //강좌 타겟 층(고1, 고2,,)
    private int price; //강과 가격
    private String title; //강좌 제목
    private String introduce; //강좌 소개
    private String notice; //강좌 공지사항
    private String file_name; //강좌 사진 제목

    private LocalDateTime created_at; // 강좌 개설 날짜
    private int pay_count;//강좌에 대한 결제가 몇건 일어났는지 count 수
    private double feedback_avg; //강의평 점수 평균

}
