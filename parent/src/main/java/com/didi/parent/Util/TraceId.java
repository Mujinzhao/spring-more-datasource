package com.didi.parent.Util;/*
 * @Author zhangxinkun
 */

import java.util.Date;
import java.util.Random;

/**
 * @ClassName TraceId
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/6/21  10:51 AM
 * @Version 1.0
 */
public class TraceId {

    public static String generateTraceId(){
        String time = String.valueOf(System.currentTimeMillis());
        Random random  = new Random();
        Long RandID = random.nextLong();
        return time + String.valueOf(RandID);
    }
}
