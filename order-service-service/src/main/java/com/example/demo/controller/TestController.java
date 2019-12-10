package com.example.demo.controller;

import com.example.demo.entity.OrderParam;
import com.example.demo.utils.ValidDataUtil;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/validData")
    public String validData(@RequestBody @Validated OrderParam orderParam, BindingResult erros) {
        if (erros.hasErrors()) {
            for (ObjectError objectError : erros.getAllErrors())
                System.out.println(objectError.getDefaultMessage());
        }
        return orderParam.getId();
    }

    @PostMapping("/test")
    public String test(@RequestBody OrderParam orderParam) {
        ValidDataUtil.validData(orderParam);
        return orderParam.getId();
    }
}
