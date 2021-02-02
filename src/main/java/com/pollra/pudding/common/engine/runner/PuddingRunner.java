package com.pollra.pudding.common.engine.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author pollra
 * @description ApplicationRunner
 * @since 2021.01.31
 **********************************************************************************************************************/
@Component
@RequiredArgsConstructor
public class PuddingRunner implements ApplicationRunner {

    private final DefaultListableBeanFactory defaultListableBeanFactory;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        for (String name : defaultListableBeanFactory.getBeanDefinitionNames()) {
//            System.out.println(name + "\t"+defaultListableBeanFactory.getBean(name).getClass().getName());
//        }
    }
}
