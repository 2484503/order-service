package com.example.demo.constants;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/9/17 11:26
 */
@Component
public class ControllerIgnoredRegistrationAdapter implements WebMvcRegistrations {
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping() {
            protected boolean isHandler(Class<?> beanType) {
                return super.isHandler(beanType) && !beanType.isAnnotationPresent(ControllerIgnored.class);
            }
        };
    }
}
