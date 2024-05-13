package com.omega.demo00.ioc;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class CustomApplicationContext
 *
 * @author KennySo
 * @date 2024/5/14
 */
public class CustomApplicationContext {

    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();

    /**
     * 构造器初始化时, 会接收一个容器的配置文件
     */
    public CustomApplicationContext(String configFile) throws Exception {
        // 1.使用Dom4j解析xml文件
        String filePath = this.getClass().getResource("/" + configFile).getPath();
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(filePath));
        Element rootElement = document.getRootElement();

        // 2.获取子元素
        List<Element> elementList = rootElement.elements();
        for (Element beanElement : elementList) {
            // 获取 bean 对象
            String id = beanElement.attributeValue("id");
            String classFullPath = beanElement.attributeValue("class");
            Class<?> beanClass = Class.forName(classFullPath);
            Object bean = beanClass.newInstance();

            // 获取bean元素的属性值
            List<Element> propetyElementList= beanElement.elements();
            for (Element propetyElement : propetyElementList) {
                String fieldName = propetyElement.attributeValue("name");
                String fieldValue = propetyElement.attributeValue("value");

                // 为bean属性赋值
                // 获取字段类型
                Field declaredField = beanClass.getDeclaredField(fieldName);
                Class<?> fieldType = declaredField.getType();
                // 使用set方法赋值
                String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Method declaredMethod = beanClass.getDeclaredMethod(methodName, fieldType);
                declaredMethod.invoke(bean, transferData(fieldValue, fieldType));
            }

            // 将bean放入map中
            singletonObjects.put(id, bean);
        }
    }

    /**
     * 根据字段类型将传入的数据转换成对应类型
     * @param value 需要转换的值(String类型)
     * @param dataType 需要的数据类型
     * @return 对应数据类型的值
     */
    public <T> Object transferData(String value, T dataType) {
        if (String.class.equals(dataType)) {
            return value;
        } else if (Integer.class.equals(dataType)) {
            return Integer.valueOf(value);
        }
        // Todo..
        return null;
    }

    /**
     * 提供方法获取容器中的bean
     */
    public Object getBean(String name) {
        return singletonObjects.get(name);
    }
}
