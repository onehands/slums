package com.slums.hands;

import com.slums.hands.api.HellApi;
import com.slums.hands.config.MyFactoryBeanImportBeanDefinitionRegistrar;
import com.slums.hands.config.MyImportBeanDefinitionRegistrar;
import com.slums.hands.entity.Company;
import com.slums.hands.service.DynamicService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Map;

@Import({MyImportBeanDefinitionRegistrar.class, MyFactoryBeanImportBeanDefinitionRegistrar.class})
@SpringBootApplication(scanBasePackages = "com.slums.*")
public class SlumsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SlumsApplication.class, args);
        Map<String, DynamicService> data = ctx.getBeansOfType(DynamicService.class);
        System.out.println(data);
        System.out.println(ctx.getBeansOfType(Company.class));
        HellApi hellApi = ctx.getBean(HellApi.class);
        System.out.println(hellApi.add(1, 2));;
        System.out.println(hellApi.add(1, 2));;
        System.out.println(hellApi.add(1, 2));;
    }

}
