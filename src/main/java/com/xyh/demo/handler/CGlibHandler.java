package com.xyh.demo.handler;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibHandler implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        // 设置需要创建的子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码 来动态创建子类实例
        return enhancer.create();
    }

    //实现MethodInterceptor接口方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用cglib代理：开始");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("调用cglib代理：结束");
        return result;
    }
}
