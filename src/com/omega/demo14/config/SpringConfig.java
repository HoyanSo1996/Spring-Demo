package com.omega.demo14.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Class SpringConfig
 *
 * @author KennySo
 * @date 2024/6/21
 */
@ComponentScan("com.omega.demo14")
@PropertySource("classpath:resource/beans14.properties")
@Import(JdbcConfig.class)
@EnableTransactionManagement   // 开启事务管理
public class SpringConfig {
}
