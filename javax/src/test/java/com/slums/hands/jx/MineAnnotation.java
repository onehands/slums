package com.slums.hands.jx;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/6 11:03
 * @version: 1.0
 */
@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MineAnnotation {
}
