package com.example.demo;

/**
 * Created by Edwin Xu on 7/31/2020 11:43 AM
 *
 *
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AccessLimit {
    int maxCount();
}