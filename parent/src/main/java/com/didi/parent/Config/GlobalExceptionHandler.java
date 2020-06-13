package com.didi.parent.Config;

import com.didi.parent.ApiResponse.ApiResponse;
import com.didi.parent.ApiResponse.MoreExceprionCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Author zhangxinkun
 * @Date 2020/1/19  3:28 PM
 * @Version 1.0
 */
@RestControllerAdvice(value = {"com.didi.parent.Controller"})
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleException(Exception e) {
        log.error("Default Exception xinkun: ", e);
        return ApiResponse.error(MoreExceprionCode.PARAMS_ERROR);
    }

}
