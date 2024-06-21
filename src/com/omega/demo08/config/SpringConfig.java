package com.omega.demo08.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Class SpringConfig
 *
 * @author KennySo
 * @date 2024/6/1
 */
@ComponentScan("com.omega.demo08")
@PropertySource("classpath:resource/beans8.properties")
public class SpringConfig {
}
