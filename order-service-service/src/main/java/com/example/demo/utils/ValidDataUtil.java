package com.example.demo.utils;

import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 校验参数
 *
 * @author lijn
 * @version 1.0
 * @date 2019/11/26 16:29
 */
public class ValidDataUtil {

    public static boolean validData(@Valid Object param) {
        Set<ConstraintViolation<Object>> validateSet = Validation.buildDefaultValidatorFactory().getValidator().validate(param, new Class[0]);

        if (!CollectionUtils.isEmpty(validateSet)) {
            Map<String, String> map = validateSet.stream().collect(Collectors.toMap(c -> c.getPropertyPath().toString(), ConstraintViolation::getMessage));
            return false;
        }

        return true;
    }

}
