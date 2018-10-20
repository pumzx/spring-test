package serviceimpl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author panzhixiong
 * @date 2018/10/20
 */
@Service
public class ScheduleFunctionService {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 3000)
    public void execFixRate() {
        System.out.println("fixRate exec:" + sdf.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    public void execFixDelay() {
        System.out.println("fixDelay exec:" + sdf.format(new Date()));
    }

    @Scheduled(cron = "00 59 16 ? * *")
    public void execCron() {
        System.out.println("cron exec:" + sdf.format(new Date()));
    }
}
