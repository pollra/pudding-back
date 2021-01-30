package com.pollra.pudding.auth.bisiness.account.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

public class AccountForm {
    public static class Request {

        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class FindOne {
            private String identity;
        }

        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Add {
            @NotBlank
            private String identity;

            @NotBlank
            @JsonProperty("nick_name")
            private String nickName;

            @NotBlank
            private String password;

            @NotBlank
            @JsonProperty("password_check")
            private String passwordCheck;

            @AssertTrue(message="패스워드 체크가 올바르지 않습니다.")
            public boolean passwordCheck() {
                if(password.equals(passwordCheck)) return true;
                return false;
            }
        }
    }

    public static class Response {

    }
}
