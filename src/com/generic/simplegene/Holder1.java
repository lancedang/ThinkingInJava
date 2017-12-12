package com.generic.simplegene;

/**
 * 容器一，只能持有 特定类型 对象
 * Created by Dangdang on 2017/12/6.
 */
public class Holder1 {
    //持有特定类型的对象，无法重用，无法持有其他类型的对象
    private Automobile a;

    //初始化所持有的对象
    public Holder1(Automobile a) {
        this.a = a;
    }

    //从容器中取出对象
    public Automobile get() {
        return a;
    }
}

class Automobile {

}
