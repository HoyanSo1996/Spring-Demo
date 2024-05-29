package com.omega.demo08.component4.service;

import com.omega.demo08.component4.dao.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Class BaseService
 *
 * @author KennySo
 * @date 2024/5/30
 */
public class BaseService<T> {

    @Autowired
    // @Resource    // 不能使用这个, 会抛异常
    private BaseDAO<T> baseDAO;

    public void save() {
        baseDAO.save();
    }
}
