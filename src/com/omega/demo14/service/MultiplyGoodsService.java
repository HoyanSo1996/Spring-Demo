package com.omega.demo14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class MultiplyGoodsService
 *
 * @author KennySo
 * @date 2024/6/21
 */
@Service
public class MultiplyGoodsService {

    @Autowired
    private GoodsService goodsService;

    @Transactional
    public void buyGoodsTwins() {
        // 1号用户 购买 1号商品.
        goodsService.buyGoods(1, 1, 1);
        // 2号用户 购买 2号商品.
        goodsService.buyGoods2(2, 2, 1);
    }
}
