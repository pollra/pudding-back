package com.pollra.pudding.web.sample.controller;

import com.pollra.pudding.common.engine.exception.ExceptionCode;
import com.pollra.pudding.web.sample.exception.SampleException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping
    public String sample(){
        return "hello world!";
    }

    @GetMapping("/exception")
    public String sampleException() throws SampleException{
        throw new SampleException(ExceptionCode.SAMPLE_01, HttpStatus.OK);
    }
}
