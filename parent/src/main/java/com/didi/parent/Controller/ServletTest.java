package com.didi.parent.Controller;

import com.didi.parent.Service.LongProcessor;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ServletTest
 * @Author zhangxinkun
 * @Date 2020/1/18  9:12 AM
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/test/servlet",asyncSupported = true)
public class ServletTest extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        req.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
        AsyncContext context = req.startAsync();
        System.out.println("进入业务代码之前");
        LongProcessor longProcessor = new LongProcessor(context);

        Thread thread = new Thread(longProcessor);
        thread.start();

        System.out.println("主线程直接结束");
    }
}
