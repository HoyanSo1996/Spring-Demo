package com.omega.demo000.ioc;

import com.omega.demo000.annotation.CustomComponentScan;
import com.omega.demo000.config.SpringConfig;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class CustomApplicationContext
 *
 * @author KennySo
 * @date 2024/5/27
 */
public class CustomApplicationContext {

    private Class<SpringConfig> springConfigClass;

    private final ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();


    public CustomApplicationContext(Class<SpringConfig> springConfigClass) {
        this.springConfigClass = springConfigClass;

        // 解析配置类, 获取自动扫描的包的路径
        CustomComponentScan customComponentScan = springConfigClass.getDeclaredAnnotation(CustomComponentScan.class);
        String scanPath = customComponentScan.value();
        String scanPath2 = scanPath.replace(".", "/");
        // 获取包的全路径
        ClassLoader classLoader = springConfigClass.getClassLoader();
        URL url = classLoader.getResource(scanPath2);
        // System.out.println("url = " + url);

        // 扫描包下的所有文件
        File file = new File(url.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                String absolutePath = f.getAbsolutePath();
                // 判断是否class文件
                if (absolutePath.endsWith(".class")) {
                    // 截取类名
                    String fileName = absolutePath.substring(absolutePath.lastIndexOf("\\") + 1, absolutePath.indexOf(".class"));
                    String classFullPath = scanPath + "." + fileName;
                    try {
                        // 判断类上是否存在指定注解
                        Class<?> clazz = classLoader.loadClass(classFullPath);
                        if (clazz.isAnnotationPresent(Component.class) ||
                                clazz.isAnnotationPresent(Controller.class) ||
                                clazz.isAnnotationPresent(Service.class) ||
                                clazz.isAnnotationPresent(Repository.class)) {
                            Object instance = clazz.newInstance();

                            // 将实例放入ioc容器
                            // uncapitalize()作用: 让首字母变成小写
                            singletonObjects.put(StringUtils.uncapitalize(fileName), instance);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    // Todo: 循环打开
    public void scanFileFromDirectory(File file) {

    }


    /**
     * 获取singletonObjects方法
     */
    public ConcurrentHashMap<String, Object> getSingletonObjects() {
        return singletonObjects;
    }

    /**
     * 获取bean方法
     */
    public <T> T getBean(String name, Class<T> clazz) {
        Object bean = singletonObjects.get(name);
        if (clazz.isInstance(bean)) {
            return (T) bean;
        } else {
            throw new RuntimeException("Cannot cast bean to " + clazz.getName());
        }
    }
}
