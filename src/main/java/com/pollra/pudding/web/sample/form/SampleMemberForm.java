package com.pollra.pudding.web.sample.form;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @since       2021.01.29
 * @author      pollra
 * @description SampleMemberForm
 **********************************************************************************************************************/
public class SampleMemberForm {

    public static class Request {

        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Add {
            @NotBlank
            private String name;

            @NotNull
            @Min(0)
            @Max(200)
            private Integer age;
        }
    }

    public static class Response {
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class FindOne {
            private Long id;

            private String name;

            private Integer age;

            private LocalDateTime createdDate;
        }
    }
}
