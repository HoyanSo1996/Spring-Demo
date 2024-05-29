package com.omega.demo08.component4.dao;

import com.omega.demo08.component4.entity.Phone;
import org.springframework.stereotype.Repository;

/**
 * Class PhoneDAO
 *
 * @author KennySo
 * @date 2024/5/30
 */
@Repository
public class PhoneDAO extends BaseDAO<Phone> {

    @Override
    public void save() {
        System.out.println("PhoneDAO save()...");
    }
}
