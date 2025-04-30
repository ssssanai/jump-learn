package com.ssanai.jumplearn.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 교육 정보, 대입 정보, ...
public abstract class BbsDTOInterface {
    private int id;
    private String title;
    private String content;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
    private int view_count;
    private String admin_id;
}