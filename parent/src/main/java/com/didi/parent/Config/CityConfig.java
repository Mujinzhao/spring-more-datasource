package com.didi.parent.Config;

import com.didi.parent.Entity.CityInfo;
import com.didi.parent.Entity.UserInfo;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName CityConfig
 * @Author zhangxinkun
 * @Date 2019/12/11  5:05 PM
 * @Version 1.0
 */
@Configuration
@ConditionalOnClass({UserInfo.class})
public class CityConfig {

    @Bean
    CityInfo cityInfo() {
        CityInfo cityInfo = CityInfo.builder().cityName("allCitys").lnt(123L).pnt(321L).build();
        return cityInfo;
    }
}
