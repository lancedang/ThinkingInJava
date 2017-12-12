package com.generic.genericmethod;

import com.generic.igeneric.coffee.CoffeeGenerator1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dangdang on 2017/12/9.
 */
public class VariableParam {

    public static void makeList2(String... ts) { //String...表示 String 类型的参数若干个，可变指数量可变
        System.out.println(ts[2]);
        Arrays.asList(ts);
        for (String item : ts) {
            System.out.println(item);
        }
    }

    public static <T> List<T> makeList(T... ts) { //T...表示 可变参数列表，可变指数量可变
        List<T> list = new ArrayList<>();
        for (T item : ts) { //for-each 用法，实现了 Iterable 接口的类 可用for-each 来遍历
            list.add(item);
        }
        return list;
    }

    //演示可变参数列表 T... 能接收的参数类型和形式
    public static void main(String[] args) {
        //1. 形式：罗列若干参数；类型：并且参数类型不同
        System.out.println(makeList(1, "str", true));
        //2. 形式：用数组作为参数；类型：参数类型相同
        String[] strs = "how are you".split(" ");
        System.out.println(makeList(strs));
        //3. 形式：list作为参数；类型：参数类型相同
        List<String> strs2 = Arrays.asList(strs);
        System.out.println(strs2);
        //自定义CoffeeGenerator1，其实现了 Iterable 接口
        System.out.println(new CoffeeGenerator1(5));
    }
}
