package com.generic.anonymousclass;

import com.generic.igeneric.IMyGenerator;

/**
 * Created by Dangdang on 2017/12/16.
 */
public class Teller {
    private static int count = 0;
    private final int index = count++;

    private Teller() {
    }

    //获取创建Teller的生成器
    public static IMyGenerator<Teller> getTeller() {
        return new IMyGenerator<Teller>() {
            @Override
            public Teller next() {
                return new Teller();
            }
        };
    }

    @Override
    public String toString() {
        return "teller: " + index;
    }
}
