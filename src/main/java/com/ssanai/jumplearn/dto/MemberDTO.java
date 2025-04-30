package com.ssanai.jumplearn.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Log4j2
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {
    /*regexp는 정규표현식 message는 벨류데이션 실패시 사용자에게 보여지는 문장*/
    @NotEmpty
    @Pattern(regexp = "^[a-z0-9]{8,20}$", message = "아이디는 영소문자와 숫자 조합, 8~20자여야 합니다.")
    private String id;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@!])[A-Za-z\\d@!]{8,20}$",
            message = "비밀번호는 영어, 숫자, 특수문자(@, !)를 포함하여 8~20자여야 합니다.")
    private String password;
    @NotEmpty
    @Pattern(regexp = "^[가-힣]{1,10}$", message = "이름은 한글 10자 이내여야 합니다.")
    private String name;
    @Past(message = "생일은 과거 날짜여야 합니다.")
    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    @NotEmpty
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;
    @NotEmpty
    @Pattern(regexp = "^(grade1|grade2|grade3|n)$", message = "학년은 grade1, grade2, grade3, 또는 n이어야 합니다.")
    private String grade;
    @NotEmpty
    @Pattern(regexp = "^[MF]{1}$", message = "성별은 M 또는 F로 입력해야 합니다.")
    private String gender;
    private LocalDateTime signup_date;
    private LocalDateTime last_pwd_date;
    private int status;
    private String file_name;
    private String file_path;
    private long file_size;
    @Pattern(regexp = "^(?i)(jpg|jpeg|png)$", message = "이미지 확장자는 jpg, jpeg, png, gif만 허용됩니다.")
    private String file_ext;
    private LocalDateTime status_changed_date;
}