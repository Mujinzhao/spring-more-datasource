package com.didi.db.XinkunServiceImpl;/*
 * @Author zhangxinkun
 */

import com.didi.db.Service.ServiceTest;
import com.didi.db.config.ValidateBean;
import com.didi.db.pojo.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/6/20  4:05 PM
 * @Version 1.0
 */
@Service
@Slf4j
@Validated
public class UserService{

//    @Override
    public void test(){
        System.out.println("oNe");
        Request request = new Request();
        this.createRequest(request);
    }

    public void createRequest(Request name){
//        ValidateBean.validateParam(name);
        log.info("sdgdasfdasfdsaaaddddddddddddddd");
        return;
    }
}
