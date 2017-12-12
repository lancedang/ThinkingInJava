package com.generic.genericmethod;

import java.lang.reflect.Method;
import java.util.*;

/**
 * 用于比较个容器类所含方法、接口的差异, 各方法通过容器Set来存储, 然后利用MathSetOperation 集合操作比较
 * Created by Dangdang on 2017/12/13.
 */
public class ContainerMethodsDifferences {
    /**
     * 方法级别, 获取某个类的所有方法
     *
     * @param tClass
     * @return
     */
    public static Set<String> containerMethodSet(Class<?> tClass) {
        Set<String> methodSet = new TreeSet<>();
        //方法级别
        for (Method method : tClass.getMethods()) {
            methodSet.add(method.getName());
        }
        return methodSet;
    }

    /**
     * 类和接口级别, 获取某个类的所有接口
     *
     * @param tClass
     * @return
     */
    public static List<String> containerInterfaceList(Class<?> tClass) {
        List<String> interfaceList = new ArrayList<>();
        for (Class<?> c : tClass.getInterfaces()) {
            interfaceList.add(c.getName());
        }
        return interfaceList;
    }

    /**
     * 比较两个容器类的方法区别
     *
     * @param srcContainer 源类
     * @param dstContainer 目的类
     * @return
     */
    public static Set<String> showDiffMethod(Class<?> srcContainer, Class<?> dstContainer) {
        return MathSetOperation.difference(containerMethodSet(srcContainer), containerMethodSet(dstContainer));
    }

    //获取Object类中的方法
    static Set<String> objectMethods = containerMethodSet(Object.class);

    static {
        objectMethods.add("clone"); //与上行有执行顺序的区别, static 变量/静态块 顺序执行
    }

    public static void main(String[] args) {
        Set<String> diffOfMapAndSet = showDiffMethod(HashSet.class, HashMap.class);
        System.out.println(diffOfMapAndSet);
    }

}
