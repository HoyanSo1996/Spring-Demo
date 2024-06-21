package com.omega.demo08.test;

import com.omega.demo08.component.UserController;
import com.omega.demo08.component.UserService;
import com.omega.demo08.component2.MemberController;
import com.omega.demo08.component2.MemberService;
import com.omega.demo08.component3.AdminController;
import com.omega.demo08.component3.AdminService;
import com.omega.demo08.component4.service.BookService;
import com.omega.demo08.component4.service.PhoneService;
import com.omega.demo08.component5.CarService;
import com.omega.demo08.component5.CarService2;
import com.omega.demo08.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Class Spring8Test
 *
 * @author KennySo
 * @date 2024/5/29
 */
public class Spring8Test {

    // private final ApplicationContext ioc = new ClassPathXmlApplicationContext("/beans8.xml");

    // 测试使用 @ComponentScan 注解替代 xml 中的 context:component-scan 扫描
    private final ApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);

    /**
     * 测试 @Autowired 注解装配
     */
    @Test
    public void setPropertiesByAnnotation() {
        UserController userController = ioc.getBean("userController", UserController.class);
        userController.say();

        UserService userService01 = ioc.getBean("userService01", UserService.class);
        // UserService userService02 = ioc.getBean("userService02", UserService.class);
        // UserService userService03 = ioc.getBean("userService03", UserService.class);
        System.out.println("userService01 = " + userService01);
        // System.out.println("userService02 = " + userService02);
        // System.out.println("userService03 = " + userService03);
    }


    /**
     * 测试 @Resource 注解装配 （这个注解由 java8 提供）
     */
    @Test
    public void setPropertiesByAnnotation2() {
        MemberController memberController = ioc.getBean("memberController", MemberController.class);
        memberController.say();

        MemberService memberService01 = ioc.getBean("memberService01", MemberService.class);
        System.out.println("memberService01 = " + memberService01);
        // MemberService memberService02 = ioc.getBean("memberService02", MemberService.class);
        // System.out.println("memberService02 = " + memberService02);
        // MemberService memberService03 = ioc.getBean("memberService03", MemberService.class);
        // System.out.println("memberService03 = " + memberService03);
    }


    /**
     *  自动装配的注解，可以识别接口属性，并为其装配它的实现类.
     *  如果该接口的实现类有多个，那么就要 在 注解上 指定装配类型 或者 指定装配 id。
     */
    @Test
    public void setPropertiesByAnnotation3() {
        AdminController adminController = ioc.getBean("adminController", AdminController.class);
        adminController.say();

        AdminService adminServiceImpl = ioc.getBean("adminServiceImpl", AdminService.class);
        System.out.println(adminServiceImpl);

        AdminService adminServiceImpl2 = ioc.getBean("adminServiceImpl2", AdminService.class);
        System.out.println(adminServiceImpl2);
    }


    /**
     * 测试 spring 自动装配 包含泛型依赖的bean
     */
    @Test
    public void setGenericPropertiesByAnnotation() {
        BookService bookService = ioc.getBean(BookService.class);
        bookService.save();
        PhoneService phoneService = ioc.getBean(PhoneService.class);
        phoneService.save();
    }

    /**
     * 测试 @Value 注解装配
     */
    @Test
    public void setPropertiesByAnnotation4() {
        CarService carService = ioc.getBean(CarService.class);
        carService.print();

        CarService2 carService2 = ioc.getBean(CarService2.class);
        carService2.print();
    }
}
