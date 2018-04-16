package com.aloe.tasks;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务 Demo
 */
@Component
public class DemoTimedTask {
    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    //  @Scheduled(cron = "5-30 * * * * ?")
    public void reportTask() {
        String format = dateFormat.format(new Date());
        System.out.println("当前时间==>" + format);
    }


}
