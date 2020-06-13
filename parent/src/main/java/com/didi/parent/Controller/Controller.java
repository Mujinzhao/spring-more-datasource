package com.didi.parent.Controller;

import com.didi.db.Service.ServiceTest;
import com.didi.db.XinkunServiceImpl.UserService;
import com.didi.parent.ApiResponse.ApiResponse;
import com.didi.parent.Entity.CityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * @ClassName Controller
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/6/18  2:54 PM
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/controlloer")
public class Controller {

    @Autowired
    UserService serviceTest;
//
    @RequestMapping(value = "/test/accpect/params",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object test(@Validated @RequestBody CityInfo cityInfo) throws Exception{
        serviceTest.test();
        return null;
    }
}
