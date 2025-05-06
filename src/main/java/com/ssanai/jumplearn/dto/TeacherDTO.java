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
public class TeacherDTO {
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
    @NotEmpty
    @Past(message = "생일은 과거 날짜여야 합니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    @NotEmpty
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;
    @NotEmpty
    @Pattern(regexp = "^[MF]{1}$", message = "성별은 M 또는 F로 입력해야 합니다.")
    private String gender;
    private LocalDateTime signup_date;
    private String introduce1;
    private String introduce2;
    private String introduce3;
    private int status;
    private String file_name;
    private String file_path;
    private long file_size;
    @Pattern(regexp = "^(?i)(jpg|jpeg|png)$", message = "이미지 확장자는 jpg, jpeg, png, gif만 허용됩니다.")
    private String file_ext;
}
