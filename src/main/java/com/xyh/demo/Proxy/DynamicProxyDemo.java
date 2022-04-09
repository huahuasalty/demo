package com.xyh.demo.Proxy;

import com.xyh.demo.handler.CGlibHandler;
import com.xyh.demo.handler.JobHandler;
import com.xyh.demo.serivce.IJobService;
import com.xyh.demo.serivce.impl.JobService;
import org.junit.Test;

public class DynamicProxyDemo {
    public static void main(String[] args) {
        IJobService service = new JobService();
        JobHandler handler = new JobHandler(service);
        IJobService proxy = (IJobService) handler.getProxy();
        proxy.findJob();
    }

    public void testCGlib(){
        System.out.println("test cglib dynamic proxy");
    }

    @Test
    public void test(){
        CGlibHandler handler = new CGlibHandler();
        DynamicProxyDemo proxy = (DynamicProxyDemo) handler.getProxy(DynamicProxyDemo.class);
        proxy.testCGlib();
    }
}
