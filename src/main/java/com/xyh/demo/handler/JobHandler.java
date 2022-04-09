package com.xyh.demo.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JobHandler implements InvocationHandler {

    private Object target;

    public JobHandler(Object target){
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        printLog();
        Object result = method.invoke(target, args);
        printResult(result);
        return result;
    }

    public void printLog(){
        System.out.println("方法启动钱打印日志");
    }

    public void printResult(Object result){
        System.out.println("打印方法返回值" );
    }
}
