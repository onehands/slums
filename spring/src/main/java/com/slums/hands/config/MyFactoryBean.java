package com.slums.hands.config;

import com.slums.hands.api.HellApi;
import lombok.Setter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Method;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/18 17:13
 * @version: 1.0
 */
public class MyFactoryBean implements FactoryBean, BeanFactoryAware {

    private BeanFactory beanFactory;
    @Setter
    private Class<?> classz;

    @Override
    public Object getObject() throws Exception {
        return Enhancer.create(HellApi.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("被代理");
                return 2;
            }

        });
    }

    @Override
    public Class<?> getObjectType() {
        return classz;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
