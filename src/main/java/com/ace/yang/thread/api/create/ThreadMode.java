package com.ace.yang.thread.api.create;

/**
 * @author yang
 * @date 2019/8/7 11:47
 */
public class ThreadMode {

    public static void main(String[] args) {
        //创建子类对象
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();

        //调用start方法
        rabbit.start();
        tortoise.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main-->" + i);
        }
    }
}


class Rabbit extends Thread {

    @Override
    public void run() {
        //线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("兔子跑了" + i + "步");
        }
    }
}


class Tortoise extends Thread {

    @Override
    public void run() {
        //线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("乌龟跑了" + i + "步");
        }
    }
}