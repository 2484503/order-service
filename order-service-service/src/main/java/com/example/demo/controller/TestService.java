package com.example.demo.controller;

import com.example.demo.entity.OrderParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/12/10 09:23
 */
@Service
@Slf4j
public class TestService {
    @Async
    void test(OrderParam orderParam) {


        log.info("test进入了{}", orderParam);
    }

    void test1(Integer item) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("test进入了{}", item);
    }
}
