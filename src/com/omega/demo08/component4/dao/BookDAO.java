package com.omega.demo08.component4.dao;

import com.omega.demo08.component4.entity.Book;
import org.springframework.stereotype.Repository;

/**
 * Class BookDAO
 *
 * @author KennySo
 * @date 2024/5/30
 */
@Repository
public class BookDAO extends BaseDAO<Book> {

    @Override
    public void save() {
        System.out.println("BookDAO save()...");
    }
}
