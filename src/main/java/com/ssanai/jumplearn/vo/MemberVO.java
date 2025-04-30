package com.ssanai.jumplearn.vo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MemberVO {
    private String id; //회원 아이디
    private String password; //회원 비밀번호
    private String name; //회원 이름
    private Date birthday; //회원 생일
    private String email; //회원 이메일
    private String grade; //고1 = grade1, 고2 = grade2, 고3 = grade3, n수 = n이라고 명시해야합니다.
    private String gender; //성별 남자 M/ 여자 F 명시해야함
    private LocalDateTime signup_date; //회원 가입 날짜
    private LocalDateTime last_pwd_date; //마지막 비밀번호 변경 날짜
    private int status; //회원등급 1:일반 회원, 2: 신고 받은 회원 3: 6개월동안 비밀번호 변경하지 않은 회원 4:탈퇴한 회원
    private String file_name; //회원 프로필 사진 파일 이름
    private String file_path; //회원 프로필 사진 파일 경로
    private long file_size; // 회원 프로필 사진 파일 크기
    private String file_ext; // 회원 프로필 파일 확장자 ->사진 같은경우는 이미지만 들어가야함
    private LocalDateTime status_changed_date; //Status 변경 날짜
}
