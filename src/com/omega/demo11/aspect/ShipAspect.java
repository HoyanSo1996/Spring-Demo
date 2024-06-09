package com.omega.demo11.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Class ShipAspect
 *
 * @author KennySo
 * @date 2024/6/9
 */
@Component
@Aspect
public class ShipAspect {

    @Before("execution(public void com.omega.demo11.component.Ship.run())")
    public void enhance(JoinPoint joinPoint) {
        // 获取 目标方法 的名字
        String methodName = joinPoint.getSignature().getName();
        System.out.println("methodName = " + methodName);

        // 获取 目标方法 的声明类型(public、private、protected), 返回的数数字
        int modifier = joinPoint.getSignature().getModifiers();
        System.out.println("modifier = " + modifier);

        // 获取 目标方法 所属类的全类名
        String fullClassName = joinPoint.getSignature().getDeclaringTypeName();
        System.out.println("fullClassName = " + fullClassName);

        // 获取 目标方法 所属类简单类名
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        System.out.println("className = " + className);

        // 获取 目标方法 的传入参数(一个数组)
        Object[] args = joinPoint.getArgs();
        System.out.println("args = " + Arrays.toString(args));

        // 获取 被代理的对象
        Object target = joinPoint.getTarget();
        Class<?> targetClass = target.getClass();
        System.out.println("targetClass = " + targetClass);

        // 获取 代理对象本身(需要debug才能看出来)
        Object proxy = joinPoint.getThis();
        Class<?> proxyClass = proxy.getClass();
        System.out.println("proxyClass = " + proxyClass);
    }


    // 后置通知。方法的参数名 要和 returning="res" 的属性值一致。
    @AfterReturning(value = "execution(public String com.omega.demo11.component.Ship.run(double))", returning = "res")
    public void showSuccessEndLog(JoinPoint joinPoint, Object res) {
        System.out.println("正常信息 = " + res);
    }


    @AfterThrowing(value = "execution(public String com.omega.demo11.component.Ship.run(double))", throwing = "e")
    public void showFailEndLog(JoinPoint joinPoint, Throwable e) {
        System.out.println("异常信息 = " + e);
    }

    /**
     * 环绕通知 的结构要写成 try-catch-finally
     */
    @Around(value = "execution(public String com.omega.demo11.component.Ship.run(double, int))")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Object result = null;
        String methodName = joinPoint.getSignature().getName();
        try {
            // 1.相当于前置通知
            System.out.println("AOP 环绕通知[前置通知]--" + methodName + "方法开始--参数--" + Arrays.toString(joinPoint.getArgs()));
            // 在环绕通知中要调用joinPoint.proceed()来执行目标方法
            result = joinPoint.proceed();
            // 2.相当于返回通知
            System.out.println("AOP 环绕通知[返回通知]--" + methodName + "方法结束--结果--" + result);

        } catch (Throwable throwable) {
            // 3.相当于异常通知
            System.out.println("AOP 环绕通知[异常通知]--" + methodName + "方法抛出异常--异常对象--" + throwable);
        } finally {
            // 4.相当于后置通知
            System.out.println("AOP 环绕通知[后置通知]--" + methodName + "方法最终结束...");
        }
        return result;
    }
}
