import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hzlichaolin on 2016/8/31.
 */
public class Test55 {
    public static void main(String[] args) {
        final AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        System.out.println(counter.addAndGet(1));
                    }
                }
            }).start();
        }
    }
}
