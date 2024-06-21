package com.omega.demo14.service;

import com.omega.demo14.dao.GoodsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class GoodService
 *
 * @author KennySo
 * @date 2024/6/21
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsDAO goodsDAO;


    @Transactional
    public void buyGoods(int userId, int goodsId, int amount) {
        // 查询商品价格
        Float price = goodsDAO.queryPriceById(goodsId);
        // 更新商品余额
        goodsDAO.updateBalance(userId, price * amount);
        // 模拟异常
        // int i = 1/0;
        // 更新商品库存
        goodsDAO.updateAmount(goodsId, amount);
        System.out.println("购买商品成功...");
    }
}
