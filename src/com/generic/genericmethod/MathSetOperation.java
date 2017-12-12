package com.generic.genericmethod;

import java.util.HashSet;
import java.util.Set;

/**
 * 此类是一种工具类, 用来模拟集合的数学操作, 合集、并集、交集等
 * 思考：用 Set 的地方是不是都可以用 List
 * Created by Dangdang on 2017/12/10.
 */
public class MathSetOperation {
    //并集, 两者合到一起
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> unionSet = new HashSet<>(a);
        unionSet.addAll(b);//添加 b
        return unionSet;
    }

    //交集, 两者共有的
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> intersectionSet = new HashSet<>(a);
        intersectionSet.retainAll(b);
        return intersectionSet;
    }

    //差集
    public static <T> Set<T> difference(Set<T> a, Set<T> b) {
        Set<T> differenceSet = new HashSet<>(a);
        differenceSet.removeAll(b);
        return differenceSet;
    }

    //补集
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

}
