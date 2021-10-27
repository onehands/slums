package com.slums.hands.config;

import com.slums.hands.annotation.MyApi;
import com.slums.hands.util.ReflectionUtil;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/18 17:29
 * @version: 1.0
 */
public class MyFactoryBeanImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Set<Class<Object>> apiInterfaceList
                = ReflectionUtil.scanAnnotatedWith("com.slums.*", MyApi.class);

        for (Class<Object> objectClass : apiInterfaceList) {
            BeanDefinitionBuilder definition = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
            definition.addPropertyValue("classz", objectClass);
            AbstractBeanDefinition beanDefinition = definition.getBeanDefinition();
            BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition, objectClass.getCanonicalName(),
                    new String[]{objectClass.getSimpleName()});
            BeanDefinitionReaderUtils.registerBeanDefinition(holder, registry);
        }
    }
}
