package com.pollra.pudding.auth.bisiness.account.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

/**
 * @since       2021.01.31
 * @author      pollra
 * @description GuestAccountForm
 **********************************************************************************************************************/
@Slf4j
public class GuestAccountForm {

    public static class Request {

        @Setter
        @Getter
        @Builder
        @ToString
        @Valid
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Add {
            @NotBlank
            @Length(min=4, max=20)
            private String identity;

            @NotBlank
            @Length(min=4, max=20)
            private String nickname;

            @NotBlank
            @Length(min=8, max=50)
            private String password;

            @JsonProperty("password_check")
            @Length(min=8, max=50)
            private String passwordCheck;

            @AssertTrue(message="비밀번호가 일치하지 않습니다.")
            public boolean isValidPassword(){
                return password.equals(passwordCheck);
            }
        }
    }

    public static class Response {

        @Setter
        @Getter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class AddSuccess {
            private Long id;
            private String identity;
            private String nickname;
        }

        @Setter
        @Getter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class FindOne {
            private Long id;
            private String identity;
            private String nickname;
        }
    }
}
