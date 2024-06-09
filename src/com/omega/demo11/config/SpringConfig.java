package com.omega.demo11.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Class SpringConfig
 *
 * @author KennySo
 * @date 2024/6/9
 */
@Configuration
@ComponentScan("com.omega.demo11")
@EnableAspectJAutoProxy
public class SpringConfig {
}
