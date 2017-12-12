package com.generic.genericmethod;

import com.generic.igeneric.IMyGenerator;
import com.generic.igeneric.coffee.CoffeeGenerator1;
import com.generic.igeneric.coffee.entity.Coffee;
import com.generic.igeneric.fibonacci.FibonacciGenerator1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Dangdang on 2017/12/9.
 */
public class GenerateCollection {
    /**
     * 利用泛型和自定义的生成器, 生成不同元素类型和容量大小的 Collection
     * 或者 用任意类型的容器存放任意类型的数据, 任意类型容器由用户指定(List, set)
     *
     * @param collection  返回的 Collection, 用接口Collection作为参数的意义在于： 可将返回元素保存到
     *                    List, Set, Map 等任意 Collection 中
     * @param myGenerator 生成器, 可扩展, 用于生成任意类型对象
     * @param count       容量大小
     * @param <T>         容器元素类型
     * @return
     */
    public static <T> Collection<T> createCollection(Collection<T> collection, IMyGenerator<T> myGenerator, int count) {
        for (int i = 0; i < count; i++) {
            //生成器创建元素
            T item = myGenerator.next();
            collection.add(item);
        }
        return collection;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffees = GenerateCollection.createCollection(new ArrayList<Coffee>(), new CoffeeGenerator1(), 5);
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }

        Collection<Integer> numbers = GenerateCollection.createCollection(new HashSet<>(), new FibonacciGenerator1(), 18);
        for (Integer item : numbers) {
            System.out.println(item);
        }

    }


}
