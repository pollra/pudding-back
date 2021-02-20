package com.pollra.pudding.auth.bisiness.account.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;

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
            private String password;

            @JsonProperty("password_check")
            private String passwordCheck;
        }

        @Setter
        @Getter
        @Builder
        @ToString
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Modify {
            @NotBlank
            @Length(min=4, max=20)
            private String identity;

            @NotBlank
            @Length(min=4, max=20)
            private String nickname;

            @NotBlank
            private String password;
        }
    }

    public static class Response {

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
