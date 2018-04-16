package com.aloe.tasks;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * 异步任务 Demo
 */
@Component
public class AsyncDemoTask {
    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    @Async
    public Future<Boolean> async1() throws Exception {
        System.out.println("任务1开始==>" + dateFormat.format(new Date()));
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long l = (System.currentTimeMillis() - start) / 1000;
        System.out.println("任务1结束==>" + dateFormat.format(new Date()));
        System.out.println("任务1耗时：" + l);
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> async2() throws Exception {
        System.out.println("任务2开始==>" + dateFormat.format(new Date()));
        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long l = (System.currentTimeMillis() - start) / 1000;
        System.out.println("任务2结束==>" + dateFormat.format(new Date()));
        System.out.println("任务2耗时：" + l);
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> async3() throws Exception {
        System.out.println("任务3开始==>" + dateFormat.format(new Date()));
        long start = System.currentTimeMillis();
        Thread.sleep(5000);
        long l = (System.currentTimeMillis() - start) / 1000;
        System.out.println("任务3结束==>" + dateFormat.format(new Date()));
        System.out.println("任务3耗时：" + l);
        return new AsyncResult<>(true);
    }

}
