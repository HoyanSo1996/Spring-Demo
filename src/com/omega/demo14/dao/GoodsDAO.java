package com.omega.demo14.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Class GoodsDAO
 *
 * @author KennySo
 * @date 2024/6/21
 */
@Repository
public class GoodsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Float queryPriceById(Integer id) {
        String sql = "SELECT price From goods Where goods_id = ?";
        return jdbcTemplate.queryForObject(sql, Float.class, id);
    }
    public void updateBalance(Integer user_id, Float money) {
        String sql = "UPDATE user_account SET money = money - ? Where user_id = ?";
        jdbcTemplate.update(sql, money, user_id);
    }

    public void updateAmount(Integer goods_id, int amount){
        String sql = "UPDATE goods_amount SET goods_num = goods_num - ? Where goods_id = ?";
        jdbcTemplate.update(sql, amount , goods_id);
    }
}
