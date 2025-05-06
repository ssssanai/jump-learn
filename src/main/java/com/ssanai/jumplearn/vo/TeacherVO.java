package com.ssanai.jumplearn.vo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TeacherVO {
    private String id; //선생님 아이디
    private String password; //선생님 비밀번호
    private String name; //선생님 이름
    private Date birth; //선생님 생일
    private String email; //선생님 이메일
    private String gender; //성별 남자 M/ 여자 F 명시해야함
    private LocalDateTime signup_date; //선생님 가입 날짜
    private String introduce1; //선생님 소개1
    private String introduce2; //선생님 소개2
    private String introduce3; //선생님 소개3
    private int status; //선생님등급 1:일반 선생님, 2: 신고 받은 선생님
    private String file_name; //선생님 프로필 사진 파일 이름
    private String file_path; //선생님 프로필 사진 파일 경로
    private long file_size; // 선생님 프로필 사진 파일 크기
    private String file_ext; // 선생님 프로필 파일 확장자 ->사진 같은경우는 이미지만 들어가야함
}
