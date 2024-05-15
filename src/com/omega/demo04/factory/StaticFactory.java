package com.omega.demo04.factory;

import com.omega.entity.Monster;

import java.util.HashMap;
import java.util.Map;

/**
 * Class StaticFactory
 *
 * @author KennySo
 * @date 2024/5/15
 */
public class StaticFactory {

    private static final Map<String, Monster> monsterMap;

    static {
        monsterMap = new HashMap<>();
        monsterMap.put("monster01", new Monster(100, "蜘蛛精", "吐丝"));
        monsterMap.put("monster02", new Monster(200, "白骨精", "蛊惑人心"));
    }

    public static Monster getMonster(String key) {
        return monsterMap.get(key);
    }
}
