package com.omega.demo13.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Monster
 *
 * @author KennySo
 * @date 2024/6/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monster {

    private Integer id;
    private String name;
    private String skill;
}
