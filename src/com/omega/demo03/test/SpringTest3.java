package com.omega.demo03.test;

import com.omega.demo03.entity.Employee;
import com.omega.demo03.service.MemberServiceImpl;
import com.omega.demo03.service.MemberServiceImpl2;
import com.omega.demo03.entity.BookStore;
import com.omega.entity.Master;
import com.omega.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class SpringTest3
 *
 * @author KennySo
 * @date 2024/5/14
 */
public class SpringTest3 {

    private final ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("/beans3.xml");

    /**
     * 通过setter方法来给引用数据类型的属性赋值
     */
    @Test
    public void testSetBeanPropertiesByRef() {
        MemberServiceImpl memberService = ioc.getBean("memberService", MemberServiceImpl.class);
        memberService.add();
    }


    /**
     * 通过有参构造器来给引用数据类型的属性赋值
     */
    @Test
    public void testSetBeanPropertiesByRef2() {
        MemberServiceImpl2 memberService = ioc.getBean("memberService2", MemberServiceImpl2.class);
        memberService.add2();
    }


    /**
     * 通过内部bean对象给引用数据类型的属性赋值
     */
    @Test
    public void testSetBeanPropertiesByInnerBean() {
        MemberServiceImpl memberService = ioc.getBean("memberService3", MemberServiceImpl.class);
        memberService.add();
    }

    /**
     * 通过内部bean对象给引用数据类型的属性赋值
     */
    @Test
    public void testSetBeanPropertiesByInnerBean2() {
        MemberServiceImpl2 memberService = ioc.getBean("memberService4", MemberServiceImpl2.class);
        memberService.add2();
    }


    // ======================================================================================
    /**
     * 为 array 属性赋值
     */
    @Test
    public void testSetArrayProperties() {
        Master master05 = ioc.getBean("master01", Master.class);
        System.out.println(master05);
    }

    /**
     * 为 list 属性赋值
     */
    @Test
    public void testSetListProperties() {
        Master master01 = ioc.getBean("master02", Master.class);
        System.out.println(master01);
    }

    /**
     * 为 set 属性赋值
     */
    @Test
    public void testSetSetProperties() {
        Master master02 = ioc.getBean("master03", Master.class);
        System.out.println(master02);
    }

    /**
     * 为 map 属性赋值
     */
    @Test
    public void testSetMapProperties() {
        Master master03 = ioc.getBean("master04", Master.class);
        System.out.println(master03);
    }

    /**
     * 为 properties 属性赋值
     */
    @Test
    public void testSetPropertiesTypeProperties() {
        Master master04 = ioc.getBean("master05", Master.class);
        System.out.println(master04);
    }


    // ======================================================================================

    /**
     * 使用util名称空间为list属性赋值
     */
    @Test
    public void testSetListPropertiesByUtilSpace() {
        BookStore bookStore = ioc.getBean("bookStore", BookStore.class);
        System.out.println(bookStore);
    }

    /**
     * 使用级联方式赋值
     */
    @Test
    public void testSetPropertiesDirectly() {
        Employee employee = ioc.getBean("employee", Employee.class);
        System.out.println(employee);
    }

    /**
     * 通过 继承方式 设置bean属性
     */
    @Test
    public void testSetBeanPropertiesByExtends() {
        Student student07 = ioc.getBean("student07", Student.class);
        System.out.println(student07);
    }

    /**
     * 将配置bean的 abstract 属性设置为true, 那么这个bean只可以继承, 不能被实例化
     */
    @Test
    public void testSetBeanPropertiesByExtends2() {
        Student student08 = ioc.getBean("student08", Student.class);
        System.out.println(student08);
    }
}
