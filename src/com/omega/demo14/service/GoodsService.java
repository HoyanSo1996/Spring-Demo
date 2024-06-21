package com.omega.demo14.service;

import com.omega.demo14.dao.GoodsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
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
        //int i = 1/0;
        // 更新商品库存
        goodsDAO.updateAmount(goodsId, amount);
        System.out.println("购买商品成功...");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void buyGoods2(int userId, int goodsId, int amount) {
        // 查询商品价格
        Float price = goodsDAO.queryPriceById(goodsId);
        // 更新商品余额
        goodsDAO.updateBalance(userId, price * amount);
        // 模拟异常
        int i = 1/0;
        // 更新商品库存
        goodsDAO.updateAmount(goodsId, amount);
        System.out.println("购买商品成功...");
    }


    /**
     * 查看数据库默认的隔离级别 SELECT @@global.tx_isolation
     */
    // @Transactional(isolation = Isolation.READ_COMMITTED)
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void queryGoodsByTxISOLATION(int goodsId) {
        Float goodsPrice = goodsDAO.queryPriceById(goodsId);
        System.out.println("第一次读取的价格 = " + goodsPrice);

        // 打个断点, 然后使用数据库进行操作, 再放开断点
        goodsPrice = goodsDAO.queryPriceById(goodsId);
        System.out.println("第二次读取的价格 = " + goodsPrice);
    }
}
