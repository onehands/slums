package com.slums.hands.entity;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/11 22:05
 * @version: 1.0
 */
@Data
@ToString
public class User {
    private String name;
    private String cellphone;
    private Position position;
    private LocalDateTime createTime = LocalDateTime.now();

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

}
