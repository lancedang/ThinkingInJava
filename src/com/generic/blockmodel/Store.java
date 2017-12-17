package com.generic.blockmodel;

import com.generic.genericmethod.GenerateCollection;
import com.generic.igeneric.IMyGenerator;

import java.util.ArrayList;
import java.util.Random;

/**
 * 理念就是以一个个小积木 组装成一个大整体, 每个小组件用泛型封装的干净整齐
 * Created by Dangdang on 2017/12/16.
 */
public class Store extends ArrayList<Aisle> {

    //存放若干收银台
    private ArrayList<CheckoutStand> checkoutStands = new ArrayList<>();

    //定义一个办公室
    private Office office = new Office();

    //定义仓库, 且设定规格：走廊个数、一个走廊放置货架个数、一个货架储存产品个数
    public Store(int aisleCount, int shelfCount, int proCount) {
        for (int i = 0; i < aisleCount; i++) {
            //this的运用太溜了, 初始化已经填充了若干Aisle
            this.add(new Aisle(shelfCount, proCount));
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Aisle aisle : this) {
            for (Shelf shelf : aisle) {
                for (Product product : shelf) {
                    builder.append(product);
                    builder.append("\n");
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(10, 10, 10));
    }
}

//创建产品
class Product {
    //private static int count = 1;
    private final int index;
    private String desc;
    private double price;

    static Random random = new Random(47);

    public Product(int index, String desc, double price) {
        //this.index = index;
        this.index = index;
        this.desc = desc;
        this.price = price;
    }

    @Override
    public String toString() {
        return "id " + index + ", " + desc + ", " + price;
    }

    //构造 product 生成器
    public static IMyGenerator<Product> getProducts() {
        return new IMyGenerator<Product>() {
            @Override
            public Product next() {
                return new Product(random.nextInt(1000), "test", Math.round(random.nextDouble() * 1000 + 0.99));
            }
        };
    }

}

//构造货架, 货架本身是一种容器, 能存放若干product
class Shelf extends ArrayList<Product> {

    //构造Shelf, 其本身即是一个Container, 参数表示每个货架存放的书的个数
    public Shelf(int proCounts) {
        GenerateCollection.createCollection(this, Product.getProducts(), proCounts);
    }
}

//构造长廊, 长廊可以放置若干货架
class Aisle extends ArrayList<Shelf> {

    //添加若干个货架, 每个货架放置若干书籍, 参数表示一个走廊 放置货架的个数, 和每个货架放置产品的个数
    public Aisle(int shelfCount, int proCount) {
        for (int i = 0; i < shelfCount; i++) {
            //创建若干货架
            this.add(new Shelf(proCount));
        }
    }
}

//创建收银台
class CheckoutStand {

}

//创建办公室
class Office {

}


