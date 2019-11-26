package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/11/26 09:51
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderParam implements Serializable {

    private static final long serialVersionUID = -5779095056025243780L;

    @NotNull(message = "id不能为空")
    private String id;
}
