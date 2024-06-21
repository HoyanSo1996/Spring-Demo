package com.omega.demo13.test;

import com.omega.demo13.component.Monster;
import com.omega.demo13.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Spring13Test
 *
 * @author KennySo
 * @date 2024/6/19
 */
public class Spring13Test {

    /**
     * 测试数据源
     */
    @Test
    public void testDataSourceByJdbcTemplate() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("/resource/beans13.xml");
        DataSource dataSource = ioc.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
        connection.close();
    }

    @Test
    public void testAddDataByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("/resource/beans13.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        String sql = "INSERT INTO monster VALUES(?, ?, ?)";
        int affected = jdbcTemplate.update(sql, 400, "红孩儿", "三味真火");
        System.out.println(affected > 0 ? "插入数据成功!" : "插入数据失败!");
    }

    @Test
    public void testUpdateDataByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("/resource/beans13.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        String sql = "UPDATE monster SET skill = ? WHERE id = ?";
        int affected = jdbcTemplate.update(sql, "美人计", 300);
        System.out.println(affected > 0 ? "更新数据成功!" : "更新数据失败!");
    }

    @Test
    public void testAddBatchDataByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("/resource/beans13.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        String sql = "INSERT INTO monster VALUES(?, ?, ?)";
        List<Object[]> paramList = new ArrayList<>();
        paramList.add(new Object[]{500, "金翅大鹏", "飞翔"});
        paramList.add(new Object[]{600, "狮子精", "吃人"});
        jdbcTemplate.batchUpdate(sql, paramList);
        System.out.println("批量添加数据成功!");
    }

    /**
     * 查询单行数据并封装到类里
     */
    @Test
    public void testQueryDataByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("/resource/beans13.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        String sql = "SELECT id, name, skill FROM monster WHERE id = ?";
        RowMapper<Monster> rowMapper = new BeanPropertyRowMapper<>(Monster.class);
        Monster monster = jdbcTemplate.queryForObject(sql, rowMapper, 100);
        System.out.println(monster);
    }

    /**
     * 查询多行数据并封装到类里
     */
    @Test
    public void testQueryMulDataByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("/resource/beans13.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        String sql = "SELECT id, name, skill FROM monster WHERE id > ?";
        RowMapper<Monster> rowMapper = new BeanPropertyRowMapper<>(Monster.class);
        List<Monster> monsterList = jdbcTemplate.query(sql, rowMapper, 100);
        for (Monster monster : monsterList) {
            System.out.println(monster);
        }
    }

    /**
     * 查询一行一列数据
     */
    @Test
    public void testQueryScalarDataByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("/resource/beans13.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        String sql = "SELECT COUNT(*) FROM monster WHERE id > ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, 200);
        System.out.println("count = " + count);
    }

    /**
     * 使用 Map 传入具名参数完成操作
     */
    @Test
    public void testAddDataByNamedParameterJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("/resource/beans13.xml");
        NamedParameterJdbcTemplate jdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);
        String sql = "INSERT INTO monster VALUES(:my_id, :name, :skill)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("my_id", 700);
        paramMap.put("name", "蝎子精");
        paramMap.put("skill", "蜇人");
        int affected = jdbcTemplate.update(sql, paramMap);
        System.out.println(affected > 0 ? "插入数据成功!" : "插入数据失败!");
    }

    /**
     * 使用 sqlParameterSource 来封装具名参数
     */
    @Test
    public void testAddDataByNamedParameterJdbcTemplate2() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("/resource/beans13.xml");
        NamedParameterJdbcTemplate jdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);
        String sql = "INSERT INTO monster VALUES(:id, :name, :skill)";
        Monster monster = new Monster(800, "蜈蚣精", "咬人");
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(monster);
        int affected = jdbcTemplate.update(sql, sqlParameterSource);
        System.out.println(affected > 0 ? "插入数据成功!" : "插入数据失败!");
    }


    /**
     * 使用 注解方式 配置 数据源
     */
    @Test
    public void testSetDataSourceByAnnotation() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        String sql = "SELECT id, name, skill FROM monster WHERE id = ?";
        RowMapper<Monster> rowMapper = new BeanPropertyRowMapper<>(Monster.class);
        Monster monster = jdbcTemplate.queryForObject(sql, rowMapper, 100);
        System.out.println(monster);
    }
}
