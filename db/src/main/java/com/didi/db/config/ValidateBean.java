package com.didi.db.config;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @ClassName ValidateBean
 * @Author zhangxinkun
 * @Date 2020/1/19  4:52 PM
 * @Version 1.0
 */
@Slf4j
public class ValidateBean {

    public static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static   <T> void validateParam(T param) {
        if (param != null) {
            try {
                Set<ConstraintViolation<T>> violations = validator.validate(param);
                if (violations == null || violations.isEmpty()) {
                    return;
                }
                log.warn("validate violation. param:{}, violations:{}", param, violations.toString());
            } catch (Exception e) {
                log.warn("validate exception.param={}", param, e);
            }
        }
        throw new RuntimeException("参数异常");
    }
}
