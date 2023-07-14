package com.sapo.servicetwo.task;


import com.sapo.servicetwo.dao.MyDao;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync //Bật cấu hình bất đồng bộ
@EnableScheduling//Bật scheduling
public class MyTask {
    private final MyDao myDao;

    public MyTask(MyDao myDao) {
        this.myDao = myDao;
    }

    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    // @Scheduled(cron="*/5 * * * * MON-FRI")
    /* thực thi sau vào mỗi 5p từ thứ 2-t6
    * */
    public void task1(){
        var user = myDao.findById(1);
        //System.out.println("Scheduling => "+ user.get(0).getUsername());
    }
}
