package com.generic.igeneric.fibonacci;

import java.util.Iterator;

/**
 * 通过继承 FibonacciGenerator1 创建适配器（调用父类next接口）
 * Created by Dangdang on 2017/12/8.
 */
public class FibonacciGenerator3 extends FibonacciGenerator1 implements Iterable<Integer> {

    private int size; //容量（边界值）用于结束 迭代的判断

    public FibonacciGenerator3() {
    }

    public FibonacciGenerator3(int size) {
        this.size = size;
    }


    @Override
    public Iterator<Integer> iterator() {
        //通过匿名类来返回 Iterator
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public Integer next() {
                size--;
                //继承父类，借用其接口
                return FibonacciGenerator3.this.next();
            }
        };
    }


    public static void main(String[] args) {
        for (int item : new FibonacciGenerator3(18)) {
            System.out.println(item);
        }
    }
}
