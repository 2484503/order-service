package com.example.demo;

import com.example.demo.constants.ControllerIgnored;
import com.example.demo.entity.OrderParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/11/26 09:17
 */
@RequestMapping("/order")
@FeignClient("order-service")
@ControllerIgnored
public interface OrderClient {

    @PostMapping("/getOrderPort")
    String getOrderPort(@RequestParam("id") String id);

    @PostMapping("/testNotNull")
    String testNotNull(@RequestBody OrderParam orderParam);
}
