package com.pollra.pudding.infra.auth.jwt.form;

import lombok.*;

/**
 * @author pollra
 * @description JwtForm
 * @since 2021.02.28
 **********************************************************************************************************************/
public class JwtForm {
    public static class Authentication {

        private Headers headers;
        private Payloads payloads;

        @Setter
        @Builder

        @NoArgsConstructor
        @AllArgsConstructor
        public static class Headers {
            private String type;
            private String algorithm;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Payloads {
            private Credential credential;

            @Data
            @Builder
            @NoArgsConstructor
            @AllArgsConstructor
            public static class Credential {
                private String role;
                private String nickname;
            }
        }
    }
}
