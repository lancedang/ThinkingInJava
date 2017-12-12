package com.generic.genericmethod;

import com.generic.igeneric.IMyGenerator;

/**
 * 该BasicGenerator能生成任意类的对象, 任意类通过泛型-类型参数（Type parameter）确定
 * 要求：
 * 1. 任意类 modifier 问题, 若与该工具类在不同包下, 则需 public 权限
 * 2. 需要提供默认构造函数（供.newInstance()使用）
 * <p>
 * Created by Dangdang on 2017/12/9.
 */
public class BasicGenerator<T> implements IMyGenerator<T> {

    private Class<T> tClass;

    public BasicGenerator(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public T next() {
        try {
            return tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    //创建生成器, 也就是该类的一个实例, 只需要提供生成器所需的Class参数
    public static <T> IMyGenerator<T> create(Class<T> tClass) {
        return new BasicGenerator<>(tClass);
    }

    static class CountedObject {
        //此种写法,能够记录当下创建了多少个该类的实例
        private static int index = 0;
        //加上 final 的作用是防止通过反射来修改count值, 尽管是private变量,
        //但反射的 setAccessible() 方法能够将其可见性置为True
        private final int count = index++;

        @Override
        public String toString() {
            //通过toString能将当前实例的编号打印出来
            return this.getClass().getName() + " " + count;
        }
    }

    public static void main(String[] args) {
        //BasicGenerator<CountedObject> generator3 = new BasicGenerator<>(CountedObject.class);
        IMyGenerator<CountedObject> generator3 = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 4; i++) {
            System.out.println(generator3.next());
        }
        //创建这种普通的String和integer体现不出意义来
        BasicGenerator<String> generator = new BasicGenerator<>(String.class);
        System.out.println(generator.next().getClass().getName());
        //BasicGenerator<Integer> generator2 = new BasicGenerator<>(Integer.class);
        //System.out.println(generator2.next().getClass().getName());
    }
}
