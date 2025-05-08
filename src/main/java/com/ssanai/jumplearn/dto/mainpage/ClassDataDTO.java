package com.ssanai.jumplearn.dto.mainpage;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
@Log4j2
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassDataDTO {
    private int id;
    private int class_id;
    private int data_order;

    private String data_path;
    private String data_name;
    private String data_extension;
    private long data_size;

    private String title;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    //해당 선생님 필드 추가
    private String teacher_id;
}
