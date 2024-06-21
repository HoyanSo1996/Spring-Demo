package com.omega.demo13.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Class SpringConfig
 *
 * @author KennySo
 * @date 2024/6/21
 */
@ComponentScan("com.omega.demo13")
@PropertySource("classpath:resource/beans13.properties")
@Import(JdbcConfig.class)  // 也可以不用这个注解, 而是在 JdbcConfig 类上加上 @Configuration 注解. （推荐这种, 方便观察）
public class SpringConfig {
}
