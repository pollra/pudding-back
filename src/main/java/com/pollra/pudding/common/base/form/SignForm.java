package com.pollra.pudding.common.base.form;

import com.pollra.pudding.common.base.annotation.Description;
import lombok.Data;

public class SignForm {

    @Data
    public static class Request {

        @Data
        public static class Creator {

            @Description("조회자")
            private String createdBy;
        }
    }
}
