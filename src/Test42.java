import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hzlichaolin on 2016/8/30.
 */
public class Test42 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,10);
        System.out.println("now is " + new Date());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timerTask run at " + new Date());
            }
        },calendar.getTime());
    }
}
