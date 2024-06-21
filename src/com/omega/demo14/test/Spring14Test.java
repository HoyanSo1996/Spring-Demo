package com.omega.demo14.test;

import com.omega.demo14.service.GoodsService;
import com.omega.demo14.service.MultiplyGoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Spring14Test
 *
 * @author KennySo
 * @date 2024/6/21
 */
public class Spring14Test {

    private final ApplicationContext ioc = new ClassPathXmlApplicationContext("resource/beans14.xml");

    @Test
    public void testJdbcTemplateWithTx() {
        GoodsService goodsService = ioc.getBean(GoodsService.class);
        goodsService.buyGoods(1, 1, 1);
    }

    @Test
    public void testJdbcTemplateWithTxPropagation() {
        MultiplyGoodsService multiplyGoodsService = ioc.getBean(MultiplyGoodsService.class);
        multiplyGoodsService.buyGoodsTwins();
    }

    @Test
    public void testJdbcTemplateWithTxIsolation() {
        GoodsService goodsService = ioc.getBean(GoodsService.class);
        goodsService.queryGoodsByTxISOLATION(1);
    }

    @Test
    public void testJdbcTemplateWithTxTimeout() {
        GoodsService goodsService = ioc.getBean(GoodsService.class);
        goodsService.buyGoods3(1, 1, 1);
        System.out.println("购买商品成功...");
    }
}
