package com.slums.hands.jx;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/19 15:48
 * @version: 1.0
 */
public class ProxyTest {
    class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    class ProxyA implements InvocationHandler {
        //要代理的真实对象
        private Object target;

        //构造方法，给要代理的真实对象赋初值
        ProxyA(Object obj) {
            this.target = obj;
        }

        public Object getInstance() {
            return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("introduce yourself...");
            // 执行调用方法（此方法执行前后，可以进行相关业务处理）
            Object result = method.invoke(target, args);
            System.out.println("score...");
            return result;
        }
    }

    @Test
    public void proxyTest() {
        ProxyA proxyA = new ProxyA(new User("onehands"));
        User user = (User) proxyA.getInstance();
        System.out.println(user.getName());
    }
}
