package com.generic.igeneric.fibonacci;

import com.generic.igeneric.IMyGenerator;

import java.util.Iterator;

/**
 * 通过实现Iterable迭代遍历，完全重写 Fibonacci
 * Created by Dangdang on 2017/12/8.
 */
public class FibonacciGenerator2 implements Iterable<Integer> {

    private int size;

    public FibonacciGenerator2() {
    }

    public FibonacciGenerator2(int size) {
        this.size = size;
    }

    //首先记住 Fibonacci的递归写法, 内部工具方法，供 next调用
    public Integer fibonacci(int i) {
        if (i < 2) {
            return 1;
        } else {
            return fibonacci(i - 1) + fibonacci(i - 2);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }

    class FibonacciIterator implements Iterator<Integer> {
        int count = -1; //需从-1开始，-1表明有下一个

        @Override
        public boolean hasNext() {
            return count < size - 1;
        }

        @Override
        public Integer next() {
            count++;
            return FibonacciGenerator2.this.fibonacci(count);
        }

    }

    public static void main(String[] args) {
        FibonacciGenerator2 fibonacciGenerator2 = new FibonacciGenerator2(18);
        for (Integer item : fibonacciGenerator2) {
            System.out.println(item);
        }

    }


}
