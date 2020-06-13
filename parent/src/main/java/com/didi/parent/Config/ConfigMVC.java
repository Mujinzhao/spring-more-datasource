package com.didi.parent.Config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.didi.parent.Util.NullAwareBeanUtils;
import com.didi.parent.Util.ServletUtils;
import com.didi.parent.interceptor.AuthInterceptor;
import com.google.common.collect.Maps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ConfigMVC
 * @Author zhangxinkun
 * @Date 2020/1/19  5:50 PM
 * @Version 1.0
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com"})
public class ConfigMVC extends WebMvcConfigurerAdapter {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(fastjsonConverter());
    }

    /**
     * 用于替换mapping2jackson
     */
    @Bean
    FastJsonHttpMessageConverter4 fastjsonConverter() {
        FastJsonHttpMessageConverter5 converter = new FastJsonHttpMessageConverter5();
        converter.getFastJsonConfig().setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        return converter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
    }

//    static {
//        HystrixPlugins.getInstance().registerConcurrencyStrategy(HystrixTraceableConcurrencyStrategy.getInstance());
//        ResultOpt.registerExecutor(1000, 1500);
//    }
//
//
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new CustomerDateConverter());
//        registry.addConverter(new CustomerIntConverter());
//        registry.addConverter(new CustomerLongConverter());
//        registry.addConverter(new CustomerStringTrimConverter());
//    }
//
//    @Bean
//    public GeneralAspect generalAspect() {
//        return new GeneralAspect();
//    }
//
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(0, new HeaderBindModelResolver(true));
//        argumentResolvers.add(0, new HeaderBindRequestParamResolver(true));
//    }





























    public class FastJsonHttpMessageConverter5 extends FastJsonHttpMessageConverter4 {

        public final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

        public FastJsonHttpMessageConverter5() {
            setDefaultCharset(DEFAULT_CHARSET);
            setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, new MediaType("application", "*+json")));
        }

        @Override
        public Object read(Type type, //
                           Class<?> contextClass, //
                           HttpInputMessage inputMessage //
        ) throws IOException, HttpMessageNotReadableException {
            InputStream in = inputMessage.getBody();
            Object target = JSON.parseObject(in, getFastJsonConfig().getCharset(), type, getFastJsonConfig().getFeatures());
            Map<String, String> dataMap = getSimpleParameterMap();
            Map<String, String> headerKV = ServletUtils.getHeaderKV(inputMessage.getHeaders());
            dataMap.putAll(headerKV);
            NullAwareBeanUtils.copyPropertiesIgnoreNull(target, dataMap);
            return target;
        }


        public Map<String, String> getSimpleParameterMap() {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Map<String, String[]> map = request.getParameterMap();
            Map<String, String> newMap = Maps.newHashMap();
            map.entrySet().stream()
                    .filter(stringEntry -> stringEntry.getValue() != null && stringEntry.getValue().length > 0)
                    .forEach(item -> {
                        newMap.put(item.getKey(), item.getValue()[0]);
                    });
            return newMap;
        }
    }
}
