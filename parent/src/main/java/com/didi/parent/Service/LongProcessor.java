package com.didi.parent.Service;

import javax.servlet.AsyncContext;
import java.io.PrintWriter;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName LongProcessor
 * @Author zhangxinkun
 * @Date 2020/1/18  9:34 AM
 * @Version 1.0
 */
public class LongProcessor implements Runnable {

    private AsyncContext context;

    public LongProcessor(AsyncContext context) {
        this.context = context;
    }

    @Override
    public void run(){

        System.out.println("into service processor");
        try {
            Thread.sleep(2000);

        }catch (InterruptedException inex){

        }
        try {
            PrintWriter out = context.getResponse().getWriter();
            out.write("Processing done for " + 10 + " milliseconds!!");
        }catch (Exception ex){

        }
        context.complete();
        System.out.println("service processor is over");
    }
}
