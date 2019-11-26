package com.example.demo.controller;

import com.example.demo.OrderClient;
import com.example.demo.entity.OrderParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OrderController implements OrderClient {

    @Value("${server.port}")
    private String port;

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
        System.out.println("进入了");
        return orderParam.getId();
    }
}
