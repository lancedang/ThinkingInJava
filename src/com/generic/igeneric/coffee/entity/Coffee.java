package com.generic.igeneric.coffee.entity;

/**
 * Created by Dangdang on 2017/12/6.
 */
public class Coffee {
    //注意父类 static 类变量，所有子类均共享
    private static long counter = 0;
    //final 变量，每个子类都不同
    private final long id = counter++;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + id;
    }
}
