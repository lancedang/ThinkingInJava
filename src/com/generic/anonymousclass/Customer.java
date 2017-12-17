package com.generic.anonymousclass;

import com.generic.igeneric.IMyGenerator;

/**
 * Created by Dangdang on 2017/12/16.
 */
public class Customer {
    private static int count = 0;
    private final int index = count++;


    //因为已经有Generator生成器, 故不需外部用 new 来生成
    private Customer() {

    }

    //利用匿名类生成 Customer 的生成器, 取代构造函数
    public static IMyGenerator<Customer> getCustomer() {
        return new IMyGenerator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }

    @Override
    public String toString() {
        return "customer: " + index;
    }
}
