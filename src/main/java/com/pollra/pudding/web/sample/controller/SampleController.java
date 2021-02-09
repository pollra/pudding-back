package com.pollra.pudding.web.sample.controller;

import com.pollra.pudding.common.engine.exception.ExceptionCode;
import com.pollra.pudding.web.sample.exception.SampleException;
import com.pollra.pudding.web.sample.form.SampleMemberForm.Request;
import com.pollra.pudding.web.sample.form.SampleMemberForm.Response;
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
    public Response.FindOne findOne(@PathVariable(value="id", name="find.id") Request.Find find) {
        return mapper.toFindOne(sampleMemberService.find(mapper.toSampleMember(find)));
    }

    @PostMapping("/members")
    public Response.FindOne add(@Valid Request.Add add) {
        return mapper.toFindOne(sampleMemberService.add(mapper.toSampleMember(add)));
    }

    @GetMapping("/members/{id}/name/{name}") // 이렇게 하면 안됨
    public Boolean findName(@ModelAttribute Request.FindName find) {
//    public Boolean findName(@PathVariable Integer id, @PathVariable String name, @RequestBody Integer age) {
        return mapper.toFindOne(sampleMemberService.find(mapper.toSampleMember(find))).getName().equals(find.getName());
    }
}
