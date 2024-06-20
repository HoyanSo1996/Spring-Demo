package com.omega.demo02.test;

import com.omega.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class SpringTest2
 *
 * @author KennySo
 * @date 2024/5/14
 */
public class SpringTest2 {

    private final ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("/resource/beans2.xml");

    /**
     * 使用setter方法为bean的属性赋值
     * （注释了setter方法后会报错）
     */
    @Test
    public void testSetBeanPropertiesBySetterMethod() {
        Student student01 = ioc.getBean("student01", Student.class);
        System.out.println(student01);
    }


    /**
     * 使用构造器为bean属性赋值 (name)
     */
    @Test
    public void testSetBeanPropertiesByConstructor1() {
        Student student02 = ioc.getBean("student02", Student.class);
        System.out.println(student02);
    }

    /**
     * 使用构造器为bean属性赋值 (index, 从0开始)
     */
    @Test
    public void testSetBeanPropertiesByConstructor2() {
        Student student03 = ioc.getBean("student03", Student.class);
        System.out.println(student03);
    }

    /**
     * 使用构造器为bean属性赋值 (type)
     */
    @Test
    public void testSetBeanPropertiesByConstructor3() {
        Student student04 = ioc.getBean("student04", Student.class);
        System.out.println(student04);
    }

    /**
     * 使用构造器为bean属性赋值 (type)
     */
    @Test
    public void testSetBeanPropertiesByPSpace() {
        Student student05 = ioc.getBean("student05", Student.class);
        System.out.println(student05);
    }
}
