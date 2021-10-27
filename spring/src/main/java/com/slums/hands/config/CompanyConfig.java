package com.slums.hands.config;

import com.slums.hands.entity.Company;
import com.slums.hands.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/18 15:12
 * @version: 1.0
 */
@Configuration
//@Component
public class CompanyConfig {
    @Bean
    public User user() {
        System.out.println("user 初始化");
        return new User("onehands");
    }

    @Bean
    public Company company(User user) {
        return new Company(Arrays.asList(user, user()));
    }
}
