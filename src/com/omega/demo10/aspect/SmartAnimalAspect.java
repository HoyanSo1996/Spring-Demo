package com.omega.demo10.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Class SmartAnimalAspect
 *
 * @author KennySo
 * @date 2024/6/2
 */
@Component  // 1.通知类配置成IOC容器的bean
@Aspect     // 2.设置当前类为切面类（底层是切面编程的支撑: 动态代理+反射+动态绑定 ）
public class SmartAnimalAspect {  // 替代了原来的代理工厂类

    // 切入表达式的重用
    @Pointcut("execution(public double com.omega.demo10.component.SmartDog.getSum(double, double))")
    public void myPointcut() {

    }

    /**
     * 1. @Before 表示前置通知, 即在目标对象方法的前面执行
     * 2. value = "execution(xxx)" 表示切入到哪个类的哪个方法, 形式是 访问修饰符 返回类型 类全名.方法名.(形参列表)
     * 3. JoinPoint 是由 AspectJ 切面框架提供, 该类可以封装了 动态代理类 InvocationHandler 接口中 invoke 方法形参中的信息
     */
    //@Before(value = "execution(public double com.omega.demo10.component.SmartDog.getSum(double, double))")
    @Before("myPointcut()")
    public void showBeginLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("前置通知-方法执行开始-日志-方法名-" + signature.getName() + "-参数 " + Arrays.toString(joinPoint.getArgs()));
    }

    //@AfterReturning(value = "execution(public double com.omega.demo10.component.SmartDog.getSum(double, double))")
    @AfterReturning("myPointcut()")
    public void showSuccessEndLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("返回通知-方法执行正常结束-日志-方法名-" + signature.getName() + "-结果 result = " );
    }

    //@AfterThrowing(value = "execution(public double com.omega.demo10.component.SmartDog.getSum(double, double))")
    @AfterReturning("myPointcut()")
    public void showExceptionLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("异常通知-方法执行异常-日志-方法名-" + signature.getName() + "-异常类型-");
    }

    //@After(value = "execution(public double com.omega.demo10.component.SmartDog.getSum(double, double))")
    @After("myPointcut()")
    public void showFinalLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("最终通知-方法最终结束-日志-方法名-" + signature.getName());
    }
}
