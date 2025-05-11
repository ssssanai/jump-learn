package com.ssanai.jumplearn.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalesReportDTO {
    private int class_id; //강좌 아이디
    private String class_name; //강좌 제목
    private String class_target; // 강좌 타겟 층
    private int class_cost; //강좌 금액
    private String class_category; //강좌 카테고리
    private int class_total_count; //강좌 총 판매 개수
    private int class_total_cost; //강좌 총 결제 금액
    private String class_month;// 강좌 월 별 담을 곳
    private String teacher_name; //선생님 이름

}
