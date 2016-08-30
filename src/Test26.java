import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hzlichaolin on 2016/8/26.
 */
public class Test26 {
    public static void main(String[] args) {
        AtomicAddTask task = new AtomicAddTask();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }

    static class AtomicAddTask implements Runnable{
        private AtomicInteger count = new AtomicInteger(0);

        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(count.incrementAndGet());
            }
        }
    }
}
