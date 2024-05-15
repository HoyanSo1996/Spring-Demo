package com.omega.demo04.factory;

import com.omega.entity.Monster;
import org.springframework.beans.factory.FactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Class CustomFactoryBean
 *
 * @author KennySo
 * @date 2024/5/16
 */
public class CustomFactoryBean implements FactoryBean<Monster> {

    private String key;
    private final Map<String, Monster> monsterMap;

    {
        monsterMap = new HashMap<>();
        monsterMap.put("monster04", new Monster(400, "蜈蚣精", "咬人"));
        monsterMap.put("monster05", new Monster(500, "蝎子精", "蜇人"));
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public Monster getObject() throws Exception {
        return monsterMap.get(key);
    }

    @Override
    public Class<?> getObjectType() {
        return Monster.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
