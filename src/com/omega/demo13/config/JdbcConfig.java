package com.omega.demo13.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Class JdbcConfig
 *
 * @author KennySo
 * @date 2024/6/21
 */
// @Configuration  // 可以使用 @Component 替代
public class JdbcConfig {

    @Value("${jdbc.driverClass}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 配置好 DataSource, 并放入 IOC 容器中
     * @return dataSource
     */
    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        System.out.println("flag1 = " + dataSource);
        return dataSource;
    }

    /**
     * 配置好 JdbcTemplate, 并放入 IOC 容器中
     * @param dataSource Spring 会自动从 IOC 容器中找到 dataSource 对象赋值给参数 dataSource 变量, 如果找不到就会报错。
     * @return JdbcTemplate
     */
    @Bean
    public JdbcTemplate jdbcTemplated(DataSource dataSource) {
        System.out.println("flag2 = " + dataSource);
        return new JdbcTemplate(dataSource);
    }
}
