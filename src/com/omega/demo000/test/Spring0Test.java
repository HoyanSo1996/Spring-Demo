package com.omega.demo000.test;

import com.omega.demo000.config.SpringConfig;
import com.omega.demo000.ioc.CustomApplicationContext;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Class Spring0Test
 *
 * @author KennySo
 * @date 2024/5/27
 */
public class Spring0Test {

    public static void main(String[] args) {
        CustomApplicationContext ioc = new CustomApplicationContext(SpringConfig.class);
        ConcurrentHashMap<String, Object> singletonObjects = ioc.getSingletonObjects();
        ConcurrentHashMap.KeySetView<String, Object> keySet = singletonObjects.keySet();
        for (String key : keySet) {
            System.out.println("key = " + key + ", value = " + singletonObjects.get(key));
        }
    }
}
