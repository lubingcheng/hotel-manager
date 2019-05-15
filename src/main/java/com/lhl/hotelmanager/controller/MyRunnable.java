package com.lhl.hotelmanager.controller;

/**
 * @author: lbc
 * @date: 2019年5月14日 下午 3:56
 * @Description: 添加描述
 * @updateUser: lbc
 * @updateDate: 2019年5月14日 下午 3:56
 * @updateDescription: 修改描述
 * @version: V1.0
 */
public class MyRunnable implements Runnable {

    private  int i = 20;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName()+"我要抢"+i);
            synchronized (obj) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i>0) {
                    System.out.println(Thread.currentThread().getName() + "抢到了-" + i);
                    i--;
                }else {
                    break;
                }
            }
        }



    }
}
