package com.didi.db.pojo;


import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @ClassName Request
 * @Author zhangxinkun
 * @Date 2020/1/19  3:24 PM
 * @Version 1.0
 */
public class Request {
    private Long cityId;

    @NotNull(message = "城市不能为空222")
    private String cityName;
}
