package com.slums.hands;

import com.slums.hands.service.IService;
import com.slums.hands.service.impl.MyService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/20 10:36
 * @version: 1.0
 */
public class ProxyTest {
    @Test
    public void test1() {
        MyService myService = new MyService();
        IService service = (IService) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{IService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始代理");
                return method.invoke(myService, args);
            }
        });
        System.out.println(service.add(2, 3));
    }

    @Test
    public void test2() {
        MyService myService = new MyService();
        IService service = (IService) Enhancer.create(myService.getClass(), myService.getClass().getInterfaces(), (MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("cglib开始代理");
            return method.invoke(myService, objects);
        });
        System.out.println(service.add(3, 4));
    }

    @Test
    public void test3() {
        IService service = (IService) Enhancer.create(IService.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib代理接口：" + method.getName());
                if (method.getName().equals("add")) {
                    return (int) objects[0] + (int) objects[1];
                }
//                return method.invoke(o, objects);
                return null;
            }
        });
        System.out.println(service.add(1, 2));
    }
}
