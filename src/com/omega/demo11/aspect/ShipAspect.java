package com.omega.demo11.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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


    @AfterReturning(value = "execution(public String com.omega.demo11.component.Ship.run(double))", returning = "res")
    public void showSuccessEndLog(JoinPoint joinPoint, Object res) {
        System.out.println("正常信息 = " + res);
    }


    @AfterThrowing(value = "execution(public String com.omega.demo11.component.Ship.run(double))", throwing = "e")
    public void showFailEndLog(JoinPoint joinPoint, Throwable e) {
        System.out.println("异常信息 = " + e);
    }
}
