import com.slums.hands.service.BaseService;
import com.slums.hands.service.DefaultService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/18 16:17
 * @version: 1.0
 */
public class CGlibTest {
    @Test
    public void test() {
        BaseService enhancer = (BaseService) Enhancer.create(BaseService.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return "onehands_proxy";
            }
        });
        System.out.println(enhancer.doSth("onehands"));
    }

    @Test
    public void test2() {
        BaseService enhancer = (BaseService) Enhancer.create(DefaultService.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("begin proxy");
                return methodProxy.invokeSuper(o, objects);
            }
        });
        System.out.println(enhancer.doSth("onehands"));
    }
}
