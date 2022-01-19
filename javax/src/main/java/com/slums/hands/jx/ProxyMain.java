package com.slums.hands.jx;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/19 16:09
 * @version: 1.0
 */
public class ProxyMain {
    class Target implements TargetInterface {

        public Target() {
        }

        @Override
        public String method1() {
            return "onehands";
        }
    }

    interface TargetInterface {
        String method1();
    }
    class SayHello{
        public void say(){
            System.out.println("hello everyone");
        }
    }
    public void doSth() {
        TargetInterface newProxyInstance = (TargetInterface) Proxy.newProxyInstance(
                Target.class.getClassLoader(),
                new Class[]{TargetInterface.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // TODO Auto-generated method stub
                        Object invoke = method.invoke(new Target(), args);
                        return invoke;
                    }
                });

        String method1 = newProxyInstance.method1();
        System.out.println(method1);
    }

    public void doSthCGLibInterface() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetInterface.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("entering " + method.getName());
//                Object result = proxy.invokeSuper(o, args);
                System.out.println("leaving " + method.getName());
                return "";
            }
        });
        TargetInterface proxy = (TargetInterface) enhancer.create();
        proxy.method1();
    }
    public void doSthCGLibObject() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Target.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("entering " + method.getName());
                Object result = proxy.invokeSuper(o, args);
                System.out.println("leaving " + method.getName());
                return result;
            }
        });
        Target proxy = (Target) enhancer.create();
        proxy.method1();
    }
    public void doSth2(){
        CglibProxy proxy = new CglibProxy();
        //通过生成子类的方式创建代理类
        SayHello proxyImp = (SayHello)proxy.getProxy(SayHello.class);
        proxyImp.say();
    }

    class CglibProxy implements MethodInterceptor {
        private Enhancer enhancer = new Enhancer();
        public Object getProxy(Class clazz){
            //设置需要创建子类的类
            enhancer.setSuperclass(clazz);
            enhancer.setCallback(this);
            //通过字节码技术动态创建子类实例
            return enhancer.create();
        }

        public CglibProxy() {
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("前置代理");
            //通过代理类调用父类中的方法
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("后置代理");
            return result;
        }
    }

    public static void main(String[] args) {
        ProxyMain proxyMain = new ProxyMain();
        proxyMain.doSth();
        proxyMain.doSthCGLibInterface();
        proxyMain.doSth2();
//        proxyMain.doSthCGLibObject();



    }
}
