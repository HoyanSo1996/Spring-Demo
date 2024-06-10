package com.omega.demo12.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import java.util.Arrays;

/**
 * Class SmartAnimalAspect
 *
 * @author KennySo
 * @date 2024/6/10
 */
public class SmartAnimalAspect {

    public void showBeginLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("前置通知-方法执行开始-日志-方法名-" + signature.getName() + "-参数 " + Arrays.toString(joinPoint.getArgs()));
    }

    public void showSuccessEndLog(JoinPoint joinPoint, Object res) {
        Signature signature = joinPoint.getSignature();
        System.out.println("返回通知-方法执行正常结束-日志-方法名-" + signature.getName() + "-结果 result = " + res);
    }

    public void showExceptionLog(JoinPoint joinPoint, Throwable e) {
        Signature signature = joinPoint.getSignature();
        System.out.println("异常通知-方法执行异常-日志-方法名-" + signature.getName() + "-异常类型 = " + e);
    }

    public void showFinalLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("最终通知-方法最终结束-日志-方法名-" + signature.getName());
    }
}
