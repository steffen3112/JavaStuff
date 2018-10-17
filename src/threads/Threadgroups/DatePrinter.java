package threads.Threadgroups;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DatePrinter implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(new Date());
            ThreadUtils.safeSleep(TimeUnit.SECONDS, 3);
        }
    }

}