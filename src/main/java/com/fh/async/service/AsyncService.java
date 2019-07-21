package com.fh.async.service;

import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:config/system.properties")
public class AsyncService {

    @Async
    public void async(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("aaaaaaaaa");
    }

    /**
     * cron默认有六个值 每个值用空格隔开 也可以有第7位表示年
     * second(秒) minute(分) hour(时) day of month(日) month(月) day of week(周) year(年)
     * 着六个值都可以使用 , - *  / 其中","表示枚举 "-"表示区间，实际效果个枚举一样
     * "*"表示任意 "/"表示步长，如果0/5 表示从0开始每隔5执行一次
     * "?"是解决日和周之间冲突的，哪一个冲突就用？表示，如我日指定为*即任意，而周指定为周一
     * 这样日和周就冲突了，因为不是每一天都是周一，所以就在冲突的地方替换为?
     * 除此之外 日还可以加 L W C  L表示最后 W表示工作日 C表示和calender联系后计算过的值
     * 星期可以加入 L C # #用于确定时间 格式：星期几+1#数字 如 4#2表示第二个星期三
     */
//    @Scheduled(cron = "${time}")
    public void testScheduled(){
        System.out.println("hello...");
    }
}
