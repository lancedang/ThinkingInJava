package com.generic.igeneric.coffee;

import com.generic.igeneric.IMyGenerator;
import com.generic.igeneric.coffee.entity.*;

import java.util.Iterator;
import java.util.Random;

/**
 * 目的：随机生成具体 coffee对象
 * Created by Dangdang on 2017/12/7.
 */
public class CoffeeGenerator1 implements IMyGenerator<Coffee>, Iterable<Coffee> { //泛型-类型参数告诉编译器 生成器中将使用Coffee类型

    private Class[] classes = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
    private Random random = new Random(47);
    private int size;

    public CoffeeGenerator1() {
    }

    //初始化容器大小
    public CoffeeGenerator1(int size) {
        this.size = size;
    }

    //生成具体coffee的方法
    public Coffee next() {
        try {
            Coffee coffee = (Coffee) classes[random.nextInt(classes.length)].newInstance();
            return coffee;
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);  ////throw 后，catch中就无需 return语句了（或者catch外围也无需return了）
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        //return null;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }
    //创建自定义迭代器类，用于在自定义容器中遍历其中元素
    class CoffeeIterator implements Iterator<Coffee> {
        int counter = size;
        @Override
        public boolean hasNext() {
            //判断当前游标索引是否小于total
            return counter > 0;
        }
        //获取下一个元素，此处没有顺序遍历，只是随机生成size个元素
        @Override
        public Coffee next() {
            counter--;
            return CoffeeGenerator1.this.next();
        }
    }
    public static void main(String[] args) {
        CoffeeGenerator1 coffeeGenerator2 = new CoffeeGenerator1(5);
        for (Coffee coffee : coffeeGenerator2) {
            System.out.println(coffee);
        }

        CoffeeGenerator1 coffeeGenerator = new CoffeeGenerator1();
        for (int i = 0; i < 5; i++) {
            System.out.println(coffeeGenerator.next());
        }

    }
}
