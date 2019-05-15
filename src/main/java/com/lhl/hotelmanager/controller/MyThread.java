package com.lhl.hotelmanager.controller;

/**
 * @author: lbc
 * @date: 2019年5月13日 下午 4:22
 * @Description: 添加描述
 * @updateUser: lbc
 * @updateDate: 2019年5月13日 下午 4:22
 * @updateDescription: 修改描述
 * @version: V1.0
 */
public class MyThread extends Thread {

    private static int i = 20;
    static Object obj = new Object();

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        int i = 0;
        for(Boolean bool = true ;bool;){
            i++;
            if(i==10){
                bool = false;
            }
        }
        System.out.println(i);

        /*new MyThread("窗口-01").start();
        new MyThread("窗口-02").start();
        new MyThread("窗口-03").start();*/

    }

}
