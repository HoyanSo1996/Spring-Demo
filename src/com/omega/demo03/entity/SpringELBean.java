package com.omega.demo03.entity;

import com.omega.entity.Monster;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class SpringELBean
 *
 * @author KennySo
 * @date 2024/5/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpringELBean {

    private String name;
    private Monster monster;
    private String monsterName;
    private String crySound;
    private String bookName;
    private Double result;

    public String cry(String sound) {
        return "发出 " + sound + " 叫声...";
    }
    public static String read(String bookName) {
        return "正在看 " + bookName;
    }
}
