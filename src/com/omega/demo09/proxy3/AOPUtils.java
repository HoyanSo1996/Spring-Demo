package com.omega.demo09.proxy3;

import java.lang.reflect.Method;

/**
 * Class AOPUtils
 *
 * @author KennySo
 * @date 2024/6/1
 */
public class AOPUtils {

    public static void before(Object proxy, Method method, Object[] args) {
        System.out.println("before-方法执行开始-日志-方法名-" + method.getName() + "-参数 " + args[0] + " " + args[1]);
    }

    public static void after(Object proxy, Method method, Object[] args, double result) {
        System.out.println("after方法执行正常结束-日志-方法名-" + method.getName() + "-结果 result = " + result);
    }

    public static void error(Object proxy, Method method, Object[] args, Exception e) {
        System.out.println("error-方法执行异常-日志-方法名-" + method.getName() + "-异常类型-" + e.getMessage());
    }

    public static void finalize(Object proxy, Method method, Object[] args) {
        System.out.println("finalize-方法最终结束-日志-方法名-" + method.getName());
    }
}
