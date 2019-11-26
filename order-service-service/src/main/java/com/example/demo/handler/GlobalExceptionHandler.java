package com.example.demo.handler;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/11/26 10:07
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String, Object> argumentValidException(Exception e) {
        System.out.println("进入了异常处理器");
        Map<String, Object> map = new HashMap<>();
        map.put("STATUS", "2");
        map.put("MESSAGE", "参数验证失败");
        return map;
    }

}
