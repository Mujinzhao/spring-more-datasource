package com.didi.parent.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * @ClassName CityInfo
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/23  4:22 PM
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityInfo {

    @Max(value = 100)
    @Min(value = 1)
    private Long lnt;

    private Long pnt;

    @NotNull(message = "城市不能为空")
    private String cityName;
}
