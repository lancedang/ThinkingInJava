package com.generic.simplegene;

/**
 * 使用容器存放 特定 但类型未知 的某一类对象
 * 取出 不用转型，编译器保证来检测要存储的类型是否符合要求
 * Created by Dangdang on 2017/12/6.
 */
public class Holder3<T> {
    //容器所持有的 T 类型的对象
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {

        //告诉编译器你想要存储什么类型
        Holder3<String> h1 = new Holder3<>("test");
        String str = h1.getA(); //无需转型
        //必须存取 相应类型，否则编译器报错
        //h1.setA(2L);
    }
}
