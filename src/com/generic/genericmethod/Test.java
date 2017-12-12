package com.generic.genericmethod;

/**
 * 对于static 方法而言，是无法访问泛型类的类型参数的，所以如果static方法 需要使用泛型能力，就
 * 必须使该static 方法成为泛型方法。
 * Created by Dangdang on 2017/12/9.
 */
public class Test<T> {

    public void test1(T t) {

    }
    //static 方法不能使用 T 泛型参数
    /*
    public static void test2(T t) {

    }
    */

}
