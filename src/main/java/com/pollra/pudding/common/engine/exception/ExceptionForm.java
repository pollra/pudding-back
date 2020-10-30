package com.pollra.pudding.common.engine.exception;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionForm {

    private ExceptionCode code;
    private String        message;
}