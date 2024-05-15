package com.omega.demo03.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Class BookStore
 *
 * @author KennySo
 * @date 2024/5/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookStore {
    private List<String> bookList;
}
