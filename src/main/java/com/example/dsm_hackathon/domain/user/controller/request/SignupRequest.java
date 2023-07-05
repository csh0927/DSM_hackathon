package com.example.dsm_hackathon.domain.user.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@NoArgsConstructor
@Getter
public class SignupRequest {
    @NotNull(message = "이름을 입력해주세요.")
    private String name;

    @NotNull(message = "이메일을 입력해주세요.")
    private String email;

    @NotNull(message = "생년월일을 입력해주세요.")
    private Date birth;

    @NotNull(message = "재학여부를 입력해주세요.")
    private String inSchool;

    @NotNull(message = "학교명을 입력해주세요.")
    private String schoolName;

    @NotNull(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자가 포함되어야 합니다.")
    private String password;
}
