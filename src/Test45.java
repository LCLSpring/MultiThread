import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hzlichaolin on 2016/8/30.
 */
public class Test45 {
    public static void main(String[] args) {
        System.out.println("new is at " + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,5);
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("run at " + new Date());
                timer.cancel();
            }
        },calendar.getTime(),2000);
    }
}
