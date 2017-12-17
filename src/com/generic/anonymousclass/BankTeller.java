package com.generic.anonymousclass;

import com.generic.genericmethod.GenerateCollection;

import java.util.*;

/**
 * Created by Dangdang on 2017/12/16.
 */
public class BankTeller {
    //银行柜员服务顾客
    public static void serve(Teller teller, Customer customer) {
        System.out.println(teller + " serve " + customer);
    }

    public static void main(String[] args) {

        //用队列queue模拟 customer, LinkedList 增删优势
        Queue<Customer> customerQueue = new LinkedList<>();
        //用集合list模拟柜员 teller, ArrayList 随机查找优势
        List<Teller> tellerList = new ArrayList<>();

        //创建若干customer 和 teller
        //customerQueue 经过填充
        GenerateCollection.createCollection(customerQueue, Customer.getCustomer(), 20);
        //tellerList 经过填充
        GenerateCollection.createCollection(tellerList, Teller.getTeller(), 4);

        Random random = new Random(47);

        //为每个teller随机分配customer
        //for (Teller teller : tellers) {
        //serve(teller, customers.);
        //}

        //为每个customer随机提供teller
        for (Customer c : customerQueue) {
            serve(tellerList.get(random.nextInt(tellerList.size())), c);
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);

        System.out.println(list.get(0).getClass());
        System.out.println(list.get(1).getClass());

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);

    }
}
