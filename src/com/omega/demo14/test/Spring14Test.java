package com.omega.demo14.test;

import com.omega.demo14.config.SpringConfig;
import com.omega.demo14.service.GoodsService;
import com.omega.demo14.service.MultiplyGoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Spring14Test
 *
 * @author KennySo
 * @date 2024/6/21
 */
public class Spring14Test {


    @Test
    public void testJdbcTemplateWithTx() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("resource/beans14.xml");
        GoodsService goodsService = ioc.getBean(GoodsService.class);
        goodsService.buyGoods(1, 1, 1);
    }

    @Test
    public void testJdbcTemplateWithTxPropagation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("resource/beans14.xml");
        MultiplyGoodsService multiplyGoodsService = ioc.getBean(MultiplyGoodsService.class);
        multiplyGoodsService.buyGoodsTwins();
    }

    @Test
    public void testJdbcTemplateWithTxIsolation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("resource/beans14.xml");
        GoodsService goodsService = ioc.getBean(GoodsService.class);
        goodsService.queryGoodsByTxISOLATION(1);
    }

    @Test
    public void testJdbcTemplateWithTxTimeout() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("resource/beans14.xml");
        GoodsService goodsService = ioc.getBean(GoodsService.class);
        goodsService.buyGoods3(1, 1, 1);
        System.out.println("购买商品成功...");
    }


    @Test
    public void testJdbcTemplateWithTxByAnnotation() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
        GoodsService goodsService = ioc.getBean(GoodsService.class);
        goodsService.buyGoods(1, 1, 1);
    }
}
