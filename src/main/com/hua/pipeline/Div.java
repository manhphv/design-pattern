package com.hua.pipeline;

/**
 * Created by limenghua on 2016/10/22.
 *
 * @author limenghua
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by ycy on 16/1/16.
 */
public class Div implements Runnable {

    public static BlockingQueue<Msg> bq = new LinkedBlockingDeque<Msg>();

    public void run() {
        while (true) {
            try {
                Msg msg = bq.take();
                msg.i = msg.i / 2;
                // "计算结果" + msg.orgStr + "=" + msg.i
                System.out.println(String.format("计算结果：%s=%s", msg.orgStr, msg.i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

