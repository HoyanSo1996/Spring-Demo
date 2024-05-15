package com.omega.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Class Master
 *
 * @author KennySo
 * @date 2024/5/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Master {

    private String name;
    private String[] monsterNames;
    private List<Monster> monsterList;
    private Set<Monster> monsterSet;
    private Map<String, Monster> monsterMap;
    private Properties pros;
}
