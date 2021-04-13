package com.pollra.pudding.common.engine.filter.jwt.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pollra
 * @description JwtForm
 * @since 2021.02.28
 **********************************************************************************************************************/
public class JwtForm {
    public static class Authentication {

        private Headers headers;
        private Payloads payloads;

        @Data
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
