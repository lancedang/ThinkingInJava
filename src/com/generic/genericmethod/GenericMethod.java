package com.generic.genericmethod;

import java.util.*;

/**
 * 对于static 方法而言，是无法访问泛型类的类型参数的，所以如果static方法 需要使用泛型能力，就
 * 必须使该static 方法成为泛型方法。
 * Created by Dangdang on 2017/12/9.
 */
public class GenericMethod {

    /**
     * 泛型方法中 类型参数 T 的目的是在该方法中 运用 各种类型进行操作
     * 一种运用情况是需要通过 方法参数传递一个 类型参数的引用
     *
     * @param t
     * @param <T>
     */
    public static <T, S, W> void showClassInfo(T t, S s, W w, String str) {
        Map<T, S> map = new HashMap<>();

        System.out.println("class: " + t.getClass().getName()); //包含包路径
        System.out.println("class: " + t.getClass().getSimpleName()); //不包含包路径，只有类名
        System.out.println("class: " + t.getClass().getCanonicalName()); //包含包路径
    }

    public static void main(String[] args) {
        GenericMethod.showClassInfo("test", 1, true, "test1");
        GenericMethod.showClassInfo(1, "test", 'o', "test2");
        GenericMethod.showClassInfo(new Random(34), new TreeSet<>(), new ArrayList<>(), "test3");
        Map<String, String> map = new HashMap<>();
    }

}
