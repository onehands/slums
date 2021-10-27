package com.slums.hands.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/11 22:22
 * @version: 1.0
 */
@Data
@ToString
public class Company {
    private List<User> users;

    public Company(List<User> users) {
        this.users = users;
    }
}
