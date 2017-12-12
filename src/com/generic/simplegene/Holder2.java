package com.generic.simplegene;

/**
 * 容器二，用 Object 持有任意类型对象，但取出时 需要强制转换
 * Created by Dangdang on 2017/12/6.
 */
public class Holder2 {
    //持有 任意 类型对象
    private Object o;

    public Holder2(Object o) {
        this.o = o;
    }

    //存储对象
    public void set(Object o) {
        this.o = o;
    }

    //从容器中取出对象
    public Object get() {
        return o;
    }

    public static void main(String[] args) {
        //存储 Automobile 对象
        Holder2 holder2 = new Holder2(new Automobile());
        //取出
        Automobile automobile = (Automobile) holder2.get();

        //存 String 对象
        holder2.set("test");
        //取
        String str = (String) holder2.get();
    }

}
