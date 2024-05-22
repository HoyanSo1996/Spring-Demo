package com.omega.demo06.processor;

import com.omega.demo06.entity.House;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Class CustomBeanPostProcessor
 *
 * @author KennySo
 * @date 2024/5/22
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在 bean 初始化之前完成某些任务
     *
     * @param bean : 传入 ioc 容器中配置的 bean, 如果 bean 在这里被修改，则返回的 bean 对象也会被修改
     * @param beanName: 传入 ioc 容器配置的 bean 的名称
     * @return Object: 返回处理后的 bean 对象
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization 被调用: beanName = " + beanName + ", bean = " + bean);
        if (bean instanceof House) {
            House house = (House) bean;
            house.setName(house.getName() + 1);
        }
        return bean;
    }

    /**
     * 在 bean 初始化之后进行调用
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization 被调用: beanName = " + beanName + ", bean = " + bean);
        return bean;
    }
}
