package com.pollra.pudding.common.engine.auditor;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @since       2021.01.29
 * @author      pollra
 * @description AuditorEvent
 **********************************************************************************************************************/
@Data
@AllArgsConstructor
public class AuditorEvent<T>{
    private T source;
}
