package com.slums.hands.jx;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.junit.Test;

public class SimpleCGLibDemo {
// java.lang.IllegalArgumentException: Superclass has no null constructors but no arguments were given
//    原因：
//    代理目标对象不能是内部类（因为内部类的创建依赖外部类），如果是内部类，cglib代理内部会获取到一个有参构造函数（参数是外部类对象，如果实在需要代理一个内部类，可以通过传递构造参数实现）
//    Cglib代理默认创建一个缺省构造函数的目标对象，如果目标对象存在有参构造函数，Cglib进行代理时需要指定构造函数的参数，或者在目标对象上必须存在缺省构造函数，否则抛出异常（可以通过传递构造参数创建代理类）
    static class RealService {
        public void sayHello() {
            System.out.println("hello");
        }
    }

    private <T> T getProxy(Class<T> cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("entering " + method.getName());
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("leaving " + method.getName());
            return result;
        });
        enhancer.setSuperclass(cls);
        return (T) enhancer.create();
    }

    @Test
    public void test() {
        SimpleCGLibDemo simpleCGLibDemo = new SimpleCGLibDemo();
        RealService realService = simpleCGLibDemo.getProxy(RealService.class);
        realService.sayHello();
    }

}
