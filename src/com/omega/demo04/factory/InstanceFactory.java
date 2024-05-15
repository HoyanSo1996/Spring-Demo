package com.omega.demo04.factory;

import com.omega.entity.Monster;

import java.util.HashMap;
import java.util.Map;

/**
 * Class InstanceFactory
 *
 * @author KennySo
 * @date 2024/5/16
 */
public class InstanceFactory {

    private final Map<String, Monster> monsterMap;

    {
        monsterMap = new HashMap<>();
        monsterMap.put("monster01", new Monster(100, "蜘蛛精~", "吐丝~"));
        monsterMap.put("monster02", new Monster(200, "白骨精~", "蛊惑人心~"));
    }

    public Monster getMonster(String key) {
        return monsterMap.get(key);
    }
}
