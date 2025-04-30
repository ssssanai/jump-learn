package com.ssanai.jumplearn.vo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AdminVO {
    private String id; //관리자 아이디
    private String password; //관리자 비밀번호
    private String name; //관리자 이름
    private String email; //관리자 이메일
    private LocalDateTime signup_date; //관리자 가입 날짜
    private int status; //관리자권한 1:슈퍼 관리자, 2: 중간 관리자 3:말단 관리자
}
