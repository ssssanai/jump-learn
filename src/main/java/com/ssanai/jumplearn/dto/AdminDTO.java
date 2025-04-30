package com.ssanai.jumplearn.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Log4j2
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDTO {
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
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;
    private LocalDateTime signup_date;
    private int status;
}
