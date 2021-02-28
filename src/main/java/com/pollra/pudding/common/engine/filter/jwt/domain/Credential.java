package com.pollra.pudding.common.engine.filter.jwt.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pollra
 * @description Credential
 * @since 2021.02.28
 **********************************************************************************************************************/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Credential {

    private String name;
    private String role;
}
