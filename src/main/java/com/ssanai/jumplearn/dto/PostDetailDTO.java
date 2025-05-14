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
public class PostDetailDTO {
    //post테이블
    private int post_id; //post_id
    private String post_member_id; //post_member_id
    private String post_title; //post_title
    private String post_content; //post_content
    private LocalDateTime post_created_at; //post_created_at
    private LocalDateTime post_updated_at; //post_updated_at
    private int view_count; //view_count

    private String member_name;//회원이름

    //post_like테이블
    private int like_id;
    private String like_member_id;
    private int like_count; //좋아요 개수

}
