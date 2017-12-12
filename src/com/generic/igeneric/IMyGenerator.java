package com.generic.igeneric;

/**
 * 定义一个生成器，专门负责创建对象的类，一般一个生成器 只定义一个方法
 * Created by Dangdang on 2017/12/6.
 */
public interface IMyGenerator<T> {
    //定义创建对象方法，区别于工厂模式（一般需要参数），该方法无参数
    T next();
}