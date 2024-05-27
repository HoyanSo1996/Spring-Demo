package com.omega.demo000.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation CustomComponentScan
 *
 * @author KennySo
 * @date 2024/5/27
 */
@Target(ElementType.TYPE)  // 设置该注解只能放到类, 接口, 枚举上
@Retention(RetentionPolicy.RUNTIME)  // 设置该注解能用到程序运行时
public @interface CustomComponentScan {

    String value() default "";
}
