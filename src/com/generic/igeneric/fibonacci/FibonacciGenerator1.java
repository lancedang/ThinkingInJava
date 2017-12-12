package com.generic.igeneric.fibonacci;

import com.generic.igeneric.IMyGenerator;

/**
 * Created by Dangdang on 2017/12/8.
 */
public class FibonacciGenerator1 implements IMyGenerator<Integer> {
    private int index = 0;
    @Override
    public Integer next() {
        return fibonacci(index++);
    }
    //首先记住 Fibonacci的递归写法, 内部工具方法，供 next调用
    public Integer fibonacci(int i) {
        if (i < 2) {
            return 1;
        }else {
            return fibonacci(i - 1) + fibonacci(i - 2);
        }
    }

    public static void main(String[] args) {
        FibonacciGenerator1 fibonacci = new FibonacciGenerator1();
        for (int i = 1; i< 10; i++) {
            System.out.println(fibonacci.next());
        }
    }

}
