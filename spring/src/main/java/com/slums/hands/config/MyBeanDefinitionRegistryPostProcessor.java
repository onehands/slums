package com.slums.hands.config;

import com.slums.hands.service.DynamicService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/15 16:26
 * @version: 1.0
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(DynamicService.class).addPropertyValue("name", "onehands");
        BeanDefinition beandefinition = builder.getBeanDefinition();
        registry.registerBeanDefinition("onehands", beandefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory");
    }

    public MyBeanDefinitionRegistryPostProcessor() {
        System.out.println("constructor");
    }
}
