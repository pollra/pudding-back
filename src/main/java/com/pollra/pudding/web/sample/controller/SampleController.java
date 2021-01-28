package com.pollra.pudding.web.sample.controller;

import com.pollra.pudding.common.engine.exception.ExceptionCode;
import com.pollra.pudding.web.sample.exception.SampleException;
import com.pollra.pudding.web.sample.form.SampleMemberForm.*;
import com.pollra.pudding.web.sample.service.SampleMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.pollra.pudding.web.sample.mapper.SampleMemberMapper.mapper;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sample")
public class SampleController {

    private final SampleMemberService sampleMemberService;

    @GetMapping
    public String sample(){
        return "hello world!";
    }

    @GetMapping("/exception")
    public String sampleException() throws SampleException{
        throw new SampleException(ExceptionCode.SAMPLE_01, HttpStatus.OK);
    }

    @GetMapping("/members/{id}")
    public Response.FindOne findOne(@PathVariable Long id) {
        return mapper.toFindOne(sampleMemberService.find(mapper.toSampleMember(id)));
    }

    @PostMapping("/members")
    public Response.FindOne add(@Valid Request.Add add) {
        return mapper.toFindOne(sampleMemberService.add(mapper.toSampleMember(add)));
    }
}
