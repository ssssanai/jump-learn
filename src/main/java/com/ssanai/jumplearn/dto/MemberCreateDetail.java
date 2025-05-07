package com.ssanai.jumplearn.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemberCreateDetail {
    private String id; //회원 아이디
    private int post_id; //게시물 아이디
    private String post_title; //게시물 제목
    private int view_count; //게시물 조회 수
    private int like_count; //게시물 좋아요 수
    private LocalDateTime created_at; //게시물 생성 날짜
    private LocalDateTime updated_at; //게시물 수정 날짜
}
