import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hzlichaolin on 2016/8/30.
 */
public class Test43 {
    public static void main(String[] args) {
        System.out.println("now is " + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND,calendar.get(Calendar.SECOND)-10);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timerTask run at " + new Date());
            }
        },calendar.getTime());
    }
}
