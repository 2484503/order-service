package com.example.demo.controller;

import com.example.demo.OrderClient;
import com.example.demo.entity.OrderParam;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class OrderController implements OrderClient {

    @Value("${server.port}")
    private String port;

    private TestService testService;

    public OrderController(TestService testService) {
        this.testService = testService;
    }

    /**
     * 获取服务端口号
     *
     * @return
     */
    public String getOrderPort(@RequestParam("id") String id) {
        return "order-service port：" + port + id;
    }

    @Override
    public String testNotNull(@Valid @RequestBody OrderParam orderParam) {
        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9);

        list.parallelStream().forEach(item ->{
            testService.test1(item);
        });
        log.info("进入了{}", orderParam);

        return orderParam.getId();
    }

}
