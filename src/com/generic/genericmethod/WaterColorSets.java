package com.generic.genericmethod;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by Dangdang on 2017/12/12.
 */
public class WaterColorSets {

    //通过限定 color 起始范围创建 EnumSet
    public static EnumSet<WaterColorEnum> createColorSet(WaterColorEnum colorBegin, WaterColorEnum colorEnd) {
        //记住这个EnumSet和 enum 之间的转换方法即可
        return EnumSet.range(colorBegin, colorEnd);
    }

    public static void main(String[] args) {
        EnumSet<WaterColorEnum> set1 = createColorSet(WaterColorEnum.YELLOW, WaterColorEnum.BLACK);
        EnumSet<WaterColorEnum> set2 = createColorSet(WaterColorEnum.GREEN, WaterColorEnum.GRAY);
        Set<WaterColorEnum> difference = MathSetOperation.difference(set1, set2);
        Set<WaterColorEnum> union = MathSetOperation.union(set1, set2);
        System.out.println(difference);
        System.out.println(union);
    }

}
