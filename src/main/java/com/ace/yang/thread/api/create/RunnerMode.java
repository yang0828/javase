package com.ace.yang.thread.api.create;

/**
 * @author yang
 * @date 2019/8/7 11:33
 *
 *   推荐  Runnable 创建线程
 *  1)、避免单继承的局限性
 *  2)、便于共享资源
 *
 *    使用 Runnable 创建线程
 *   1、类 实现 Runnable接口 +重写 run()   -->真实角色类
 *   2、启动多线程  使用静态代理
 *     1)、创建真实角色
 *     2)、创建代理角色 +真实角色引用
 *     3)、调用 .start() 启动线程
 */
public class RunnerMode implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("...............一遍听歌");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i <500; i++) {
                System.out.println("...............一遍敲代码");
            }
        });


        System.out.println(Thread.currentThread().getName() + "静静的看着。。。");
        // 真实角色，任务本身
        RunnerMode runnerMode = new RunnerMode();
        // 代理角色，执行器
        new Thread(runnerMode, "攻城狮").start();
        // 任务本身 + 执行器
        thread.start();
    }
}
